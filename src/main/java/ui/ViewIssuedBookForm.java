package ui;

import database.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewIssuedBookForm extends JFrame {

    public ViewIssuedBookForm() {

        setTitle("Issued Books");
        setSize(500,300);
        setLocationRelativeTo(null);

        String[] columns = {"Student", "Book", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM issued_books";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("student_name"),
                        rs.getString("book_name"),
                        rs.getString("issue_date")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }
}
