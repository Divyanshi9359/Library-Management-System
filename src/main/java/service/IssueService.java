package service;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueService
{

    public static void issueBook(String student, String book) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO issued_books(student_name, book_name) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student);
            ps.setString(2, book);

            ps.executeUpdate();

            // Reduce quantity
            String update = "UPDATE books SET quantity = quantity - 1 WHERE name=?";
            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setString(1, book);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void returnBook(String student, String book) {

        try {
            Connection con = DBConnection.getConnection();

            String delete = "DELETE FROM issued_books WHERE student_name=? AND book_name=?";
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setString(1, student);
            ps.setString(2, book);
            ps.executeUpdate();

            String update = "UPDATE books SET quantity = quantity + 1 WHERE name=?";
            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setString(1, book);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getRecommendedBook() {

        String book = "No data";

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT book_name, COUNT(*) total " +
                            "FROM issued_books " +
                            "GROUP BY book_name " +
                            "ORDER BY total DESC LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                book = rs.getString("book_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public static boolean hasIssuedBooks(int studentID)
    {
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT 1 FROM issued_books WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentID);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
