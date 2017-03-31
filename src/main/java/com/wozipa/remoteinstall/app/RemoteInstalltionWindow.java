package com.wozipa.remoteinstall.app;

import com.wozipa.remoteinstall.app.actions.AboutAction;
import com.wozipa.remoteinstall.app.actions.ConfigAction;
import com.wozipa.remoteinstall.app.actions.NewAction;
import com.wozipa.remoteinstall.app.config.RIConfig;
import com.wozipa.remoteinstall.app.tab.IPReptileTabbar;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.*;

/**
 * Created by wozipa on 2017/3/21.
 */
public class RemoteInstalltionWindow extends ApplicationWindow {

    private static final Logger LOGGER= Logger.getLogger(RemoteInstalltionWindow.class);

    private TabFolder content;
    private NewAction newAction=null;

    public static void main(String[] args)
    {
        RemoteInstalltionWindow window=new RemoteInstalltionWindow();
        window.setBlockOnOpen(true);
        window.open();
        Display.getCurrent().dispose();
    }

    public RemoteInstalltionWindow()
    {
        super(null);
        //
        newAction=new NewAction();
        //
        this.addMenuBar();
        this.addToolBar(SWT.FILL);
        this.addStatusLine();
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText("分发工具");
        shell.setMaximized(true);
        shell.setSize(RIConfig.RI_APP_WIDTH,RIConfig.RI_APP_HEIGH);
    }

    @Override
    protected Control createContents(Composite parent) {
        parent.setBackground(new Color(null,new RGB(255,255,255)));
        this.content=new TabFolder(parent,SWT.NONE);
        IPReptileTabbar ipReptileTabbar=new IPReptileTabbar(content,SWT.NONE);
        return parent;
    }

    @Override
    protected IToolBarManager createToolBarManager2(int style) {
        ToolBarManager toolBarManager=new ToolBarManager(style);
        toolBarManager.add(newAction);
        return toolBarManager;
    }

    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuManager=new MenuManager();
        //
        MenuManager fileMenu=new MenuManager("文件");
        MenuManager configMenu=new MenuManager("配置");
        MenuManager helpMenu=new MenuManager("帮助");
        menuManager.add(fileMenu);
        menuManager.add(configMenu);
        menuManager.add(helpMenu);
        //create the button list menu on the menu bar
        fileMenu.add(newAction);
        //create the button list menu on the config bar
        ConfigAction configAction=new ConfigAction();
        configMenu.add(configAction);
        //create the button list menu on the help menu
        AboutAction aboutAction=new AboutAction();
        helpMenu.add(aboutAction);
        //return the menumanager
        return menuManager;
    }
}
