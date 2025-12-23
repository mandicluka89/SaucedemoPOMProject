package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest{


    public LoginPage (){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css=".error-message-container.error")
    public WebElement errorMessage;

    //-----------------------


    public void inputUsername(String username){
        usernameBox.clear();
        usernameBox.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
