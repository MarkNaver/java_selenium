//package com.Config.selenium;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import pageclasses.ExtentFactory;
//import pageclasses.SearchPageFactoryDemoT;
//
//import java.util.concurrent.TimeUnit;
//
//public class Config {
//    protected  WebDriver driver;
//    protected SearchPageFactoryDemoT searchPage;
//    private ExtentReports reports;
//    private static ExtentTest test;
//
//    @Parameters({"browser","url"})
//    @BeforeClass(alwaysRun = true)
//    public void setup(String browser,String baseUrl) {
//        reports = ExtentFactory.GetInstance();
//        test = reports.startTest("打开了");
//        driver = getBrowser(browser, baseUrl);
////        searchPage = PageFactory.initElements(driver, SearchPage.class);
//        searchPage = PageFactory.initElements(driver, SearchPageFactoryDemoT.class);
//    }
//
//    public static WebDriver getBrowser(String browser,String baseUrl) {
//        WebDriver driver = null;
//        if (browser.equalsIgnoreCase("Chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("Firefox")) {
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("Chrome_headless")) {
//            //Chrome无头浏览器
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
//            driver = new ChromeDriver(chromeOptions);
//        } else if (browser.equalsIgnoreCase("Firefox_headless")) {
//            FirefoxBinary firefoxBinary = new FirefoxBinary();
//            firefoxBinary.addCommandLineOptions("--headless");
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setBinary(firefoxBinary);
//            driver = new FirefoxDriver(firefoxOptions);
//        }
//        assert driver != null;
//
//        driver.manage().window().maximize();
//        test.log(LogStatus.INFO, "Browser Maximized...");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(baseUrl);
//        test.log(LogStatus.INFO, "Web Application Opened");
//        driver.get(baseUrl);
//        return driver;
//    }
//
//    @AfterMethod
//    public void tearDown() throws Exception {
////        Thread.sleep(1222);
////        if (result.getStatus() == ITestResult.FAILURE) {
////            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
////            String imagePath = test.addScreenCapture(path);
////            test.log(LogStatus.FAIL, "执行失败了", imagePath);
//////
////        }
////        driver.quit();
////        reports233.endTest(test);
////        System.out.println("123");
////        reports233.flush();
////        System.out.println("qqqqqqqq");
//        driver.quit();
//    }
//
//}
