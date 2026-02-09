package ui;

import service.BookService;
import service.IssueService;
import service.StudentService;

import javax.swing.*;
import java.awt.*;

public class IssueBookForm extends JFrame {

    JTextField studentField, bookField;

    public IssueBookForm() {

        setTitle("Issue Book");
        setSize(400,250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));

        //panel.add(new JLabel("Student Name"));
        JLabel stud=new JLabel("Student Name:");
        stud.setFont(new Font("Arial", Font.PLAIN,15));
        panel.add(stud);
        studentField = new JTextField();
        panel.add(studentField);

        //panel.add(new JLabel("Book Name"));
        JLabel book=new JLabel("Book Name:");
        book.setFont(new Font("Arial",Font.PLAIN,15));
        panel.add(book);
        bookField = new JTextField();
        panel.add(bookField);

        JButton issueBtn = new JButton("Issue Book");
        panel.add(issueBtn);

        add(panel);

        issueBtn.addActionListener(e -> issueBook());

        setVisible(true);
    }

    private void issueBook() {

        String student = studentField.getText();
        String book = bookField.getText();

        if(!StudentService.studentExists(student)) {
            JOptionPane.showMessageDialog(this,"Student not found");
            return;
        }

        if(!BookService.bookAvailable(book)) {
            JOptionPane.showMessageDialog(this,"Book not available");
            return;
        }

        IssueService.issueBook(student, book);

        JOptionPane.showMessageDialog(this,"Book Issued Successfully");
        dispose();
    }

}
