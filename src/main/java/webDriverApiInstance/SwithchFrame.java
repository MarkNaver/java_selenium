package webDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwithchFrame {
    //切换iframe内嵌框架
    private WebDriver driver;
    private String baseUrl;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/datepicker/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void test() throws InterruptedException {
        driver.switchTo().frame(0);
//        driver.switchTo().frame("id");
//        driver.switchTo().frame("name");

        WebElement dataPicker = driver.findElement(By.id("datepicker"));
        dataPicker.click();
        Thread.sleep(3333);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@name='s']")).sendKeys("测试成功");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
