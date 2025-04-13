package WebApplication.Pages.Pagefactory.HRMOrange;


import WebApplication.Base.CommonToAllPage;
import WebApplication.Pages.Pagefactory.Appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRM_LoginPage extends CommonToAllPage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    public HRM_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitbutton;

    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement emailID;
    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginbutton;
@FindBy (xpath = "//p[text()='Invalid credentials']")
private WebElement error_Message_ohr;

    public void loginTo_HRM_validCreds() {
        openOrangeHRMUrl();
        log.info("Opening Orange HRM Application");
        WaitHelpers.waitJVM(5000);
        enterInput(emailID, PropertiesReader.readKey("ohr_username"));
        log.info("Entered Username "+PropertiesReader.readKey("ohr_username"));
        enterInput(password, PropertiesReader.readKey("ohr_password"));
        log.info("Entered Password "+PropertiesReader.readKey("ohr_password"));
        clickElement(loginbutton);
        log.info("Click on login button");

    }

    public String loginTo_HRM_InvalidCreds(String email, String pass) {
        openOrangeHRMUrl();
        log.info("Opening Orange HRM Application");
        WaitHelpers.waitJVM(5000);
        enterInput(emailID, PropertiesReader.readKey("ohr_invalid_username"));
        log.info("Entered Invalid username "+PropertiesReader.readKey("ohr_invalid_username"));
        enterInput(password, PropertiesReader.readKey("ohr_invalid_password"));
        log.info("Entered Invalid Password"+PropertiesReader.readKey("ohr_invalid_password"));
        clickElement(loginbutton);
        log.info("Click on login button");
        WaitHelpers.waitJVM(5000);
        return getText(error_Message_ohr);
    }


}

