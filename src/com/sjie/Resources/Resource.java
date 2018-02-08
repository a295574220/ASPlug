package com.sjie.Resources;


import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import com.sjie.BaseBuilder;
import com.sjie.Behind.Net_R.Retrofit;
import com.sjie.Behind.Net_V.Volleys;
import com.sjie.Behind_dialog;
import com.sjie.OnPatternSelectedListener;
import com.sjie.Resource_dialog;


import java.util.ArrayList;

public class Resource extends AnAction implements OnPatternSelectedListener {
    public Resource() {
        super("");
    }
    private AnActionEvent mEvent;
    private Resource_dialog behind_dialog;
    @Override
    public void actionPerformed(AnActionEvent e) {
        this.mEvent=e;
        behind_dialog=new Resource_dialog();
        behind_dialog.setOnPatternSelectedListener(this);
        behind_dialog.setVisible(true);
    }
    @Override
    public void onPatternSelected(int index) {
        if (mEvent==null)return;
         BaseBuilder builder = null;
            builder = new Resources();
            if (builder != null) {
                builder.build(mEvent,index);
            }

    }
}
