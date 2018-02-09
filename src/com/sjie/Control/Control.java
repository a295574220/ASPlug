package com.sjie.Control;

import com.intellij.codeInsight.CodeInsightActionHandler;
import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sjie.BaseBuilder;
import com.sjie.Behind_dialog;
import com.sjie.Control_dialog;
import com.sjie.OnPatternSelectedListener;

public class Control extends BaseGenerateAction implements OnPatternSelectedListener{
    public Control() {
        super(null);
    }
    private AnActionEvent mevent;
    @Override
    public void actionPerformed(AnActionEvent e) {
        this.mevent=e;
        Control_dialog control_dialog=new Control_dialog();
        control_dialog.setOnPatternSelectedListener(this);
        control_dialog.setVisible(true);
    }

    @Override
    public void onPatternSelected(int index) {
        if (mevent==null)return;
        BaseBuilder builder=new Controls();
        if (builder != null) {
            builder.build(mevent,index);
        }
    }
}
