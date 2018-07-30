import com.config.selenium.SeleniumHaaaaaa;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class S_jTest {
    public static void main(String[] args) {
        new SeleniumHaaaaaa();
        String cccc = SeleniumHaaaaaa.str();
        int ddd = SeleniumHaaaaaa.str1(3,5);
        System.out.println(cccc+"123123");
        System.out.println(ddd);
        int[] numbers = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        //            System.out.println(x);
        for (int x: numbers
             )
            if (x != 15) {
                System.out.println(x);
                continue;

            }


    }
    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
    }

    @Test
    public void testName() {
        System.out.println("Hello");
    }

    @Test
    public void testName2() {
        System.out.println("world");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
    }

    @Test
    public void testMain() {
        Assert.assertEquals(1,1);
    }



}





