package testSuite;

import com.ExeclDemo.ExeclUtility;
import com.config.selenium.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsingExecl {
    //使用Execl数据驱动
    private WebDriver driver;
//    String baseUrl;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
//        baseUrl = "";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        //切换iframe
        driver.switchTo().frame("x-URS-iframe");
        //指明execl文件路径
        ExeclUtility.setExcelFile(Constants.execlPath + Constants.fileName, "LoginTests");

    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExeclUtility.getTestData("start");
        return testData;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExecl(String username, String password) throws InterruptedException {
        //输入用户名
        WebElement element = driver.findElement(By.xpath("//input[@data-placeholder='邮箱帐号或手机号']"));
        element.clear();
        element.sendKeys(username);
        //输入密码
        WebElement element1 = driver.findElement(By.xpath("//input[@data-placeholder='密码']"));
        element1.sendKeys(password);
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();

        //查找错误信息是否存在
        boolean result = driver.findElements(By.xpath("//div[text()='账号或密码错误']")).size() != 0;
        Assert.assertTrue(result);
        Thread.sleep(2000);

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
