package xxb.Invoicemanagement;


//import org.apache.Log4j.xml.DOMConfigurator;

import com.config.selenium.FileChaseFW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InvoiceAddedFactoryBase {

    private static final Logger log = LogManager.getLogger(InvoiceAddedFactoryBase.class.getName());
    private WebDriver driver;

    @FindBy(id = "uid")
    private WebElement uid;

    public void setUid(String username) {
        uid.sendKeys(username);
        log.info("输入用户名: "+ username);
    }

    @FindBy(id = "pwd")
    private WebElement pwd;

    public void setPwd(String password) {
        pwd.sendKeys(password);
        log.info("输入密码: " + password);
    }

    @FindBy(xpath = "//input[@value='登录']")
    private WebElement loginBtn;

    public void setLoginBtn() {
        loginBtn.click();
        log.info("点击了登录按钮");
    }

    public void clickBtn(String username,String password) {
        setUid(username);
        setPwd(password);
        setLoginBtn();
    }



    @FindBy(linkText = "发票管理")
    private WebElement invoiceManagement;
    @FindBy(id = "search.customerName")
    private WebElement searchCustomerName;
    @FindBy(className = "ui-menu-item")
    private WebElement uimenuitem;
    @FindBy(className = "searchSelect")
    private WebElement searchSelect;
    @FindBy(linkText = "检索")
    private WebElement searchButton;

    /**
     * 鼠标悬停到发票管理Tab
     */
    public void setInvoiceManagement() {
        Actions action = new Actions(driver);

        action.moveToElement(invoiceManagement).perform();
    }

    @FindBy(xpath = "//a[@href='/jsp/contract/invoiceNew/addInvoice.jsp']")
    private WebElement getInvoiceManagement;

    /**
     * 点击悬停后的第一个按钮
     */
    public void setGetInvoiceManagement() {
        Actions action = new Actions(driver);

        action.moveToElement(getInvoiceManagement).click().perform();
    }

    /**
     * 输入客户名称
     * @param customerName
     * @throws InterruptedException
     */
    public void setSearchCustomerName(String customerName) throws InterruptedException {
        searchCustomerName.sendKeys(customerName);
        Thread.sleep(800);
        log.info("输入客户名称");
    }

    /**
     * 从下拉中选择客户
     */
    public void setUimenuitem1() {
        uimenuitem.click();
    }


    /**
     * 点击检索按钮
     *
     * @throws InterruptedException
     */
    public void setSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(800);
    }

    @FindBy(id = "secondParty")
    private WebElement secondParty;

    /**
     * 选择第一个乙方公司
     */
    public void setSecondParty() {
        Select select = new Select(secondParty);
        select.selectByIndex(1);
        log.info("选择了乙方公司");
    }
    public InvoiceAddedFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "contractNo")
    private WebElement contractNo;

    /**
     * 给出需要开发票的合同编号
     * @param contractNo1
     */
    public void setContractNo(String contractNo1) {
        contractNo.sendKeys(contractNo1);
    }

    @FindBy(className = "checkbox")
    private WebElement checkbox;

    /**
     * 点击复选框
     */
    public void setCheckbox() {
        checkbox.click();
    }

    @FindBy(id = "ToolTables_invoiceTable_0")
    private WebElement ToolTables_invoiceTable_0;

    /**
     * 点击开票按钮
     */
    public void setChickInvoice() {
        ToolTables_invoiceTable_0.click();
    }

    @FindBy(xpath = "//a[contains(text(),'本次开票明细')]")
    private WebElement BillingDetails;

    /**
     * 点击本次开票明细
     */
    public void setBillingDetails() {
        BillingDetails.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[9]")
    private WebElement InvoiceAmount;

    /**
     * 输入开票金额
     * @param totalContract
     */
    public void setInvoiceAmount(String totalContract) {
        InvoiceAmount.clear();
        InvoiceAmount.sendKeys(totalContract);
    }

    @FindBy(name = "startMonth")
    private WebElement startMonth;

    /**
     * 输入服务期开始日期
     * @param serverStartDate
     */
    public void setStartMonth(String serverStartDate) {
        startMonth.clear();
        startMonth.click();
        startMonth.sendKeys(serverStartDate);
    }

    @FindBy(name = "endMonth")
    private WebElement endMonth;

    /**
     * 输入服务期结束日
     * @param serverEndDate
     */
    public void setEndMonth(String serverEndDate) {
        endMonth.sendKeys(serverEndDate);
    }

    @FindBy(id = "invoiceType")
    private WebElement invoiceType;

    /**
     * 发票类型选择为普通发票
     */
    public void setInvoiceType() throws InterruptedException {
        Select select = new Select(invoiceType);
        select.selectByIndex(2);
        Thread.sleep(1000);
    }

    @FindBy(xpath = "//a[@id='invoiceDiv']")
    private WebElement invoiceDiv;

    /**
     * 点击提交按钮
     */
    public void setInvoiceDiv() {
        invoiceDiv.click();
    }


    /**
     * 选择data文件合同号
     */
    public String getcontractNo() {
        String[] fileArr =  FileChaseFW.readEndData("./src/main/java/com/datacenter/data.txt").split(",");
        System.out.println(fileArr[0]);
        return fileArr[0];
    }

    public String getcontractAmount() {
        String[] fileArr =  FileChaseFW.readEndData("./src/main/java/com/datacenter/data.txt").split(",");
        System.out.println(fileArr[0]);
        return fileArr[1];
    }


//    /**
//     * 合同去初审
//     */
//    void setBtnReview() throws InterruptedException {
////        Thread.sleep(3000);
//        btnReview.click();
//        Thread.sleep(2000);
//    }
//
//    /**
//     * 点击初审通过按钮
//     */
//    void setreviewBtn() throws InterruptedException {
//        reviewBtn.click();//点击初审通过按钮
//        Thread.sleep(2000);
//    }
//
//    /**
//     * 点击初审驳回按钮
//     */
//    void setReviewRejectBtn() {
//        reviewRejectBtn.click();//点击初审驳回按钮
//    }
//
//    /**
//     * 返回合同编号
//     *
//     * @return
//     */
//    String No() {
//        return getContractNo.getText();
//    }
//
//    /**
//     * 点击确认并返回按钮，该页面有合同编号
//     */
//    void setoKAndReturnButton() {
//        oKAndReturnButton.click();
//    }
//
//    /**
//     * 点击合同审核按钮
//     */
//    void setContractReviewButton() {
//        addContractReviewButton.click();
//        log.info("点击了合同审核按钮");
//    }
//
//    /**
//     * 输入客户名称
//     *
//     * @param customerName
//     * @throws InterruptedException
//     */
//    void setSearchCustomerName(String customerName) throws InterruptedException {
//        searchCustomerName.sendKeys(customerName);
//        Thread.sleep(1500);
//        log.info("输入客户名称");
//    }
//
//    /**
//     * 从下拉中选择客户
//     */
//    void setUimenuitem1() {
//        uimenuitem.click();
//    }
//
//
//    /**
//     * 点击检索按钮
//     *
//     * @throws InterruptedException
//     */
//    void setSearchButton() throws InterruptedException {
//        searchButton.click();
//        Thread.sleep(1500);
//    }
//
//
//    /**
//     * 点击审核按钮，请确保列表只有一个，如果有多个，该方法会报错
//     *
//     * @throws InterruptedException
//     */
//    void setAuditButton() throws InterruptedException {
//        auditButton.click();
//        Thread.sleep(1500);
//    }
//
//    /**
//     * 点击审核通过按钮，应该是终审通过
//     *
//     * @throws InterruptedException
//     */
//    void setReviewButtonPass() throws InterruptedException {
//        Thread.sleep(1500);
//        ReviewButtonPass.click();
//        Thread.sleep(3500);
//    }

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


//    /**
//     * 处理初审成功的弹窗
//     *
//     * @return
//     */
//    void reviewAlert() {
//        driver.switchTo().alert().accept();
//    }
//
//    public boolean isReviewSuccessfully() {
//        return No().contains("BJ");
//    }


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

