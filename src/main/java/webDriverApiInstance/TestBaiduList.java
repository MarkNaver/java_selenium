package webDriverApiInstance;

import com.config.selenium.LoggerDemoOne;
import com.config.selenium.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBaiduList {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        LoggerDemoOne.Output(LogType.LogTypeName.INFO, "创建chrome浏览器对象");
        baseUrl = "https://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        LoggerDemoOne.Output(LogType.LogTypeName.INFO, "隐式等待11s");
        gm = new GenericMethods(driver);


    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);
        LoggerDemoOne.Output(LogType.LogTypeName.INFO, "打开百度首页");

//        List<WebElement> elementList = gm.getElementList("kw","id");
        boolean result = gm.isElenmentPresent("kw", "id");
        System.out.println("元素在页面上存在吗" + result);

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("kw"))
        );
        emailField.sendKeys("hahaha");

        boolean result2 = gm.isElenmentPresent("kw22", "id");
        System.out.println("元素再页面上存在吗" + result2);

//        driver.findElement(By.id("su")).click();
        LoggerDemoOne.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        LoggerDemoOne.Output(LogType.LogTypeName.INFO, "退出浏览器");
    }
}
