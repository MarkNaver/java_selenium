package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 15);
//        driver.manage().window().maximize();
        System.out.println(123123);
    }

    @AfterClass
    public void teardown() {
        System.out.println(123123);
    }
}
