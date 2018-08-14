package com.learning;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumHotelCase extends TestSuiteBaseDemo {
    private HotelsFactoryDemo hotelsFactoryDemo;


    @BeforeClass
    public void beforeClass() {
        //每个测试类都需要初始化对象仓库
        hotelsFactoryDemo = PageFactory.initElements(driver, HotelsFactoryDemo.class);

    }

    @Test
    public void searchFlights() throws InterruptedException {
//        hotelsFactoryDemo.searchHotels("东京, 日本 (TYO-所有机场)","2018/09/24","2018/10/24");
        hotelsFactoryDemo.clickHotel();
        hotelsFactoryDemo.sendDestination("东京, 日本 (TYO-所有机场)");
        hotelsFactoryDemo.sendCheckin("2018/09/24");
        hotelsFactoryDemo.sendCheckout("2018/10/24");
//        clickClose();
        hotelsFactoryDemo.setSearchButton();

        Thread.sleep(13333);
    }

    @AfterClass
    public void tearDown() {
    }
}