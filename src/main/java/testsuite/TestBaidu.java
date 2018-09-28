//package testsuite;
//
////import webdriverapiInstance.GenericMethods;
////import com.Config.selenium.LOGGER;
//import com.Config.selenium.LogType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class testBaidu {
//
//    private WebDriver driver;
//    private String  baseUrl;
//    private GenericMethods gm;
//
//    @BeforeClass
//    public void setUp() {
//
////        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
//        driver = new FirefoxDriver();
//        LOGGER.Output(LogType.LogTypeName.INFO, "创建chrome浏览器对象");
//        baseUrl = "https://www.baidu.com";
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        LOGGER.Output(LogType.LogTypeName.INFO, "隐式等待10s");
//        gm = new GenericMethods(driver);
//    }
//
//    @Test
//    public void testMethod() throws Exception {
//        driver.get(baseUrl);
//        LOGGER.Output(LogType.LogTypeName.INFO, "打开百度首页");
//
//        WebElement element = gm.getElement("kw", "id");
//        element.sendKeys("selenium");
//
//        Thread.sleep(3000);
//
////        driver.findElement(By.id("su")).click();
//        LOGGER.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
//        Thread.sleep(3000);
//    }
//
//    @AfterClass
//    public void tearDown() throws Exception{
//        Thread.sleep(2000);
//        driver.quit();
//        LOGGER.Output(LogType.LogTypeName.INFO, "退出浏览器");
//    }
//}
