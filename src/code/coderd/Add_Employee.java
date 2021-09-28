package code.coderd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Add_Employee implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b,b1,b2,b3;
    Color success = new Color(116,181,112);
    Color warning = new Color(218,0,55);

    Add_Employee(int i){}
    
    Add_Employee(){
        f = new JFrame("Employee Management System - Add Employee");
        f.setBackground(Color.white);
        f.setResizable(false);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
//        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("code/icons/add_employee.jpg"));
//        id15.setIcon(img);

        id8 = new JLabel("- Employee Form -");
        id8.setBounds(250,30,500,50);
        id8.setFont(new Font("poppins",Font.BOLD,35));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Full Name");
        id1.setBounds(50,200,150,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,200,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,200,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,200,150,30);
        id15.add(t2);

        id3= new JLabel("Age");
        id3.setBounds(50,250,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,250,150,30);
        id15.add(t3);

        id4= new JLabel("Date of Birth");  
        id4.setBounds(400,250,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,250,150,30);
        id15.add(t4);

        id5= new JLabel("Address");
        id5.setBounds(50,300,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,300,150,30);
        id15.add(t5);

        id6= new JLabel("Phone No.");
        id6.setBounds(400,300,120,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,300,150,30);
        id15.add(t6);

        id7= new JLabel("Email ID");
        id7.setBounds(50,350,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,350,150,30);
        id15.add(t7);

        id9= new JLabel("Education");
        id9.setBounds(400,350,100,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,350,150,30);
        id15.add(t8);

        id10= new JLabel("Job Post");
        id10.setBounds(50,400,100,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        t9=new JTextField();
        t9.setBounds(200,400,150,30);
        id15.add(t9);


        id11= new JLabel("Citizenship No.");
        id11.setBounds(400,400,130,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        t10=new JTextField();
        t10.setBounds(600,400,150,30);
        id15.add(t10);

        id12= new JLabel("Employee ID");
        id12.setBounds(200,120,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);

        t11=new JTextField();   
        t11.setBounds(400,120,150,30);
        id15.add(t11);

        

        lab=new JLabel();
        lab.setBounds(200,450,250,200);
	id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("SUBMIT");
        b.setBackground(success);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        b.setBounds(170,500,200,50);
        
        id15.add(b);

        b1=new JButton("CANCEL");   
        b1.setBackground(warning);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("poppins",Font.TYPE1_FONT,15));
        b1.setBounds(420,500,200,50);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(820,700);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = t11.getText();
        if(ae.getSource() == b){
            try{
                DatabaseConnection cc = new DatabaseConnection();
                String q = "insert into employee values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
                cc.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted.");
                f.setVisible(false);
                new Dashboard();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String[ ] arg){
        new Add_Employee();
    }
}