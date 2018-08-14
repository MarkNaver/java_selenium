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

    public String browserName;
    public String serverURL;
    public WebDriver driver;

    public void initConfigData() throws IOException{

        Properties p = new Properties();
        // 加载配置文件
        InputStream ips = new FileInputStream("./src/main/java/com/config/selenium/config.properties");
        p.load(ips);

        LOGGER.Output(LogType.LogTypeName.INFO, "开始从属性文件中选择浏览器名称");
        browserName=p.getProperty("browserName");
        LOGGER.Output(LogType.LogTypeName.INFO, "选择的浏览器类型是: "+ browserName);
        serverURL = p.getProperty("URL");
        LOGGER.Output(LogType.LogTypeName.INFO, "测试地址URL为: "+ serverURL);
        ips.close();

    }

    public WebDriver getBrowser(){

        if(browserName.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", "./Tools/geckodriver.exe");
            driver = new FirefoxDriver();

            LOGGER.Output(LogType.LogTypeName.INFO, "Launching Firefox ...");

        }else if(browserName.equalsIgnoreCase("Windows_Chrome")){

            System.setProperty("webdriver.chrome.driver", "src/main/java/Tools/chromedriver.exe");
            driver= new ChromeDriver();
            LOGGER.Output(LogType.LogTypeName.INFO, "启动Chrome浏览器 ...");
            driver.get(serverURL);
            LOGGER.Output(LogType.LogTypeName.INFO, "Open URL: "+ serverURL);
            driver.manage().window().maximize();
            LOGGER.Output(LogType.LogTypeName.INFO, "最大化浏览器...");
            callWait(5);
            return driver;

        }else if(browserName.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver", "./Tools/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            LOGGER.Output(LogType.LogTypeName.INFO, "启动 IE浏览器 ...");
        }else if (browserName.equalsIgnoreCase("Mac_Chrome"))

            System.setProperty("webdriver.chrome.driver", "./src/main/java/Tools/chromedriver");
            driver= new ChromeDriver();
            LOGGER.Output(LogType.LogTypeName.INFO, "启动Chrome浏览器 ...");

        driver.get(serverURL);
        LOGGER.Output(LogType.LogTypeName.INFO, "Open URL: "+ serverURL);
        driver.manage().window().maximize();
        LOGGER.Output(LogType.LogTypeName.INFO, "最大化浏览器...");
        callWait(5);
        return driver;
    }

    /*
     * 关闭浏览器并退出方法
     */

    public void tearDown() throws InterruptedException{

        LOGGER.Output(LogType.LogTypeName.INFO, "浏览器关闭中...");
        driver.quit();
        Thread.sleep(3000);
    }

    /*
     * 隐式时间等待方法
     */
    public void callWait(int time){

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        LOGGER.Output(LogType.LogTypeName.INFO, "Wait for "+time+" seconds.");
    }



}

