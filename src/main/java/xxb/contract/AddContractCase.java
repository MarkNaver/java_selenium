//package xxb.contract;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.learning.TestSuiteBaseDemo;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pageclasses.ExtentFactory;
//
//import java.util.Map;
//
//import com.datacenter.GetData;
//import webDriverApiInstance.ScreenshotsDemo;
//
//
//public class AddContractCase extends TestSuiteBaseDemo {
//    public static final Logger log = LogManager.getLogger(AddContractCase.class.getName());
//    private AddContractFactoryBase search;
//    //高级测试报告
//    private ExtentReports reports;
//    private ExtentTest test;
//
//
//    @BeforeClass
//    public void beforeClass() {
//        //每个测试类都需要初始化对象仓库
//        search = PageFactory.initElements(driver, AddContractFactoryBase.class);
//
//        //高级测试报告
//        reports = ExtentFactory.GetInstance(AddContractCase.class.getSimpleName());
//        //报告的名称
//        test = reports.startTest("AddContractCase -> 添加合同");
//
//    }
//
//    @Test
//    public void testAddContractCase() throws InterruptedException {
//        Map map = RandomDataCenter.getAddress();
////        search.LoginContract("adminceshi", "123abc,.;");
//        search.setAddContractButton();
//        search.setNoGenerateWorkOrder();
//        search.setSearchCustomerName("奥巴马123");
//        Thread.sleep(1200);
//        search.setUimenuitem();
//        search.setBeginDate(GetData.getCurrentData());
//        search.setDataButton();
//        search.setEndDate("2018-08-28");
//        search.setEnddataButton();
//        search.setSecondParty();
//        search.setPaymentMethod();
//
//        //输入备注
//        search.setMem("selenium test");
//        search.setProductName("北京兆维空间租用1U");
//        Thread.sleep(1200);
//        search.setUimenuitem1();
//        search.setQty("2");
//        search.setFactPrice("444");
//        search.setSaveBtn();
//        Thread.sleep(2000);
//
//        boolean result = search.isSavedSuccessfully();
//        Assert.assertTrue(result);
//        test.log(LogStatus.PASS, "用例执行成功");
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) throws Exception {
//        Thread.sleep(1222);
//        //失败截图，并存入报告
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
//            String imagePath = test.addScreenCapture(path);
//            test.log(LogStatus.FAIL, "执行失败了", imagePath);
////            test.log(LogStatus.FATAL,result.getThrowable());
//
//        }
//        reports.endTest(test);
//        reports.flush();
//    }
//
//    @AfterClass
//    public void tearDown() {
//
//    }
//
//}
