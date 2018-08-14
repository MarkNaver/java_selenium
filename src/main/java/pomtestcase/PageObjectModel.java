package pomtestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.SearchPage;

import java.util.concurrent.TimeUnit;

public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia-cn.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        SearchPage.clickTabFlightTab(driver);
        SearchPage.sendKeysOriginTextBox(driver, "北京, 中国 (PEK-首都国际机场)");
        SearchPage.sendDestinationTextBox(driver, "东京, 日本 (TYO-所有机场)");
        SearchPage.sendDepartureDateTextBox(driver, "2018/08/08");
        SearchPage.sendReturnTextBox(driver, "2018/08/25");
        SearchPage.clickSearchButton(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5555);
        driver.quit();
    }
}
