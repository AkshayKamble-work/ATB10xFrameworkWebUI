package WebApplication.Tests.PageFactory.Appvwo;

import WebApplication.Base.CommonToAllTest;
import WebApplication.Listeners.RetryAnalyzer;
import WebApplication.Listeners.ScreenshotListener;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WebApplication.Driver.DriverManager.getDriver;
@Listeners(ScreenshotListener.class)
public class TestVWOLogin_PageFactory extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PageFactory.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginNegativeVWO_PF()
    {
        logger.info("Starting the Testcases Page Factory");
        getDriver().get(PropertiesReader.readKey("url"));
        LoginPage loginPage_PF = new LoginPage(getDriver());
        String error_msg = loginPage_PF.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), "invalid_password");
        logger.info("Error msg I got " + error_msg);
        logger.info("Finished the Testcases Page Factory");
        logger.debug("Finished the Testcases Page Factory");
        logger.error("Finished the Testcases Page Factory");
        logger.fatal("Fatal error - code is dead!");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}