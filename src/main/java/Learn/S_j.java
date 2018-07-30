package Learn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class S_j {
    public void highlight(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
    }
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        String strDate = date.toString();
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //打开chrome浏览器
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,1024));
        driver.get("https://www.baidu.com/");
        System.out.println("打开了百度，时间为"+df1.format(date));
        String current_tile = driver.getTitle();
        System.out.println(current_tile);
        driver.findElement(By.id("kw")).sendKeys("陶春文");
        Thread.sleep(1000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(1024);
        driver.quit();
        System.out.println("打开了百度，时间为"+df1.format(date));
//        assertEquals(driver.getTitle(),"百度一下");
        String exp_tile = "百度一下";
        assert exp_tile == current_tile;
    }
}



