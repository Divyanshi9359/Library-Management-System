package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame
{

    private JTextField usernameField;
    private JPasswordField  passwordField;
    private JButton Login;


    public LoginPage()
    {
        setTitle("Library System Management-Login");
        setSize(500,350);
        //getContentPane().setBackground(Color.ORANGE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
//        setUndecorated(true);
        setVisible(true);


    }
    private void initComponents()
    {
        JPanel panel=new JPanel(new BorderLayout(10,10));
       // panel.setBackground(Color.ORANGE);

        JLabel heading =new JLabel("Login Page",SwingConstants.CENTER);
        heading.setFont(new Font("Arial",Font.BOLD,22));
        panel.add(heading,BorderLayout.NORTH);

        JPanel centralPanel=new JPanel(new GridLayout(8,0,300,15));
       // centralPanel.setBackground(Color.ORANGE);


        JLabel username=new JLabel("Username");
        username.setFont(new Font("Arial",Font.BOLD,16));
        centralPanel.add(username);
        usernameField=new JTextField("admin");
        centralPanel.add(usernameField);

        JLabel password=new JLabel("Password");
        password.setFont(new Font("Arial",Font.BOLD,16));
        centralPanel.add(password);
        passwordField=new JPasswordField("admin123");
        centralPanel.add(passwordField);

        JButton Login =new JButton("Login");
        centralPanel.add(Login);


        JButton forget=new JButton("Forgot your Password?");
        forget.setBorderPainted(false);
        forget.setContentAreaFilled(false);
        forget.setFocusPainted(false);
        centralPanel.add(forget);

        panel.add(centralPanel,BorderLayout.CENTER);

//        ImageIcon icon=new ImageIcon(getClass().getResource("/images/pic.png"));
//        JLabel picLabel=new JLabel(icon);
//        panel.add(picLabel,BorderLayout.EAST);
        add(panel);


        Login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handleLogin();
            }
        });
    }
    private void handleLogin()
    {
        String username=usernameField.getText();
        String password=new String(passwordField.getPassword());

        if(username.equals("admin") && password.equals("admin123"))
        {
            JOptionPane.showMessageDialog(this,"Login Successful");
            new MainDashboard();
            dispose();

        }
        else{
            JOptionPane.showMessageDialog(this,"Invalid username or password");
            }
    }

    public static void main(String[] args)
    {
        new LoginPage();
    }
}



