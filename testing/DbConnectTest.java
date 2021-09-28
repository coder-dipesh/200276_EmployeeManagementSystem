
import java.sql.*;


public class DbConnectTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String hostName;
    String port;
    String username;
    String password;
    public static Connection con;
    Statement stmt = null;

    public Statement setUpConnection() throws SQLException {

        try{
            final String DB_URL = "jdbc:mysql://"+hostName+":"+port+"";

            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(DB_URL,username,password);
            stmt = con.createStatement();

            String query = "CREATE DATABASE oopProject";
            stmt.executeUpdate(query);

            con= DriverManager.getConnection(DB_URL+"/oopProject",username,password);
            stmt = con.createStatement();

            System.out.println(DB_URL);



        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("statement: "+stmt);
        return stmt;

    }


    public Statement connection() {


        try{
            final String DB_URL = "jdbc:mysql://"+hostName+":"+port+"";

            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(DB_URL,username,password);
            stmt = con.createStatement();

            con= DriverManager.getConnection(DB_URL+"/oopProject",username,password);
            stmt = con.createStatement();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return stmt;

    }

}