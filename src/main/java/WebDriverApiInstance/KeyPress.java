package WebDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KeyPress {
    //WebDriver使用键盘按键Api实例
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://login.yahoo.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("login-username")).sendKeys("test");

//        driver.findElement(By.id("login-signin")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("login-username")).sendKeys(Keys.TAB);

        String selectAll = Keys.chord(Keys.CONTROL, "a");
        driver.findElement(By.id("login-signin")).sendKeys(selectAll);

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
