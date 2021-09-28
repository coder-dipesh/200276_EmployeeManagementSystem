package code.coderd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Dashboard  implements ActionListener{

    JFrame mainFrame;
    JLabel lblImage, lblDetails,heading;
    JButton btnAdd, btnView, btnRemove, btnUpdate, btnLogout;
    Color success = new Color(116,181,112);
    Color warning = new Color(218,0,55);

    Dashboard(){
        mainFrame =new JFrame("Employee Management System - Dashboard");
        mainFrame.setBackground(Color.white);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        lblImage = new JLabel();
        lblImage.setBounds(25,0,1100,800);
        lblImage.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("code/icons/dash.png"));
        lblImage.setIcon(i1);
        mainFrame.add(lblImage);

        lblDetails = new JLabel("- DETAILS -");
        lblDetails.setBounds(800,120,250,40);
        lblDetails.setFont(new Font("poppins",Font.BOLD,25));
        lblDetails.setForeground(Color.black);
        lblImage.add(lblDetails);

        heading = new JLabel("YOUR DASHBOARD");
        heading.setBounds(100,70,500,40);
        heading.setFont(new Font("poppins",Font.BOLD,40));
        heading.setForeground(Color.black);
        mainFrame.add(heading);

        btnAdd =new JButton("ADD");
        btnAdd.setBounds(750,190,100,40);
        btnAdd.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnAdd.addActionListener(this);
        lblImage.add(btnAdd);


        btnView =new JButton("VIEW");
        btnView.setBounds(750,280,100,40);
        btnView.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnView.addActionListener(this);
        lblImage.add(btnView);

        btnRemove =new JButton("REMOVE");
        btnRemove.setBounds(900,280,100,40);
        btnRemove.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnRemove.addActionListener(this);
        lblImage.add(btnRemove);

        btnUpdate =new JButton("UPDATE");
        btnUpdate.setBounds(900,190,100,40);
        btnUpdate.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnUpdate.addActionListener(this);
        lblImage.add(btnUpdate);
        
        btnLogout =new JButton("LOGOUT");
        btnLogout.setBounds(750,350,250,40);
        btnLogout.setFont(new Font("poppins",Font.BOLD,15));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(warning);
        btnLogout.addActionListener(this);
        lblImage.add(btnLogout);

        mainFrame.setVisible(true);
        mainFrame.setSize(1100,800);
        mainFrame.setLocation(150,20);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnAdd){
            mainFrame.setVisible(false);
            new Add_Employee();
        }
        if(ae.getSource()== btnView){
            mainFrame.setVisible(false);
            new SearchEmployee();
        }
        if(ae.getSource()== btnRemove){
            mainFrame.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()== btnUpdate){
            mainFrame.setVisible(false);
            new Search_Employee();
        }
        if(ae.getSource()== btnLogout){
            mainFrame.setVisible(true);
            int confirmed = JOptionPane.showConfirmDialog(mainFrame,
            "Are you sure you want to logout?", "Exit From Dashboard.",JOptionPane.YES_NO_OPTION);
            
            if (confirmed == JOptionPane.YES_OPTION) {
             mainFrame.dispose();
            }
        }
    }
    

    public static void main(String[ ] arg){
        Dashboard d = new Dashboard();
    }
}
