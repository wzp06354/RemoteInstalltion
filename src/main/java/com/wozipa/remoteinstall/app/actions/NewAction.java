package com.wozipa.remoteinstall.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;


/**
 * Created by USER on 2017/3/21.
 */
public class NewAction extends Action{

   public NewAction()
   {
       super();
        this.setText("新建");
        this.setAccelerator(SWT.ALT + SWT.SHIFT + 'N');
   }

    @Override
    public void run() {

    }
}
