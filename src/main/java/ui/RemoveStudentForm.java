package ui;

import service.StudentService;

import javax.swing.*;
import java.awt.*;

public class RemoveStudentForm extends JFrame {

    public RemoveStudentForm() {

        setTitle("Remove Student");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50,50,100,30);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150,50,150,30);
        add(idField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(150,100,100,35);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());

                boolean deleted = StudentService.deleteStudent(id);

                if (deleted) {
                    JOptionPane.showMessageDialog(this,
                            "Student deleted successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Student has issued books or not exists!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid Student ID");
            }
        });

        setVisible(true);
    }
}

