package ui;

import database.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudentsForm extends JFrame {

    private JTextField searchField;
    private DefaultTableModel model;

    public ViewStudentsForm() {

        setTitle("Search Students");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔹 Top panel (search bar)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Student Name:"));

        searchField = new JTextField(15);
        topPanel.add(searchField);

        JButton searchBtn = new JButton("Search");
        topPanel.add(searchBtn);

        JButton refreshBtn = new JButton("Refresh");
        topPanel.add(refreshBtn);

        add(topPanel, BorderLayout.NORTH);

        // 🔹 Table
        String[] columns = {"Student ID", "Student Name"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load all students initially
        loadStudents("");

        // 🔎 Search action
        searchBtn.addActionListener(e -> {
            String name = searchField.getText().trim();
            loadStudents(name);
        });

        // 🔄 Refresh action
        refreshBtn.addActionListener(e -> {
            searchField.setText("");
            loadStudents("");
        });

        setVisible(true);
    }

    private void loadStudents(String name) {
        model.setRowCount(0); // clear table

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT id, name FROM students WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
