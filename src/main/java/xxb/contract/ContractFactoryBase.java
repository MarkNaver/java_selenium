package xxb.contract;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContractFactoryBase {
    //    private static final Logger log = LogManager.getLogger(ContractFactoryBase.class.getName());
    public static final Logger log = LogManager.getLogger(ContractFactoryBase.class.getName());

    /*
    合同系统元素工厂
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
    //客户管理
    @FindBy(xpath = "//a[@class='enable'][contains(text(),'客户管理')]")
    private WebElement customer;
    //新增客户
    @FindBy(id = "ToolTables_tblcontract_0")
    private WebElement newCustomer;
    //新增客户弹窗-客户名称
    @FindBy(id = "subCustomerName")
    private WebElement subCustomerName;
    //弹窗滚动
    @FindBy(id = "addCustomerFrom")
    private WebElement addCustomerFrom;
    @FindBy(id = "sale_no")
    private WebElement sale_no;
    //行业下拉
    @FindBy(id = "qualityIndustry")
    private WebElement qualityIndustry;
    //注册地国家
    @FindBy(id = "province_state")
    private WebElement provinceState;
    //注册地省份
    @FindBy(id = "province_uid")
    private WebElement provinceUid;
    //主联系人姓名
    @FindBy(id = "contactName")
    private WebElement contactName;
    //主联系人电话
    @FindBy(id = "contactPhone")
    private WebElement contactPhone;
    //主联系人Email
    @FindBy(id = "contactEmail")
    private WebElement contactEmail;
    //付款方式
    @FindBy(id = "payMethod")
    private WebElement payMethod;
    //商务联系人姓名
    @FindBy(id = "businessName")
    private WebElement businessName;

    //选择中国
    //商务联系人电话
    @FindBy(id = "businessPhone")
    private WebElement businessPhone;
    //商务联系人Email
    @FindBy(id = "businessEmail")
    private WebElement businessEmail;
    //证件类型
    @FindBy(id = "certType")
    private WebElement certType;
    //证件号码
    @FindBy(id = "idNo")
    private WebElement idNo;
    //公司/个人地址
    @FindBy(id = "address")
    private WebElement address;

    //选择一个付款方式
    //GIC合同归属
    @FindBy(id = "custBelong")
    private WebElement custBelong;
    //主用户名称
    @FindBy(id = "userName")
    private WebElement userName;
    //主用户密码
    @FindBy(id = "userPass")
    private WebElement userPass;
    //主用户手机
    @FindBy(id = "userPhone")
    private WebElement userPhone;

    //选择一个证件类型
    //主用户Email
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    //新增按钮
    @FindBy(xpath = "//a[@class='btnh btn-w-i btn-h'][contains(text(),'新增')]")
    private WebElement addButton;

    public ContractFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    void LoginContract(String uid, String pwd) {
        username.sendKeys(uid);
        password.sendKeys(pwd);
        loginButton.click();
    }

    void Customer() {
        customer.click();
    }

    void ToolTables() {
        newCustomer.click();
    }

    void subCustomerName(String name) {
        subCustomerName.sendKeys(name);
    }

    void scroll() {
        sale_no.sendKeys(Keys.TAB);

    }

    //选择第一个行业
    void selectIndustry() {
        Select level = new Select(qualityIndustry);
        level.selectByIndex(1);//电商行业
    }

    public boolean isTitleBarPresent() {
        WebElement titleBar;
        try {
            titleBar = driver.findElement(By.xpath("//h3[contains(text(),'排序方式：')]"));
            if (titleBar != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
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

