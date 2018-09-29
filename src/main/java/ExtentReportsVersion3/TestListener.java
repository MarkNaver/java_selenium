package ExtentReportsVersion3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.ApiTest;
import tests.BaseTest;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午4:13 2018/9/29
 * @Modified By:
 */
public class TestListener extends BaseTest implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
}
