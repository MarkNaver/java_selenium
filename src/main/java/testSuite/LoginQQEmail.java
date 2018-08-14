//package testSuite;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import WebDriverApiInstance.ScreenshotsDemo;
//import com.config.selenium.Config;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import pageclasses.ExtentFactory;
//import pageclasses.HomePage;
//
//public class LoginQQEmail extends Config {
//
////    private WebDriver driver;
////    private String baseUrl;
//    ExtentReports report;
//    ExtentTest test;
//    HomePage hp;
//
//    @Parameters({"browser","url"})
//    @BeforeClass
//    public void beforeClass() {
////        baseUrl = "https://mail.qq.com";
////        report = ExtentFactory.GetInstance();
////        test = report.startTest("Verify if login successfully");
////        driver = new ChromeDriver();
////        hp = new HomePage(driver, test);
////        test.log(LogStatus.INFO, "Browser started...");
////
////        // Maximize the browser's window
////        driver.manage().window().maximize();
////        test.log(LogStatus.INFO, "Browser Maximized...");
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driver.get(baseUrl);
////        test.log(LogStatus.INFO, "Web Application Opened");
//
//    }
//
//    @Test
//    public void test1_validLoginTest() throws Exception {
//        driver.switchTo().frame("login_frame");
//        hp.login("7646909351", "20090106*woaini");
//
//        Thread.sleep(3000);
//        boolean result = hp.isWelcomeTextPresent();
//
//        Assert.assertTrue(result);
////        System.out.println(result);
//        test.log(LogStatus.PASS, "Verified Login Successfully");
//
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            String path =  ScreenshotsDemo.takeScreenshots(driver, testResult.getName());
//            String imagePath = test.addScreenCapture(path);
//            test.log(LogStatus.FAIL,"执行失败了", imagePath);
//        }
//        driver.quit();
//    }
//
//    @AfterClass
//    public void afterClass() {
////        driver.quit();
//        report.endTest(test);
//        report.flush();
//    }
//
//}