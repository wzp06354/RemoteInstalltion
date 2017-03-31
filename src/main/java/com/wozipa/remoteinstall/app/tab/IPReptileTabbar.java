package com.wozipa.remoteinstall.app.tab;

import com.wozipa.remoteinstall.util.ColorsUtils;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by wozipa on 2017/3/27.
 */
public class IPReptileTabbar extends TabItem {

    private static final Logger LOGGER=Logger.getLogger(IPReptileTabbar.class);

    private TabFolder parent;
    private int style;
    private Composite composite;

    private Text firstStart;
    private Text firstEnd;
    private Text secondStart;
    private Text secondEnd;
    private Text thirdStart;
    private Text thirdEnd;
    private Text fouthStart;
    private Text fouthEnd;

    private Text ipList=null;

    public IPReptileTabbar(TabFolder tabFolder, int i) {
        super(tabFolder, i);
        this.parent=tabFolder;
        this.style=i;
        this.composite=new Composite(this.parent,style);
        this.setText("IP Reptile");
        this.setControl(composite);
        //
        this.composite.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        this.composite.setLayout(new GridLayout(10,false));
        //
        createContent();
    }

    @Override
    protected void checkSubclass() {

    }

    public void createContent()
    {
        createIpRangeArea();
        createIPListArea();
        createButtonArea();
    }

    public void createIpRangeArea()
    {
        Label label=new Label(this.composite,this.style);
        label.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        label.setText("IP范围");
        label.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false,1,1));
        //
        Group group=new Group(this.composite,SWT.NONE);
        group.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false,9,1));
        group.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        group.setLayout(new GridLayout(15,false));
        //first ip range
        firstStart=initText(group,firstStart);
        firstStart.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        Label label1=new Label(group,style);
        label1.setText("-");
        label1.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false,1,1));
        label1.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        firstEnd=initText(group,firstEnd);
        firstEnd.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        Label point1=new Label(group,style);
        point1.setText(".");
        point1.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false,1,1));
        //second ip range
        secondStart=initText(group,secondStart);
        secondStart.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        Label label2=new Label(group,style);
        label2.setText("-");
        label2.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false,1,1));
        label2.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        secondEnd=initText(group,secondEnd);
        secondEnd.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        //
        Label point2=new Label(group,style);
        point2.setText(".");
        point2.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        point2.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        //thrrd ip range
        thirdStart=initText(group,thirdStart);
        thirdStart.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        Label label3=new Label(group,style);
        label3.setText("-");
        label3.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        thirdEnd=initText(group,thirdEnd);
        thirdEnd.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        //
        Label point3=new Label(group,style);
        point3.setText(".");
        point3.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        point3.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        fouthStart=initText(group,fouthStart);
        fouthStart.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        //
        Label label4=new Label(group,this.style);
        label4.setText("-");
        label4.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        fouthEnd=initText(group,this.fouthEnd);
        fouthEnd.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
    }

    public Text initText(Composite group, Text txt)
    {
        txt=new Text(group,SWT.BORDER);
        txt.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        txt.setTextLimit(3);
        txt.setEditable(true);
        return txt;
    }

    public void createIPListArea()
    {
        Label label=new Label(this.composite,style);
        label.setText("IP列表");
        label.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        label.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        //
        this.ipList=new Text(this.composite,style|SWT.BORDER);
        this.ipList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,9,1));
    }

    public void createButtonArea()
    {
        Label label=new Label(this.composite,style);
        label.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
        label.setBackground(ColorsUtils.GetColor(ColorsUtils.WHITE));
        //
        Button submit=new Button(this.composite,this.style);
        submit.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false,9,1));
        submit.setText("获取IP");
    }


}
