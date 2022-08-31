package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    @FindBy(className = "error-message-container")
    WebElement errorMessage;
    @FindBy(id="continue")
    WebElement continuebtn;
    @FindBy(id="first-name")
    WebElement firstname;
    @FindBy(id="last-name")
    WebElement lastname;
    @FindBy(id="postal-code")
    WebElement zipcode;
    @FindBy(className = "summary_subtotal_label")
    WebElement subtotal;
    @FindBy(id = "finish")
    WebElement finishbtn;
    @FindBy(id = "back-to-products")
    WebElement backhomebtn;


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    public void clickContinue(){
        continuebtn.click();
    }
    public String getErrorBtnText(){
        String errorText= errorMessage.getText();
        return errorText;
    }
    public void setFirstname(String firstname1){
        firstname.sendKeys(firstname1);
    }
    public void setLastname(String lastname1){lastname.sendKeys(lastname1);    }
    public void setZipcode(String zipcode1){zipcode.sendKeys(zipcode1);    }
    public String getSubtotal() {
        String pricesub = subtotal.getText();
        return pricesub;
    }
    public void clickFinsh(){
        finishbtn.click();
    }
    public void clickBackhome(){
        backhomebtn.click();
    }
}
