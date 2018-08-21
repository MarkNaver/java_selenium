package webDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SliderActions {
    //滑块动作 可设置横向或纵向坐标
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "http://jqueryui.com/slider/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSliderActions() throws Exception {
        driver.get(baseUrl);
        driver.switchTo().frame(0);
        Thread.sleep(2222);
        WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));

        //用Actions类操作
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 300, 0).perform();

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
