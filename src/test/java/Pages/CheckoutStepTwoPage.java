package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepTwoPage extends BaseTest {

    public CheckoutStepTwoPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(css = ".summary_subtotal_label")
    public WebElement summaryPriceOfItems;

    @FindBys(
            @FindBy(css = ".inventory_item_price")
    )
    public List<WebElement> elementsPrices;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;


    //-------------------------------

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }

    public double summaryOfPrices(){
        List<Double> itemsPrices = new ArrayList<>();
        double summary = 0;
        for (WebElement we: elementsPrices){
             itemsPrices.add(Double.parseDouble(we.getText().replace("$","")));
        }
        for (double ip : itemsPrices){
            summary += ip;
        }
        return summary;

    }

    public void loggingOut() throws InterruptedException {
        hamburgerMenu.click();
        Thread.sleep(500);
        logoutLink.click();
    }



}
