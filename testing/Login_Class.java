

public class Login_Class {
    String user_name ="root";
    String pass= "root";

    public boolean userLogin(String username, String password) {
        boolean result = false;

        if(username == user_name && password == pass) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {


    }
}
