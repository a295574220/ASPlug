package com.sjie.Gradle;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sjie.BaseBuilder;
import com.sjie.Dialog.SelectDialog;
import com.sjie.Dialog_dialog;
import com.sjie.Gradle_dialog;
import com.sjie.OnPatternSelectedListener;

public class Gradle extends AnAction implements OnPatternSelectedListener{
    private AnActionEvent mEvent;
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        this.mEvent = anActionEvent;
        Gradle_dialog dialog = new Gradle_dialog();
        dialog.setOnPatternSelectedListener(this);
        dialog.setVisible(true);
    }

    @Override
    public void onPatternSelected(int index) {
        if (mEvent == null) return;
        BaseBuilder builder = null;
        builder = new Gradles();
        if (builder != null) {
            builder.build(mEvent,index);
        }
    }
}
