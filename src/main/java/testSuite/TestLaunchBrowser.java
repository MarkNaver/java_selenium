package testSuite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.config.selenium.Browser;

public class TestLaunchBrowser {

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException{

        Browser browserEngine = new Browser();
        browserEngine.initConfigData();
        driver=browserEngine.getBrowser();

    }


    @Test
    public void clickNews(){

        driver.findElement(By.id("kw")).sendKeys("iPhone 7");
        driver.findElement(By.id("su")).click();

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }


}
