package code.coderd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Search_Employee implements ActionListener{
    JFrame mainFrame;
    JTextField tfID;
    JLabel lblEmpID, lblImage;
    JButton btnSearch, btnClose;
    Color success = new Color(116,181,112);
    Color warning = new Color(218,0,55);

    Search_Employee(){
        mainFrame =new JFrame("Employee Management System - Search Employee");
        mainFrame.setBackground(Color.green);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        lblImage =new JLabel();
        lblImage.setBounds(0,0,500,270);
        lblImage.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("code/icons/searchData.png"));
        lblImage.setIcon(img);


        lblEmpID =new JLabel("Employee ID");
        lblEmpID.setVisible(true);
        lblEmpID.setBounds(40,50,250,30);
        lblEmpID.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        lblEmpID.setFont(F1);
        lblImage.add(lblEmpID);
        mainFrame.add(lblImage);

        tfID =new JTextField();
        tfID.setBounds(240,50,220,30);
        lblImage.add(tfID);

        btnSearch =new JButton("SEARCH");
        btnSearch.setBackground(success);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnSearch.setBounds(200,150,130,40);
        btnSearch.addActionListener(this);
        lblImage.add(btnSearch);


        btnClose =new JButton("CANCEL");
        btnClose.setBounds(350,150,130,40);
        btnClose.setForeground(Color.WHITE);
        btnClose.setBackground(warning);
        btnClose.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnClose.addActionListener(this);
        lblImage.add(btnClose);

        mainFrame.setSize(500,270);
        mainFrame.setLocation(450,250);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnClose){
            mainFrame.setVisible(false);
            Dashboard d=new Dashboard();
        }
        if(ae.getSource()== btnSearch){
            new Update_Employee(tfID.getText());
            mainFrame.setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new Search_Employee();
    } 	
}