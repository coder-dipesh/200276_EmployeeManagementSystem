import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Login_ClassTest {

    // Login with valid data
    @Test
    public void test_case_first() {
        String username ="root";
        String pass = "root";
        Login_Class login_test = new Login_Class();
        boolean result = login_test.userLogin(username,pass);
        assertEquals(true,result);
    }

    // Login with invalid Data
    @Test
    public void test_case_second() {
        String username ="root";
        String pass = "root123";
        Login_Class login_test = new Login_Class();
        boolean result = login_test.userLogin(username,pass);

        assertNotEquals(true,result);

    }


}