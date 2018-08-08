package WebDriverApiInstance;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots2 {
    public static String takeScreenshots(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "/Users/tcw/seleniumjava/logs/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(directory + fileName));
        String destination = directory + fileName;
        return destination;
    }
}
