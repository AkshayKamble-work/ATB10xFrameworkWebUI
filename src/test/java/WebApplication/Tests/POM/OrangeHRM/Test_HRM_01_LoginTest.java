package WebApplication.Tests.POM.OrangeHRM;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Driver.DriverManager;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.LoginPage;
import WebApplication.Pages.Pagefactory.PageObjectModel.orangeHRM.HRM_LoginPage;
import WebApplication.Tests.PageFactory.Appvwo.TestVWOLogin_PageFactory;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_HRM_01_LoginTest extends CommonToAllPage {
    private static final Logger logger = LogManager.getLogger(Test_HRM_01_LoginTest.class);

    @Description("TC#1- Verify that with valid email, pass, error message is shown on the awesomeqa.com")
    @Test(priority = 1)
    public void test_Positive_HRM_login() throws Exception {

        // Driver Manager Code - 1
        DriverManager.init();
        logger.info("Opening the browser");
        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HRM_LoginPage HRM_loginPage = new HRM_LoginPage(DriverManager.getDriver());
        HRM_loginPage.Test_HRM_LoginUser(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));
        WaitHelpers.waitJVM(5000);
        DriverManager.getDriver().quit();
        logger.info("closing the browswer");

    }

}
