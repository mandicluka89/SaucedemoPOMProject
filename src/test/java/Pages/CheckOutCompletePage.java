package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BaseTest {

    public CheckOutCompletePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    //--------------------------

    public void loggingOut() throws InterruptedException {
        hamburgerMenu.click();
        Thread.sleep(500);
        logoutLink.click();
    }

}






