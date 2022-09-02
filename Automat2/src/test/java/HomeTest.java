import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

//Ignacio Cossio 58754
public class HomeTest extends BaseTest{
    @Test
    public void twitterDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickTwitter();
        Thread.sleep(2500);
    }
    @Test
    public void facebookDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickFacebook();
        Thread.sleep(2500);
    }
    @Test
    public void linkedinDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickLinkedin();
        Thread.sleep(2500);
    }
    @Test
    public void logoutSaveCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
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
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
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
    @Test
    public void aboutFunction(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickBurger();
        homePage.clickAbout();

    }
    @Test
    public void verifyHighToLow(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.selectFilter("Price (high to low)");
        List<Double> prices=homePage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);


    }
    @Test
    public void verifyLowToHigh(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.selectFilter("Price (low to high)");
        List<Double> prices=homePage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);


    }

    @Test
    public void parcialDos()  {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        HomePage homePage=new HomePage(DriverManager.getDriver().driver);
        CartPage cartPage=new CartPage(DriverManager.getDriver().driver);
        CheckoutPage checkoutPage=new CheckoutPage(DriverManager.getDriver().driver);
        loginPage.setUser("standard_user");
        loginPage.setPssw("secret_sauce");
        loginPage.clickLgn();
        homePage.clickaddbackpack();
        homePage.clickaddbikelight();
        homePage.clickCart();
        Assert.assertTrue(cartPage.verifyNoItemsByNameBackPack());
        Assert.assertTrue(cartPage.verifyNoItemsByNameBike());
        Assert.assertEquals(homePage.getCartText(),"2");
        System.out.println(homePage.getCartText());
        cartPage.clickCheckout();
        checkoutPage.setFirstname("lalo");
        checkoutPage.setLastname("landa");
        checkoutPage.setZipcode("0000");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getSubtotal(),"Item total: $39.98");
        System.out.println(checkoutPage.getSubtotal());
        checkoutPage.clickFinsh();
        checkoutPage.clickBackhome();
        homePage.clickaddbackpack();
        homePage.clickaddbikelight();
        homePage.clickCart();
        cartPage.clickRemovebp();
        cartPage.clickRemovelp();
        Assert.assertEquals(homePage.getCartText(),"");
        System.out.println(homePage.getCartText());






    }




}
