package xxb.contract;

import com.config.selenium.FileChaseFW;
import com.datacenter.GetData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetC {
    public static void main(String[] args) {
//        WebDriver driver = null;
//        driver = new ChromeDriver();
//        driver.get("https://www.baidu.com");
//        driver.findElement(By.className("soutu-btn")).click();
//        driver.findElement(By.className("upload-pic")).sendKeys(
//                "./logs/AddCustomer2018-08-17-18:12:26:267.png");
//
//
////        driver.quit();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.DAY_OF_MONTH,10);
//        System.out.println(format.format(c.getTime()));
//        String data1 = format.format(new Date());
//        System.out.println(data1);
        String AA = FileChaseFW.readEndData("./src/main/java/com/datacenter/data.txt");
//        FileChaseFW.fileChase("./src/main/java/com/datacenter/data.txt", "123","3333");
        System.out.println(AA);
        String[] arr = AA.split(",");
        System.out.println(arr[1]);
        System.out.println(GetData.serverData());
    }
}
