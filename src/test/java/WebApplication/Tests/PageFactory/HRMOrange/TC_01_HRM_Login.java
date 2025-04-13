package WebApplication.Tests.PageFactory.HRMOrange;

import WebApplication.Base.CommonToAllTest;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_LoginPage;
import WebApplication.Pages.Pagefactory.PageObjectModel.appvwo.LoginPage;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WebApplication.Driver.DriverManager.getDriver;

public class TC_01_HRM_Login extends CommonToAllTest {

    @Test
    public void Test_HRM_Login() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
        HRM_LoginPage page = new HRM_LoginPage(getDriver());

        WaitHelpers.waitJVM(5000);
        String errorMessage_ohr = page.loginTo_HRM_InvalidCreds(PropertiesReader.readKey("ohr_invalid_username"), PropertiesReader.readKey("ohr_invalid_password"));
        WaitHelpers.waitJVM(5000);
        Assert.assertEquals(errorMessage_ohr, PropertiesReader.readKey("error_message_ohr"));
        page.loginTo_HRM_validCreds();
    }
}
