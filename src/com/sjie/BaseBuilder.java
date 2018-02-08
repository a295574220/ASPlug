package com.sjie;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * author WangYi
 * created on 2017/1/14.
 */
public abstract class BaseBuilder {
    public void build(AnActionEvent event,int select) {
        PsiFile psiFile = event.getData(LangDataKeys.PSI_FILE);
        if (psiFile == null) return;
            Editor editor = event.getData(PlatformDataKeys.EDITOR);
            if (editor == null) return;
            Project project = editor.getProject();
            if (project == null) return;
            PsiElementFactory elementFactory = JavaPsiFacade.getElementFactory(project);
            String selectText = editor.getSelectionModel().getSelectedText();
            Document document = editor.getDocument();
            SelectionModel selectionModel = editor.getSelectionModel();
            build(selectionModel, project,document,select);
    }

    public abstract void build(SelectionModel selectionModel, Project project,Document document,int select);

    protected boolean containFiled(PsiClass psiClass, PsiField psiField) {
        return psiClass.findFieldByName(psiField.getName(), true) != null;
    }

    protected boolean containMethod(PsiClass psiClass, PsiMethod psiMethod) {
        return psiClass.findMethodsByName(psiMethod.getName(), true).length > 0;
    }

    protected boolean containClass(PsiClass psiClass, PsiClass innerClass) {
        return psiClass.findInnerClassByName(innerClass.getName(), true) != null;
    }
}
