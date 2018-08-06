package com.contract;

import com.config.selenium.Browser;
import com.config.selenium.LOGGER;
import com.config.selenium.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Case_Login {
    public String username;
    public String password;
    public WebDriver driver;

    public void prepare(){
        //打开浏览器
        Browser browser=new Browser();
            try {
                browser.initConfigData();
                driver=browser.getBrowser();
            } catch (IOException e) {
                System.out.println( "读取浏览器信息失败！ " );
                e.printStackTrace();
            }

    }

    public void getUsernameAndPassword(){
        //读取用户名密码
        Properties p = new Properties();
        InputStream ips = null;
        try {
            ips = new FileInputStream("./src/main/java/com/config/selenium/config.properties");
            p.load(ips);

            username=p.getProperty("username");
            password = p.getProperty("password");
            LOGGER.Output(LogType.LogTypeName.INFO, "从配置文件中获取登录名："+ username+"，密码："+password);
        } catch (FileNotFoundException e) {
            System.out.println("未找到配置文件，读取用户名密码失败！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取用户名密码失败！");
            e.printStackTrace();
        }


    }
    public void runCase(){
        prepare();
        getUsernameAndPassword();
        driver.findElement(By.id("uid")).sendKeys(username);
        driver.findElement(By.id("pwd")).sendKeys(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@value='登录']")).click();
        LOGGER.Output(LogType.LogTypeName.INFO, "登录合同系统");

    }


}