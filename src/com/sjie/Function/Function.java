package com.sjie.Function;

import com.intellij.codeInsight.CodeInsightActionHandler;
import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sjie.BaseBuilder;
import com.sjie.Function_dialog;
import com.sjie.OnPatternSelectedListener;

public class Function extends BaseGenerateAction implements OnPatternSelectedListener {
    public Function() {
        super(null);
    }
    private AnActionEvent mEvent;
    @Override
    public void actionPerformed(AnActionEvent e) {
        this.mEvent=e;
        Function_dialog function_dialog=new Function_dialog();
        function_dialog.setOnPatternSelectedListener(this);
        function_dialog.setVisible(true);
    }
    @Override
    public void onPatternSelected(int index) {
        if (mEvent==null)return;
        BaseBuilder baseBuilder=new Functions();
        if (baseBuilder!=null)
            baseBuilder.build(mEvent,index);
    }
}
