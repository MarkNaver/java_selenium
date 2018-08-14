package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
    WebDriver driver;

    public WaitTypes(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement waitForElement(By locator, int timeout) {
        //显式等待 等待元素后返回该元素
        WebElement element = null;
        try {
            System.out.println("最长等待" + timeout + "秒元素可用");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("元素再页面上出现了");
        } catch (Exception e) {
            System.out.println("元素没有出现");
        }
        return element;
    }

    public void clickWhenReady(By locator, int timeout) {
        //显式等待 当元素准备就绪可点击状态时去点击
        try {
            WebElement element = null;
            System.out.println("最长等待" + timeout + "秒元素可点击");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("在页面上点击了元素");
        } catch (Exception e) {
            System.out.println("元素没有出现");
        }
    }
}
