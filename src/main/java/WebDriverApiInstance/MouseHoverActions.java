package WebDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseHoverActions {
    //鼠标悬停操作
    JavascriptExecutor jse;
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "file:///Users/tcw/Downloads/PracticePage2.html";
        jse = (JavascriptExecutor) driver;

        //Maximize windows
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMoushHoverActions() throws InterruptedException {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        WebElement mainElement = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(4444);
        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[text()='回到顶部']"));
        action.moveToElement(subElement).click().perform();
        Thread.sleep(4444);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
