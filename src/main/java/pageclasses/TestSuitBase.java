package pageclasses;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuitBase {
    protected WebDriver driver;
    protected SearchPageFactory search;

    public static WebDriver GetDriverInstance(String platform, String browser, String version, String url)
            throws MalformedURLException {
        String nodeURL = "http://192.168.0.108:5555/wd/hub";
        WebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        //platforms选择操作系统平台
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(Platform.MAC);
        }

        //选择浏览器
        if (browser.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        }

        //设置浏览器版本
        caps.setVersion(version);
        driver = new RemoteWebDriver(new URL(nodeURL), caps);

//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    @Parameters({"platform", "browser", "version", "url"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String platform, String browser, String version, String url)
            throws MalformedURLException {
        driver = GetDriverInstance(platform, browser, version, url);
        search = PageFactory.initElements(driver, SearchPageFactory.class);

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

}
