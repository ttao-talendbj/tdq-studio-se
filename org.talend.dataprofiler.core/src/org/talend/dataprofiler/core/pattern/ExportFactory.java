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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.talend.commons.utils.io.FilesUtils;
import org.talend.cwm.helper.TaggedValueHelper;
import org.talend.cwm.relational.TdExpression;
import org.talend.dataprofiler.core.i18n.internal.DefaultMessagesImpl;
import org.talend.dataprofiler.core.ui.wizard.parserrule.ParserRuleToExcelEnum;
import org.talend.dataquality.PluginConstant;
import org.talend.dataquality.domain.pattern.Pattern;
import org.talend.dataquality.domain.pattern.PatternComponent;
import org.talend.dataquality.domain.pattern.RegularExpression;
import org.talend.dataquality.helpers.MetadataHelper;
import org.talend.dataquality.indicators.definition.IndicatorDefinition;
import org.talend.dataquality.rules.ParserRule;
import org.talend.dq.helper.UDIHelper;
import org.talend.dq.helper.resourcehelper.ResourceFileMap;
import orgomg.cwm.objectmodel.core.Expression;
import orgomg.cwm.objectmodel.core.TaggedValue;

import com.csvreader.CsvWriter;

/**
 * DOC zqin class global comment. Detailled comment
 */
public final class ExportFactory {

    private static Logger log = Logger.getLogger(ExportFactory.class);

    private static final boolean USE_TEXT_QUAL = ImportFactory.USE_TEXT_QUAL;

    private static final char TEXT_QUAL = ImportFactory.TEXT_QUAL;

    private static final char CURRENT_SEPARATOR = ImportFactory.CURRENT_SEPARATOR;

    private ExportFactory() {
    }

    static void export(File exportFile, IFolder folder, Pattern... patterns) {

        if (exportFile.isDirectory()) {
            for (Pattern pattern : patterns) {
                File file = new File(exportFile, toLocalFileName(pattern.getName() + ".csv")); //$NON-NLS-1$
                export(file, folder, pattern);
            }
        }

        String fileExtName = getFileExtName(exportFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$

            try {

                CsvWriter out = new CsvWriter(new FileOutputStream(exportFile), CURRENT_SEPARATOR, Charset.defaultCharset());
                out.setEscapeMode(CsvWriter.ESCAPE_MODE_DOUBLED);
                out.setTextQualifier(TEXT_QUAL);
                out.setForceQualifier(USE_TEXT_QUAL);

                PatternToExcelEnum[] values = PatternToExcelEnum.values();
                String[] temp = new String[values.length];

                for (int i = 0; i < patterns.length + 1; i++) {

                    for (int j = 0; j < values.length; j++) {
                        if (i == 0) {
                            temp[j] = values[j].getLiteral();
                        } else {
                            temp[j] = getRelatedValueFromPattern(patterns[i - 1], folder).get(values[j]);
                        }
                    }

                    out.writeRecord(temp);
                }

                out.flush();
                out.close();

            } catch (FileNotFoundException fe) {
                MessageDialogWithToggle
                        .openError(
                                null,
                                DefaultMessagesImpl.getString("ExportFactory.errorOne"), DefaultMessagesImpl.getString("ExportFactory.notFoundFile")); //$NON-NLS-1$ //$NON-NLS-2$
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public static void export(File exportFile, IFolder folder, ParserRule... parserRules) {
        if (exportFile.isDirectory()) {
            for (ParserRule pr : parserRules) {
                File file = new File(exportFile, pr.getName() + ".csv"); //$NON-NLS-1$
                export(file, folder, pr);
            }
        }

        String fileExtName = getFileExtName(exportFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$

            try {

                CsvWriter out = new CsvWriter(new FileOutputStream(exportFile), CURRENT_SEPARATOR, Charset.defaultCharset());
                out.setEscapeMode(CsvWriter.ESCAPE_MODE_DOUBLED);
                out.setTextQualifier(TEXT_QUAL);
                out.setForceQualifier(USE_TEXT_QUAL);
                List<TdExpression> expressions = parserRules[0].getExpression();
                ParserRuleToExcelEnum[] values = ParserRuleToExcelEnum.values();
                String[] temp = new String[values.length];

                for (int i = 0; i < expressions.toArray().length + 1; i++) {
                    for (int j = 0; j < values.length; j++) {
                        if (i == 0) {
                            temp[j] = values[j].getLiteral();
                        } else {
                            Map<ParserRuleToExcelEnum, String> relatedValueFromParserRule = getRelatedValueFromParserRule(
                                    parserRules[0], folder, expressions.get(i - 1));
                            temp[j] = relatedValueFromParserRule.get(values[j]);
                        }
                    }

                    out.writeRecord(temp);
                }
                out.flush();
                out.close();

            } catch (FileNotFoundException fe) {
                MessageDialogWithToggle
                        .openError(
                                null,
                                DefaultMessagesImpl.getString("ExportFactory.errorOne"), DefaultMessagesImpl.getString("ExportFactory.notFoundFile")); //$NON-NLS-1$ //$NON-NLS-2$
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public static void export(File exportFile, IFolder folder, IndicatorDefinition... indicatorDefinitions) {

        if (exportFile.isDirectory()) {
            for (IndicatorDefinition id : indicatorDefinitions) {
                File file = new File(exportFile, id.getName() + ".csv"); //$NON-NLS-1$
                export(file, folder, id);
            }
        }

        String fileExtName = getFileExtName(exportFile);

        if ("csv".equalsIgnoreCase(fileExtName)) { //$NON-NLS-1$

            try {

                CsvWriter out = new CsvWriter(new FileOutputStream(exportFile), CURRENT_SEPARATOR, Charset.defaultCharset());
                out.setEscapeMode(CsvWriter.ESCAPE_MODE_DOUBLED);
                out.setTextQualifier(TEXT_QUAL);
                out.setForceQualifier(USE_TEXT_QUAL);

                PatternToExcelEnum[] values = PatternToExcelEnum.values();
                String[] temp = new String[values.length];

                for (int i = 0; i < indicatorDefinitions.length + 1; i++) {

                    for (int j = 0; j < values.length; j++) {
                        if (i == 0) {
                            temp[j] = values[j].getLiteral();
                        } else {
                            temp[j] = getRelatedValueFromIndicatorDefinition(indicatorDefinitions[i - 1], folder).get(values[j]);
                        }
                    }

                    out.writeRecord(temp);
                }

                out.flush();
                out.close();

            } catch (FileNotFoundException fe) {
                MessageDialogWithToggle
                        .openError(
                                null,
                                DefaultMessagesImpl.getString("ExportFactory.errorOne"), DefaultMessagesImpl.getString("ExportFactory.notFoundFile")); //$NON-NLS-1$ //$NON-NLS-2$
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * DOC klliu Comment method "relpaceTempHasEscapeCharactor".
     * 
     * @param temp
     */
    private static String relpaceTempHasEscapeCharactor(String temps) {
        if (temps == null) {
            return PluginConstant.EMPTY_STRING;
        }
        boolean contains = temps.contains("\r");
        if (contains) {
            return temps.replace("\r", "");
        }
        return temps;
    }

    private static Map<ParserRuleToExcelEnum, String> getRelatedValueFromParserRule(ParserRule parserRule, IFolder folder,
            TdExpression tde) {

        Map<ParserRuleToExcelEnum, String> idMap = new HashMap<ParserRuleToExcelEnum, String>();

        if (folder != null) {
            IFile file = ResourceFileMap.findCorrespondingFile(parserRule);
            URI relativeURI = folder.getLocationURI().relativize(file.getParent().getLocationURI());

            // get the basic information
            idMap.put(ParserRuleToExcelEnum.Label, relpaceTempHasEscapeCharactor(parserRule.getName()));
            idMap.put(ParserRuleToExcelEnum.Purpose, relpaceTempHasEscapeCharactor(MetadataHelper.getPurpose(parserRule)));
            idMap.put(ParserRuleToExcelEnum.Description, relpaceTempHasEscapeCharactor(MetadataHelper.getDescription(parserRule)));
            idMap.put(ParserRuleToExcelEnum.Author, relpaceTempHasEscapeCharactor(MetadataHelper.getAuthor(parserRule)));
            idMap.put(ParserRuleToExcelEnum.RelativePath, relativeURI.toString());
            idMap.put(ParserRuleToExcelEnum.Name, replaceQual(tde.getName()));
            idMap.put(ParserRuleToExcelEnum.Body, replaceQual(tde.getBody()));
            idMap.put(ParserRuleToExcelEnum.Language, replaceQual(tde.getLanguage()));

        }

        return idMap;
    }

    private static String replaceQual(String sourceString) {
        String replace = sourceString.replace("\"", "");//$NON-NLS-1$ //$NON-NLS-2$

        return replace;

    }

    private static Map<PatternToExcelEnum, String> getRelatedValueFromIndicatorDefinition(
            IndicatorDefinition indicatorDefinition, IFolder folder) {

        Map<PatternToExcelEnum, String> idMap = new HashMap<PatternToExcelEnum, String>();

        if (folder != null) {
            IFile file = ResourceFileMap.findCorrespondingFile(indicatorDefinition);
            URI relativeURI = folder.getLocationURI().relativize(file.getParent().getLocationURI());

            // get the basic information
            idMap.put(PatternToExcelEnum.Label, relpaceTempHasEscapeCharactor(indicatorDefinition.getName()));
            idMap.put(PatternToExcelEnum.Purpose, relpaceTempHasEscapeCharactor(MetadataHelper.getPurpose(indicatorDefinition)));
            idMap.put(PatternToExcelEnum.Description,
                    relpaceTempHasEscapeCharactor(MetadataHelper.getDescription(indicatorDefinition)));
            idMap.put(PatternToExcelEnum.Author, relpaceTempHasEscapeCharactor(MetadataHelper.getAuthor(indicatorDefinition)));
            idMap.put(PatternToExcelEnum.RelativePath, relativeURI.toString());
            idMap.put(PatternToExcelEnum.Category, UDIHelper.getUDICategory(indicatorDefinition).getLabel());
            TaggedValue tagValue = TaggedValueHelper.getTaggedValue(TaggedValueHelper.CLASS_NAME_TEXT,
                    indicatorDefinition.getTaggedValue());
            idMap.put(PatternToExcelEnum.JavaClassName, tagValue == null ? null : tagValue.getValue());
            tagValue = TaggedValueHelper.getTaggedValue(TaggedValueHelper.JAR_FILE_PATH, indicatorDefinition.getTaggedValue());
            idMap.put(PatternToExcelEnum.JavaJarPath, tagValue == null ? null : tagValue.getValue());

            for (PatternLanguageType languagetype : PatternLanguageType.values()) {
                for (Expression expression : indicatorDefinition.getSqlGenericExpression()) {
                    if (expression != null && expression.getLanguage().equalsIgnoreCase(languagetype.getLiteral())) {
                        idMap.put(languagetype.getExcelEnum(), expression.getBody());
                    }
                }

                if (!idMap.containsKey(languagetype.getExcelEnum())) {
                    idMap.put(languagetype.getExcelEnum(), ""); //$NON-NLS-1$
                }

            }
        }

        return idMap;
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

    private static Map<PatternToExcelEnum, String> getRelatedValueFromPattern(Pattern pattern, IFolder folder) {

        Map<PatternToExcelEnum, String> patternMap = new HashMap<PatternToExcelEnum, String>();

        if (folder != null) {
            IFile file = ResourceFileMap.findCorrespondingFile(pattern);
            URI relativeURI = folder.getLocationURI().relativize(file.getParent().getLocationURI());

            // get the basic information
            patternMap.put(PatternToExcelEnum.Label, pattern.getName());
            patternMap.put(PatternToExcelEnum.Purpose, MetadataHelper.getPurpose(pattern));
            patternMap.put(PatternToExcelEnum.Description, MetadataHelper.getDescription(pattern));
            patternMap.put(PatternToExcelEnum.Author, MetadataHelper.getAuthor(pattern));
            patternMap.put(PatternToExcelEnum.RelativePath, relativeURI.toString());

            for (PatternLanguageType languagetype : PatternLanguageType.values()) {
                for (PatternComponent component : pattern.getComponents()) {
                    Expression expression = ((RegularExpression) component).getExpression();
                    if (expression != null && expression.getLanguage().equalsIgnoreCase(languagetype.getLiteral())) {
                        patternMap.put(languagetype.getExcelEnum(), expression.getBody());
                    }
                }

                if (!patternMap.containsKey(languagetype.getExcelEnum())) {
                    patternMap.put(languagetype.getExcelEnum(), ""); //$NON-NLS-1$
                }
            }
        }

        return patternMap;
    }

    /**
     * DOC xqliu Comment method "exportFile".
     * 
     * @param exportFile
     * @param sourceFile
     * @throws IOException
     */
    public static void exportFile(File exportFile, IFile sourceFile) throws IOException {
        if (exportFile != null && sourceFile != null) {
            File file = new File(sourceFile.getRawLocation().toOSString());
            if (exportFile.exists()) {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS"); //$NON-NLS-1$
                File bakFile = new File(exportFile.getAbsolutePath() + "." + simpleDateFormat.format(new Date()) + ".bak"); //$NON-NLS-1$ //$NON-NLS-2$
                FilesUtils.copyFile(exportFile, bakFile);
            }
            FilesUtils.copyFile(file, exportFile);
        }
    }

    /**
     * DOC yyi Comment method "toLocalFileName".
     * 
     * @param src
     * @return localFileName
     */
    public static String toLocalFileName(String src) {

        if (!"Linux".equalsIgnoreCase(System.getProperty("os.name"))) { //$NON-NLS-1$ //$NON-NLS-2$

            int i;
            int srcLength = src.length();
            char j;
            StringBuffer tmp = new StringBuffer();
            tmp.ensureCapacity(src.length() * 6);

            for (i = 0; i < srcLength; i++) {
                j = src.charAt(i);
                if ('\\' == j) {
                    tmp.append("%5c"); //$NON-NLS-1$
                } else if ('/' == j) {
                    tmp.append("%2f"); //$NON-NLS-1$
                } else if (':' == j) {
                    tmp.append("%3a"); //$NON-NLS-1$
                } else if ('*' == j) {
                    tmp.append("%2a"); //$NON-NLS-1$
                } else if ('?' == j) {
                    tmp.append("%3f"); //$NON-NLS-1$
                } else if ('"' == j) {
                    tmp.append("%22"); //$NON-NLS-1$
                } else if ('<' == j) {
                    tmp.append("%3c"); //$NON-NLS-1$
                } else if ('>' == j) {
                    tmp.append("%3e"); //$NON-NLS-1$
                } else if ('|' == j) {
                    tmp.append("%7c"); //$NON-NLS-1$
                } else {
                    tmp.append(j);
                }
            }
            return tmp.length() > 255 ? tmp.toString().substring(0, 255) : tmp.toString();
        } else {
            return src.length() > 255 ? src.substring(0, 255) : src;
        }
    }
}