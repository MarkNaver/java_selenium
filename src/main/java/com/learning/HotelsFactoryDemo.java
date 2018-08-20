package com.learning;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsFactoryDemo {
    private static final Logger log = LogManager.getLogger(HotelsFactoryDemo.class.getName());

    /*
    搜索酒店
     */
    private WebDriver driver;

    //打开首页需点击酒店tab
    @FindBy(id = "primary-header-hotel")
    private WebElement primaryHeaderHotel;

    //搜索酒店页面目的地输入框
    @FindBy(id = "hotel-destination")
    private WebElement hotelDestination;

    //入住时间输入框
    @FindBy(id = "hotel-checkin")
    private WebElement hotelCheckin;

    //退房时间输入框
    @FindBy(id = "hotel-checkout")
    private WebElement hotelCheckout;

    //输入时间后的弹窗
    @FindBy(xpath = "//div[@class='datepicker-close']//button[@type='button']")
    private WebElement datepickerClose;

    //搜索按钮
    @FindBy(id = "search-button")
    private WebElement searchButton;

    //搜索酒店文字
    @FindBy(xpath = "//h1[@class='col wizard-title']")
    private WebElement wizardTitle;

    public HotelsFactoryDemo(WebDriver driver) {
        this.driver = driver;
    }


    void sendDestination(String data) {
        hotelDestination.sendKeys(data);
        log.info("输入了目的地");
    }

    void clickWizardTitle() {
        wizardTitle.click();
        log.info("输入目的地后切换一下焦点");
    }

    void clickHotel() {
        primaryHeaderHotel.click();
    }

    void sendCheckin(String data) {
        hotelCheckin.sendKeys(data);
        log.info("输入入住日期");
    }

    void sendCheckout(String data) {
        hotelCheckout.sendKeys(data);
        log.info("输入离开日期");

    }

    public boolean isTitleBarPresent() {
        WebElement titleBar;
        try {
            titleBar = driver.findElement(By.xpath("//h3[contains(text(),'排序方式：')]"));
            if (titleBar != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void clickClose() {
        datepickerClose.click();
    }

    void setSearchButton() {
        searchButton.click();
        log.info("点击了搜索按钮");

    }

    public void searchHotels(String data1, String data2, String data3) {
        clickHotel();
        sendDestination(data1);
        sendCheckin(data2);
        sendCheckout(data3);
//        clickClose();
        setSearchButton();
    }
}

