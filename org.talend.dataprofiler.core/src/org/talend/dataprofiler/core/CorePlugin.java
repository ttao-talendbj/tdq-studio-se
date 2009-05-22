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
package org.talend.dataprofiler.core;

import java.util.List;

import net.sourceforge.sqlexplorer.EDriverName;
import net.sourceforge.sqlexplorer.ExplorerException;
import net.sourceforge.sqlexplorer.dbproduct.Alias;
import net.sourceforge.sqlexplorer.dbproduct.AliasManager;
import net.sourceforge.sqlexplorer.dbproduct.ManagedDriver;
import net.sourceforge.sqlexplorer.dbproduct.Session;
import net.sourceforge.sqlexplorer.dbproduct.User;
import net.sourceforge.sqlexplorer.plugin.SQLExplorerPlugin;
import net.sourceforge.sqlexplorer.plugin.editors.SQLEditor;
import net.sourceforge.sqlexplorer.plugin.editors.SQLEditorInput;
import net.sourceforge.sqlexplorer.sqleditor.actions.ExecSQLAction;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.help.internal.base.BaseHelpSystem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.talend.cwm.helper.DataProviderHelper;
import org.talend.cwm.softwaredeployment.TdDataProvider;
import org.talend.cwm.softwaredeployment.TdProviderConnection;
import org.talend.dataprofiler.core.exception.ExceptionHandler;
import org.talend.dataprofiler.core.ui.views.DQRespositoryView;
import org.talend.dataprofiler.help.BookMarkEnum;
import org.talend.dq.helper.resourcehelper.PrvResourceFileHelper;
import org.talend.utils.ProductVersion;
import org.talend.utils.sugars.TypedReturnCode;
import orgomg.cwm.foundation.softwaredeployment.DataProvider;

/**
 * The activator class controls the plug-in life cycle.
 */
public class CorePlugin extends AbstractUIPlugin {

    protected static Logger log = Logger.getLogger(CorePlugin.class);

    private DQRespositoryView respositoryView;

    /**
     * Getter for respositoryView.
     * 
     * @return the respositoryView
     */
    public DQRespositoryView getRespositoryView() {
        return this.respositoryView;
    }

    /**
     * Sets the respositoryView.
     * 
     * @param respositoryView the respositoryView to set
     */
    public void setRespositoryView(DQRespositoryView respositoryView) {
        this.respositoryView = respositoryView;
    }

    // The plug-in ID
    public static final String PLUGIN_ID = "org.talend.dataprofiler.core"; //$NON-NLS-1$

    // The shared instance
    private static CorePlugin plugin;

    private RefreshAction refreshAction;

    /**
     * The constructor.
     */
    public CorePlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        getPreferenceStore().setDefault(PluginConstant.CHEAT_SHEET_VIEW, true);
        try {
            for (BookMarkEnum bookMark : BookMarkEnum.VALUES) {
                BaseHelpSystem.getBookmarkManager().addBookmark(bookMark.getHref(), bookMark.getLabel());
            }
        } catch (Exception e) {
            log.error(e, e);
        }

        IProject rootProject = ResourceManager.getRootProject();
        org.talend.dataquality.PluginConstant.setRootProjectName(rootProject.getName());
        SQLExplorerPlugin.getDefault().setRootProject(rootProject);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext )
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
        // save();
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static CorePlugin getDefault() {
        return plugin;
    }

    // public void save() {
    // NeedSaveDataProviderHelper.saveAllDataProvider();
    // }

    /**
     * Returns an image descriptor for the image file at the given plug-in relative path.
     * 
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    // public void loadExternalDriver(String driverPaths, String driverName,
    // String url) {
    // String[] driverJarPath = driverPaths.split(";");
    // LinkedList<String> driverFile = new LinkedList<String>();
    // for (String driverpath : driverJarPath) {
    // driverFile.add(driverpath);
    // }
    // ManagedDriver driver = new
    // ManagedDriver(SQLExplorerPlugin.getDefault().getDriverModel
    // ().createUniqueId());
    // driver.setJars(driverFile);
    // driver.setDriverClassName(driverName);
    // driver.setUrl(url);
    // SQLExplorerPlugin.getDefault().getDriverModel().addDriver(driver);
    // }

    /**
     * DOC Zqin Comment method "getCurrentActiveEditor".
     * 
     * @return the current active editor;
     */
    public IEditorPart getCurrentActiveEditor() {
        return getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    }

    /**
     * DOC Zqin Comment method "runInDQViewer". this method open DQ responsitory view and run the specified query.
     * 
     * @param tdDataProvider
     * @param query
     */
    public void runInDQViewer(TdDataProvider tdDataProvider, String query, String editorName) {
        SQLEditor sqlEditor = openInSqlEditor(tdDataProvider, query, editorName);
        Session session = sqlEditor.getSession();
        if (sqlEditor != null && session != null) {
            new ExecSQLAction(sqlEditor).run();
        }
    }

    /**
     * DOC bZhou Comment method "openInSqlEditor".
     * 
     * @param tdDataProvider
     * @param query
     * @param editorName
     * @return the specified sql editor.
     */
    public SQLEditor openInSqlEditor(TdDataProvider tdDataProvider, String query, String editorName) {
        if (editorName == null) {
            editorName = String.valueOf(SQLExplorerPlugin.getDefault().getEditorSerialNo());
        }

        SQLExplorerPlugin sqlPlugin = SQLExplorerPlugin.getDefault();
        AliasManager aliasManager = sqlPlugin.getAliasManager();

        Alias alias = aliasManager.getAlias(tdDataProvider.getName());

        if (alias == null) {
            List<TdDataProvider> allDataProviders = PrvResourceFileHelper.getInstance().getAllDataProviders(
                    ResourceManager.getMetadataFolder());
            for (TdDataProvider dataProvider : allDataProviders) {
                if (dataProvider == tdDataProvider) {
                    addConnetionAliasToSQLPlugin(dataProvider);
                    openInSqlEditor(tdDataProvider, query, editorName);
                }
            }
        } else {
            try {
                SQLEditorInput input = new SQLEditorInput("SQL Editor (" + editorName + ").sql"); //$NON-NLS-1$ //$NON-NLS-2$
                input.setUser(alias.getDefaultUser());
                IWorkbenchPage page = SQLExplorerPlugin.getDefault().getActivePage();
                SQLEditor editorPart = (SQLEditor) page.openEditor((IEditorInput) input, SQLEditor.class.getName());
                editorPart.setText(query);
                return editorPart;
            } catch (PartInitException e) {
                log.error(e, e);
            }
        }

        return null;
    }

    /**
     * DOC bZhou Comment method "addConnetionAliasToSQLPlugin".
     * 
     * @param dataproviders
     */
    public void addConnetionAliasToSQLPlugin(DataProvider... dataproviders) {
        SQLExplorerPlugin sqlPlugin = SQLExplorerPlugin.getDefault();
        AliasManager aliasManager = sqlPlugin.getAliasManager();

        for (DataProvider dataProvider : dataproviders) {
            try {
                TypedReturnCode<TdProviderConnection> tdPc = DataProviderHelper.getTdProviderConnection(dataProvider);
                TdProviderConnection providerConnection = tdPc.getObject();

                Alias alias = new Alias(dataProvider.getName());

                String clearTextUser = DataProviderHelper.getClearTextUser(providerConnection);
                String user = "".equals(clearTextUser) ? "root" : clearTextUser;
                String password = DataProviderHelper.getClearTextPassword(providerConnection);

                String url = providerConnection.getConnectionString();

                User previousUser = new User(user, password);
                alias.setDefaultUser(previousUser);

                alias.setAutoLogon(false);
                alias.setConnectAtStartup(true);
                alias.setUrl(url);
                ManagedDriver manDr = sqlPlugin.getDriverModel().getDriver(
                        EDriverName.getId(providerConnection.getDriverClassName()));
                alias.setDriver(manDr);
                aliasManager.addAlias(alias);

            } catch (ExplorerException e) {
                log.error(e, e);
            }
        }

        aliasManager.modelChanged();
    }

    /**
     * DOC bZhou Comment method "removeConnetionAliasFromSQLPlugin".
     * 
     * @param dataproviders
     */
    public void removeConnetionAliasFromSQLPlugin(DataProvider... dataproviders) {
        SQLExplorerPlugin sqlPlugin = SQLExplorerPlugin.getDefault();
        AliasManager aliasManager = sqlPlugin.getAliasManager();

        for (DataProvider dataProvider : dataproviders) {
            try {
                String aliasName = dataProvider.getName();
                Alias alias = aliasManager.getAlias(aliasName);

                for (IEditorReference editorRef : sqlPlugin.getActivePage().getEditorReferences()) {
                    IEditorPart editor = editorRef.getEditor(false);
                    if (editor instanceof SQLEditor) {
                        SQLEditor sqlEditor = (SQLEditor) editor;
                        if (sqlEditor.getSession().getUser().getAlias() == alias) {
                            sqlPlugin.getActivePage().closeEditor(sqlEditor, true);
                        }
                    }
                }

                if (alias != null) {
                    aliasManager.removeAlias(aliasName);
                }
            } catch (Exception e) {
                log.error(e, e);
            }
        }
    }

    /**
     * DOC bZhou Comment method "openEditor".
     * 
     * @param file
     * @param editorId
     * @return
     */
    public IEditorPart openEditor(IFile file, String editorId) {
        FileEditorInput input = new FileEditorInput(file);
        // input.setUser(alias.getDefaultUser());
        try {

            return this.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, editorId);
        } catch (PartInitException e) {
            ExceptionHandler.process(e);
            return null;
        }
    }

    /**
     * Get viewPart with special partId. If the active page doesn't exsit, the method will return null; Else, it will
     * get the viewPart and focus it. if the viewPart closed, it will be opened.
     * 
     * @param viewId the identifier of viewPart
     * @return
     */
    public IViewPart findView(String viewId) {
        IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWorkbenchWindow == null) {
            return null;
        }
        IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
        if (page == null) {
            return null;
        }
        IViewPart part = page.findView(viewId);
        if (part == null) {
            try {
                part = page.showView(viewId);
            } catch (Exception e) {
                ExceptionHandler.process(e, Level.ERROR);
            }
        } else {
            page.bringToTop(part);
        }
        return part;
    }

    public void refreshWorkSpace() {
        if (refreshAction == null) {
            refreshAction = new RefreshAction(PlatformUI.getWorkbench().getActiveWorkbenchWindow());

        }
        refreshAction.run();
    }

    public void refreshDQView() {
        ((DQRespositoryView) findView(DQRespositoryView.ID)).getCommonViewer().refresh();
    }

    /**
     * DOC bzhou Comment method "getProductVersion".
     * 
     * @return
     */
    public ProductVersion getProductVersion() {
        Object obj = plugin.getBundle().getHeaders().get(org.osgi.framework.Constants.BUNDLE_VERSION);
        ProductVersion currentVersion = ProductVersion.fromString(obj.toString());
        return currentVersion;
    }
}
