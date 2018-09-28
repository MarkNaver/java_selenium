package com.learning;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestFramework extends BrowserEngine {
    protected SearchPageFactoryDemoT search;
    //高级测试报告
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void beforeClass() {
//        //每个测试类都需要初始化对象仓库
//        search = PageFactory.initElements(driver, SearchPageFactoryDemoT.class);
//        //高级测试报告
//        reports = ExtentFactory.GetInstance(SeleniumTestFramework.class.getSimpleName());
//        //报告的名称
//        test = reports.startTest("SeleniumTestFramework -> 查找机票");
    }

    @Test
    public void searchFlights() {
//        search.clickTab();
//        test.log(LogStatus.INFO, "点击了机票按钮");
//
//        search.clickFightTab();
//        test.log(LogStatus.INFO, "点击了单程按钮");
//
//        search.setOriginCity("北京, 中国 (PEK-首都国际机场)");
//        test.log(LogStatus.INFO, "输入出发地");
//
//        search.setDestinationCity("上海, 中国 (SHA-虹桥国际机场)");
//        test.log(LogStatus.INFO, "输入目的地");
//
//        search.setDeaprtureDate("2018/09/29");
//        test.log(LogStatus.INFO, "输入出发时间");
//
//        search.clickCalendar();
//        test.log(LogStatus.INFO, "关闭弹窗");
//
//        search.clickSearchButton();
//        test.log(LogStatus.INFO, "点击搜索按钮");

    }

//    @AfterMethod
//    public void tearDown(ITestResult result) throws Exception {
//        Thread.sleep(1222);
//        //失败截图，并存入报告
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String path = ScreenshotsDemo.takeScreenshots(driver, result.getName());
//            String imagePath = test.addScreenCapture(path);
//            test.log(LogStatus.FAIL, "执行失败了", imagePath);
//
//        }
//        reports.endTest(test);
//        reports.flush();
//    }


    @AfterClass
    public void tearDown() {
    }
}