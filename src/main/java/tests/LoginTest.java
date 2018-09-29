package tests;

import ExtenNews.ExtentTestManager;
import com.common.BrowserEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import xxb.Invoicemanagement.InvoiceAddedFactoryBase;

public class LoginTest extends BrowserEngine {
    public static final Logger log = LogManager.getLogger(LoginTest.class.getName());
    private InvoiceAddedFactoryBase search;

    @BeforeClass
    public void beforeClass() {
        search = PageFactory.initElements(driver,InvoiceAddedFactoryBase.class);


    }

    @Parameters({"username", "password"})
    @Test(description = "哈哈哈")
    public void invalidLoginTest_InvalidUserNameInvalidPassword1(String username,String password) throws InterruptedException {
        ExtentTestManager.getTest().setDescription("这是用例的描述信息");
        search.clickBtn(username, password);
        search.setInvoiceManagement();
//        test.log()
        search.setGetInvoiceManagement();
        search.setSearchCustomerName("奥巴马123");
        search.setUimenuitem1();
        search.setSecondParty();
//        search.setContractNo(search.getcontractNo());
//        search.setSearchButton();
//        search.setCheckbox();
//        search.setChickInvoice();
//        search.setBillingDetails();
//        search.setInvoiceAmount(search.getcontractAmount());
//        search.setStartMonth(GetData.serverData());
//        search.setEndMonth(GetData.serverData());
////        Thread.sleep(100000);
//        search.setInvoiceType();
//        Thread.sleep(30000);
//        search.setInvoiceDiv();
//        Thread.sleep(10000);
    }


}
