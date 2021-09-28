package code.coderd;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage implements ActionListener {

    JFrame mainFrame;

    JTextField jFieldFirstname,jFieldLastname,jFieldEmail, jFieldUsername;
    JPasswordField jFieldPassword;
    JLabel title,lblUsername,lblPassword,lblFirstname,lblLastname,lblEmail,successMessage,warningMessage ;
    JButton btnSignup,btnBack;
    Font font,titleFont,inputFont,btnFont,invalid,success;
    
        
    Color successC = new Color(116,181,112);
    Color warning = new Color(218,0,55);


    public RegisterPage(){
        mainFrame = new JFrame("Employee Management System - Register User");
        mainFrame.setResizable(false);
        mainFrame.setLocation(370,100);

        font = new Font("Fira Code",Font.BOLD,18);
        titleFont = new Font("poppins",Font.BOLD,35);
        inputFont = new Font("Century Gothic",Font.PLAIN,16);
        btnFont = new Font("Century Gothic",Font.BOLD,16);
        invalid = new Font("Fira Code",Font.BOLD,14);
        success = new Font("Fira Code",Font.BOLD,14);


        // Components inside JPanel

        title = new JLabel();
        title.setText("-SIGN UP-");
        title.setFont(titleFont);
        title.setForeground(Color.BLUE);
        title.setBounds(220,20,200,50);


        lblFirstname = new JLabel();
        lblFirstname.setText("First Name");
        lblFirstname.setBounds(100,100,150,25);
        lblFirstname.setFont(font);

        jFieldFirstname = new JTextField();
        jFieldFirstname.setBounds(250,100,250,35);
        jFieldFirstname.setFont(inputFont);


        lblLastname = new JLabel();
        lblLastname.setText("Last Name");
        lblLastname.setBounds(100,170,150,25);
        lblLastname.setFont(font);

        jFieldLastname = new JTextField();
        jFieldLastname.setBounds(250,170,250,35);
        jFieldLastname.setFont(inputFont);

        lblEmail = new JLabel();
        lblEmail.setText("Email ID");
        lblEmail.setBounds(100,240,100,25);
        lblEmail.setFont(font);

        jFieldEmail = new JTextField();
        jFieldEmail.setBounds(250,240,250,35);
        jFieldEmail.setFont(inputFont);


        lblUsername = new JLabel();
        lblUsername.setText("Username");
        lblUsername.setBounds(100,310,100,25);
        lblUsername.setFont(font);

        jFieldUsername = new JTextField();
        jFieldUsername.setBounds(250,310,250,35);
        jFieldUsername.setFont(inputFont);


        lblPassword = new JLabel();
        lblPassword.setText("Password");
        lblPassword.setBounds(100,380,100,25);
        lblPassword.setFont(font);

        jFieldPassword = new JPasswordField();
        jFieldPassword.setBounds(250,380,250,35);
        jFieldPassword.setFont(inputFont);



        // Button

        btnSignup = new JButton("SIGN UP");
        btnSignup.setBounds(100,450,170,40);
        btnSignup.setFont(btnFont);
        btnSignup.setBackground(successC);
        btnSignup.setForeground(Color.WHITE);
        btnSignup.addActionListener(this);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(330,450,170,40);
        btnBack.setFont(btnFont);
        btnBack.setBackground(warning);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);

        
        
        successMessage = new JLabel();
        successMessage.setText("");
        successMessage.setFont(success);
        successMessage.setForeground(successC);
        successMessage.setBounds(200,500,400,35);
        
        
        warningMessage = new JLabel();
        warningMessage.setText("");
        warningMessage.setFont(success);
        warningMessage.setForeground(Color.RED);
        warningMessage.setBounds(200,500,400,35);



        mainFrame.add(title);
        mainFrame.add(lblFirstname);
        mainFrame.add(jFieldFirstname);
        mainFrame.add(lblLastname);
        mainFrame.add(jFieldLastname);
        mainFrame.add(lblEmail);
        mainFrame.add(jFieldEmail);
        mainFrame.add(lblUsername);
        mainFrame.add(jFieldUsername);
        mainFrame.add(lblPassword);
        mainFrame.add(jFieldPassword);


        mainFrame.add(btnSignup);
        mainFrame.add(btnBack);
        mainFrame.add(successMessage);
        mainFrame.add(warningMessage);

        mainFrame.setSize(600,650);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);


    }

    public static void main(String[] args) {
            new RegisterPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String firstname = jFieldFirstname.getText();
        String lastname = jFieldLastname.getText();
        String email =  jFieldEmail.getText();
        String username = jFieldUsername.getText();
        String password = jFieldPassword.getText();

        try {
            if (e.getSource() == btnSignup){
                
                if (!jFieldFirstname.getText().isBlank() && !jFieldLastname.getText().isBlank()&& 
                        !jFieldEmail.getText().isBlank()&&!jFieldUsername.getText().isBlank() && !jFieldPassword.getText().isBlank()){
                    
                
                    DatabaseConnection c1 = new DatabaseConnection();
                    String insertFields = "INSERT INTO login(firstname, lastname, email, username, password) VALUES ('";
                    String insertValues = firstname + "','" + lastname + "','" + email + "','" + username + "','" + password + "')";

                    String insertToRegister = insertFields + insertValues;
                    int rs = c1.statement.executeUpdate(insertToRegister);
                    
                    warningMessage.setText("");
                    successMessage.setText("Registration Successful!");
                    }
                
                else{
                    successMessage.setText("");
                    warningMessage.setText("Fields cannot be empty!");
                    System.out.println("Fields Cannot be empty");
                }
                
            }
                    if (e.getSource() == btnBack){
                        mainFrame.setVisible(false);
                        new LoginPage();
                    }

        
       
            
        }
            catch(Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
        }
        
    }


