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

public class ReviewContractCase extends TestSuiteBaseDemo {
    public static final Logger log = LogManager.getLogger(ReviewContractCase.class.getName());
    private ReviewContractFactoryBase search;
    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;


    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        search = PageFactory.initElements(driver, ReviewContractFactoryBase.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("ReviewContractCase -> 合同提审");

    }

    @Test
    public void AddCustomer() throws InterruptedException {
        Map map = RandomDataCenter.getAddress();
        search.setAddContractButton();
        search.setSearchCustomerName("奥巴马123");
        Thread.sleep(1200);
        search.setUimenuitem1();
        search.setSearchSelect();
        search.setSearchButton();
        search.sorting_desc1();
        search.setEdit();
        //切换到新浏览器窗口
        search.switchWindowsHandle();

        search.reviewButton();
        Thread.sleep(1300);
        boolean result = search.isReviewSuccessfully();
        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "用例执行成功");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        //失败截图，并存入报告
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "执行失败了", imagePath);
//            driver.quit();

        }
        reports.endTest(test);
        reports.flush();
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

}
