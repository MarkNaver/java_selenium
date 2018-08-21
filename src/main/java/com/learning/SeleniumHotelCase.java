package com.learning;

import webDriverApiInstance.ScreenshotsDemo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.ExtentFactory;

public class SeleniumHotelCase extends TestSuiteBaseDemo {
    private HotelsFactoryDemo hotelsFactoryDemo;

    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;


    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        hotelsFactoryDemo = PageFactory.initElements(driver, HotelsFactoryDemo.class);

        //高级测试报告
        reports = ExtentFactory.GetInstance();
        //报告的名称
        test = reports.startTest("SeleniumHotelCase -> 查找酒店");

    }

    @Test
    public void searchFlights() {
//        hotelsFactoryDemo.searchHotels("东京, 日本 (TYO-所有机场)","2018/09/24","2018/10/24");
        hotelsFactoryDemo.clickHotel();
        test.log(LogStatus.INFO, "点击了酒店按钮");

        hotelsFactoryDemo.sendDestination("东京, 日本 (TYO-所有机场)");
        test.log(LogStatus.INFO, "输入了目的地");

        hotelsFactoryDemo.clickWizardTitle();
        test.log(LogStatus.INFO, "输入目的地后切换焦点，避免元素遮挡");


        hotelsFactoryDemo.clickWizardTitle();
        test.log(LogStatus.INFO, "点击了搜索酒店文字");

        hotelsFactoryDemo.sendCheckin("2018/09/24");
        test.log(LogStatus.INFO, "输入了入住日期");

        hotelsFactoryDemo.sendCheckout("2018/10/04");
        test.log(LogStatus.INFO, "输入了离店时间");

//        clickClose();
        hotelsFactoryDemo.setSearchButton();
        test.log(LogStatus.INFO, "点击了搜索按钮");

        boolean result = hotelsFactoryDemo.isTitleBarPresent();
        Assert.assertTrue(result);
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

        }
        reports.endTest(test);
        reports.flush();
    }
    @AfterClass
    public void tearDown() {

    }
}