package com.learning;

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
    protected WebDriver driver;
    protected SearchPageFactoryDemoT search;

    private static WebDriver getDriverInstance(String browser, String url) {
        WebDriver driver = null;

        // Browsers
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome_headless")) {
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
//        search = PageFactory.initElements(driver, SearchPageFactoryDemoT.class);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}