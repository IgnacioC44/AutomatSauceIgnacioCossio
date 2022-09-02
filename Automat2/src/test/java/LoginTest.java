import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
    }

    @Test
    public void LoginDisplayed(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        Assert.assertTrue(loginPage.verifyLoginLogoIsDisplayed());
    }
}
