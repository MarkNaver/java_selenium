package com.config.selenium;

import org.openqa.selenium.WebDriver;

public class Browser {
    public static WebDriver driver;
    public static String pageTitle;
    public static String pageUrl;

    protected Browser(WebDriver driver) {
        Browser.driver = driver;//构造方法，实例化一个浏览器
    }

    public static void main(String[] args) {

    }
}
