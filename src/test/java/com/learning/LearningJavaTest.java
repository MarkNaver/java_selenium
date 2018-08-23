package com.learning;//import com.config.selenium.LoggerDemoOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsuite.FrameworkTestCase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class LearningJavaTest {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(FrameworkTestCase.class.getName());

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver","/var/jenkins_home/workspace/java+selenium3/src/main/java/Tools/chromedriver");
//        driver = new ChromeDriver();
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
        System.out.println(driver.getTitle()+ ", " + driver.getCurrentUrl());
    }

    @Test
    public void test() {
        driver.findElement(By.id("kw")).sendKeys("Selenium");
        log.info("搜索selenium");

        String url =  driver.getCurrentUrl();
        System.out.println(url);
        log.info("输入网址");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1333);
        driver.quit();
    }
}