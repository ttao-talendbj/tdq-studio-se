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
package org.talend.dataprofiler.core.helper;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.talend.commons.utils.WorkspaceUtils;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.Folder;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.dataprofiler.core.CorePlugin;
import org.talend.dataprofiler.core.i18n.internal.DefaultMessagesImpl;
import org.talend.dataprofiler.core.ui.utils.MessageUI;
import org.talend.dq.helper.FileUtils;
import org.talend.dq.helper.RepositoryNodeHelper;
import org.talend.dq.nodes.SourceFileRepNode;
import org.talend.dq.nodes.SourceFileSubFolderNode;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IRepositoryNode;
import org.talend.resource.ResourceManager;
import org.talend.utils.sugars.ReturnCode;
import orgomg.cwm.objectmodel.core.ModelElement;

/**
 * 
 * DOC mzhao class global comment. Detailled comment
 */
public final class WorkspaceResourceHelper {

    private static final String ANALYSIS_EDITOR_ID = "org.talend.dataprofiler.core.ui.editor.analysis.AnalysisEditor"; //$NON-NLS-1$

    public static final String COMMA = ", "; //$NON-NLS-1$

    private WorkspaceResourceHelper() {
    }

    /**
     * 
     * DOC Administrator Comment method "getModelElementPath".
     * 
     * @param me
     * @return
     */
    public static IPath getModelElementPath(ModelElement me) {
        return WorkspaceUtils.getModelElementResource(me).getFullPath();
    }

    /**
     * DOC bZhou Comment method "getInstallPath".
     * 
     * @return the install path for the current release.
     */
    public static String getInstallPath() {
        return Platform.getInstallLocation().getURL().getPath().substring(1);
    }

    /**
     * DOC bZhou Comment method "getLocationPath".
     * 
     * @return
     */
    public static String getLocationPath() {
        return Platform.getInstanceLocation().getURL().getPath().substring(1);
    }

    /**
     * DOC bZhou Comment method "computeFileFromPlugin".
     * 
     * @param plugin
     * @param srcPath
     * @param recurse
     * @param desFolder
     * @param suffix
     * @param type
     * @param resultMap
     * @throws Exception
     */
    public static void computeFileFromPlugin(Plugin plugin, String srcPath, boolean recurse, Folder desFolder,
            Set<String> suffix, ERepositoryObjectType type, Map<File, IPath> resultMap) throws Exception {
        if (plugin == null || srcPath == null) {
            return;
        }

        IProject project = ResourceManager.getRootProject();
        Enumeration<String> paths = plugin.getBundle().getEntryPaths(srcPath);

        while (paths != null && paths.hasMoreElements()) {
            String nextElement = (String) paths.nextElement();
            String currentPath = "/" + nextElement; //$NON-NLS-1$
            URL resourceURL = plugin.getBundle().getEntry(currentPath);
            URL fileURL = null;
            File file = null;

            fileURL = FileLocator.toFileURL(resourceURL);
            file = new File(fileURL.getFile());
            String fileName = file.getName();
            if (file.isDirectory() && recurse) {
                if (fileName.startsWith(".")) { //$NON-NLS-1$
                    continue;
                }
                Folder folder = null;
                if (!project.getFolder(fileName).exists()) {
                    folder = ProxyRepositoryFactory.getInstance().createFolder(type, Path.EMPTY, fileName);
                } else {
                    IPath fullPath = new Path(file.getPath());
                    int count = fullPath.segmentCount();
                    FolderItem folderItem = ProxyRepositoryFactory.getInstance().getFolderItem(
                            ProjectManager.getInstance().getCurrentProject(), type, fullPath.removeFirstSegments(count - 1));

                    if (folderItem == null) {
                        folder = ProxyRepositoryFactory.getInstance().createFolder(type, Path.EMPTY, fileName);
                    } else {
                        folder = new Folder(folderItem.getProperty(), type);
                    }
                }
                computeFileFromPlugin(plugin, currentPath, recurse, folder, suffix, type, resultMap);
                continue;
            }

            // MOD msjian TDQ-4608 2012-3-6: deal with the *.jasper file
            if (suffix != null && !suffix.contains(FileUtils.getExtension(file))) { //$NON-NLS-1$
                continue;
            }

            String folderName = null;
            folderName = file.getParentFile().getName();
            // TDQ-4608 ~
            IFolder folder = project.getFolder(folderName);
            int segmentCount = folder.getFullPath().segmentCount();
            IPath parentPath = folder.getFullPath().removeFirstSegments(segmentCount - 1);

            resultMap.put(file, parentPath);
        }
    }

    /**
     * if the source file has been opened then return true.
     * 
     * @param sourceNode the source file node
     * @return
     */
    public static boolean sourceFileHasBeenOpened(IRepositoryNode sourceNode) {
        boolean opened = false;
        IWorkbenchWindow workbenchWindow = CorePlugin.getDefault().getWorkbench().getActiveWorkbenchWindow();
        if (workbenchWindow == null) {
            IWorkbenchWindow[] workbenchWindows = CorePlugin.getDefault().getWorkbench().getWorkbenchWindows();
            if (workbenchWindows != null && workbenchWindows.length > 0) {
                workbenchWindow = workbenchWindows[0];
            }
        }
        if (workbenchWindow != null) {
            IWorkbenchPage activePage = workbenchWindow.getActivePage();
            if (activePage != null) {
                IEditorReference[] editorReferences = activePage.getEditorReferences();
                if (editorReferences != null) {
                    for (IEditorReference reference : editorReferences) {
                        try {
                            IEditorInput editorInput = reference.getEditorInput();
                            if (editorInput != null && editorInput instanceof FileEditorInput) {
                                FileEditorInput fileInput = (FileEditorInput) editorInput;
                                IFile nodeFile = RepositoryNodeHelper.getIFile(sourceNode);
                                if (nodeFile != null
                                        && nodeFile.getFullPath().toString().equals(fileInput.getFile().getFullPath().toString())) {
                                    opened = true;
                                    break;
                                }
                            }
                        } catch (PartInitException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return opened;
    }

    /**
     * DOC xqliu Comment method "checkSourceFileNodeOpening".
     * 
     * @param node
     * @return
     */
    public static ReturnCode checkSourceFileNodeOpening(SourceFileRepNode node) {
        boolean opened = false;
        String msg = ""; //$NON-NLS-1$
        if (WorkspaceResourceHelper.sourceFileHasBeenOpened(node)) {
            opened = true;
            msg += node.getLabel() + COMMA;
        }
        return new ReturnCode(msg, opened);
    }

    /**
     * DOC xqliu Comment method "checkSourceFileSubFolderNodeOpening".
     * 
     * @param node
     * @return
     */
    public static ReturnCode checkSourceFileSubFolderNodeOpening(SourceFileSubFolderNode node) {
        boolean opened = false;
        String msg = ""; //$NON-NLS-1$
        List<IRepositoryNode> children = node.getChildren();
        for (IRepositoryNode iNode : children) {
            if (iNode instanceof SourceFileRepNode) {
                SourceFileRepNode fileNode = (SourceFileRepNode) iNode;
                ReturnCode rc = checkSourceFileNodeOpening(fileNode);
                if (rc.isOk()) {
                    opened = rc.isOk();
                    msg += rc.getMessage();
                }
            } else if (iNode instanceof SourceFileSubFolderNode) {
                SourceFileSubFolderNode folderNode = (SourceFileSubFolderNode) iNode;
                ReturnCode rc = checkSourceFileSubFolderNodeOpening(folderNode);
                if (rc.isOk()) {
                    opened = rc.isOk();
                    msg += rc.getMessage();
                }
            }
        }
        return new ReturnCode(msg, opened);
    }

    /**
     * DOC xqliu Comment method "showSourceFilesOpeningWarnMessages".
     * 
     * @param openSourceFileNames
     */
    public static void showSourceFilesOpeningWarnMessages(String openSourceFileNames) {
        if (openSourceFileNames.endsWith(COMMA)) {
            openSourceFileNames = openSourceFileNames.substring(0, openSourceFileNames.lastIndexOf(COMMA));
        }
        String msgTag = "SourceFileAction.sourceFileOpening"; //$NON-NLS-1$
        if (openSourceFileNames.indexOf(COMMA) > -1) {
            msgTag = "SourceFileAction.sourceFilesOpening"; //$NON-NLS-1$
        }
        MessageUI.openWarning(DefaultMessagesImpl.getString(msgTag, openSourceFileNames));
    }
}
