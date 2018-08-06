package testSuite;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageclasses.SearchPageFactory;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;

//import org.junit.BeforeClass;

public class FrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;
    private SearchPageFactory searchPage;
    private static final Logger log = LogManager.getLogger(FrameworkTestCase.class.getName());

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
//        driver = new ChromeDriver();
        baseUrl = "https://www.expedia-cn.com/";
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome_headless")) {
            //Chrome无头浏览器
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("Firefox_headless")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        }


        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        log.info("浏览器最大化");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        log.info("打开了网址");
    }

    @Test
    public void test(){
        searchPage.clicTabfightTab();
        searchPage.clickFightTab();
        searchPage.setFlightOrigin("北京, 中国 (PEK-首都国际机场)");
        searchPage.setDestination("东京, 日本 (TYO-所有机场)");
        searchPage.setDepartureDate("2018/09/24");
        searchPage.clickFightTab();
        searchPage.clickSearchButton();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
