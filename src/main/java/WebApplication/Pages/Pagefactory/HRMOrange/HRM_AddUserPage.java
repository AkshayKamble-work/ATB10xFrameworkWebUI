package WebApplication.Pages.Pagefactory.HRMOrange;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Pages.Pagefactory.Appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_AddUserPage extends CommonToAllPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    WebDriver driver;

    public HRM_AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
    private WebElement Addbutton;

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private WebElement firstname;

    @FindBy(xpath = "//input[@name=\"middleName\"]")
    private WebElement middlename;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement lastname;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private WebElement EmpId;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitbutton;

    public void TestAddUser() {
        Addbutton.click();
        log.info("Click on Add button");
        WaitHelpers.waitJVM(5000);
        enterInput(firstname, PropertiesReader.readKey("firstname"));
        log.info("First name entered " + PropertiesReader.readKey("firstname"));
        enterInput(middlename, PropertiesReader.readKey("middlename"));
        log.info("Middle name entered " + PropertiesReader.readKey("middlename"));
        enterInput(lastname, PropertiesReader.readKey("lastname"));
        log.info("Last name entered " + PropertiesReader.readKey("lastname"));
        enterInput(EmpId, PropertiesReader.readKey("EmployeeID"));
        log.info("Employee ID entered " + PropertiesReader.readKey("EmployeeID"));
        submitbutton.click();

    }

}
