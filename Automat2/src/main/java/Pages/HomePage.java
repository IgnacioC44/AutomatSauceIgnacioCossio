package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(className="social_twitter")
    WebElement twitterbtn;
    @FindBy(id="react-burger-menu-btn")
    WebElement burgermenubtn;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetbtn;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutbtn;
    @FindBy(className = "shopping_cart_link")
    WebElement carticon;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeSauceBP;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addtocartSauceBP;






    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickTwitter(){
        twitterbtn.click();
    }
    public String getCartText(){
        String cartText= carticon.getText();
        return cartText;
    }
    public void addProduct(){
        addtocartSauceBP.click();
    }
    public void clickBurger(){
        burgermenubtn.click();
    }
    public void clickLogout(){
        logoutbtn.click();
    }
    public void removeProduct(){
        removeSauceBP.click();
    }
    public void clickReset(){
        resetbtn.click();
    }




}
