package WebApplication.Tests.PageFactory.HRMOrange;

import WebApplication.Base.CommonToAllTest;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_LoginPage;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_Logout;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static WebApplication.Driver.DriverManager.getDriver;

public class TC_02_HRM_LogoutPage extends CommonToAllTest {
    @Description("Verify that with user is able to logout by clicking on logout button")
    @Test
    public void Test_Logout() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
        HRM_LoginPage page = new HRM_LoginPage(getDriver());
        page.loginTo_HRM_validCreds();
        HRM_Logout logout = new HRM_Logout(getDriver());
        WaitHelpers.waitJVM(5000);
        logout.Test_HRM_Logout();


    }

}
