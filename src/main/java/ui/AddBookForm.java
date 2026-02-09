package ui;

import model.Book;
import service.BookService;

import javax.swing.*;
import java.awt.*;

public class AddBookForm extends JFrame {

    private JTextField nameField;
    private JTextField authorField;
    private JTextField quantityField;

    public AddBookForm() {

        setTitle("Add Book");
        setSize(400,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2,5,5));

        panel.add(new JLabel("Book Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Author"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Quantity"));
        quantityField = new JTextField();
        panel.add(quantityField);

        JButton saveBtn = new JButton("Save");
        panel.add(saveBtn);

        panel.add(new JLabel()); // empty cell

        add(panel);

        saveBtn.addActionListener(e -> saveBook());

        setVisible(true);
    }

    private void saveBook() {

        if(nameField.getText().isEmpty() ||
                authorField.getText().isEmpty() ||
                quantityField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,"Fill all fields");
            return;
        }

        int qty = Integer.parseInt(quantityField.getText());

        Book book = new Book(
                nameField.getText(),
                authorField.getText(),
                qty
        );

        BookService.addBook(book);

        JOptionPane.showMessageDialog(this,"Book Added Successfully");
        dispose();
    }
}
