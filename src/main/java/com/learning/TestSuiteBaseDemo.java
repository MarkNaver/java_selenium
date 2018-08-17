package com.learning;

import Tools.DriverPath;
import org.apache.logging.log4j.LogManager;
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
import xxb.contract.ContractFactoryBase;

import java.util.concurrent.TimeUnit;

public class TestSuiteBaseDemo {
    private static final Logger log = LogManager.getLogger(ContractFactoryBase.class.getName());

    protected WebDriver driver;

//    protected SearchPageFactoryDemoT search;

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
        } else if (browser.equalsIgnoreCase("Firefox_headless")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        }
        // Open the Application
        try {
            assert driver != null;
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(url);
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