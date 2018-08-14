package pageclasses;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFactoryDemo {
//    private static final Logger log = LogManager.getLogger(LoginTest.class.getName());

    //返回日期文本框
    @FindBy(id = "flight-returning")
    public WebElement flightReturning;
    @FindBy(xpath = "//div[@class='datepicker-close']//button[@type='button']")
    public WebElement datepickerClose;
    WebDriver driver;
    //创建对象工厂
    private ExtentTest test;
    //往返 标签元素
    @FindBy(id = "tab-flight-tab")
    private WebElement tabFightTab;
    //单程 标签元素
    @FindBy(id = "flight-type-one-way-label")
    private WebElement fightTab;
    //往返 标签元素
    @FindBy(id = "flight-type-roundtrip-label")
    private
    WebElement roundTrip;
    //多个目的地 标签元素
    @FindBy(id = "flight-type-multi-dest-label")
    private WebElement multipleDestination;
    //始发地文本框 元素
    @FindBy(id = "flight-origin")
    private WebElement origin;
    //目的地文本框 元素
    @FindBy(id = "flight-destination")
    private WebElement destination;
    //出发日期文本框
    @FindBy(id = "flight-departing")
    private WebElement departure;
    //搜索按钮 元素
    @FindBy(css = "#search-button")
    private WebElement searchButton;


    public SearchPageFactoryDemo(WebDriver driver) {
        //构造函数，初始化所有PageFactory供用例使用
        this.driver = driver;
        //        PageFactory.initElements(driver,this);
    }

    //点击机票大Tab标签
    public void clicTabfightTab() {
        tabFightTab.click();
//        log.info("点击机票大Tab标签");

    }


    //点击单程标签
    public void clickFightTab() {
        fightTab.click();
//        log.info("点击了单程标签,我在元素工厂中");

    }

    //点击往返标签
    public void clickRoundTrip() {
        roundTrip.click();
    }

    //点击多个目的地标签
    public void clickMultipleDestination() {
        multipleDestination.click();
    }

    //出发地输入
    public void setFlightOrigin(String originCity) {
        origin.sendKeys(originCity);
//        test.log(LogStatus.INFO,"输入了出发地");
    }

    //目的地输入
    public void setDestination(String destinationCity) {
        destination.sendKeys(destinationCity);
    }

    //出发时间输入
    public void setDepartureDate(String departureDate) {
        departure.sendKeys(departureDate);
    }

    //关闭文本框的元素，必须的，不然会挡住搜索按钮
    public void clickDatepickerClose() {
        datepickerClose.click();
    }

    //搜索按钮点击
    public void clickSearchButton() {
        searchButton.click();
//        test.log(LogStatus.INFO,"点击了搜索按钮,我在元素工厂中");

    }

    //判断是否找到了titleBar元素来判断case是否成功
    public boolean isTitleBarPresent() {
        WebElement titleBar;
        try {
            titleBar = driver.findElement(By.id("titleBar"));
            if (titleBar != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    //步骤集合
    public void searchPage1(String flightOrigin, String flightDestination, String flightDeparting) {
        clicTabfightTab();
        clickFightTab();
        setFlightOrigin(flightOrigin);
        setDestination(flightDestination);
        setDepartureDate(flightDeparting);
//        clickFightTab();//注意！必须调用，否则上一步元素弹窗挡住了下一步的元素导致case失败
        clickDatepickerClose();//直接点击弹窗的关闭按钮，与上面一条二选一
        clickSearchButton();
    }

}
