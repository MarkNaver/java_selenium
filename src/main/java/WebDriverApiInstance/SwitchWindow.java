package WebDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    //切换浏览器标签
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://www.hao123.com/";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        //获取主窗口handle


        //获取主窗口
        String parentHandle = driver.getWindowHandle();
        System.out.println("主窗口handle为：" + parentHandle);
        Thread.sleep(3000);

        //点击央视网，打开新窗口
        WebElement openWindow = driver.findElement(By.xpath("//a[contains(text(),'央视网')]"));
        openWindow.click();

        //获取所有窗口handles
        Set<String> parentHandles = driver.getWindowHandles();

        //切换handles
        for (String handle : parentHandles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                WebElement openNewWindow = driver.findElement(By.xpath("//img[@title='Chinese Traditional']"));
                openNewWindow.click();
                Thread.sleep(2000);
                driver.close();
//                Thread.sleep(4000);
                break;

            }
        }

        //切回主窗口
        driver.switchTo().window(parentHandle);
        WebElement openWindow1 = driver.findElement(By.xpath("//a[contains(text(),'网信网')]"));
        openWindow1.click();
        System.out.println("打开网信网");
        Thread.sleep(3000);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
