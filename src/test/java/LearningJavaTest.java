//import com.config.selenium.LOGGER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.concurrent.TimeUnit;

public class LearningJavaTest {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger("Selenium");
        PropertyConfigurator.configure("./src/test/java/Log4j.properties");


        WebDriver driver = new ChromeDriver();
        logger.info("启动浏览器");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        logger.info("隐式等待");

        driver.get("https://www.baidu.com");
        logger.info("打开百度");


        driver.findElement(By.id("kw")).sendKeys("Selenium");
        logger.info("搜索selenium");

        String url =  driver.getCurrentUrl();
        System.out.println(url);
        logger.info("输入网址");

        Thread.sleep(3333);
        driver.quit();
    }
}