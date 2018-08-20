package xxb.contract;


//import org.apache.log4j.xml.DOMConfigurator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReviewContractFactoryBase {

    private static final Logger log = LogManager.getLogger(ReviewContractFactoryBase.class.getName());

    /**
     * 合同系统-审核合同
     */
    @FindBy(xpath = "//a[contains(text(),'合同新增')]")
    private WebElement addContractButton;
    private WebDriver driver;
    @FindBy(id = "search.customerName")
    private WebElement searchCustomerName;
    @FindBy(className = "ui-menu-item")
    private WebElement uimenuitem;
    @FindBy(className = "searchSelect")
    private WebElement searchSelect;
    @FindBy(linkText = "检索")
    private WebElement searchButton;
    //筛选开始日期，点击2次倒叙
    @FindBy(xpath = "//th[@class='sorting'][contains(text(),'创建时间')]")
//    @FindBy(xpath = "//th[contains(.,'开始日期')]")
    private WebElement sorting_1;
    @FindBy(className = "sorting_asc")
    private WebElement sorting_asc;
    //点击编辑合同按钮
    @FindBy(xpath = "//td[2]/div/a")
    private WebElement edit;
    //点击提审按钮
    @FindBy(xpath = "//div[@class='form-actions']//a[2]")
    private WebElement Review;

    public ReviewContractFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    void setAddContractButton() {
        addContractButton.click();
        log.info("点击了合同新增按钮");
    }

    void setSearchCustomerName(String customerName) {
        searchCustomerName.sendKeys(customerName);
        log.info("输入客户名称");
    }

    void setUimenuitem1() {
        uimenuitem.click();
    }

    void setSearchSelect() {
        Select select = new Select(searchSelect);
        select.selectByIndex(1);//选择了草稿合同
        log.info("选择了草稿合同");
    }

    void setSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);
    }

    void sorting_desc1() throws InterruptedException {
        sorting_1.click();
        Thread.sleep(1000);
        sorting_asc.click();
    }

    void setEdit() throws InterruptedException {
        edit.click();
        Thread.sleep(3000);
    }

    void switchWindowsHandle() {
        Set<String> parentHandles = driver.getWindowHandles();
        List<String> it = new ArrayList<String>(parentHandles);
        driver.switchTo().window(it.get(1));

    }

    void reviewButton() throws InterruptedException {
        Thread.sleep(3000);
        Review.click();
    }

    //弹窗读取信息
    public String alertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public boolean isReviewSuccessfully() {
        if (alertText().contains("提审成功")) {
            driver.switchTo().alert().accept();
            return true;
        } else {
            driver.switchTo().alert().accept();
        }
        return false;
    }


//    public void clickClose() {
//        datepickerClose.click();
//    }

//    void setSearchButton() {
//        searchButton.click();
//    }

//    public void searchHotels(String data1, String data2, String data3) {
//        clickHotel();
//        sendDestination(data1);
//        sendCheckin(data2);
//        sendCheckout(data3);
////        clickClose();
//        setSearchButton();
//    }
}

