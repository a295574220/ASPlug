package com.sjie.Control;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Controls extends BaseBuilder{

    @Override
    public void build(SelectionModel selectionModel, Project project, Document document, int select) {
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                String builder;
                switch (select){
                    case 0:
                        builder=toolbar();
                        break;
                    case 1:
                        builder="";
                        break;
//                    case 2:
//                        builder=mullist();
//                        break;
                    default:
                        builder="";
                        break;

                }
                document.replaceString(start, end, builder);
            }
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
        selectionModel.removeSelection();
    }
    private String toolbar(){
        return "/**基类\n"
                +"public void addToolBar(final LinearLayout linearLayout, Toolbar toolbar){\n"
                +"    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,\n"
                +"            Toolbar.LayoutParams.WRAP_CONTENT);\n"
                +"    // 取控件aaa当前的布局参数\n"
                +"    params.height = dip2px(45.0f);        // 当控件的高强制设成150象素\n"
                +"    params.width=Toolbar.LayoutParams.MATCH_PARENT;\n"
                +"    linearLayout.addView(toolbar,0,params);\n"
                +"}\n"
                +"public int dip2px(float dip){\n"
                +"    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dip,getResources().getDisplayMetrics());\n"
                +"}*/\n"
                +"//调用\n"
                +"/**\n"
                +" Toolbar toolbar=new MyToolBar(this)\n"
                +"     .init().addTitle(\"登陆\")\n"
                +"     .addLogo()\n"
                +"     .setOverflowIcon()\n"
                +"     .addHome(0, new View.OnClickListener() {\n"
                +"    @Override\n"
                +"    public void onClick(View v) {\n"
                +"    finish();\n"
                +"    }\n"
                +"    });\n"
                +" this.addToolBar(binding.lineToolbar,toolbar);\n"
                +" */\n"
                +"public class MyToolBar {\n"
                +"    private Toolbar toolbar;\n"
                +"    private BaseActivity activity;\n"
                +"    public MyToolBar(@NonNull BaseActivity activity){\n"
                +"        this.activity=activity;\n"
                +"    }\n"
                +"    //第一步\n"
                +"    public MyToolBar init(){\n"
                +"        this.toolbar=new Toolbar(activity);\n"
                +"        this.toolbar.setTitleTextColor(Color.WHITE);\n"
                +"        this.toolbar.setBackgroundResource(R.color.colorPrimary);\n"
                +"        return this;\n"
                +"    }\n"
                +"    public MyToolBar addTitle(@NonNull String title){\n"
                +"        this.toolbar.setTitle(title);\n"
                +"        return this;\n"
                +"    }\n"
                +"    public MyToolBar setOverflowIcon(){\n"
                +"        this.toolbar.setOverflowIcon(activity.getResources().getDrawable(R.drawable.ic_more_vert_black_24dp));\n"
                +"        return this;\n"
                +"    }\n"
                +"    public MyToolBar addLogo(){\n"
                +"        this.toolbar.setLogo(R.drawable.ic_toolbar_logo);\n"
                +"        this.toolbar.setContentInsetStartWithNavigation(0);\n"
                +"        return this;\n"
                +"    }\n"
                +"    public MyToolBar setColor(@ColorRes int bgcolor,@ColorInt @ColorRes int titlecolor){\n"
                +"        toolbar.setTitleTextColor(titlecolor);\n"
                +"        toolbar.setBackgroundResource(bgcolor);\n"
                +"        return this;\n"
                +"    }\n"
                +"    public MyToolBar addMenu(int menu,Toolbar.OnMenuItemClickListener onMenuItemClickListener){\n"
                +"        toolbar.inflateMenu(menu);\n"
                +"        //设置选项菜单的菜单项的点击事件\n"
                +"        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);\n"
                +"        return this;\n"
                +"    }\n"
                +"    //最后一步\n"
                +"    public Toolbar addHome(int home, View.OnClickListener onClickListener){\n"
                +"        switch (home){\n"
                +"            case 0://菜单\n"
                +"                toolbar.setNavigationIcon(R.drawable.ic_format_list_bulleted_black_24dp);\n"
                +"                break;\n"
                +"            case 1://返回\n"
                +"                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);\n"
                +"                break;\n"
                +"            default:\n"
                +"                toolbar.setNavigationIcon(home);\n"
                +"                break;\n"
                +"        }\n"
                +"        toolbar.setNavigationOnClickListener(onClickListener);\n"
                +"        return toolbar;\n"
                +"    }\n"
                +"}\n";
    }
}
