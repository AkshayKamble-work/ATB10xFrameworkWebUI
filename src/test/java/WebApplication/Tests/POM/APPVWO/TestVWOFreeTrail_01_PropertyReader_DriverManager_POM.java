package WebApplication.Tests.POM.APPVWO;

import WebApplication.Driver.DriverManager;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.FreetrailPage;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOFreeTrail_01_PropertyReader_DriverManager_POM {

    @Description("TC#1- Verify that user able to  click on start free trail link on the app.vwo.com")
    @Test(priority = 1)
    public void test_Start_FreeTaril_Link_vwo_login() throws Exception {

        // Driver Manager Code - 1
        DriverManager.init();

        // Page Class Code (POM Code) - 2
        LoginPage loginPage  = new LoginPage(DriverManager.getDriver());
        FreetrailPage freetrailPage=new FreetrailPage(DriverManager.getDriver());
        String errorMessgae=freetrailPage.TestFreeTrail(PropertiesReader.readKey("username"));
        WaitHelpers.waitJVM(5000);
        assertThat(errorMessgae).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errorMessgae,PropertiesReader.readKey("error_message_accountexit"));
        DriverManager.getDriver().quit();

    }
}
