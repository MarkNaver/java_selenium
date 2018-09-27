package tests;

import ExtenNews.ExtentTestManager;
import com.learning.TestSuiteBaseDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xxb.Invoicemanagement.InvoiceAddedFactoryBase;

public class LoginTest extends TestSuiteBaseDemo {
    public static final Logger log = LogManager.getLogger(LoginTest.class.getName());
    private InvoiceAddedFactoryBase search;

    @BeforeClass
    public void beforeClass() {
        search = PageFactory.initElements(driver,InvoiceAddedFactoryBase.class);


    }

    @Test(description = "哈哈哈")
    public void invalidLoginTest_InvalidUserNameInvalidPassword1() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("这是用例的描述信息");
        search.setInvoiceManagement();
//        test.log()
        search.setGetInvoiceManagement();
        search.setSearchCustomerName("奥巴马123");
        search.setUimenuitem1();
        search.setSecondParty();
        search.setContractNo(search.getcontractNo());
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
