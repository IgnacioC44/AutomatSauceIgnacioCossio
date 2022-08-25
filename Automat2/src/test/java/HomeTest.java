import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

//Ignacio Cossio 58754
public class HomeTest extends BaseTest{
    @Test
    public void twitterDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage=new HomePage(DriverManager.getDriver());
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickTwitter();
        Thread.sleep(2500);
    }
    @Test
    public void logoutSaveCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage=new HomePage(DriverManager.getDriver());
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.addProduct();
        Thread.sleep(2500);
        homePage.clickBurger();
        Thread.sleep(2500);
        homePage.clickLogout();
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        Thread.sleep(2500);
        loginPage.clickLgn();
        Thread.sleep(2500);
        Assert.assertEquals(homePage.getCartText(),"1");
        System.out.println(homePage.getCartText());

    }
    @Test
    public void resetFunction() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage=new HomePage(DriverManager.getDriver());
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        Thread.sleep(2500);
        homePage.addProduct();
        Thread.sleep(2500);
        homePage.clickBurger();
        Thread.sleep(2500);
        homePage.clickReset();
        Thread.sleep(2500);
        Assert.assertEquals(homePage.getCartText(),"");
        System.out.println(homePage.getCartText());
    }


}
