package com.sjie.Dialog;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sjie.BaseBuilder;
import com.sjie.Dialog_dialog;
import com.sjie.OnPatternSelectedListener;

public class Dialog extends BaseGenerateAction implements OnPatternSelectedListener {
    public Dialog() {
        super(null);
    }
    private AnActionEvent mEvent;
    @Override
    public void actionPerformed(AnActionEvent e) {
        this.mEvent = e;
        Dialog_dialog dialog = new Dialog_dialog();
        dialog.setOnPatternSelectedListener(this);
        dialog.setVisible(true);
    }

    @Override
    public void onPatternSelected(int index) {
        if (mEvent == null) return;
        BaseBuilder builder = null;
        builder = new SelectDialog();
        if (builder != null) {
            builder.build(mEvent,index);
        }
    }
}
