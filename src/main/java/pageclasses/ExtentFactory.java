package pageclasses;

import com.relevantcodes.extentreports.ExtentReports;

import java.util.Properties;

public class ExtentFactory {
    public static ExtentReports GetInstance() {
        //报告生成文件路径及系统信息等
        Properties props = System.getProperties();
        String osName = props.getProperty("os.name");
        String userName = props.getProperty("user.name");
        ExtentReports extentReports;
        String Path = "./logs/report-demo.html";
        extentReports = new ExtentReports(Path, false);
        extentReports
                .addSystemInfo("Selenium Version", "3.6.0")
                .addSystemInfo("Platform", osName)
                .addSystemInfo("测试执行人",userName)
                .addSystemInfo("Browser","Chrome");
        return extentReports;
    }
}
