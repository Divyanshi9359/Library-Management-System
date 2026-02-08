package model;

public class Issue {

    private String studentName;
    private String bookName;

    public Issue(String studentName, String bookName) {
        this.studentName = studentName;
        this.bookName = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBookName() {
        return bookName;
    }
}

