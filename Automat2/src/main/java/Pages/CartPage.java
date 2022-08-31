package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutbtn;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement lights;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(className = "inventory_item_name")
    WebElement bpsauce;
    @FindBy(className = "inventory_item_name")
    WebElement lightssauce;


    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickCheckout(){
        checkoutbtn.click();
    }
    public void clickRemovebp(){backpack.click();
    }
    public void clickRemovelp(){
        lights.click();
    }
    public boolean verifyNoItemsByNameBackPack() {
        boolean verifyNoItems = bpsauce.isDisplayed();
        return verifyNoItems;
    }

    public boolean verifyNoItemsByNameBike() {
        boolean verifyNoItems = lightssauce.isDisplayed();
        return verifyNoItems;
    }

}
