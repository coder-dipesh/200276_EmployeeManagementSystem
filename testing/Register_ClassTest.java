import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Register_ClassTest {

    @Test
    // testing class not null
    public void testConstructor() {
        Register_Class registerClass = new Register_Class();
        assertNotNull(registerClass);
    }

    @Test
    // Register inserting test pass
    public void testGetters() {
        Register_Class registerClient = new Register_Class("Dipesh","Siwakoti","dipeshsiwakoti112@gmail.com","dipesh112", "7323");
        String expected = "dipesh112";
        String actual = registerClient.getUsername();
        assertEquals(expected,actual);
    }

}