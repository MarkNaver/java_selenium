package ExtenNews;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "/logs/ExtenResult.html", true);
            extent
                    .addSystemInfo("selenium version", "3.14.0")
                    .addSystemInfo("测试执行人", "Mr.t");
        }
        return extent;
    }

}
