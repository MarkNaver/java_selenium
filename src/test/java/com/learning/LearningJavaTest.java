package com.learning;//import com.config.selenium.LoggerDemoOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsuite.FrameworkTestCase;

import java.util.concurrent.TimeUnit;

class LearningJavaTest {
    private WebDriver driver;

    //        private static final Logger log = LogManager.getLogger
private static final Logger log = LogManager.getLogger(FrameworkTestCase.class.getName());

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","/var/jenkins_home/workspace/java+selenium3/src/main/java/Tools/chromedriver");
        driver = new FirefoxDriver();
        String baseUrl = "https://www.baidu.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        log.info("打开了浏览器");
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