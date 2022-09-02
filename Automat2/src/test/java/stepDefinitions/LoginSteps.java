package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);


    @Given("I set the user name field with {string}")
    public void setUserName(String userName){
        loginPage.setUser(userName);

    }
    @And("I set the password field with {string}")
    public void setPassword(String password){
        loginPage.setPssw(password);

    }
    @When("I click on login button")
    public void clickLoginBtn(){
        loginPage.clickLgn();

    }
    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assert.assertTrue(homePage.appLogoIsDisplayed());

    }
    @And("I click on burger menu button")
    public void clickBurgerMenu() throws InterruptedException {
        homePage.clickBurger();
        Thread.sleep(3000);
    }
    @When("I click on logout button")
    public void clickLogOut() throws InterruptedException {
        homePage.clickLogout();
        Thread.sleep(3000);
    }
    @Then("The login page should be displayed")
    public void verifyLoginPageIsDisplayed(){
        Assert.assertTrue(loginPage.verifyLoginLogoIsDisplayed());

    }

    @When("I add a product to the cart")
    public void addProduct(){
        homePage.clickaddbackpack();
    }
    @Then("The cart product's number increments")
    public void verifyCart(){
        Assert.assertEquals(homePage.getCartText(),"1");
    }
    @When("I select low to high option in the filter")
    public void selectHiToLo(){
        homePage.selectFilter("Price (low to high)");
    }
    @Then("The products will be sorted in low to high prices")
    public void verifyHiToLo(){
        List<Double> prices=homePage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

}
