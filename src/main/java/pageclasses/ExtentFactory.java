package pageclasses;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports GetInstance() {
        //报告生成文件路径及系统信息等
        ExtentReports extentReports;
        String Path = "./logs/report-demo.html";
        extentReports = new ExtentReports(Path, false);
        extentReports.addSystemInfo("Selenium Version", "3.6.0").addSystemInfo("Platform", "Mac");
        return extentReports;
    }
}
