package WebApplication.Pages.Pagefactory.Appvwo;

import WebApplication.Base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static WebApplication.Utility.WaitHelpers.visibilityOfElement;

public class Dashboard extends CommonToAllPage {

    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;


    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
