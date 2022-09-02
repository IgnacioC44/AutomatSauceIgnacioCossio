package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy (id="user-name")
    WebElement usrnmtxtbx;
    @FindBy (id="password")
    WebElement psswtxtbx;
    @FindBy (id="login-button")
    WebElement lgnbtn;
    @FindBy (className="login_logo")
    WebElement loginlogo;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean verifyLoginLogoIsDisplayed(){
        boolean loginLogoIsDisplayed = loginlogo.isDisplayed();
        return loginLogoIsDisplayed;

    }

    public void setUser(String username){
        usrnmtxtbx.sendKeys(username);
    }
    public void setPssw(String password){
        psswtxtbx.sendKeys(password);
    }
    public void clickLgn(){
        lgnbtn.click();
    }



}
