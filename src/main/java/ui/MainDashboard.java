package ui;

import service.IssueService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainDashboard extends JFrame {

   public MainDashboard()
   {
      setTitle("Library Management System-Dashboard");
      setSize(1000,700);
      //getContentPane().setBackground(Color.orange);
       setLayout(new BorderLayout());
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      BackGroundPanel panel=new BackGroundPanel("/images/pict.png");
      panel.setLayout(null);
      JLabel welcome=new JLabel("Welcome to Dashboard");

      welcome.setFont(new Font("Arial",Font.BOLD,35));
      welcome.setForeground(Color.BLACK);
      welcome.setBounds(320,10,500,50);
      panel.add(welcome);



      JMenuBar menuBar=new JMenuBar();

      JMenu FileMenu=new JMenu("File");
      JMenu BookMenu=new JMenu("Books");
      JMenu StudentMenu=new JMenu("Students");
      JMenu IssueMenu=new JMenu("Issue");

      JMenuItem logoutItem=new JMenuItem("Logout");
      JMenuItem addBookItem=new JMenuItem("Add Books");
      JMenuItem viewBookItem=new JMenuItem("view Books");
      JMenuItem returnBookItem=new JMenuItem("return book");
      JMenuItem addStudentItem=new JMenuItem("Add Student");
      JMenuItem issueBookItem=new JMenuItem("Issue Book");
      JMenuItem viewIssuedBookForm=new JMenuItem("Issued Book");

      logoutItem.addActionListener(e->
       {
           new LoginPage();
           dispose();
       });

      viewBookItem.addActionListener(e-> new ViewBooksForm());

      addStudentItem.addActionListener(e->new AddStudentForm());

      issueBookItem.addActionListener(e->new IssueBookForm());

      returnBookItem.addActionListener(e->new ReturnBookForm());

      addBookItem.addActionListener(e-> new AddBookForm());

      viewIssuedBookForm.addActionListener(e->new ViewIssuedBookForm());

       JMenuItem removeStudentItem = new JMenuItem("Remove Student");
       removeStudentItem.addActionListener(e -> new RemoveStudentForm());

       StudentMenu.add(removeStudentItem);

       JMenuItem viewStudentsItem = new JMenuItem("View Students");

       viewStudentsItem.addActionListener(e -> new ViewStudentsForm());

       StudentMenu.add(viewStudentsItem);



       FileMenu.add(logoutItem);
      BookMenu.add(addBookItem);
      BookMenu.add(viewBookItem);
      StudentMenu.add(addStudentItem);
      IssueMenu.add(issueBookItem);
      BookMenu.add(returnBookItem);
      BookMenu.add(viewIssuedBookForm);

      menuBar.add(FileMenu);
      menuBar.add(BookMenu);
      menuBar.add(StudentMenu);
      menuBar.add(IssueMenu);

      setJMenuBar(menuBar);
//      JLabel label=new JLabel("Welcome to Library Dashboard",SwingConstants.CENTER);
//      label.setFont(new Font("Arial",Font.BOLD,40));
//



       String recommended = IssueService.getRecommendedBook();

       JLabel aiLabel = new JLabel("Recommended Book (AI): " + recommended);
       aiLabel.setHorizontalAlignment(SwingConstants.CENTER);
       aiLabel.setBounds(180,600,500,60);
       panel.add(aiLabel);

       setContentPane(panel);


      setVisible(true);





   }
}
