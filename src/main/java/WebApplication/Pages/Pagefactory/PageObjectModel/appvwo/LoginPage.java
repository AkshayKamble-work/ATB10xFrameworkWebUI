package WebApplication.Pages.Pagefactory.PageObjectModel.appvwo;


import WebApplication.Base.CommonToAllPage;
import WebApplication.Driver.DriverManager;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static WebApplication.Driver.DriverManager.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends CommonToAllPage {

    // Page Class
    // Page Locators
    WebDriver driver;
// constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);

    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

    }

}
