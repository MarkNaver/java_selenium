package WebDriverApiInstance;

import com.config.selenium.LOGGER;
import com.config.selenium.LogType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class isListPresent {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        LOGGER.Output(LogType.LogTypeName.INFO, "创建chrome浏览器对象");
        baseUrl = "https://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.Output(LogType.LogTypeName.INFO, "隐式等待10s");
        gm = new GenericMethods(driver);


    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);
        boolean result = gm.isElenmentPresent("//a44", "xpath");
        LOGGER.Output(LogType.LogTypeName.INFO, "打开百度首页");

        List<WebElement> elementList = gm.getElementList("//a33", "xpath");
        int size = elementList.size();
        System.out.println("：" + result);
        Thread.sleep(3000);

//        driver.
        LOGGER.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        LOGGER.Output(LogType.LogTypeName.INFO, "退出浏览器");
    }
}
