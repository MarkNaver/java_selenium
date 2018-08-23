package com.learning;//import com.config.selenium.LoggerDemoOne;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.ExtentFactory;
import testsuite.FrameworkTestCase;
import webdriverapiInstance.ScreenshotsDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class LearningJavaTest {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(FrameworkTestCase.class.getName());
    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver","/var/jenkins_home/workspace/java+selenium3/src/main/java/Tools/chromedriver");
//        driver = new ChromeDriver();

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("LearningJavaTest -> 百度搜索Selenium");

        String nodeURL = "http://47.94.100.252:4444/wd/hub";
//        WebDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.UNIX);
        caps = DesiredCapabilities.chrome();
        caps.setVersion("68.0.3440.84");

        driver = new RemoteWebDriver(new URL(nodeURL), caps);

        String baseUrl = "https://www.baidu.com/";
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        log.info("打开了浏览器");
        test.log(LogStatus.INFO,"打开了浏览器");
        System.out.println(driver.getTitle()+ ", " + driver.getCurrentUrl());
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.id("kw")).sendKeys("Selenium");
        log.info("搜索selenium");

        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        log.info("输入网址");
        if (driver.getTitle().equals("Selenium_百度搜索")) {
            test.log(LogStatus.PASS,"测试通过");
        }else {
            test.log(LogStatus.FATAL,"测试失败");
        }
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        //失败截图，并存入报告
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "执行失败了", imagePath);

        }
        reports.endTest(test);
        reports.flush();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1333);
        driver.quit();
    }
}