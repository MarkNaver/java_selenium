package com.learning;

import Tools.DriverPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestSuiteBaseDemo {
    private static final Logger log = LogManager.getLogger(TestSuiteBaseDemo.class.getName());

    protected WebDriver driver;


    private static WebDriver getDriverInstance(String browser, String url) {
        WebDriver driver = null;
        String osname = System.getProperty("os.name");
        String path;
        // Browsers

        if (browser.equalsIgnoreCase("Chrome")) {
            if (osname.contains("Mac")) {
                path = DriverPath.getPath() + "/chromedriver";
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
                log.info("选择了MAC_Chrome浏览器。。。");
            } else {
                path = DriverPath.getPath() + "/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
                log.info("选择了Windows_Chrome浏览器。。。");
            }
        } else if (browser.equalsIgnoreCase("Firefox")) {
            if (osname.contains("Mac")) {
                path = DriverPath.getPath() + "/geckodriver";
                System.setProperty("webdriver.gecko.driver", path);
                driver = new FirefoxDriver();
                log.info("选择了MAC_Firefox浏览器。。。");
            } else {
                path = DriverPath.getPath() + "/geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", path);
                driver = new FirefoxDriver();
                log.info("选择了Windows_Firefox浏览器。。。");
            }
        } else if (browser.equalsIgnoreCase("Chrome_headless")) {
            //可能会报错。。。待解决
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
            log.info("选择了Chrome无头浏览器。。。");

        } else if (browser.equalsIgnoreCase("Firefox_headless")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
            log.info("选择了Firefox无头浏览器。。。");

        }
        // Open the Application
        try {
            assert driver != null;
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(url);
            log.info("打开了浏览器");
            driver.findElement(By.id("uid")).sendKeys("adminceshi");
            driver.findElement(By.id("pwd")).sendKeys("123abc,.;");
            driver.findElement(By.xpath("//input[@value='登录']")).click();
            log.info("输入了管理员用户名和密码并点击了登录按钮");
        } catch (Exception e) {
            e.getMessage();
        }
        return driver;
    }

    @Parameters({"browser", "url"})
    @BeforeClass(alwaysRun = true)
    public void setup(String browser, String url) {
        driver = getDriverInstance(browser, url);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}