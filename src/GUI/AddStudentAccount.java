package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Data.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentAccount extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public AddStudentAccount() {
        setTitle("Add Student Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAddCurrentAccount = new JLabel("Add Student Account ");
        lblAddCurrentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAddCurrentAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddCurrentAccount.setBounds(10, 11, 414, 34);
        contentPane.add(lblAddCurrentAccount);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblName.setBounds(10, 72, 124, 14);
        contentPane.add(lblName);

        textField = new JTextField();
        textField.setBounds(144, 69, 254, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblBalance = new JLabel("Balance:");
        lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblBalance.setBounds(10, 118, 124, 14);
        contentPane.add(lblBalance);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(144, 115, 254, 20);
        contentPane.add(textField_1);

        JLabel lblMaximumWithdrawLimit = new JLabel("Institution Name:");
        lblMaximumWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblMaximumWithdrawLimit.setBounds(10, 163, 135, 14);
        contentPane.add(lblMaximumWithdrawLimit);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(144, 160, 254, 20);
        contentPane.add(textField_2);
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = textField.getText();
                double bal = Double.parseDouble(textField_1.getText());
                String insname = textField_2.getText();
                if (bal < 100) {
                    JOptionPane.showMessageDialog(getComponent(0), "Minimum Limit 100", "Warning", 0);
                    textField.setText(null);
                    textField_1.setText(null);
                    textField_2.setText(null);
                } else {
                    if (name == null || bal <= 0 || insname == null) {
                        JOptionPane.showMessageDialog(getComponent(0), "Typing Mismatch!! Try Again");
                        textField.setText(null);
                        textField_1.setText(null);
                        textField_2.setText(null);
                    } else {
                        try {
                            FileIO.bank.addAccount(name, bal, insname);
                        } catch (Exception e1) {

                        }
                        int ch = JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
                        if (ch == 0) {
                            int index = 0;
                            try {
                                index = FileIO.bank.addAccount(name, bal, insname);
                            } catch (Exception e1) {

                            }
                            DisplayList.arr.addElement(FileIO.bank.getAccounts()[index].toString());

                            JOptionPane.showMessageDialog(getComponent(0), "Added Successfully");
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(getComponent(0), "Failed");
                            textField.setText(null);
                            textField_1.setText(null);
                            textField_2.setText(null);
                        }

                    }
                }

            }
        });
        btnAdd.setBounds(86, 209, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
                textField_1.setText(null);
                textField_2.setText(null);

            }
        });
        btnReset.setBounds(309, 209, 89, 23);
        contentPane.add(btnReset);
    }
}