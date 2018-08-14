package com.learning;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestFramework extends TestSuiteBaseDemo {

    @BeforeClass
    public void beforeClass() {
        search = PageFactory.initElements(driver, SearchPageFactoryDemoT.class);
    }

    @Test
    public void searchFlights() {
        search.clickTab();
//        Thread.sleep(3000);
        search.clickFightTab();
        search.setOriginCity("北京, 中国 (PEK-首都国际机场)");
        search.setDestinationCity("上海, 中国 (SHA-虹桥国际机场)");
        search.setDeaprtureDate("2018/09/29");
        search.clickCalendar();
        search.clickSearchButton();


    }

    @AfterClass
    public void tearDown() {
    }
}