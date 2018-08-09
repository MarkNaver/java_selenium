package WebDriverApiInstance;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Screenshots {
    private WebDriver driver;
    private String baseUrl;

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrsduvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://login.yahoo.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testScreenshots() {
        driver.get(baseUrl);

        driver.findElement(By.id("login-username")).sendKeys("test");
        driver.findElement(By.id("login-signin")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        String fileNmae = getRandomString(10) + ".png";
        String directory = "./src/main/java/Logs/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileNmae));

        driver.quit();
    }

}
