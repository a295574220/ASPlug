package com.sjie.Gradle;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Gradles extends BaseBuilder {
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
                        builder=setname();
                        break;
                    case 1:
                        builder=appname();
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
    private String setname(){
        return "    //签名信息配置在android {下\n"
                +"    signingConfigs {\n"
                +"        release {\n"
                +"            storeFile file(\"C:\\Users\\admin\\Desktop\\123.jks\")\n"
                +"            keyAlias \"key0\"\n"
                +"            storePassword \"123456\"\n"
                +"            keyPassword \"123456\"\n"
                +"        }\n"
                +"    //signingConfig signingConfigs.release\n"
                +"    //signingConfig signingConfigs.debug\n"
                +"    }\n";
    }
    private String appname(){
        return "    buildTypes {\n"
                +"        release {\n"
                +"            minifyEnabled false   //允许最小化会开启下列代码，作用是剥离未使用的代码并对符号做模糊处理，使app很难被反向工程\n"
                +"//前一部分代表系统默认的android程序的混淆文件，该文件已经包含了基本的混淆声明，后一个文件是自己的定义混淆文件\n"
                +"            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'\n"
                +"            signingConfig signingConfigs.release\n"
                +"// 输出apk名称  自定义+v版本号+时间.apk\n"
                +"            buildConfigField(\"boolean\", \"YLog\", \"false\");\n"
                +"            android.applicationVariants.all { variant ->\n"
                +"                    variant.outputs.each { output ->\n"
                +"                    def outputFile = output.outputFile\n"
                +"                if (outputFile != null && outputFile.name.endsWith('.apk')) {\n"
                +"                    File outputDirectory = new File(outputFile.parent);\n"
                +"                    def fileName\n"
                +"                    if (variant.buildType.name == \"release\") {\n"
                +"                        fileName = \"MMHF_V${defaultConfig.versionName}_${releaseTime()}.apk\"\n"
                +"                        output.outputFile = new File(outputDirectory, fileName)\n"
                +"                    }\n"
                +"                }\n"
                +"            }\n"
                +"            }\n"
                +"        }\n"
                +"        debug {\n"
                +"            debuggable true\n"
                +"            minifyEnabled false\n"
                +"            signingConfig signingConfigs.debug\n"
                +"        }\n"
                +"    }\n";

    }
}
