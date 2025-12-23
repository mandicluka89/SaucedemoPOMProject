package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(css=".shopping_cart_badge")
    public List<WebElement> shoppingCartCounter;

    @FindBy(id ="continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id="checkout")
    public WebElement checkoutButton;

    @FindBys(
            @FindBy( css = ".cart_item")
    )
    public List<WebElement> ListOfItemsInCart;

    @FindBys(
            @FindBy(css = ".cart_item button.btn_secondary")
    )
    public List<WebElement> removeButtonsList;


    //-------------------

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public int countingCart(){
        if (shoppingCartCounter.isEmpty()){
            return 0;
        }
        return Integer.parseInt(shoppingCartCounter.getFirst().getText());
    }

    //---------------- Removing From Cart ----------------

    public void removingItemFromCart(){
        List<WebElement> ListaRemoveButtonsPocetna = new ArrayList<>(removeButtonsList);
        for (WebElement rb:ListaRemoveButtonsPocetna){
            rb.click();
        }
    }

    public void loggingOut() throws InterruptedException {
        hamburgerMenu.click();
        Thread.sleep(500);
        logoutLink.click();
    }
}
