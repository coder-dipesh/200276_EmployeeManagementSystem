package code.coderd;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_Employee extends Add_Employee implements ActionListener{

    JFrame mainFrame;
    JLabel name, fatherName, address, mobileNo, emailID, education, jobPost, heading, ctznNo, empID, lblImage,dob;
    JTextField pname, fname, txtAddress, txtMobile, txtEmail, txtEducation, txtPost, txtCtznNo, txtEmpID, txtDob;
    JButton btnUpdate, btnCancel;
    String id_emp;
    
    Color success = new Color(116,181,112);
    Color warning = new Color(218,0,55);

    Update_Employee(String empID){
        super(0);
        mainFrame =new JFrame("Employee Management System - Update Employee Details");
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(900,500);
        mainFrame.setLocation(450,250);
        mainFrame.setBackground(Color.white);
        mainFrame.setLayout(null);

        id_emp= empID;
        lblImage =new JLabel();
        lblImage.setBounds(0,0,900,500);
        lblImage.setLayout(null);

        heading = new JLabel("Update Employee Detail:");
        heading.setBounds(215,10,600,50);
        heading.setFont(new Font("poppins",Font.BOLD,40));
        heading.setForeground(Color.black);
        lblImage.add(heading);
        mainFrame.add(lblImage);


        name = new JLabel("Name:");
        name.setBounds(50,100,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(name);

        pname =new JTextField();
        pname.setBounds(200,100,150,30);
        lblImage.add(pname);

        fatherName = new JLabel("Father's Name:");
        fatherName.setBounds(400,100,200,30);
        fatherName.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(fatherName);

        fname =new JTextField();
        fname.setBounds(600,100,150,30);
        lblImage.add(fname);

        address = new JLabel("Address:");
        address.setBounds(50,150,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(address);

        txtAddress =new JTextField();
        txtAddress.setBounds(200,150,150,30);
        lblImage.add(txtAddress);

        mobileNo = new JLabel("Mobile No:");
        mobileNo.setBounds(400,150,100,30);
        mobileNo.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(mobileNo);

        txtMobile =new JTextField();
        txtMobile.setBounds(600,150,150,30);
        lblImage.add(txtMobile);

        emailID = new JLabel("Email Id:");
        emailID.setBounds(50,200,100,30);
        emailID.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(emailID);

        txtEmail =new JTextField();
        txtEmail.setBounds(200,200,150,30);
        lblImage.add(txtEmail);

        education = new JLabel("Education:");
        education.setBounds(400,200,100,30);
        education.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(education);

        txtEducation =new JTextField();
        txtEducation.setBounds(600,200,150,30);
        lblImage.add(txtEducation);

        jobPost = new JLabel("Job Post:");
        jobPost.setBounds(50,250,100,30);
        jobPost.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(jobPost);

        txtPost =new JTextField();
        txtPost.setBounds(200,250,150,30);
        lblImage.add(txtPost);

        ctznNo = new JLabel("Citizenship No:");
        ctznNo.setBounds(400,250,150,30);
        ctznNo.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(ctznNo);

        txtCtznNo =new JTextField();
        txtCtznNo.setBounds(600,250,150,30);
        lblImage.add(txtCtznNo);

        this.empID = new JLabel("Employee Id:");
        this.empID.setBounds(50,300,150,30);
        this.empID.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(this.empID);
        
       
        mainFrame.setVisible(false);
        txtEmpID =new JTextField();
        txtEmpID.setEditable(false);
        txtEmpID.setBounds(200,300,150,30);
        lblImage.add(txtEmpID);

        
        
        dob = new JLabel("DOB: ");
        dob.setBounds(400,300,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        lblImage.add(dob);

        txtDob =new JTextField();
        txtDob.setBounds(600,300,150,30);
        lblImage.add(txtDob);
        
        
        
        // Buttons
        btnUpdate =new JButton("UPDATE");
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBackground(success);
        btnUpdate.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnUpdate.setBounds(250,400,130,40);
        btnUpdate.addActionListener(this);
        lblImage.add(btnUpdate);

        btnCancel =new JButton("CANCEL");
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(warning);
        btnCancel.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        btnCancel.setBounds(450,400,130,40);
        btnCancel.addActionListener(this);
        lblImage.add(btnCancel);

        showData(empID);
    }

    int i=0;
    String age,dat;

    void showData(String s){
        try{
            DatabaseConnection con = new DatabaseConnection();
            String str = "select * from employee where emp_id = '"+s+"'";
            ResultSet rs = con.statement.executeQuery(str);

            if(rs.next()){
                mainFrame.setVisible(true);
                i=1;

                pname.setText(rs.getString(1));
                fname.setText(rs.getString(2));
                txtAddress.setText(rs.getString(5));
                txtMobile.setText(rs.getString(6));
                txtEmail.setText(rs.getString(7));
                txtEducation.setText(rs.getString(8));
                txtPost.setText(rs.getString(9));
                txtCtznNo.setText(rs.getString(10));
                txtEmpID.setText(rs.getString(11));
//                t9.setText(rs.getString(3));
                txtDob.setText(rs.getString(4));

                age=rs.getString(3);
                dat=rs.getString(4);
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
            new Search_Employee();
        }catch(Exception ex){}
        mainFrame.setVisible(true);
        mainFrame.setSize(900,500);
        mainFrame.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnUpdate && i==1){
            try{
                DatabaseConnection con = new DatabaseConnection();
                String str = "update employee set name='"+ pname.getText()+"',fname='"+ fname.getText()+"',age='"+age+"',dob='"+dat+"',address='"+ txtAddress.getText()+"',phone='"+ txtMobile.getText()+"',email='"+ txtEmail.getText()+"',education='"+ txtEducation.getText()+"',post='"+ txtPost.getText()+"',ctzn_no='"+ txtCtznNo.getText()+"',emp_id='"+ txtEmpID.getText()+"' where emp_id='"+id_emp+"'";
                con.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                mainFrame.setVisible(false);
                new Search_Employee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()== btnCancel){
            mainFrame.setVisible(false);
            Dashboard d=new Dashboard();
        }
    }

    public static void main(String[] arg){
        new Update_Employee("Update Employee");
    }
}