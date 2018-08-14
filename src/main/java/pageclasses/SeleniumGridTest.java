package pageclasses;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridTest {
    /*
    使用selenium grid 分布式测试
    注意node机器上selenium-sever-standalone版本需使用3.9.1，截止目前最新的3.13.0版本运行case会失败
     */
    private WebDriver driver;
    private String baseUrl;
    private String nodeUrl;
    //    private ExtentTest test;
    private SearchPageFactory searchPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://www.expedia-cn.com/";
        nodeUrl = "http://192.168.0.108:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeUrl), cap);


        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @Test
    public void test() {
        searchPage.searchPage("北京, 中国 (PEK-首都国际机场)",
                "东京, 日本 (TYO-所有机场)",
                "2018/09/24");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
