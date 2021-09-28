package code.coderd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SplashScreen implements ActionListener{
    JFrame mainFrame;
    JLabel id;
    JButton btnproceed;
    Color darkBlue = new Color(104,145,200);

    SplashScreen(){
        mainFrame =new JFrame("Employee Management System -  Splash Screen");
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("code/icons/splash.png"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        mainFrame.add(l1);


        btnproceed = new JButton("CLICK HERE TO PROCEED");
        btnproceed.setBackground(Color.BLACK);
        btnproceed.setForeground(Color.WHITE);
        

        btnproceed.setBounds(500,600,300,70);
        btnproceed.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        

        JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(darkBlue);
        id.add(lid);

        id.add(btnproceed);
        mainFrame.add(id);

        mainFrame.getContentPane().setBackground(Color.WHITE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1360,750);
        mainFrame.setLocation(100,50);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnproceed){
            mainFrame.setVisible(false);
            new LoginPage();
        }
    }

    public static void main(String[] arg){
        SplashScreen f = new SplashScreen();
    }
}