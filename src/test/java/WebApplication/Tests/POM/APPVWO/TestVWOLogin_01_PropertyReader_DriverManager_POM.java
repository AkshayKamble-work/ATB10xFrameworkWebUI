package WebApplication.Tests.POM.APPVWO;

import WebApplication.Driver.DriverManager;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.DashboardPage;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_PropertyReader_DriverManager_POM {
    @Description ("TC#1- Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test(priority = 1)
    public void test_negative_vwo_login() throws Exception {

        // Driver Manager Code - 1
        DriverManager.init();

        // Page Class Code (POM Code) - 2
        LoginPage loginPage  = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
        DriverManager.getDriver().quit();

    }

    @Owner("Akshay")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test(priority = 2)
    public void testLoginPositiveVWO() {

        DriverManager.init();
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashBoardPage  = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
        DriverManager.getDriver().quit();

    }



}
