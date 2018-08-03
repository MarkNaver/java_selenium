package testSuite;
import org.junit.After;
import org.junit.Before;
import com.config.selenium.LOGGER;
import com.config.selenium.LogType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class testBaidu {

    private WebDriver driver;
    private String  baseUrl;

    @Before
    public void setUp() throws Exception {

//        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        LOGGER.Output(LogType.LogTypeName.INFO, "创建chrome浏览器对象");
        baseUrl = "https://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.Output(LogType.LogTypeName.INFO, "隐式等待10s");


    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);
        LOGGER.Output(LogType.LogTypeName.INFO, "打开百度首页");

        driver.findElement(By.id("kw")).sendKeys("Selenium");
        LOGGER.Output(LogType.LogTypeName.INFO, "搜索输入框输入关键字Selenium");

        Thread.sleep(3000);

        driver.findElement(By.id("su")).click();
        LOGGER.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
        LOGGER.Output(LogType.LogTypeName.INFO, "退出浏览器");
    }
}
