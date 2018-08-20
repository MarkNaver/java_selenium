package xxb.contract;


//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContractCustomerFactoryBase {

    private static final Logger log = LogManager.getLogger(ContractCustomerFactoryBase.class.getName());

    /**
     * 合同系统-添加客户元素工厂
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
    //    //弹窗滚动
//    @FindBy(id = "addCustomerFrom")
//    private WebElement addCustomerFrom;
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
    @FindBy(id = "search.customerName")
    private WebElement searchCustomerName;

    //主联系人电话
    @FindBy(id = "contactPhone")
    private WebElement contactPhone;
    @FindBy(xpath = "//div[@class='block-content collapse in']//a[@class='btnh btn-w-i btn-h']")
    private WebElement searchB;

    //主联系人Email
    @FindBy(id = "contactEmail")
    private WebElement contactEmail;

    //输入主联系人姓名
    void inputContactName(String cname) {
        contactName.sendKeys(cname);
        log.info("输入主联系人姓名");
    }


    //付款方式
    @FindBy(id = "payMethod")
    private WebElement payMethod;

    //输入主联系人电话
    void inputContactPhone(String cphone) {
        contactPhone.sendKeys(cphone);
        log.info("输入主联系人电话");
    }

    //商务联系人姓名
    @FindBy(id = "businessName")
    private WebElement businessName;

    //输入主联系人Email
    void inputContactEmail(String cemail) {
        contactEmail.sendKeys(cemail);
        log.info("输入主联系人Email");
    }


    //商务联系人电话
    @FindBy(id = "businessPhone")
    private WebElement businessPhone;

    //选择一个付款方式
    void selectPayMethod() {
        Select level = new Select(payMethod);
        level.selectByIndex(1);//付款方式为月付
        log.info("付款方式选择为月付");
    }

    //商务联系人Email
    @FindBy(id = "businessEmail")
    private WebElement businessEmail;

    //输入商务联系人姓名
    void inputBusinessName(String bName) {
        businessName.sendKeys(bName);
        log.info("输入商务联系人姓名");
    }

    //证件类型
    @FindBy(id = "certType")
    private WebElement certType;

    //输入商务联系人电话
    void inputBusinessPhone(String bphone) {
        businessPhone.sendKeys(bphone);
        log.info("输入联系人电话");
    }
    //证件号码
    @FindBy(id = "idNo")
    private WebElement idNo;

    //输入主联系人Email
    void inputBusinessEmail(String bemail) {
        businessEmail.sendKeys(bemail);
        log.info("输入商务联系人Email");
    }

    //公司/个人地址
    @FindBy(id = "address")
    private WebElement address;

    //选择一个证件类型
    void selectCertType() {
        Select level = new Select(certType);
        level.selectByIndex(2);
        log.info("证件类型选择为护照");
    }

    //GIC合同归属
    @FindBy(id = "custBelong")
    private WebElement custBelong;

    //输入输入证件号码
    void inputIdNo(String idno) {
        idNo.sendKeys(idno);
        log.info("输入证件号码");
    }

    //主用户名称
    @FindBy(id = "userName")
    private WebElement userName;

    //输入公司或个人地址
    void inputAddress(String addresss) {
        address.sendKeys(addresss);
        log.info("输入公司或个人地址");
    }

    //主用户密码
    @FindBy(id = "userPass")
    private WebElement userPass;

    //选择合同归属
    void selectCustBelong() {
        Select select = new Select(custBelong);
        select.selectByIndex(9);
        log.info("合同归属选择了北京");
    }

    //主用户手机
    @FindBy(id = "userPhone")
    private WebElement userPhone;

    //输入主用户名称
    void inputUserName(String username) {
        userName.sendKeys(username);
        log.info("输入主用户名称");
    }




    //主用户Email
    @FindBy(id = "userEmail")
    private WebElement userEmail;

    //主用户密码
    void inputUserPass(String pwd) {
        userPass.sendKeys(pwd);
        log.info("输入主用户密码");
    }

    //新增按钮
    @FindBy(xpath = "//a[@class='btnh btn-w-i btn-h'][contains(text(),'新增')]")
    private WebElement addButton;

    //输入主用户手机号
    void inputUserPhone(String phone) {
        userPhone.sendKeys(phone);
        log.info("输入主用户手机号");
    }

    public ContractCustomerFactoryBase(WebDriver driver) {
        this.driver = driver;
    }

    //输入主用户Email
    void inputUserEmail(String email) {
        userEmail.sendKeys(email);
        log.info("输入主用户email");
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

    //点击新增按钮
    void setAddButton() {
        addButton.click();
        log.info("点击新增按钮");
    }

    void LoginContract(String uid, String pwd) {
        //首页登录步骤集合
        username.sendKeys(uid);
        password.sendKeys(pwd);
        loginButton.click();
        log.info("输入用户名和密码并点击了登录按钮");
    }

    //选择第一个行业
    void selectIndustry() {
        Select level = new Select(qualityIndustry);
        level.selectByIndex(1);//电商行业
    }

    //选择注册地国家-中国
    void selectProvinceState() {
        Select level = new Select(provinceState);
        level.selectByIndex(2);
        log.info("注册地国家选择为中国");
    }

    //选择注册地省份-北京
    void selectProvinceUid() {
        Select level = new Select(provinceUid);
        level.selectByIndex(1);
        log.info("注册地省份选择为北京");
    }

    void inputCustomerName(String scName) {
        searchCustomerName.sendKeys(scName);
        log.info("搜索框输入了客户名称");
    }

    void clickSearchB() {
        searchB.click();
        log.info("点击检索按钮");
    }


    public boolean isTitleBarPresent() {
        WebElement titleBar;
        try {
            titleBar = driver.findElement(By.xpath("//tr[@class='odd']//td[3]"));
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

