package com.sjie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Control_dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private OnPatternSelectedListener mListener;
    private boolean flag=false;
    public Control_dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("组件");
        flag=false;
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        list1.setSelectedIndex(0);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.addKeyListener(new KeyListener() {
            int preIndex = -1;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                preIndex = list1.getSelectedIndex();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (preIndex == selectedIndex) {
                    if (selectedIndex == 0) {
                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                            list1.setSelectedIndex(4);
                        }
                    } else if (selectedIndex == 4) {
                        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            list1.setSelectedIndex(0);
                        }
                    }
                }
            }
        });
        setBounds(new Rectangle(300, 400));
        setLocationRelativeTo(null);
    }

    private void onOK() {
        // add your code here
        dispose();
        if (mListener != null) {
            mListener.onPatternSelected(list1.getSelectedIndex());
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Control_dialog dialog = new Control_dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public void setOnPatternSelectedListener(OnPatternSelectedListener mListener) {
        this.mListener = mListener;
    }
}
