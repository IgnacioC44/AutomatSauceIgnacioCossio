import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
    }
}
