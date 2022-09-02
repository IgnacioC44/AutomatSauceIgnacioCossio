import Pages.CheckoutPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.CartPage;

public class CheckoutTest extends BaseTest{
    @Test
    public void errorMessageDisplayed(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        CartPage cartPage=new CartPage(DriverManager.getDriver().driver);
        CheckoutPage checkoutPage=new CheckoutPage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getErrorBtnText(),"Error: First Name is required");
        System.out.println(checkoutPage.getErrorBtnText());
    }
}
