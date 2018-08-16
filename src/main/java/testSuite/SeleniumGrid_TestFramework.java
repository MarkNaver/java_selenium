package testSuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.TestSuitBase;

public class SeleniumGrid_TestFramework extends TestSuitBase {
    String baseUrl;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void testSeleniumGrid_TestFramework() {
        search.searchPage("北京, 中国 (PEK-首都国际机场)",
                "东京, 日本 (TYO-所有机场)",
                "2018/09/24");
    }

    @AfterClass
    public void tearDown() {

    }
}
