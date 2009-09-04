// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.ui.action.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.action.Action;
import org.talend.commons.emf.FactoriesUtil;
import org.talend.cwm.dependencies.DependenciesHandler;
import org.talend.dataprofiler.core.ImageLib;
import org.talend.dataprofiler.core.i18n.internal.DefaultMessagesImpl;
import org.talend.dataquality.analysis.Analysis;
import org.talend.dataquality.helpers.ReportHelper;
import org.talend.dataquality.reports.TdReport;
import org.talend.dq.helper.resourcehelper.AnaResourceFileHelper;
import org.talend.dq.helper.resourcehelper.DQRuleResourceFileHelper;
import org.talend.dq.helper.resourcehelper.PatternResourceFileHelper;
import org.talend.dq.helper.resourcehelper.RepResourceFileHelper;
import org.talend.dq.helper.resourcehelper.UDIResourceFileHelper;
import org.talend.dq.writer.AElementPersistance;
import org.talend.dq.writer.EMFSharedResources;
import org.talend.dq.writer.impl.ElementWriterFactory;
import orgomg.cwm.objectmodel.core.ModelElement;

/**
 * DOC Zqin class global comment. Detailled comment
 */
public class DuplicateCWMResourceAction extends Action {

    private IFile[] files;

    public DuplicateCWMResourceAction(IFile[] files) {
        super(DefaultMessagesImpl.getString("DuplicateCWMResourceAction.Duplicate")); //$NON-NLS-1$
        setImageDescriptor(ImageLib.getImageDescriptor(ImageLib.EDIT_COPY));
        this.files = files;
    }

    @Override
    public void run() {
        if (files != null && files.length > 0) {
            for (IFile file : files) {

                ModelElement oldObject = getOldEObject(file);

                if (oldObject != null) {
                    ModelElement newObject = (ModelElement) EMFSharedResources.getInstance().copyEObject(oldObject);

                    IFile newFile = getNewFile(file);
                    newObject.setName("copy of " + newObject.getName()); //$NON-NLS-1$
                    // MOD 2009-01-06 mzhao copy analysis reference.
                    if (oldObject instanceof TdReport) {
                        List<Analysis> anaLs = ReportHelper.getAnalyses((TdReport) oldObject);
                        for (Analysis analysis : anaLs) {
                            DependenciesHandler.getInstance().setDependencyOn((TdReport) newObject, analysis);
                            ((TdReport) newObject).addAnalysis(analysis);
                        }
                    }

                    AElementPersistance elementPersistance = ElementWriterFactory.getInstance()
                            .create(newFile.getFileExtension());

                    elementPersistance.save(newObject, newFile);
                }
            }
        }
    }

    /**
     * DOC scorreia Comment method "getNewFile".
     * 
     * @param file
     * @return
     */
    private IFile getNewFile(IFile file) {
        IFile newFile = null;
        int idx = 1;
        while (true) {
            final String newFilename = "copy" + idx + file.getName(); //$NON-NLS-1$
            newFile = ((IFolder) file.getParent()).getFile(newFilename);
            if (!newFile.exists()) {
                break;
            }
            idx++;
        }
        return newFile;
    }

    private ModelElement getOldEObject(IFile file) {
        ModelElement object = null;
        if (FactoriesUtil.ANA.equals(file.getFileExtension())) {
            object = AnaResourceFileHelper.getInstance().findAnalysis(file);
        }

        if (FactoriesUtil.PATTERN.equals(file.getFileExtension())) {
            object = PatternResourceFileHelper.getInstance().findPattern(file);
        }
        // MOD 2009-01-03 mzhao Support duplicate report files.
        if (FactoriesUtil.REP.equals(file.getFileExtension())) {
            object = RepResourceFileHelper.getInstance().findReport(file);
        }
        // MOD 2009-04-28 mzhao Support duplicate dq rules files.
        if (FactoriesUtil.DQRULE.equals(file.getFileExtension())) {
            object = DQRuleResourceFileHelper.getInstance().findWhereRule(file);
        }

        // MOD 2009-09-02 yyi 8881: Add "Duplicate" menu on the user defined indicators
        if (FactoriesUtil.UDI.equals(file.getFileExtension())) {
            object = UDIResourceFileHelper.getInstance().findUDI(file);
        }

        return object;
    }
}
