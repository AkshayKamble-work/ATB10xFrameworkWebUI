package WebApplication.Pages.Pagefactory.Appvwo;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonToAllPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "login-username")
    private WebElement username;
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement siginButton;
    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    public void loginToVWOnvalidCreds() {
        enterInput(username, PropertiesReader.readKey("username"));
        log.info("Entered the username");
        enterInput(password, PropertiesReader.readKey("password"));
        log.info("Entered the password");
        clickElement(siginButton);
        log.info("Click on the sigin button");

    }

    public String loginToVWOInvalidCreds(String emai,String pass) {
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(siginButton);
        WaitHelpers.waitJVM(5000);
        return getText(error_message);

    }
}
