package pomtestcase;

import driverfile.DriverPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.SearchPage;

import java.util.concurrent.TimeUnit;

public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;
    private String path;
    private static final Logger log = LogManager.getLogger(PageObjectModel.class.getName());


    public WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public void setUp() {
//        WebDriver driver;
        path = DriverPath.getPath() + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
//        log.info("选择了MAC_Chrome浏览器。。。");
        baseUrl = "https://www.expedia-cn.com";
        driver.manage().window().maximize();
        log.info("123123");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("设置了等待时间");
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        SearchPage.clickTabFlightTab(driver);
        SearchPage.sendKeysOriginTextBox(driver, "北京, 中国 (PEK-首都国际机场)");
        SearchPage.sendDestinationTextBox(driver, "东京, 日本 (TYO-所有机场)");
        SearchPage.sendDepartureDateTextBox(driver, "2018/08/08");
        SearchPage.sendReturnTextBox(driver, "2018/08/25");
        SearchPage.clickSearchButton(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5555);
        driver.quit();
    }
}
