package com.sjie.Dialog;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElementFactory;
import com.sjie.BaseBuilder;

/**
 * author WangYi
 * created on 2017/1/15.
 */
public class SelectDialog extends BaseBuilder {
    @Override
    public void build(SelectionModel selectionModel, Project project, Document document,int select) {
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                String builder;
                switch (select){
                    case 0:
                        builder=easy();
                        break;
                    case 1:
                        builder=list();
                        break;
                    case 2:
                        builder=mullist();
                        break;
                    case 3:
                        builder=datepick();
                        break;
                    case 4:
                        builder=input();
                        break;
                    case 5:
                        builder=waitdialog();
                        break;
                    case 6:
                        builder=processdialog();
                        break;
                    case 7:
                        builder=mydialog();
                        break;
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
    private String easy(){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append("new AlertDialog.Builder(MainActivity.this)\n");
                stringBuilder.append("        .setIcon(R.drawable.icon_dialog);\n");
                stringBuilder.append("        .setTitle(\"This is Dialog\")\n");
                stringBuilder.append("        .setMessage(\"Something important.\")\n");
                stringBuilder.append("        .setCancelable(true)\n");
                stringBuilder.append("        .setPositiveButton(\"OK\", new DialogInterface.OnClickListener() {\n");
                stringBuilder.append("            @Override\n");
                stringBuilder.append("            public void onClick(DialogInterface dialog, int which) {\n");
                stringBuilder.append("            }\n");
                stringBuilder.append("        })\n");
                stringBuilder.append("        .setNegativeButton(\"Cancel\", new DialogInterface.\n");
                stringBuilder.append("                OnClickListener() {\n");
                stringBuilder.append("            @Override\n");
                stringBuilder.append("            public void onClick(DialogInterface dialog, int which) {\n");
                stringBuilder.append("            }\n");
                stringBuilder.append("        })\n");
                stringBuilder.append("        .show();\n");
        return stringBuilder.toString();
    }
    private String list(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("new AlertDialog.Builder(getActivity()) // build AlertDialog\n");
        stringBuilder.append("        .setTitle(\"选择语言\") // title\n");
        stringBuilder.append("        .setItems(R.array.filemanage_choose, new  DialogInterface.OnClickListener() { //content\n");
        stringBuilder.append("            @Override\n");
        stringBuilder.append("            public void onClick(DialogInterface dialog, int which) {\n");
        stringBuilder.append("              switch (which){\n");
        stringBuilder.append("                  case 0:\n");
        stringBuilder.append("                        \n");
        stringBuilder.append("                      break;\n");
        stringBuilder.append("              }\n");
        stringBuilder.append("\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        }) .show();\n");

        return stringBuilder.toString();
    }
    private String mullist(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" AlertDialog.Builder Builder = new AlertDialog.Builder(this);\n");
        stringBuilder.append("        Builder.setTitle(\"车间组别\");\n");
        stringBuilder.append("        group.delete(0,group.length());\n");
        stringBuilder.append("\n");
        stringBuilder.append("        Builder.setMultiChoiceItems(strs_group,null, new DialogInterface.OnMultiChoiceClickListener() {\n");
        stringBuilder.append("            @Override\n");
        stringBuilder.append("            public void onClick(DialogInterface dialog, int which, boolean isChecked) {\n");
        stringBuilder.append("\n");
        stringBuilder.append("                if (isChecked){\n");
        stringBuilder.append("                    group.append(strs_group[which]+\",\");\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("\n");
        stringBuilder.append("        });\n");
        stringBuilder.append("        Builder.setPositiveButton(\"确定\", new DialogInterface.OnClickListener()\n");
        stringBuilder.append("        {\n");
        stringBuilder.append("            @Override\n");
        stringBuilder.append("            public void onClick(DialogInterface dialog, int which)\n");
        stringBuilder.append("            {\n");
        stringBuilder.append("                tv_workgroup.setText(group.deleteCharAt(group.length()-1).toString());\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        });\n");
        stringBuilder.append("        Builder.setNegativeButton(\"取消\", new DialogInterface.OnClickListener()\n");
        stringBuilder.append("        {\n");
        stringBuilder.append("            @Override\n");
        stringBuilder.append("            public void onClick(DialogInterface dialog, int which)\n");
        stringBuilder.append("            {\n");
        stringBuilder.append("\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        });\n");
        stringBuilder.append("        Builder.show();\n");
        return stringBuilder.toString();
    }
    private String datepick(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {\n");
        stringBuilder.append("        //此处写在外面或其他方法内    \n");
        stringBuilder.append("        //Calendar calendar= Calendar.getInstance();\n");
        stringBuilder.append("        //DatePickerDialog dpd2 = new DatePickerDialog(this, Datelistener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));\n");
        stringBuilder.append("        //dpd2.show();\n");
        stringBuilder.append("        @Override\n");
        stringBuilder.append("        public void onDateSet(DatePicker view, int myyear, int monthOfYear, int dayOfMonth) {\n");
        stringBuilder.append("            String month=\"\";\n");
        stringBuilder.append("            String day=\"\";\n");
        stringBuilder.append("            if (monthOfYear<9){\n");
        stringBuilder.append("                month=\"0\"+(monthOfYear+1);\n");
        stringBuilder.append("            }else {\n");
        stringBuilder.append("                month=\"\"+(monthOfYear+1);\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("            if (dayOfMonth<10){\n");
        stringBuilder.append("                day=\"0\"+dayOfMonth;\n");
        stringBuilder.append("            }else {\n");
        stringBuilder.append("                day=\"\"+dayOfMonth;\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("               // end_date.setText(myyear + \"-\" +month + \"-\" + day);\n");
        stringBuilder.append("\n");
        stringBuilder.append("        }\n");
        stringBuilder.append("    };\n");
        return stringBuilder.toString();
    }
    private String input(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("final EditText input=new EditText();\n");
        stringBuilder.append("new AlertDialog.Builder(this)  \n");
        stringBuilder.append("                .setTitle(\"请输入好友账号\")  \n");
        stringBuilder.append("                .setView(input)  \n");
        stringBuilder.append("                .setPositiveButton(\"确定\",  \n");
        stringBuilder.append("                        new DialogInterface.OnClickListener() {  \n");
        stringBuilder.append("                            public void onClick(DialogInterface dialog,  \n");
        stringBuilder.append("                                    int which) {  \n");
        stringBuilder.append("                                String value = input.getText().toString ();  \n");
        stringBuilder.append("                                setTitle(value);  \n");
        stringBuilder.append("                            }  \n");
        stringBuilder.append("                         });  \n");
        stringBuilder.append("//.setPositiveButton(\"登陆\", new DialogInterfaceOnClick2())  //设置确定按 钮并且绑定监听事件\n");
        stringBuilder.append("//.setNeutralButton(\"修改\", new DialogInterfaceOnClick3())   //设置修改按 钮并且绑定监听事件\n");
        stringBuilder.append("//.setNegativeButton(\"退出\", new DialogInterfaceOnClick6())  //设置取消按 钮并且绑定监听事件\n");
        stringBuilder.append(".create();//设置取消按钮并创建\n");
        stringBuilder.append(".show();//显示\n");
        return stringBuilder.toString();
    }
    private String waitdialog(){
        return "ProgressDialog waitingDialog= new ProgressDialog(MainActivity.this);\n"
                +"waitingDialog.setTitle(\"我是一个等待Dialog\");\n"
                +"waitingDialog.setMessage(\"等待中...\");\n"
                +"waitingDialog.setIndeterminate(true);\n"
                +"waitingDialog.setCancelable(false);\n"
                +"waitingDialog.show();\n";
    }
    private String processdialog(){
        return "final int MAX_PROGRESS = 100;\n"
                +"final ProgressDialog progressDialog =\n"
                +"        new ProgressDialog(MainActivity.this);\n"
                +"progressDialog.setProgress(0);\n"
                +"progressDialog.setTitle(\"我是一个进度条Dialog\");\n"
                +"progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);\n"
                +"progressDialog.setMax(MAX_PROGRESS);\n"
                +"progressDialog.show();\n"
                +"/* 模拟进度增加的过程\n"
                +" * 新开一个线程，每个100ms，进度增加1\n"
                +" */\n"
                +"new Thread(new Runnable() {\n"
                +"    @Override\n"
                +"    public void run() {\n"
                +"        int progress= 0;\n"
                +"        while (progress < MAX_PROGRESS){\n"
                +"            try {\n"
                +"                Thread.sleep(100);\n"
                +"                progress++;\n"
                +"                progressDialog.setProgress(progress);\n"
                +"            } catch (InterruptedException e){\n"
                +"                e.printStackTrace();\n"
                +"            }\n"
                +"        }\n"
                +"        // 进度达到最大值后，窗口消失\n"
                +"        progressDialog.cancel();\n"
                +"    }\n"
                +"}).start();\n";
    }
    private String mydialog(){
        return "AlertDialog.Builder customizeDialog =\n"
                +"        new AlertDialog.Builder(MainActivity.this);\n"
                +"final View dialogView = LayoutInflater.from(MainActivity.this)\n"
                +"        .inflate(R.layout.dialog_customize,null);\n"
                +"customizeDialog.setTitle(\"我是一个自定义Dialog\");\n"
                +"customizeDialog.setView(dialogView);\n"
                +"customizeDialog.setPositiveButton(\"确定\",\n"
                +"        new DialogInterface.OnClickListener() {\n"
                +"    @Override\n"
                +"    public void onClick(DialogInterface dialog, int which) {\n"
                +"        // 获取EditView中的输入内容\n"
                +"        EditText edit_text =\n"
                +"                (EditText) dialogView.findViewById(R.id.edit_text);\n"
                +"        Toast.makeText(MainActivity.this,\n"
                +"                edit_text.getText().toString(),\n"
                +"                Toast.LENGTH_SHORT).show();\n"
                +"    }\n"
                +"});\n"
                +"customizeDialog.show();\n";

    }
}
