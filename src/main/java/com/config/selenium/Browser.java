package com.config.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {

    private String browserName;
    private String serverURL;
    public WebDriver driver;


    public void initConfigData() throws IOException{

        Properties p = new Properties();
        // 加载配置文件
        InputStream ips = new FileInputStream("./src/main/java/com/config/selenium/config.properties");
        p.load(ips);

        browserName=p.getProperty("browserName");
        serverURL = p.getProperty("URL");
        ips.close();

    }

    public WebDriver getBrowser(){

        if(browserName.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", "./Tools/geckodriver.exe");
            driver = new FirefoxDriver();


        }else if(browserName.equalsIgnoreCase("Windows_Chrome")){

            System.setProperty("webdriver.chrome.driver", "src/main/java/Tools/chromedriver.exe");
            driver= new ChromeDriver();
            driver.get(serverURL);
            driver.manage().window().maximize();
            callWait(5);
            return driver;

        }else if(browserName.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver", "./Tools/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
        }else if (browserName.equalsIgnoreCase("Mac_Chrome"))

            System.setProperty("webdriver.chrome.driver", "./src/main/java/Tools/chromedriver");
            driver= new ChromeDriver();

        driver.get(serverURL);
        driver.manage().window().maximize();
        callWait(5);
        return driver;
    }

    /*
     * 关闭浏览器并退出方法
     */

    public void tearDown() throws InterruptedException{

        driver.quit();
        Thread.sleep(3000);
    }

    /*
     * 隐式时间等待方法
     */
    private void callWait(int time){

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }



}

