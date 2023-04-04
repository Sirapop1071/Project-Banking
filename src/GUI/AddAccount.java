package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class AddAccount extends JFrame {
    private JPanel panelAc;

    public AddAccount() {
        setTitle("Add Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        panelAc = new JPanel();
        panelAc.setBackground(SystemColor.activeCaption);
        panelAc.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelAc);
        panelAc.setLayout(null);

        JButton btnAddSavingAccount = new JButton("Add Saving Account");
        btnAddSavingAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!GUIForm.addsavingsaccount.isVisible()) {
                    GUIForm.addsavingsaccount.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
                }

                dispose();
            }
        });
        btnAddSavingAccount.setBounds(118, 56, 193, 38);
        panelAc.add(btnAddSavingAccount);
        JButton btnAddStudentAccount = new JButton("Add Student Account");
        btnAddStudentAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!GUIForm.addstudentaccount.isVisible()) {

                    GUIForm.addstudentaccount.setVisible(true);
                    dispose();
                }

                else {
                    JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
                }

            }

        });
        btnAddStudentAccount.setBounds(118, 124, 193, 38);
        panelAc.add(btnAddStudentAccount);

        JButton button = new JButton("Add Fixed Deposit Account");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!GUIForm.addfFixedDeAccount.isVisible()) {
                    GUIForm.addfFixedDeAccount.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
                }

            }
        });
        button.setBounds(118, 190, 193, 38);
        panelAc.add(button);

        JLabel lblAddAccount = new JLabel("Add Account");
        lblAddAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAddAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddAccount.setBounds(108, 11, 210, 34);
        panelAc.add(lblAddAccount);
    }

}
