package WebApplication.PageObjectModel.appvwo;

import WebApplication.Utility.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        return driver.findElement(userNameOnDashboard).getText();
    }



}
