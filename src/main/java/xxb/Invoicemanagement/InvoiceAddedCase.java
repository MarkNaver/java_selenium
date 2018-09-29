package xxb.Invoicemanagement;


//import com.datacenter.GetData;
import com.common.BrowserEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageclasses.ExtentFactory;
import webDriverApiInstance.ScreenshotsDemo;


public class InvoiceAddedCase extends BrowserEngine {
    public static final Logger log = LogManager.getLogger(InvoiceAddedCase.class.getName());
    private InvoiceAddedFactoryBase search;
    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;
//    private FileChaseFW fie;


    @BeforeClass
    public void beforeClass() {

        //每个测试类都需要初始化对象仓库
        search = PageFactory.initElements(driver, InvoiceAddedFactoryBase.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance(InvoiceAddedCase.class.getSimpleName());
        //报告的名称
        test = reports.startTest("InvoiceAddedCase -> 发票添加");

    }
    @Parameters({"username", "password"})
    @Test(description = "测试合同系统")
    public void testInvoiceAddedCase(String username,String password) throws InterruptedException {
        search.clickBtn(username,password);
        search.setInvoiceManagement();
        search.setGetInvoiceManagement();
        search.setSearchCustomerName("奥巴马123");
        search.setUimenuitem1();
        search.setSecondParty();
//        search.setContractNo(search.getcontractNo());
        search.setSearchButton();
        search.setCheckbox();
        search.setChickInvoice();
        search.setBillingDetails();
//        search.setInvoiceAmount(search.getcontractAmount());
//        search.setStartMonth(GetData.serverData());
//        search.setEndMonth(GetData.serverData());
//        Thread.sleep(100000);
        search.setInvoiceType();
        Thread.sleep(30000);
        search.setInvoiceDiv();
        Thread.sleep(10000);

    }




    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        //失败截图，并存入报告
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "执行失败了", imagePath);
//            test.log(LogStatus.FATAL,result.getThrowable()); //详细的错误信息


        }
        reports.endTest(test);
        reports.flush();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
