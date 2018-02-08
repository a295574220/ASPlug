package com.sjie;

import com.jgoodies.common.collect.ArrayListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Behind_dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private OnPatternSelectedListener mListener;
    private boolean flag=false;
    public Behind_dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("后台框架");
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
        setBounds(new Rectangle(300, 200));
        setLocationRelativeTo(null);
    }

    private void onOK() {
        // add your code here
       if (flag) dispose();
        flag=true;
        if (mListener != null) {
            mListener.onPatternSelected(list1.getSelectedIndex());
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Behind_dialog dialog = new Behind_dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public void setOnPatternSelectedListener(OnPatternSelectedListener mListener) {
        this.mListener = mListener;
    }
    public void setList1(ArrayList<String> list){
        ListModel<String> listModel=new ArrayListModel<>(list);
        list1.setModel(listModel);
    }
}
