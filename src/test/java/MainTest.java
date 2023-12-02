import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    
    @Test
    public void mainTest(){
        Assertions.assertEquals(1, 2);
        TestClass.main(new String[]{""});
        System.out.println("test run");
    }
}
