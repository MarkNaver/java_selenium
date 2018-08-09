package WebDriverApiInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class javaScriptExecution {
    String baseUrl;
    private WebDriver driver;
    private JavascriptExecutor js;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "http://www.baidu.com";
        js = (JavascriptExecutor) driver;

//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavascriptExecution() throws Exception {
        /*
        js操作浏览器
         */
//        driver.get(baseUrl);
        js.executeScript("window.location = 'http://www.baidu.com';");
        Thread.sleep(3000);


//        WebElement textBox = driver.findElement(By.id("kd"));
        WebElement textBox1 = (WebElement) js.executeScript(" return document.getElementById('kw');");
        textBox1.sendKeys("test");

        Long height = (Long) js.executeScript("return window.innerHeight;");
        Long width = (Long) js.executeScript("return window.innerWidth;");
        System.out.println("窗口的高度为：" + height);
        System.out.println("窗口的宽度为：" + width);
        Thread.sleep(2000);

        //向下滚动
        js.executeScript("window.scrollBy(0,-1900);");
        System.out.println("向上滚动");
        Thread.sleep(2000);

        //向上滚动
        js.executeScript("window.scrollBy(0,33);");
        Thread.sleep(2000);
        System.out.println("向下滚动");

        WebElement element = driver.findElement(By.xpath("//div[@id='10']//h3"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
