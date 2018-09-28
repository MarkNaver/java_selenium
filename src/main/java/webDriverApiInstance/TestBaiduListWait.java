//package webdriverapiInstance;
//
//import com.Config.selenium.LOGGER;
//import com.Config.selenium.LogType;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import utility.WaitTypes;
//
//import java.util.concurrent.TimeUnit;
//
//public class testBaiduListWait {
//
//    private WebDriver driver;
//    private String baseUrl;
//    private GenericMethods gm;
//    private WaitTypes wt;
//
//    @BeforeClass
//    public void setUp() {
//
////        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
//        driver = new ChromeDriver();
//        LOGGER.Output(LogType.LogTypeName.INFO, "创建chrome浏览器对象");
//        wt = new WaitTypes(driver);
//        baseUrl = "https://www.baidu.com";
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        LOGGER.Output(LogType.LogTypeName.INFO, "隐式等待10s");
//        gm = new GenericMethods(driver);
//
//
//    }
//
//    @Test
//    public void testMethod() throws Exception {
//        driver.get(baseUrl);
//        LOGGER.Output(LogType.LogTypeName.INFO, "打开百度首页");
//
////        List<WebElement> elementList = gm.getElementList("kw","id");
//        boolean result = gm.isElenmentPresent("kw", "id");
//        System.out.println("元素在页面上存在吗" + result);
//        WebElement emailField = wt.waitForElement(By.id("kw"), 3);
////        WebDriverWait wait = new WebDriverWait(driver, 3);
////        WebElement emailField = wait.until(
////                ExpectedConditions.visibilityOfElementLocated(By.id("kw"))
////        );
//        emailField.sendKeys("hahaha");
//
//
//        wt.clickWhenReady(By.xpath("//a[@class='toindex']"), 3);
//        boolean result2 = gm.isElenmentPresent("kw22", "id");
//        System.out.println("元素再页面上存在吗" + result2);
//
////        driver.findElement(By.id("su")).click();
//        LOGGER.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
//        Thread.sleep(3000);
//    }
//
//    @AfterClass
//    public void tearDown() throws Exception {
//        Thread.sleep(2000);
//        driver.quit();
//        LOGGER.Output(LogType.LogTypeName.INFO, "退出浏览器");
//    }
//}
