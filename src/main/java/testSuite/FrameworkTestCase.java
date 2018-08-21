package testSuite;

import webdriverapiInstance.ScreenshotsDemo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageclasses.SearchPageFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class FrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;
    private ExtentReports reports;
    private ExtentTest test;
    private SearchPageFactory searchPage;
    private static final Logger log = LogManager.getLogger(FrameworkTestCase.class.getName());

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
//        driver = new ChromeDriver();
        reports = new ExtentReports("./logs/loginTest.html");
        test = reports.startTest("Verify if find");
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
        test.log(LogStatus.INFO,"寻找到了合适的浏览器并且打开了");
//        LOGGER.Output(LogType.LogTypeName.INFO, "从配置文件中获取登录名：");


        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        log.info("浏览器最大化");
        test.log(LogStatus.INFO,"浏览器最大化了");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        log.info("打开了网址");
        test.log(LogStatus.INFO,"打开了网站了！");
    }

    @Test
    public void test(){
        searchPage.clicTabfightTab();
        log.info("点击了机票标签");
        test.log(LogStatus.INFO,"点击了机票标签");

        searchPage.clickFightTab();
        log.info("点击了单程标签");
        test.log(LogStatus.INFO,"点击了单程标签");
        searchPage.setFlightOrigin("北京, 中国 (PEK-首都国际机场)");
        log.info("输入了始发地");
        test.log(LogStatus.INFO,"输入了始发地");
        searchPage.setDestination("东京, 日本 (TYO-所有机场)");
        log.info("输入了目的地");
        test.log(LogStatus.INFO,"输入了目的地");
//        searchPage.setDepartureDate("2018/09/24");
//        log.info("输入出发时间");
//        test.log(LogStatus.INFO,"输入出发时间");
        searchPage.clickFightTab();
        log.info("点击了单程标签");

        searchPage.clickSearchButton();
        log.info("点击搜索按钮");
        WebElement  webElement = null;
        try {
            webElement = driver.findElement(By.id("titleBar"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(webElement != null);
        test.log(LogStatus.PASS,"Case执行成功");


    }


    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL,"执行失败了", imagePath);

        }
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }
    //    @AfterClass
}
