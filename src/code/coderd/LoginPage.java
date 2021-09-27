package code.coderd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class LoginPage implements ActionListener{

    JFrame mainFrame;
    JLabel lblUsername, lblPassword, lblLogin;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnLogin, btnClose, btnSignup;

    Color success = new Color(116,181,112);
    Color warning = new Color(218,0,55);
    Color bg = new Color(247,247,247);

    LoginPage(){

        mainFrame =new JFrame("Employee Management System - Login");
        mainFrame.setResizable(false);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.setLayout(null);

        lblLogin = new JLabel(" LOGIN ");
        lblLogin.setFont(new Font("poppins",Font.BOLD,30));
        lblLogin.setBounds(120,50,500,30);
        mainFrame.add(lblLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("poppins",Font.BOLD,15));
        lblUsername.setBounds(40,150,100,30);
        mainFrame.add(lblUsername);
        
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("poppins",Font.BOLD,15));
        lblPassword.setBounds(40,230,100,30);
        mainFrame.add(lblPassword);
 
        tfUsername =new JTextField();
        tfUsername.setFont(new Font("Century Gothic",Font.PLAIN,14));
        tfUsername.setBounds(145,150,170,35);
        mainFrame.add(tfUsername);

        pfPassword =new JPasswordField();
        pfPassword.setBounds(145,230,170,35);
        pfPassword.setFont(new Font("Century Gothic",Font.PLAIN,14));
        mainFrame.add(pfPassword);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("code/icons/login_user.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(490,50,150,150);
        mainFrame.add(l3);


        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(40,320,130,40);
        btnLogin.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnLogin.addActionListener(this);
        btnLogin.setBackground(success);
        btnLogin.setForeground(Color.WHITE);
        mainFrame.add(btnLogin);

        btnClose =new JButton("CLOSE");
        btnClose.setBounds(190,320,130,40);
        btnClose.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnClose.setBackground(warning);
        btnClose.setForeground(Color.WHITE);
        btnClose.addActionListener(this);
        mainFrame.add(btnClose);
        
        
        
        btnSignup =new JButton("SIGN UP");
        btnSignup.setBounds(500,250,130,40);
        btnSignup.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnSignup.setBackground(Color.GRAY);
        btnSignup.setForeground(Color.WHITE);
        btnSignup.addActionListener(this);
        mainFrame.add(btnSignup);
        
        
        
        mainFrame.getContentPane();
        mainFrame.setVisible(true);
        mainFrame.setSize(800,500);
        mainFrame.setLocation(400,200);

    }

    public void actionPerformed(ActionEvent ae){

        
            
        try{
            DatabaseConnection c1 = new DatabaseConnection();
            String u = tfUsername.getText();
            String v = pfPassword.getText();
            
            String q = "select * from login where username='"+ u +"' and password='"+ v +"'";
            
            ResultSet rs = c1.statement.executeQuery(q);
            
            if(rs.next()){
                new Dashboard().mainFrame.setVisible(true);
                mainFrame.setVisible(false);
                
            }else if(ae.getSource()== btnSignup){
                mainFrame.setVisible(false);
                new RegisterPage();
            
            }
            else if(ae.getSource()== btnClose){
                mainFrame.dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(mainFrame, "Invalid Login");
                mainFrame.setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    
    
    public static void main(String[] arg){
        LoginPage l=new LoginPage();
    }
}