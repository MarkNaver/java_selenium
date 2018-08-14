package testSuite;

//import org.junit.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.ExtentFactory;

public class FrameworkTestCase3 {
    ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        reports = ExtentFactory.GetInstance();
        test = reports.startTest("FrameworkTestCase3 -> Class verification");

    }

    @Test
    public void testMethod() {
        test.log(LogStatus.INFO, "FrameworkTestCase3 -> 测试方法开始了");
        test.log(LogStatus.INFO, "FrameworkTestCase3 -> 测试方法运行中");
        test.log(LogStatus.INFO, "FrameworkTestCase3 -> 测试方法结束了");


    }

    @AfterClass
    public void afterClass() {
        reports.endTest(test);
        reports.flush();
    }
}
