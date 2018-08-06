package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageclasses.SearchPageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindLinks {
    //查找页面所有元素
    private WebDriver driver;

    @BeforeClass
    @Parameters({"url"})
    public void setUp(String url) throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void testFindLinks() throws InterruptedException {
        Thread.sleep(2000);

        //打印链接信息
        List<WebElement> linkList = clickableLinks(driver);
        for (WebElement link : linkList) {
            String href = link.getAttribute("href");
            try {
                System.out.println("URL:" + href + " |结果为：" + linkStatus(new URL(href)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    //查找页面所有链接，标签为a和img的，可用作其他元素，只需修改tagName即可
    public static List<WebElement> clickableLinks(WebDriver driver) {
        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));
        for (WebElement e : elements) {
            if (e.getAttribute("href") != null) {
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url) {
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
