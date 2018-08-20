package xxb.contract;


//import org.apache.log4j.xml.DOMConfigurator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReviewPassContractFactoryBase {

    private static final Logger log = LogManager.getLogger(ReviewPassContractFactoryBase.class.getName());
    //获取合同编号
    @FindBy(id = "getContractNo")
    public static WebElement getContractNo;
    private WebDriver driver;
    /**
     * 合同系统-审核合同
     */
    @FindBy(xpath = "//a[contains(text(),'合同审核')]")
    private WebElement addContractReviewButton;
    @FindBy(id = "search.customerName")
    private WebElement searchCustomerName;
    @FindBy(className = "ui-menu-item")
    private WebElement uimenuitem;
    @FindBy(className = "searchSelect")
    private WebElement searchSelect;
    @FindBy(linkText = "检索")
    private WebElement searchButton;
    //审核按钮
    @FindBy(xpath = "//tbody[@role='alert']//a[@class='btnedit']")
    private WebElement auditButton;
    //初审按钮
    @FindBy(xpath = "//tbody[@role='alert']//a[@class='btnreview']")
    private WebElement btnReview;
    //点击审核通过按钮按钮
    @FindBy(id = "confirmBtn")
    private WebElement ReviewButtonPass;
    //初审通过按钮
    @FindBy(id = "reviewBtn")
    private WebElement reviewBtn;
    //初审驳回按钮
    @FindBy(id = "reviewRejectBtn")
    private WebElement reviewRejectBtn;
    /**
     * 合同编号保存为静态变量
     */
//    public static String contractNo = No();

    //确认并返回按钮
    @FindBy(xpath = "//a[contains(.,'确定并返回')]")
    private WebElement oKAndReturnButton;

    public ReviewPassContractFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 合同去初审
     */
    void setBtnReview() throws InterruptedException {
//        Thread.sleep(3000);
        btnReview.click();
        Thread.sleep(2000);
    }

    /**
     * 点击初审通过按钮
     */
    void setreviewBtn() throws InterruptedException {
        reviewBtn.click();//点击初审通过按钮
        Thread.sleep(2000);
    }

    /**
     * 点击初审驳回按钮
     */
    void setReviewRejectBtn() {
        reviewRejectBtn.click();//点击初审驳回按钮
    }

    /**
     * 返回合同编号
     *
     * @return
     */
    String No() {
        return getContractNo.getText();
    }

    /**
     * 点击确认并返回按钮，该页面有合同编号
     */
    void setoKAndReturnButton() {
        oKAndReturnButton.click();
    }

    /**
     * 点击合同审核按钮
     */
    void setContractReviewButton() {
        addContractReviewButton.click();
        log.info("点击了合同审核按钮");
    }

    /**
     * 输入客户名称
     *
     * @param customerName
     * @throws InterruptedException
     */
    void setSearchCustomerName(String customerName) throws InterruptedException {
        searchCustomerName.sendKeys(customerName);
        Thread.sleep(1500);
        log.info("输入客户名称");
    }

    /**
     * 从下拉中选择客户
     */
    void setUimenuitem1() {
        uimenuitem.click();
    }


    /**
     * 点击检索按钮
     *
     * @throws InterruptedException
     */
    void setSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(1500);
    }


    /**
     * 点击审核按钮，请确保列表只有一个，如果有多个，该方法会报错
     *
     * @throws InterruptedException
     */
    void setAuditButton() throws InterruptedException {
        auditButton.click();
        Thread.sleep(1500);
    }

    /**
     * 点击审核通过按钮，应该是终审通过
     *
     * @throws InterruptedException
     */
    void setReviewButtonPass() throws InterruptedException {
        Thread.sleep(1500);
        ReviewButtonPass.click();
        Thread.sleep(3500);
    }

    /**
     * 切换到第二个窗口
     */
    void switchTwoWindowsHandle() {
        Set<String> parentHandles = driver.getWindowHandles();
        List<String> it = new ArrayList<String>(parentHandles);
        driver.switchTo().window(it.get(1));

    }

    /**
     * 切换到第一个窗口
     */
    void switchOneWindowsHandle() {
        Set<String> parentHandles = driver.getWindowHandles();
        List<String> it = new ArrayList<String>(parentHandles);
        driver.switchTo().window(it.get(0));

    }


    /**
     * 处理初审成功的弹窗
     *
     * @return
     */
    void reviewAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean isReviewSuccessfully() {
        return No().contains("BJ");
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

