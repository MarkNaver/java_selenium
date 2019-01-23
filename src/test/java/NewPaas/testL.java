package NewPaas;

import driverfile.DriverPath;
import com.common.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午12:27 2018/9/30
 * @Modified By:
 */
public class testL {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private void ffsdf() throws InterruptedException, IOException {
        String path = DriverPath.getPath() + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
//        driver = new ChromeDriver();
        driver = new ChromeDriver();
        String url = "http://100.63.0.251/inpaas-v2/app-list?token=";
        String token = Config.getToken();

        driver.get(url + token);
        Thread.sleep(4444);
        driver.findElement(By.xpath("//a[contains(text(),'创建标准IT部件')]")).click();
        Thread.sleep(4422);
        driver.findElement(By.xpath("(//a[contains(text(),'开通服务')])[3]")).click();
        Thread.sleep(2444);
        WebElement aa =  driver.findElement(By.xpath("//div[contains(text(),'中国大陆-北京-可用区A')]"));
        aa.click();
        Thread.sleep(2333);
//        System.out.println(aa.getAttribute("style") + "nnnn");
//        Thread.sleep(3333);
        WebElement ss = driver.findElement(By.xpath("//li[contains(text(),'中国大陆-北京-可用区C')]"));
        ss.click();
//        System.out.println(ss);
//        System.out.println(ss.getText() + "123123");
//        Thread.sleep(3333);
//        driver.findElement(By.xpath("//div[@class='new_create_net_ip']//label")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'创建')]")).click();

        WebElement qq = driver.findElement(By.xpath("//div[contains(text(),'2核4G')]"));
        System.out.println(qq.getAttribute("style") + " |2核4G");
        WebElement rr = driver.findElement(By.xpath("//div[contains(text(),'4核8G')]"));
        System.out.println(rr.getAttribute("style") + " |4核8G");


        Thread.sleep(5555);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        testL testL = new testL();
        testL.ffsdf();
    }
}
