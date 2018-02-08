package com.sjie.Behind;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sjie.BaseBuilder;
import com.sjie.Behind.Net_R.Retrofit;
import com.sjie.Behind.Net_V.Volleys;
import com.sjie.Behind_dialog;
import com.sjie.OnPatternSelectedListener;

import java.util.ArrayList;

public class Behind extends BaseGenerateAction implements OnPatternSelectedListener{
    public Behind() {
        super(null);
    }
    private AnActionEvent mEvent;
    private Behind_dialog behind_dialog;
    private boolean flag=false;
    private  BaseBuilder builder = null;
    @Override
    public void actionPerformed(AnActionEvent e) {
        this.mEvent=e;
        behind_dialog=new Behind_dialog();
        behind_dialog.setOnPatternSelectedListener(this);
        behind_dialog.setVisible(true);
        flag=false;
    }
    @Override
    public void onPatternSelected(int index) {
        if (mEvent==null)return;
        ArrayList<String> list=new ArrayList<>();
        if (!flag) {
            flag=true;
            switch (index) {
                case 0:
                    list.clear();
                    list.add("GET");
                    list.add("POST(JSON)");
                    builder = new Volleys();
                    break;
                case 1:
                    list.clear();
                    list.add("HttpService   (类)");
                    list.add("文件上传      (方法)");
                    list.add("POST(JSON)");
                    builder = new Retrofit();
                    break;
            }
            behind_dialog.setList1(list);
        }else {
            flag=false;
            if (builder != null) {
                builder.build(mEvent,index);
            }
        }

    }
}
