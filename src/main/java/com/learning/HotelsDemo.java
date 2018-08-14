package com.learning;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsDemo {

    /*
    搜索酒店
     */
    WebDriver driver;

    //搜索酒店页面目的地输入框
    @FindBy(id = "hotel-destination")
    private WebElement hotelDestination;

    //入住时间输入框1
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

    public HotelsDemo(WebDriver driver) {
        this.driver = driver;
    }

    public void sendDestination(String data) {
        hotelDestination.sendKeys(data);
    }

    public void sendCheckin(String data) {
        hotelCheckin.sendKeys(data);
    }

    public void sendCheckout(String data) {
        hotelCheckout.sendKeys(data);
    }

    public void clickClose() {
        datepickerClose.click();
    }

    public void setSearchButton() {
        searchButton.click();
    }

    public void searchHotels(String data1, String data2, String data3) {
        sendDestination(data1);
        sendCheckin(data2);
        sendCheckout(data3);
        clickClose();
        setSearchButton();
    }
}

