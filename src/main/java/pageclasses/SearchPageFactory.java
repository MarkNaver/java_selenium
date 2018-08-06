package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
    //创建对象工厂

    WebDriver driver;
    //往返 标签元素
    @FindBy(id = "tab-flight-tab")
    private WebElement tabFightTab;

    //单程 标签元素
    @FindBy(id = "flight-type-one-way-label")
    private WebElement fightTab;

    //往返 标签元素
    @FindBy(id = "flight-type-roundtrip-label")
    WebElement roundTrip;

    //多个目的地 标签元素
    @FindBy(id = "flight-type-multi-dest-label")
    WebElement multipleDestination;


    //始发地文本框 元素
    @FindBy(id = "flight-origin")
    WebElement origin;


    //目的地文本框 元素
    @FindBy(id = "flight-destination")
    WebElement destination;


    //出发日期文本框
    @FindBy(id = "flight-departing")
    WebElement departure;

    //返回日期文本框
    @FindBy(id = "flight-returning")
    WebElement flightReturning;

    //搜索按钮 元素
    @FindBy(css = "#search-button")
    WebElement searchButton;

    public SearchPageFactory(WebDriver driver) {
        //构造函数，初始化所有PageFactory供用例使用
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //点击机票大Tab标签
    public void clicTabfightTab() {
        tabFightTab.click();
    }


    //点击单程标签
    public void clickFightTab() {
        fightTab.click();
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
    }

    //目的地输入
    public void setDestination(String destinationCity) {
        destination.sendKeys(destinationCity);
    }

    //出发时间输入
    public void setDepartureDate(String departureDate) {
        departure.sendKeys(departureDate);
    }

    //搜索按钮点击
    public void clickSearchButton() {
        searchButton.click();
    }

}
