package testSuite;

import com.config.selenium.LOGGER;
import com.config.selenium.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class testBaidu {

    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LOGGER.Output(LogType.LogTypeName.INFO, "启动chrome浏览器");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.Output(LogType.LogTypeName.INFO, "设置隐式时间10秒");

        driver.get("https://www.baidu.com");
        LOGGER.Output(LogType.LogTypeName.INFO, "打开百度首页");

        driver.findElement(By.id("kw")).sendKeys("Selenium");
        LOGGER.Output(LogType.LogTypeName.INFO, "搜索输入框输入关键字Selenium");

        Thread.sleep(3000);

        driver.findElement(By.id("su")).click();
        LOGGER.Output(LogType.LogTypeName.INFO, "点击搜索按钮");
        Thread.sleep(3000);

        driver.quit();
        LOGGER.Output(LogType.LogTypeName.INFO, "退出浏览器");
    }

}
