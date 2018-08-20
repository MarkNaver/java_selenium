package xxb.contract;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddContractFactoryBase {
    private static final Logger log = LogManager.getLogger(AddContractFactoryBase.class.getName());
    /**
     * 合同系统-添加合同元素仓库
     */
    private WebDriver driver;
    //输入用户名
    @FindBy(id = "uid")
    private WebElement username;
    //输入密码
    @FindBy(id = "pwd")
    private WebElement password;
    //点击登录按钮
    @FindBy(xpath = "//input[@value='登录']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),'合同新增')]")
    private WebElement addContractButton;
    //生成工单合同
    @FindBy(id = "ToolTables_tblcontract_0")
    private WebElement GenerateWorkOrder;
    @FindBy(id = "ToolTables_tblcontract_1")
    private WebElement NoGenerateWorkOrder;
    //批量删除，暂不处理
    @FindBy(id = "ToolTables_tblcontract_2")
    private WebElement batchDeletion;
    @FindBy(id = "search.customerName")
    private WebElement searchCustomerName;
    @FindBy(className = "ui-menu-item")
    private WebElement uimenuitem;
    @FindBy(name = "beginDate")
    private WebElement beginDate;
    //点击开始日期的日历框确认按钮
    @FindBy(xpath = "//button")
    private WebElement dataButton;
    @FindBy(name = "endDate")
    private WebElement endDate;
    //点击结束日期的日历框确认按钮
    @FindBy(xpath = "//div[4]//div[3]//div[1]//button[1]")
    private WebElement enddateButton;
    //乙方公司
    @FindBy(id = "secondParty")
    private WebElement secondParty;
    //付款方式
    @FindBy(name = "paymentMethod")
    private WebElement paymentMethod;
    //第一个产品名称
    @FindBy(name = "productName")
    private WebElement productName;
    @FindBy(xpath = "//li[contains(.,'北京兆维空间租用')]")
    private WebElement getUimenuitem;
    //第二个产品名称
    @FindBy(xpath = "//tr[2]/td/input")
    private WebElement productName2;
    //数量
    @FindBy(name = "qty")
    private WebElement qty;
    //单价
    @FindBy(name = "factPrice")
    private WebElement factPrice;
    //最后的新增按钮
    @FindBy(className = "btnadd btn")
    private WebElement btnaddBtn;
    @FindBy(id = "saveBtn")
    private WebElement saveBtn;
    //备注输入框
    @FindBy(xpath = "//textarea[@name='mem']")
    private WebElement mem;

    public AddContractFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    void LoginContract(String uid, String pwd) {
        //首页登录步骤集合
        username.sendKeys(uid);
        password.sendKeys(pwd);
        loginButton.click();
        log.info("输入用户名和密码并点击了登录按钮");
    }

    void setAddContractButton() {
        addContractButton.click();
        log.info("点击了合同新增按钮");
    }

    void setGenerateWorkOrder() {
        GenerateWorkOrder.click();
        log.info("点击生成工单按钮");
    }

    void setNoGenerateWorkOrder() {
        NoGenerateWorkOrder.click();
        log.info("点击不生成工单按钮");
    }

    void setSearchCustomerName(String customerName) {
        searchCustomerName.sendKeys(customerName);
        log.info("输入客户名称");
    }

    void setUimenuitem() {
        uimenuitem.click();
    }

//    @FindBy(xpath = "//ul[2]/li")
//    private WebElement uimenuitem1;

    void setBeginDate(String begindate) {
        beginDate.sendKeys(begindate);
        log.info("输入开始日期");
    }

    void setDataButton() {
        dataButton.click();
        log.info("点击开始日期的日历框确认按钮");
    }

    void setEndDate(String enddate) {
        endDate.sendKeys(enddate);
        log.info("输入结束日期");
    }

    void setEnddataButton() {
        enddateButton.click();
        log.info("点击结束日期的日历框确认按钮");
    }

    void setSecondParty() {
        Select select = new Select(secondParty);
        select.selectByIndex(1);
        log.info("选择了乙方公司");
    }

    void setPaymentMethod() {
        Select select = new Select(paymentMethod);
        select.selectByIndex(1);
        log.info("选择了季付方式");
    }

    void setProductName(String string) {
        productName.sendKeys(string);
        log.info("输入了产品名称 ->" + string);
    }

    void setUimenuitem1() {
        getUimenuitem.click();
    }

    void setProductName2(String string) {
        productName.sendKeys(string);
        log.info("输入了第二个产品名称 ->" + string);
    }

    void setQty(String string) {
        qty.sendKeys(string);
        log.info("输入了产品数量 ->" + string);
    }

    void setFactPrice(String string) {
        factPrice.sendKeys(string);
        log.info("输入了单价 ->" + string);
    }

    void setBtnaddBtn() {
        btnaddBtn.click();
    }

    void setSaveBtn() {
        saveBtn.click();
        log.info("点击了保存按钮");
    }

    //弹窗读取信息
    public String alertText() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        return alert.getText();
    }

    public boolean isSavedSuccessfully() {
        if (alertText().contains("保存成功")) {
            driver.switchTo().alert().accept();
            return true;
        }
        return false;
    }

    void setMem(String memString) {
        mem.sendKeys(memString);
        log.info("输入合同备注 ->" + memString);
    }

}
