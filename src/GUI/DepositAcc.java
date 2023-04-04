package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Data.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import Exceptions.AcNotFound;
import Exceptions.InvalidAmount;

public class DepositAcc extends JFrame implements Serializable {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public DepositAcc() {
        setTitle("Deposit To Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDepositToAccount = new JLabel("Deposit To Account");
        lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblDepositToAccount.setBounds(10, 11, 414, 36);
        contentPane.add(lblDepositToAccount);

        JLabel lblName = new JLabel("Account Number:");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setBounds(0, 86, 111, 14);
        contentPane.add(lblName);

        textField = new JTextField();
        textField.setBounds(121, 83, 211, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(121, 147, 211, 20);
        contentPane.add(textField_1);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAmount.setBounds(0, 150, 111, 14);
        contentPane.add(lblAmount);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String acountNum;
                double amt;
                acountNum = textField.getText();
                amt = Double.parseDouble(textField_1.getText());
                int a = JOptionPane.showConfirmDialog(getComponent(0), "Confirm");
                if (a == 0) {
                    try {
                        FileIO.bank.deposit(acountNum, amt);
                        JOptionPane.showMessageDialog(getComponent(0), "Deposit Successful");
                        dispose();

                        textField.setText(null);
                        textField_1.setText(null);
                    } catch (InvalidAmount e1) {
                        JOptionPane.showMessageDialog(getComponent(0), "Sorry! Deposit Amount is Invalid");

                    } catch (AcNotFound e1) {
                        JOptionPane.showMessageDialog(getComponent(0), "Sorry! Account is Not Found");

                    } finally {
                        textField.setText(null);
                        textField_1.setText(null);
                    }

                } else {
                    textField.setText(null);
                    textField_1.setText(null);
                }
            }
        });
        btnDeposit.setBounds(73, 212, 89, 23);
        contentPane.add(btnDeposit);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(243, 212, 89, 23);
        contentPane.add(btnReset);

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textField.setText(null);
                textField_1.setText(null);
            }
        });
    }
}
