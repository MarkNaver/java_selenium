package xxb.contract;

import webDriverApiInstance.ScreenshotsDemo;
import com.learning.TestSuiteBaseDemo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.ExtentFactory;

import java.util.Map;

public class AddCustomerCase extends TestSuiteBaseDemo {
    public static final Logger log = LogManager.getLogger(AddCustomerCase.class.getName());
    private ContractCustomerFactoryBase search;

    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        search = PageFactory.initElements(driver, ContractCustomerFactoryBase.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("AddCustomerCase -> 添加客户");

    }

    @Test
    public void AddCustomer() throws InterruptedException {
        Map map = RandomDataCenter.getAddress();

        search.LoginContract("adminceshi", "123abc,.;");
        search.Customer();

        search.ToolTables();
        search.subCustomerName((String) map.get("name"));
        search.selectIndustry();
        search.selectProvinceState();//注册地国家
        search.selectProvinceUid();
        search.inputContactName(RandomDataCenter.getAddress().get("name"));
        search.inputContactPhone(RandomDataCenter.getAddress().get("tel"));
        search.inputContactEmail(RandomDataCenter.getAddress().get("email"));
        search.selectPayMethod();//付款方式
        search.inputBusinessName(RandomDataCenter.getAddress().get("name"));
        search.inputBusinessPhone(RandomDataCenter.getAddress().get("tel"));
        search.inputBusinessEmail(RandomDataCenter.getAddress().get("email"));
        search.scroll();
        search.selectCertType();
        search.inputIdNo("123123123");
        search.inputAddress(RandomDataCenter.getAddress().get("road"));
        search.selectCustBelong();
        search.inputUserName(RandomDataCenter.getAddress().get("email"));
        search.inputUserPass("123abc,.;");
        search.inputUserPhone(RandomDataCenter.getAddress().get("tel"));
        search.inputUserEmail(RandomDataCenter.getAddress().get("email"));
        search.setAddButton();
        Thread.sleep(3000);
        search.inputCustomerName((String) map.get("name"));
        search.clickSearchB();

        boolean result = search.isTitleBarPresent();
        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "用例执行成功了呢");
        Thread.sleep(3000);
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