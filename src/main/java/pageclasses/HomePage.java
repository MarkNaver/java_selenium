package pageclasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
//    private static final Logger log = LogManager.getLogger(LoginTest.class.getName());

    WebDriver driver = null;
    ExtentTest test;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void enterUserNameTextBox(String username) {
        WebElement emailField = driver.findElement(By.id("u"));
        emailField.sendKeys(username);
        test.log(LogStatus.INFO, "Enter User Name");
//        log.info("Enter User Name");
    }

    public void enterPasswordTextBox(String password) {
        WebElement passwordField = driver.findElement(By.id("p"));
        passwordField.sendKeys(password);
        test.log(LogStatus.INFO, "Enter Password");
    }

    public void clickOnLoginLink() {
        WebElement goButton = driver.findElement(By.id("login_button"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked on login button");

    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//b[text()='塵埃落定']"));
            if (welcomeText != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void login(String username, String password) {
        enterUserNameTextBox(username);
        enterPasswordTextBox(password);
        clickOnLoginLink();
    }
}
