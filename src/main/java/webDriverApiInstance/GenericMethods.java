//package webdriverapiInstance;
//
//import com.config.selenium.LOGGER;
//import com.config.selenium.LogType;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GenericMethods {
//    //findElement方法重写 并在控制台显示使用By方法查找的元素
//
//    WebDriver driver;
//
//    public GenericMethods(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public WebElement getElement(String locator, String type) {
//        type = type.toLowerCase();
////        List<WebElement> elementList = new ArrayList<WebElement>();
//        if (type.equals("id")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用id查找元素:" + locator);
//            return this.driver.findElement(By.id(locator));
//        } else if (type.equals("xpath")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用xpath查找元素:" + locator);
//            return this.driver.findElement(By.xpath(locator));
//        } else if (type.equals("css")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用css查找元素:" + locator);
//            return this.driver.findElement(By.cssSelector(locator));
//        } else if (type.equals("name")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用name查找元素:" + locator);
//            return this.driver.findElement(By.name(locator));
//        } else if (type.equals("classname")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用classname查找元素:" + locator);
//            return this.driver.findElement(By.className(locator));
//        } else if (type.equals("tagname")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用tagname查找元素" + locator);
//            return this.driver.findElement(By.tagName(locator));
//        } else if (type.equals("linktext")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用linktext查找元素" + locator);
//            return this.driver.findElement(By.linkText(locator));
//        } else if (type.equals("plinktext")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用plinktext查找元素" + locator);
//            return this.driver.findElement(By.partialLinkText(locator));
//        } else {
//            System.out.println("定位的路径不支持");
//            return null;
//        }
//    }
//
//    public List<WebElement> getElementList(String locator, String type) {
//        type = type.toLowerCase();
//        List<WebElement> elementList = new ArrayList<WebElement>();
//        if (type.equals("id")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用id查找元素:" + locator);
//            elementList = this.driver.findElements(By.id(locator));
//        } else if (type.equals("xpath")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用xpath查找元素:" + locator);
//            elementList = this.driver.findElements(By.xpath(locator));
//        } else if (type.equals("css")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用css查找元素:" + locator);
//            elementList = this.driver.findElements(By.cssSelector(locator));
//        } else if (type.equals("name")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用name查找元素:" + locator);
//            elementList = this.driver.findElements(By.name(locator));
//        } else if (type.equals("classname")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用classname查找元素:" + locator);
//            elementList = this.driver.findElements(By.className(locator));
//        } else if (type.equals("tagname")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用tagname查找元素" + locator);
//            elementList = this.driver.findElements(By.tagName(locator));
//        } else if (type.equals("linktext")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用linktext查找元素" + locator);
//            elementList = this.driver.findElements(By.linkText(locator));
//        } else if (type.equals("plinktext")) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用plinktext查找元素" + locator);
//            elementList = this.driver.findElements(By.partialLinkText(locator));
//        } else {
//            System.out.println("定位的路径不支持");
//        }
//        if (elementList.isEmpty()) {
//            LOGGER.Output(LogType.LogTypeName.INFO, "用" + type + ": |" + locator + "没有找到元素");
////            System.out.println("用" + type + ": " + locator + "没有找到元素");
//        } else {
////            System.out.println("元素用" + type +": " + locator + "找到了！");
//            LOGGER.Output(LogType.LogTypeName.INFO, "元素用" + type + ": |" + locator + "被找到了！");
//
//        }
//        return elementList;
//    }
//
//    public boolean isElenmentPresent(String locator, String type) {
//        List<WebElement> elementList = getElementList(locator, type);
//        int size = elementList.size();
//        return size > 0;
//    }
//}
