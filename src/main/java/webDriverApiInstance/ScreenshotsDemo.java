package webDriverApiInstance;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotsDemo {
    public static String takeScreenshots(WebDriver driver, String fileName) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
        String formatStr = format.format(new Date());
        fileName = fileName + formatStr + ".png";
        String imgPath = System.getProperty("user.dir");
        String directory = imgPath + "/logs/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(directory + fileName));
        return directory + fileName;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path + "/logs/");
    }


}
