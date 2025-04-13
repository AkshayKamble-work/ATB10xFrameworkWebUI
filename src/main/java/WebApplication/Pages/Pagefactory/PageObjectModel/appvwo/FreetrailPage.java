package WebApplication.Pages.Pagefactory.PageObjectModel.appvwo;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Utility.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static WebApplication.Driver.DriverManager.getDriver;

public class FreetrailPage extends CommonToAllPage {
    WebDriver driver;
    public FreetrailPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By Start_a_free_trial=By.linkText("Start a free trial");
    private  By email=By.name("email");
    private By checkbox=By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']");
    private By createButton=By.xpath("//button[text()='Create a Free Trial Account']");
private By ErroraccountAllReadyExitMessage=By.xpath("//div[text()='An account with this email already exists. ']");
    public String TestFreeTrail(String Email)
    {
        openVWOUrl();
        clickElement(Start_a_free_trial);
        enterInput(email,Email);
        clickElement(checkbox);
        clickElement(createButton);
        WaitHelpers.checkVisibility(getDriver(),ErroraccountAllReadyExitMessage);
       return getText(ErroraccountAllReadyExitMessage);

    }
}
