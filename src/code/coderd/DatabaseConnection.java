package code.coderd;

import java.sql.*;

public class DatabaseConnection {
    
    public Connection connect;
    public Statement statement;
 
    public DatabaseConnection(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3","root","root");
            statement = connect.createStatement();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 
