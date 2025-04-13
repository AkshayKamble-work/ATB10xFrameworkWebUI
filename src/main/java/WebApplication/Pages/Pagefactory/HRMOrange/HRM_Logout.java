package WebApplication.Pages.Pagefactory.HRMOrange;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Utility.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_Logout extends CommonToAllPage {

    WebDriver driver;

    public HRM_Logout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Site Owner']")
    private WebElement SiteOwnerLink;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement Logoutbutton;


    public void Test_HRM_Logout()
    {
        SiteOwnerLink.click();
        WaitHelpers.waitJVM(5000);
        Logoutbutton.click();
    }
}
