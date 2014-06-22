// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.talend.commons.emf.FactoriesUtil;
import org.talend.commons.utils.io.FilesUtils;
import org.talend.core.model.metadata.builder.database.DqRepositoryViewService;
import org.talend.cwm.constants.DevelopmentStatus;
import org.talend.cwm.helper.TaggedValueHelper;
import org.talend.cwm.relational.TdExpression;
import org.talend.dataprofiler.core.PluginConstant;
import org.talend.dataprofiler.core.i18n.internal.DefaultMessagesImpl;
import org.talend.dataprofiler.core.ui.action.provider.NewSourcePatternActionProvider;
import org.talend.dataprofiler.core.ui.wizard.parserrule.ParserRuleToExcelEnum;
import org.talend.dataquality.domain.pattern.ExpressionType;
import org.talend.dataquality.domain.pattern.Pattern;
import org.talend.dataquality.domain.pattern.PatternFactory;
import org.talend.dataquality.domain.pattern.RegularExpression;
import org.talend.dataquality.helpers.BooleanExpressionHelper;
import org.talend.dataquality.helpers.MetadataHelper;
import org.talend.dataquality.indicators.definition.IndicatorCategory;
import org.talend.dataquality.indicators.definition.IndicatorDefinition;
import org.talend.dataquality.rules.ParserRule;
import org.talend.dq.dqrule.DqRuleBuilder;
import org.talend.dq.factory.ModelElementFileFactory;
import org.talend.dq.helper.UDIHelper;
import org.talend.dq.helper.resourcehelper.DQRuleResourceFileHelper;
import org.talend.dq.indicators.definitions.DefinitionHandler;
import org.talend.dq.writer.impl.ElementWriterFactory;
import org.talend.resource.ResourceManager;
import org.talend.utils.sugars.ReturnCode;
import orgomg.cwm.objectmodel.core.ModelElement;

import com.csvreader.CsvReader;

/**
 * DOC zqin class global comment. Detailled comment
 */
public final class ImportFactory {

    protected static Logger log = Logger.getLogger(ImportFactory.class);

    public static final boolean USE_TEXT_QUAL = true;

    public static final char TEXT_QUAL = '"';

    public static final char CURRENT_SEPARATOR = '\t';

    private ImportFactory() {

    }

    public static List<ReturnCode> importToStucture(File importFile, IFolder selectionFolder, ExpressionType type, boolean skip,
            boolean rename) {

        List<ReturnCode> importEvent = new ArrayList<ReturnCode>();

        Set<String> names = PatternUtilities.getNestFolderPatternNames(new HashSet<String>(), selectionFolder);

        String fileExtName = getFileExtName(importFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$
            try {
                CsvReader reader = new CsvReader(new FileReader(importFile), CURRENT_SEPARATOR);
                reader.setEscapeMode(CsvReader.ESCAPE_MODE_DOUBLED);
                reader.setTextQualifier(TEXT_QUAL);
                reader.setUseTextQualifier(USE_TEXT_QUAL);

                reader.readHeaders();
                while (reader.readRecord()) {

                    String name = reader.get(PatternToExcelEnum.Label.getLiteral());

                    if (names.contains(name)) {
                        if (skip) {
                            importEvent.add(new ReturnCode(
                                    DefaultMessagesImpl.getString("ImportFactory.patternInported", name), false)); //$NON-NLS-1$
                            continue;
                        }
                        if (rename) {
                            name = name + "(" + new Date() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    }

                    PatternParameters patternParameters = new ImportFactory().new PatternParameters();
                    patternParameters.name = name;
                    patternParameters.auther = reader.get(PatternToExcelEnum.Author.getLiteral());
                    patternParameters.description = reader.get(PatternToExcelEnum.Description.getLiteral());
                    patternParameters.purpose = reader.get(PatternToExcelEnum.Purpose.getLiteral());
                    patternParameters.relativePath = reader.get(PatternToExcelEnum.RelativePath.getLiteral());

                    for (PatternLanguageType languagetype : PatternLanguageType.values()) {
                        String cellStr = reader.get(languagetype.getExcelEnum().getLiteral());
                        if (cellStr != null && !cellStr.equals("")) { //$NON-NLS-1$
                            patternParameters.regex.put(languagetype.getLiteral(), cellStr);
                        }
                    }

                    try {
                        String relativePath = "Patterns/" + createAndStorePattern(patternParameters, selectionFolder, type); //$NON-NLS-1$
                        names.add(name);

                        importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importPattern", name, //$NON-NLS-1$
                                relativePath), true));
                    } catch (Exception e) {
                        importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.SaveFailed", name), false)); //$NON-NLS-1$
                    }

                }
                reader.close();
            } catch (Exception e) {
                log.error(e, e);
                importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importFailed"), false)); //$NON-NLS-1$
            }
        }

        if ("xls".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$
            Map<Integer, PatternLanguageType> expressionMap = new HashMap<Integer, PatternLanguageType>();
            try {
                WorkbookSettings settings = new WorkbookSettings();
                settings.setEncoding("UTF-8"); //$NON-NLS-1$
                Workbook rwb = Workbook.getWorkbook(importFile, settings);
                Sheet[] sheets = rwb.getSheets();
                for (Sheet sheet : sheets) {
                    Cell[] headerRow = sheet.getRow(0);

                    for (Cell cell : headerRow) {
                        for (PatternLanguageType languageType : PatternLanguageType.values()) {
                            if (cell.getContents().equals(languageType.getExcelEnum().getLiteral())) {
                                expressionMap.put(cell.getColumn(), languageType);
                            }
                        }
                    }

                    for (int i = 1; i < sheet.getRows(); i++) {
                        Cell[] row = sheet.getRow(i);
                        Cell cell = row[0];
                        if (CellType.LABEL.equals(cell.getType())) {
                            String contents = cell.getContents();
                            if (names.contains(contents)) {
                                if (skip) {
                                    importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.patternInported", //$NON-NLS-1$
                                            contents), false));
                                    continue;
                                }
                                if (rename) {
                                    contents = contents + "(" + new Date() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                                }
                            }

                            PatternParameters patternParameters = new ImportFactory().new PatternParameters();

                            patternParameters.name = contents;
                            patternParameters.auther = row[6].getContents();
                            patternParameters.description = row[2].getContents();
                            patternParameters.purpose = row[1].getContents();
                            patternParameters.status = DevelopmentStatus.DRAFT.getLiteral();

                            for (int columnIndex : expressionMap.keySet()) {
                                String rowContent = row[columnIndex].getContents();
                                if (!rowContent.equals("")) { //$NON-NLS-1$
                                    patternParameters.regex.put(expressionMap.get(columnIndex).getLiteral(), rowContent);
                                }
                            }

                            String relativePath = "Patterns/" + createAndStorePattern(patternParameters, selectionFolder, type); //$NON-NLS-1$

                            names.add(contents);
                            importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importPattern", contents, //$NON-NLS-1$
                                    relativePath), true));
                        }
                    }
                }

                rwb.close();
            } catch (BiffException e) {
                log.error(e, e);
                importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importFailed"), false)); //$NON-NLS-1$
            } catch (IOException e) {
                log.error(e, e);
                importEvent.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importFailed"), false)); //$NON-NLS-1$
            }
        }

        return importEvent;
    }

    /**
     * DOC yyi Comment method "varifyImportFile".
     * 
     * @param importFile
     */
    // private static ReturnCode verifyImportFile(File importFile) {
    //
    // ReturnCode rc = new ReturnCode(true);
    // CsvReader reader;
    //
    // try {
    // reader = new CsvReader(new FileReader(importFile), CURRENT_SEPARATOR);
    // reader.setEscapeMode(ESCAPE_MODE_BACKSLASH);
    // reader.setTextQualifier(TEXT_QUAL);
    // reader.setUseTextQualifier(true);
    //
    // reader.readHeaders();
    // if (!checkFileHeader(reader.getHeaders())) {
    // rc.setReturnCode(DefaultMessagesImpl.getString("ImportFactory.noHeader"), false);
    // return rc;
    // }
    // reader.setUseTextQualifier(false);
    // while (reader.readRecord()) {
    // if (!checkQuotes(reader.getValues())) {
    // rc.setReturnCode(DefaultMessagesImpl.getString("ImportFactory.invalidFormat"), false);
    // return rc;
    // }
    // }
    // reader.close();
    //
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return rc;
    // }

    // private static boolean checkQuotes(String[] values) {
    // for (String value : values) {
    // if (!checkQuotationMarks(value))
    // return false;
    // }
    // return true;
    // }

    private static String createAndStorePattern(PatternParameters parameters, IFolder selectionFolder, ExpressionType type) {

        Pattern pattern = createPattern(parameters.name, parameters.auther, parameters.description, parameters.purpose,
                parameters.status);

        for (String key : parameters.regex.keySet()) {
            RegularExpression regularExpr = BooleanExpressionHelper.createRegularExpression(key, parameters.regex.get(key), type);
            pattern.getComponents().add(regularExpr);
        }

        boolean validStatus = PatternUtilities.isPatternValid(pattern);
        TaggedValueHelper.setValidStatus(validStatus, pattern);

        String fname = DqRepositoryViewService.createFilename(parameters.name, NewSourcePatternActionProvider.EXTENSION_PATTERN);

        try {

            String[] folderNames = parameters.relativePath.split("/"); //$NON-NLS-1$

            for (String folderName : folderNames) {

                IFolder folder = selectionFolder.getFolder(folderName);
                if (!folder.exists()) {
                    folder.create(false, true, null);
                }

                selectionFolder = folder;
            }
        } catch (CoreException e) {
            log.error(e, e);
        }

        IFile pfile = selectionFolder.getFile(fname);

        ElementWriterFactory.getInstance().createPatternWriter().create(pattern, selectionFolder);

        return ResourceManager.getPatternFolder().getLocationURI().relativize(selectionFolder.getLocationURI()).toString();
    }

    /**
     * DOC qzhang Comment method "createPattern".
     * 
     * @param name
     * @param author
     * @param description
     * @param purpose
     * @param status
     * @return
     */
    private static Pattern createPattern(String name, String author, String description, String purpose, String status) {
        Pattern pattern = PatternFactory.eINSTANCE.createPattern();
        pattern.setName(name);
        MetadataHelper.setAuthor(pattern, author == null ? "" : author); //$NON-NLS-1$
        MetadataHelper.setDescription(description == null ? "" : description, pattern); //$NON-NLS-1$
        MetadataHelper.setPurpose(purpose == null ? "" : purpose, pattern); //$NON-NLS-1$
        // MOD mzhao feature 7479 2009-10-16
        MetadataHelper.setDevStatus(pattern, status == null ? "" : status); //$NON-NLS-1$
        return pattern;
    }

    private static String getFileExtName(File file) {
        String name = file.getName();
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return null;
        }

        if (index == (name.length() - 1)) {
            return ""; //$NON-NLS-1$
        }

        return name.substring(index + 1);
    }

    /**
     * DOC zqin ImportFactory class global comment. Detailled comment
     */
    private class PatternParameters {

        String name;

        String auther;

        String description;

        String purpose;

        String status;

        String relativePath;

        String javaClassName;

        String javaJarPath;

        Map<String, String> regex;

        public PatternParameters() {

            name = ""; //$NON-NLS-1$
            auther = ""; //$NON-NLS-1$
            description = ""; //$NON-NLS-1$
            purpose = ""; //$NON-NLS-1$
            status = DevelopmentStatus.DRAFT.getLiteral();
            relativePath = ""; //$NON-NLS-1$
            javaClassName = "";//$NON-NLS-1$
            javaJarPath = "";//$NON-NLS-1$
            regex = new HashMap<String, String>();
        }

    }

    /**
     * DOC xqliu ImportFactory class global comment. Detailled comment
     */
    private class UDIParameters extends ImportFactory.PatternParameters {

        String category;

        public UDIParameters() {
            super();
            category = ""; //$NON-NLS-1$
        }

    }

    /**
     * DOC xqliu Comment method "importIndicatorToStucture".
     * 
     * @param importFile
     * @param selectionFolder
     * @param skip
     * @param rename
     * @return
     */
    public static List<ReturnCode> importIndicatorToStucture(File importFile, IFolder selectionFolder, boolean skip,
            boolean rename) {

        List<ReturnCode> information = new ArrayList<ReturnCode>();

        Set<String> names = UDIHelper.getAllIndicatorNames(selectionFolder);

        String fileExtName = getFileExtName(importFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$
            String name = PluginConstant.EMPTY_STRING;
            try {
                CsvReader reader = new CsvReader(new FileReader(importFile), CURRENT_SEPARATOR);
                reader.setEscapeMode(CsvReader.ESCAPE_MODE_BACKSLASH);
                reader.setTextQualifier(TEXT_QUAL);
                reader.setUseTextQualifier(USE_TEXT_QUAL);
                reader.readHeaders();

                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS"); //$NON-NLS-1$

                while (reader.readRecord()) {
                    name = reader.get(PatternToExcelEnum.Label.getLiteral());

                    if (names.contains(name)) {
                        if (skip) {
                            information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.Imported", name), false)); //$NON-NLS-1$
                            continue;
                        }
                        if (rename) {
                            name = name + "(" + simpleDateFormat.format(new Date()) + Math.random() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    }

                    UDIParameters udiParameters = new ImportFactory().new UDIParameters();
                    udiParameters.name = name;
                    udiParameters.auther = reader.get(PatternToExcelEnum.Author.getLiteral());
                    udiParameters.description = reader.get(PatternToExcelEnum.Description.getLiteral());
                    udiParameters.purpose = reader.get(PatternToExcelEnum.Purpose.getLiteral());
                    udiParameters.relativePath = reader.get(PatternToExcelEnum.RelativePath.getLiteral());
                    udiParameters.category = reader.get(PatternToExcelEnum.Category.getLiteral());
                    udiParameters.javaClassName = reader.get(PatternToExcelEnum.JavaClassName.getLiteral());
                    udiParameters.javaJarPath = reader.get(PatternToExcelEnum.JavaJarPath.getLiteral());
                    char delimiter = reader.getDelimiter();
                    String rawRecord = reader.getRawRecord();
                    String[] headers = reader.getHeaders();
                    String[] columnsValue = rawRecord.split(String.valueOf(delimiter));
                    HashMap<String, String> record = new HashMap<String, String>();
                    for (int i = 0; i < headers.length; i++) {
                        record.put(headers[i], columnsValue[i]);
                    }
                    // String cellStr = "\"\"";
                    for (PatternLanguageType languagetype : PatternLanguageType.values()) {
                        // int index = languagetype.getExcelEnum().getIndex();
                        // if (charArray.length < reader.getColumnCount()) {
                        // cellStr = reader.get(languagetype.getExcelEnum().getLiteral());
                        // } else {
                        // cellStr = String.valueOf(charArray[index]);
                        // }
                        String cellStr = record.get(languagetype.getExcelEnum().getLiteral());
                        if (cellStr != null && !cellStr.equals("\"\"")) { //$NON-NLS-1$
                            udiParameters.regex.put(languagetype.getLiteral(), trimQuote(cellStr));
                        }
                    }

                    createAndStoreUDI(udiParameters, selectionFolder);

                    names.add(name);

                    // add the suscess message to display.
                    information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedSucess" //$NON-NLS-1$
                            , name), true));

                }

                reader.close();

            } catch (Exception e) {
                log.error(e, e);
                information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedFailed", name), false)); //$NON-NLS-1$
            }
        }

        if ("xls".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$
            Map<Integer, PatternLanguageType> expressionMap = new HashMap<Integer, PatternLanguageType>();
            String contents = PluginConstant.EMPTY_STRING;
            try {
                WorkbookSettings settings = new WorkbookSettings();
                settings.setEncoding("UTF-8"); //$NON-NLS-1$
                Workbook rwb = Workbook.getWorkbook(importFile, settings);
                Sheet[] sheets = rwb.getSheets();
                for (Sheet sheet : sheets) {
                    Cell[] headerRow = sheet.getRow(0);

                    for (Cell cell : headerRow) {
                        for (PatternLanguageType languageType : PatternLanguageType.values()) {
                            if (cell.getContents().equals(languageType.getExcelEnum().getLiteral())) {
                                expressionMap.put(cell.getColumn(), languageType);
                            }
                        }
                    }

                    for (int i = 1; i < sheet.getRows(); i++) {
                        Cell[] row = sheet.getRow(i);
                        Cell cell = row[0];
                        if (CellType.LABEL.equals(cell.getType())) {
                            contents = cell.getContents();
                            if (names.contains(contents)) {
                                if (skip) {
                                    continue;
                                }
                                if (rename) {
                                    contents = contents + "(" + new Date() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                                }
                            }

                            UDIParameters udiParameters = new ImportFactory().new UDIParameters();

                            udiParameters.name = contents;
                            udiParameters.auther = row[6].getContents();
                            udiParameters.description = row[2].getContents();
                            udiParameters.purpose = row[1].getContents();
                            udiParameters.status = DevelopmentStatus.DRAFT.getLiteral();
                            udiParameters.category = row[16].getContents();

                            for (int columnIndex : expressionMap.keySet()) {
                                String rowContent = row[columnIndex].getContents();
                                if (!rowContent.equals("")) { //$NON-NLS-1$
                                    udiParameters.regex.put(expressionMap.get(columnIndex).getLiteral(), rowContent);
                                }
                            }

                            createAndStoreUDI(udiParameters, selectionFolder);

                            names.add(contents);

                            information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedSucess" //$NON-NLS-1$
                                    , contents), true));
                        }
                    }
                }

                rwb.close();
            } catch (Exception e) {
                log.error(e, e);
                information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedFailed", contents), false)); //$NON-NLS-1$
            }
        }

        // MOD qiongli 2011-11-28 TDQ-4038.consider to import the definition file.
        if (FactoriesUtil.DEFINITION.equalsIgnoreCase(fileExtName)) {
            String propFilePath = importFile.getPath().replaceFirst(PluginConstant.DOT_STRING + fileExtName,
                    PluginConstant.DOT_STRING + FactoriesUtil.PROPERTIES_EXTENSION);
            File propFile = new File(propFilePath);
            // just import the definition file which have the realted Property file.
            if (!propFile.exists()) {
                return information;
            }
            String name = importFile.getName();
            try {
                if (names.contains(name)) {
                    if (skip) {
                        information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.Imported", name), false)); //$NON-NLS-1$
                        return information;
                    }
                    if (rename) {
                        name = name + "(" + new Date() + Math.random() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                    }
                }

                IFile elementFile = selectionFolder.getFile(name);
                if (!elementFile.exists()) {
                    elementFile.create(new FileInputStream(importFile), false, null);
                    ModelElement modelElement = ModelElementFileFactory.getModelElement(elementFile);
                    if (modelElement != null) {
                        ElementWriterFactory.getInstance().createIndicatorDefinitionWriter()
                                .create(modelElement, selectionFolder);
                        DefinitionHandler.getInstance().reloadIndicatorsDefinitions();
                        names.add(name);
                        information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedSucess" //$NON-NLS-1$
                                , name), true));
                    }
                }
            } catch (Exception e) {
                log.error(e);
                information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedFailed", name), false)); //$NON-NLS-1$
            }


        }

        return information;
    }

    private static String trimQuote(String text) {
        if (text.length() < 2)
            return text;

        int beginLen = 0;
        int endLen = text.length();

        if ('\"' == text.charAt(beginLen) && '\"' == text.charAt(endLen - 1)) {
            return text.substring(1, endLen - 1);
        }

        return text;
    }

    // private static boolean checkFileHeader(String[] headers) {
    //
    // List<String> patternEnum = new ArrayList<String>();
    // for (PatternToExcelEnum tmpEnum : PatternToExcelEnum.values()) {
    // patternEnum.add(tmpEnum.getLiteral());
    // }
    //
    // for (String header : headers) {
    // if (!patternEnum.contains(header))
    // return false;
    // }
    // return true;
    // }
    //
    // private static boolean checkQuotationMarks(String text) {
    // if (0 == text.length())
    // return true;
    //
    // int beginLen = 0;
    // int endLen = text.length();
    //
    // while ('\"' == text.charAt(beginLen)) {
    // beginLen++;
    // }
    // while ('\"' == text.charAt(endLen - 1)) {
    // endLen--;
    // }
    // // System.out.println(text + "|" + beginLen + "|" + (text.length() - endLen));
    // return beginLen == text.length() - endLen;
    // }

    /**
     * DOC xqliu Comment method "createAndStoreUDI".
     * 
     * @param parameters
     * @param selectionFolder
     */
    private static void createAndStoreUDI(UDIParameters parameters, IFolder selectionFolder) {

        IndicatorDefinition id = UDIHelper.createUDI(parameters.name, parameters.auther, parameters.description,
                parameters.purpose, parameters.status, parameters.category, parameters.javaClassName, parameters.javaJarPath);

        for (String key : parameters.regex.keySet()) {
            TdExpression expression = BooleanExpressionHelper.createTdExpression(key, parameters.regex.get(key));
            id.getSqlGenericExpression().add(expression);
        }

        boolean validStatus = UDIHelper.isUDIValid(id);
        TaggedValueHelper.setValidStatus(validStatus, id);

        String fname = DqRepositoryViewService.createFilename(parameters.name, FactoriesUtil.DEFINITION);

        try {

            String[] folderNames = parameters.relativePath.split("/"); //$NON-NLS-1$

            for (String folderName : folderNames) {
                IFolder folder = selectionFolder.getFolder(folderName);
                if (!folder.exists()) {
                    folder.create(false, true, null);
                }

                selectionFolder = folder;
            }
        } catch (CoreException e) {
            log.error(e, e);
        }

        IFile pfile = selectionFolder.getFile(fname);

        ElementWriterFactory.getInstance().createIndicatorDefinitionWriter().create(id, selectionFolder);
    }

    /**
     * DOC xqliu Comment method "importFile".
     * 
     * @param importFile
     * @param targetFile
     * @throws IOException
     */
    public static void importFile(File importFile, IFile targetFile) throws IOException {
        if (importFile != null && targetFile != null) {
            File file = new File(targetFile.getRawLocation().toOSString());
            if (file.exists()) {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS"); //$NON-NLS-1$
                File bakFile = new File(file.getAbsolutePath() + "." + simpleDateFormat.format(new Date()) + ".bak"); //$NON-NLS-1$ //$NON-NLS-2$
                FilesUtils.copyFile(file, bakFile);
            }
            FilesUtils.copyFile(importFile, file);
        }
    }

    /**
     * 
     * DOC klliu Comment method "importParserRuleToStucture".
     * 
     * @param importFile
     * @param selectionFolder
     * @param skip
     * @param rename
     * @return
     */
    public static List<ReturnCode> importParserRuleToStucture(File importFile, IFolder selectionFolder, boolean skip,
            boolean rename) {
        List<ReturnCode> information = new ArrayList<ReturnCode>();

        Set<String> names = DQRuleResourceFileHelper.getInstance().getAllParserRlueNames(selectionFolder);
        ParserRuleParameters prParameters = new ImportFactory().new ParserRuleParameters();
        String fileExtName = getFileExtName(importFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$
            String name = ""; //$NON-NLS-1$
            boolean isNeedToCreate = true;
            try {
                CsvReader reader = new CsvReader(new FileReader(importFile), CURRENT_SEPARATOR);
                reader.setEscapeMode(CsvReader.ESCAPE_MODE_BACKSLASH);
                reader.setTextQualifier(TEXT_QUAL);
                reader.setUseTextQualifier(USE_TEXT_QUAL);
                reader.readHeaders();

                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS"); //$NON-NLS-1$

                while (reader.readRecord()) {
                    name = reader.get(ParserRuleToExcelEnum.Label.getLiteral());

                    if (names.contains(name)) {
                        if (skip) {
                            information.add(new ReturnCode(DefaultMessagesImpl
                                    .getString("ImportFactory.ParserRuleImported", name), false)); //$NON-NLS-1$
                            isNeedToCreate = false;
                            break;
                        }
                        if (rename) {
                            name = name + "(" + simpleDateFormat.format(new Date()) + Math.random() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    }
                    prParameters.label = reader.get(ParserRuleToExcelEnum.Label.getLiteral());
                    prParameters.auther = reader.get(ParserRuleToExcelEnum.Author.getLiteral());
                    prParameters.description = reader.get(ParserRuleToExcelEnum.Description.getLiteral());
                    prParameters.purpose = reader.get(ParserRuleToExcelEnum.Purpose.getLiteral());
                    ParserRuleTdExpresstion prExpresstion = new ImportFactory().new ParserRuleTdExpresstion();
                    prExpresstion.name = addQual(reader.get(ParserRuleToExcelEnum.Name.getLiteral()));
                    prExpresstion.body = addQual(reader.get(ParserRuleToExcelEnum.Body.getLiteral()));
                    prExpresstion.language = reader.get(ParserRuleToExcelEnum.Language.getLiteral());
                    prParameters.prExpresstions.add(prExpresstion);
                }
                if (isNeedToCreate) {
                    names.add(name);
                    information.add(new ReturnCode(DefaultMessagesImpl.getString("ImportFactory.importedParserRuleSucess" //$NON-NLS-1$
                            , name), true));
                    createAndStoreParserRule(prParameters, selectionFolder, name);
                }

                reader.close();

            } catch (Exception e) {
                log.error(e, e);
                information.add(new ReturnCode(
                        DefaultMessagesImpl.getString("ImportFactory.importedParserRuleFailed", name), false)); //$NON-NLS-1$
            }
        }
        return information;
    }

    /**
     * DOC klliu Comment method "addQual".
     * 
     * @param string
     * @return
     */
    private static String addQual(String sourceString) {
        String replace = sourceString.replace(sourceString, "\"" + sourceString + "\"");//$NON-NLS-1$ //$NON-NLS-2$
        return replace;
    }

    /**
     * DOC klliu Comment method "createAndStoreParserRule".
     * 
     * @param prParameters
     * @param selectionFolder
     */
    public static void createAndStoreParserRule(ParserRuleParameters prParameters, IFolder selectionFolder, String name) {
        DqRuleBuilder ruleBuilder = new DqRuleBuilder();
        boolean ruleInitialized = ruleBuilder.initializeParserRuleBuilder(prParameters.label);
        if (ruleInitialized) {
            ParserRule parserRule = ruleBuilder.getParserRule();
            parserRule.setName(name);
            TaggedValueHelper.setValidStatus(true, parserRule);
            List<ParserRuleTdExpresstion> prExpresstions = prParameters.getPrExpresstions();
            for (ParserRuleTdExpresstion prtde : prExpresstions) {
                parserRule.addExpression(prtde.name, prtde.language, prtde.body);
            }
            IndicatorCategory ruleIndicatorCategory = DefinitionHandler.getInstance().getDQRuleIndicatorCategory();
            if (ruleIndicatorCategory != null && !parserRule.getCategories().contains(ruleIndicatorCategory)) {
                parserRule.getCategories().add(ruleIndicatorCategory);
            }
            ElementWriterFactory.getInstance().createdRuleWriter().create(parserRule, selectionFolder);
        }

    }

    /**
     * DOC bZhou ImportFactory class global comment. Detailled comment
     */
    private class ParserRuleParameters {

        String label;

        String auther;

        String description;

        String purpose;

        String status;

        List<ParserRuleTdExpresstion> prExpresstions;

        public ParserRuleParameters() {
            label = ""; //$NON-NLS-1$
            auther = ""; //$NON-NLS-1$
            description = ""; //$NON-NLS-1$
            purpose = ""; //$NON-NLS-1$
            status = DevelopmentStatus.DRAFT.getLiteral();
            prExpresstions = new ArrayList<ParserRuleTdExpresstion>();
        }

        public List<ParserRuleTdExpresstion> getPrExpresstions() {
            return this.prExpresstions;
        }
    }

    /**
     * DOC bZhou ImportFactory class global comment. Detailled comment
     */
    private class ParserRuleTdExpresstion {

        String name;

        String body;

        String language;

        public ParserRuleTdExpresstion() {
            name = ""; //$NON-NLS-1$
            body = ""; //$NON-NLS-1$
            language = ""; //$NON-NLS-1$
        }
    }

}