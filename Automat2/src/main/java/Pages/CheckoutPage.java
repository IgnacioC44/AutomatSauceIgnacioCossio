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
}
