package xxb.contract;

import WebDriverApiInstance.ScreenshotsDemo;
import com.learning.TestSuiteBaseDemo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.ExtentFactory;

public class ContractCase extends TestSuiteBaseDemo {
    private ContractFactoryBase search;

    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;


    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        search = PageFactory.initElements(driver, ContractFactoryBase.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("ContractCase -> 添加客户");

    }

    @Test
    public void AddCustomer() throws InterruptedException {
        search.LoginContract("adminceshi", "123abc,.;");
        search.Customer();
        search.ToolTables();
        search.subCustomerName("fsdlfsl123");
        search.selectIndustry();
        search.scroll();
        Thread.sleep(1500);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        //失败截图，并存入报告
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "执行失败了", imagePath);

        }
        reports.endTest(test);
        reports.flush();
    }

    @AfterClass
    public void tearDown() {

    }
}