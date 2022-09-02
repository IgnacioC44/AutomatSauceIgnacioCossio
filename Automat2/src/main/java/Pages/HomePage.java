package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removelights;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addtocartSauceBP;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutbtn;
    @FindBy(className = "product_sort_container")
    WebElement sortbtn;
    @FindBy(className = "app_logo")
    WebElement applogo;
    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPriceLabels;
    @FindBy(className = "social_facebook")
    WebElement facebookbtn;
    @FindBy(className = "social_linkedin")
    WebElement linkedinbtn;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpackadd;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikelightadd;








    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickTwitter(){
        twitterbtn.click();
    }
    public void clickFacebook(){
        facebookbtn.click();
    }
    public void clickLinkedin(){
        linkedinbtn.click();
    }
    public String getCartText(){
        String cartText= carticon.getText();
        return cartText;
    }
    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = applogo.isDisplayed();
        return appLogoIsDisplayed;
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
    public void clickAbout(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aboutbtn));
        aboutbtn.click();
    }
    public void selectFilter(String element){
        Select selectObject=new Select(sortbtn);
        selectObject.selectByVisibleText(element);
    }
    public List<Double> getAllItemPrices(){
        List<Double> prices= new ArrayList<>();
        for (WebElement itemPrice: itemPriceLabels){
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));

        }
        return prices;


    }
    public void clickCart(){
        carticon.click();
    }
    public void clickaddbackpack(){
        backpackadd.click();
    }
    public void clickaddbikelight(){
        bikelightadd.click();
    }






}
