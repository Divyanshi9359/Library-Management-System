package ui;

import model.Book;
import service.BookService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

    public class ViewBooksForm extends JFrame {

        public ViewBooksForm() {

            setTitle("View Books");
            setSize(700,500);
            //getContentPane().setBackground(Color.ORANGE);
            setLocationRelativeTo(null);

            String[] columns = {"Name", "Author", "Quantity"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);


            List<Book> books = BookService.getAllBooks();

            for(Book b : books) {
                model.addRow(new Object[]{
                        b.getName(),
                        b.getAuthor(),
                        b.getQuantity()
                });
            }

            JTable table = new JTable(model);
            //table.setBackground(Color.orange);
            JScrollPane scroll = new JScrollPane(table);
            //scroll.setBackground(Color.orange);


            add(scroll);

            setVisible(true);
        }
    }


