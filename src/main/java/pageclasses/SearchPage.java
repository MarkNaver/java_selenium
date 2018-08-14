package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    public static WebElement element = null;

    /*
     *机票标签元素
     * @param driver
     * @return
     */
    public static WebElement tabFlightTab(WebDriver driver) {
        element = driver.findElement(By.id("tab-flight-tab"));
        return element;
    }

    /*
     *点击机票标签按钮
     * @param driver
     * @return
     */
    public static void clickTabFlightTab(WebDriver driver) {
        element = tabFlightTab(driver);
        element.click();
    }


    /*
     *始发地元素
     * @param driver
     * @return
     */
    public static WebElement originTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-origin"));
        return element;
    }

    public static void sendKeysOriginTextBox(WebDriver driver, String origin) {
        element = originTextBox(driver);
        element.sendKeys(origin);
    }


    /*
     *目的地元素
     * @param driver
     * @return
     */
    public static WebElement destinationTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-destination"));
        return element;
    }

    public static void sendDestinationTextBox(WebDriver driver, String destination) {
        element = destinationTextBox(driver);
        element.sendKeys(destination);
    }

    /*
     *出发日期元素
     * @param driver
     * @return
     */
    public static WebElement departureDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-departing"));
        return element;
    }

    public static void sendDepartureDateTextBox(WebDriver driver, String departureDate) {
        element = departureDateTextBox(driver);
        element.clear();
        element.sendKeys(departureDate);
    }

    /*
     *返程日期元素
     * @param driver
     * @return
     */
    public static WebElement returnTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-returning"));
        return element;
    }

    public static void sendReturnTextBox(WebDriver driver, String returnDate) {
        element = returnTextBox(driver);
        element.clear();
        element.sendKeys(returnDate);
    }

    /*
     *搜索按钮元素
     * @param driver
     * @return
     */
    public static WebElement searchButton(WebDriver driver) {
        element = driver.findElement(By.id("search-button"));
        return element;
    }

    /*
     *点击搜索按钮
     * @param driver
     * @return
     */
    public static void clickSearchButton(WebDriver driver) {
        element = searchButton(driver);
        element.click();
    }
}
