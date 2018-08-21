package xxb.contract;

import com.config.selenium.FileChaseFW;
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

public class ReviewPassContractCase extends TestSuiteBaseDemo {
    public static final Logger log = LogManager.getLogger(ReviewPassContractCase.class.getName());
    private ReviewPassContractFactoryBase search;
    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;
//    private FileChaseFW fie;


    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        search = PageFactory.initElements(driver, ReviewPassContractFactoryBase.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("ReviewPassContractCase -> 审核合同");

    }

    @Test
    public void AddCustomer() throws InterruptedException {
        search.setContractReviewButton();
        search.setSearchCustomerName("奥巴马123");
        search.setUimenuitem1();
        search.setSearchButton();
        search.setBtnReview();
        search.switchTwoWindowsHandle();
        search.setreviewBtn();
        search.reviewAlert();
        search.switchOneWindowsHandle();

        //终审阶段，待续
        search.setSearchCustomerName("奥巴马123");
        search.setUimenuitem1();
        search.setSearchButton();
        search.setAuditButton();
        search.switchTwoWindowsHandle();

        search.setReviewButtonPass();

        FileChaseFW.fileChase("./src/main/java/com/dataCenter/data.txt", search.No());
        boolean result = search.isReviewSuccessfully();
        Assert.assertTrue(result);
        search.setoKAndReturnButton();
        test.log(LogStatus.PASS, "用例执行成功");
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
        driver.quit();
    }

}
