package NewPaaS;

import com.common.BrowserEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageclasses.ExtentFactory;
import webDriverApiInstance.ScreenshotsDemo;

//import org.apache.logging.log4j.LogManager;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午12:27 2018/9/30
 * @Modified By:
 */
public class PaaSTest extends BrowserEngine{
    private static final Logger log = LogManager.getLogger(PaaSTest.class.getName());
    private PaaSBaseFactoryBase search;
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        search = PageFactory.initElements(driver, PaaSBaseFactoryBase.class);
        reports = ExtentFactory.GetInstance(PaaSTest.class.getSimpleName());
        test = reports.startTest("PaaSTest --> PaaS");
        System.out.println("setUp");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("tearDown");
    }



    @Parameters({"gicUrl","PaaSDBUrl","txtUserName","txtUserPwd"})
    @Test(description = "GIC登录")
    public void setTestPaaS(String gicUrl,String PaaSDBUrl,String txtUserName,String txtUserPwd) throws Exception {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
        log.info("打开了首页");
        search.setLogin(txtUserName,txtUserPwd);
        driver.get(PaaSDBUrl);
        driver.switchTo().frame(driver.findElement(By.id("frame_content")));
        Thread.sleep(4444);
        search.setCreateDBInstances();
////        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');");
////        js.executeScript()
        search.setSubscribeConnectServiceBtn();
        search.setConnectorSelectVdcBtn();
        search.setSelectVdcListBtnBeijingC();
        search.setPrivateNetwork1();
//        search.setInstanceName();
        search.setCreateBtn();
        Thread.sleep(333);
        assert search.setCreatingStatus().equals("创建中");

//        assert search.setDelStatus().equals("删除中");
        System.out.println(search.getBtnOneText()+123);

//        System.out.println(search.getBtnTwoText());
//        assert search.getBtnOneText().contains("PhpMyAdmin");
//        assert search.getBtnTwoText().contains("LC");
//        int result1 = search.getBtnOneText().indexOf("QPn");
//        System.out.println(result1);
//        if (result1 != -1) {
//            System.out.println("成功");
//
//        } else {
//            System.out.println("失败");
//        }
//        Actions actions = new Actions(driver);
//        actions.moveToElement(search.perform_more()).perform();
////        search.setMoreBtnBase();
//        System.out.println(search.perform_more().getText());
        Thread.sleep(33333);

    }


    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Thread.sleep(1222);
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotsDemo.takeScreenshots(driver,result.getName());
            String imgPath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "执行失败了", imgPath);
            test.log(LogStatus.FAIL,result.getThrowable());
        }
    }
}
