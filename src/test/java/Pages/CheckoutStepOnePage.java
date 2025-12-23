package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStepOnePage extends BaseTest {

    public CheckoutStepOnePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(css=".shopping_cart_badge")
    public List<WebElement> shoppingCartCounter;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "first-name")
    public WebElement firstnameField;

    @FindBy(id = "last-name")
    public WebElement lastnameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

//-------------------------------

    public void inputFirstname(String firstname){
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
    }

    public void inputLastname(String lastname){
        lastnameField.clear();
        lastnameField.sendKeys(lastname);
    }

    public void inputPostalCode(String postalCode){
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void loggingOut() throws InterruptedException {
        hamburgerMenu.click();
        Thread.sleep(500);
        logoutLink.click();
    }
}
