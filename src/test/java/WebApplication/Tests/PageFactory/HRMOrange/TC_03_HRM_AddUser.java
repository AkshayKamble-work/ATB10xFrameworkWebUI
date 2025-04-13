package WebApplication.Tests.PageFactory.HRMOrange;

import WebApplication.Base.CommonToAllTest;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_AddUserPage;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_LoginPage;
import WebApplication.Pages.Pagefactory.HRMOrange.HRM_Logout;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static WebApplication.Driver.DriverManager.getDriver;

public class TC_03_HRM_AddUser extends CommonToAllTest {



    @Description("Verify that user is able to add new member on HRM Orange site")
    @Test
    public void Test_Add_User() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
        HRM_LoginPage page = new HRM_LoginPage(getDriver());
        page.loginTo_HRM_validCreds();
        HRM_AddUserPage addUserPage=new HRM_AddUserPage(getDriver());
        WaitHelpers.waitJVM(5000);
        addUserPage.TestAddUser();
        WaitHelpers.waitJVM(5000);
        HRM_Logout logout = new HRM_Logout(getDriver());
        WaitHelpers.waitJVM(5000);
        logout.Test_HRM_Logout();


    }
}
