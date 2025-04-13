package WebApplication.Tests.PageFactory.DataDriven;

import WebApplication.Base.CommonToAllTest;
import WebApplication.Listeners.RetryAnalyzer;
import WebApplication.Pages.Pagefactory.Appvwo.LoginPage;
import WebApplication.UtilExcel.UtilExcel;
import WebApplication.Utility.PropertiesReader;
import WebApplication.Utility.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static WebApplication.Driver.DriverManager.getDriver;

public class Test_DDT_TestNG_POI_REAL_VWOLOGIN extends CommonToAllTest {

    @Test(dataProvider = "getData",retryAnalyzer = RetryAnalyzer.class)
    public void test_vwo_login(String email, String password) {
        System.out.println(email + " - " + password);
        getDriver().navigate().to(PropertiesReader.readKey("url"));
        Assert.assertEquals(getDriver().getTitle(), PropertiesReader.readKey("current_title"));
        Assert.assertEquals(getDriver().getCurrentUrl(), PropertiesReader.readKey("current_url"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToVWOnvalidCreds();
        WaitHelpers.waitJVM(5000);
        String error_message = loginPage.loginToVWOInvalidCreds(email, password);
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));

    }

    @DataProvider(parallel = true)
    public Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("Sheet1");


    }
}
