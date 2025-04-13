package WebApplication.Pages.Pagefactory.PageObjectModel.orangeHRM;

import WebApplication.Base.CommonToAllPage;
import WebApplication.Utility.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRM_LoginPage extends CommonToAllPage {
    WebDriver driver;
    public  HRM_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By email=By.name("username");
    private  By pass=By.name("password");
    private By loginbutton=By.xpath("//button[@type='submit']");


    public void Test_HRM_LoginUser(String Email, String Password)
    {
        openOrangeHRMUrl();
       WaitHelpers.waitJVM(5000);
        enterInput(email,Email);
        enterInput(pass,Password);
        clickElement(loginbutton);

    }
}
