package com.wozipa.remoteinstall.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Created by USER on 2017/3/21.
 */
public class SSHTab extends CTabItem {

    private CTabFolder parent;
    private int style;
    private Composite composite=null;

    public SSHTab(CTabFolder cTabFolder, int i) {
        super(cTabFolder, i);
        this.parent=cTabFolder;
        this.style=i;
        //
        this.composite=new Composite(parent,style);
        this.setControl(composite);
        this.setShowClose(true);
        this.setText("SSH无密码配置");
        //
        composite.setLayout(new GridLayout(4,false));
        composite.setBackground(new Color(null,new RGB(255,255,255)));
        //init the size
    }

    public void createContent()
    {

    }
}
