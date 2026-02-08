package service;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentService
{

    public static void addStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students(name, roll) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getRoll());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteStudent(int studentId) {

        // 🔒 Check issued books first
        if (IssueService.hasIssuedBooks(studentId)) {
            return false;
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }





    public static List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new Student(
                        rs.getString("name"),
                        rs.getString("roll")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean studentExists(String name) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
