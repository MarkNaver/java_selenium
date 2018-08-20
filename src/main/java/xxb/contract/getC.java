package xxb.contract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getC {
    public static void main(String[] args) {
        WebDriver driver = null;
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.className("soutu-btn")).click();
        driver.findElement(By.className("upload-pic")).sendKeys(
                "./logs/AddCustomer2018-08-17-18:12:26:267.png");


//        driver.quit();
    }
}
