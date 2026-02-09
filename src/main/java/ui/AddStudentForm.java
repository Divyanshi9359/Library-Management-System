package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import java.awt.*;

public class AddStudentForm extends JFrame {

    private JTextField nameField;
    private JTextField rollField;

    public AddStudentForm() {

        setTitle("Add Student");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel=new JPanel();
//        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

//        BackGroundPanel panel = new BackGroundPanel("/images/pic.png");
//        setContentPane(panel);   // background panel
        JLabel welcome=new JLabel("Enter the details to add the student");

        welcome.setFont(new Font("Arial",Font.BOLD,25));
        welcome.setForeground(Color.BLACK);
        welcome.setBounds(150,10,500,150);
        panel.add(welcome);

        JLabel student = new JLabel("Student Name:");
        student.setFont(new Font("Arial",Font.PLAIN,18));
        student.setBounds(120,120,150,30);
        student.setForeground(Color.BLACK);
        panel.add(student);

        nameField = new JTextField();
        nameField.setBounds(280,120,250,30);
        panel.add(nameField);

        JLabel rollno = new JLabel("Roll No:");
        rollno.setFont(new Font("Arial",Font.PLAIN,18));
        rollno.setBounds(120,180,150,30);
        rollno.setForeground(Color.BLACK);
        panel.add(rollno);

        rollField = new JTextField();
        rollField.setBounds(280,180,250,30);
        panel.add(rollField);

        JButton save = new JButton("Save");
        save.setBounds(280,250,120,40);
        //save.setForeground(Color.WHITE);
        panel.add(save);

       add(panel);

        save.addActionListener(e -> saveStudent());

        setVisible(true);
    }
    private void saveStudent() {

        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();

        Student s = new Student(name, roll);
        StudentService.addStudent(s);

        JOptionPane.showMessageDialog(this,"Student Added");

        dispose();
    }


}


