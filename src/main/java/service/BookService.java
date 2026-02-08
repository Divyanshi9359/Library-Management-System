package service;

import database.DBConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static void addBook(Book book) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO books(name, author, quantity) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getAllBooks() {

        List<Book> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM books";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Book b = new Book(
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("quantity")
                );

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void returnBook(String bookName) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE books SET quantity = quantity + 1 WHERE name=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bookName);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean bookAvailable(String book) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT quantity FROM books WHERE name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("quantity") > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}

