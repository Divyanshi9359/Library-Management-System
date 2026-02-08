package ui;

import service.IssueService;

import javax.swing.*;
import java.awt.*;

public class ReturnBookForm extends JFrame {

    JTextField studentField, bookField;

    public ReturnBookForm() {

        setTitle("Return Book");
        setSize(400,250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,2,10,10));

        panel.add(new JLabel("Student Name"));
        studentField = new JTextField();
        panel.add(studentField);

        panel.add(new JLabel("Book Name"));
        bookField = new JTextField();
        panel.add(bookField);

        JButton returnBtn = new JButton("Return Book");
        panel.add(returnBtn);

        add(panel);

        returnBtn.addActionListener(e -> returnBook());

        setVisible(true);
    }

    private void returnBook() {

        IssueService.returnBook(
                studentField.getText(),
                bookField.getText()
        );

        JOptionPane.showMessageDialog(this,"Book Returned");
        dispose();
    }
}
