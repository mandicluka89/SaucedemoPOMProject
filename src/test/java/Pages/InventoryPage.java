package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends BaseTest{


    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartIcon;

    @FindBy(css=".shopping_cart_badge")
    public List<WebElement> shoppingCartCounter;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuIcon;

    @FindBy(css = ".product_sort_container")
    public WebElement sortDropdown;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")
    public WebElement twitterButton;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")
    public WebElement facebookButton;

    @FindBy(xpath = "/html/body/div/div/footer/ul/li[3]/a")
    public WebElement linkedInButton;

    //------------- List Items Names -------------

    @FindBys(
            @FindBy(css = ".inventory_item_name ")
    )
    public List<WebElement> elementsNames;

    //------------ List Items Prices ------------

    @FindBys(
            @FindBy(css = ".inventory_item_price")
    )
    public List<WebElement> elementsPrices;

    //--------- List Items Add And Remove Cart Buttons ---------

    @FindBys(
            @FindBy(css = ".inventory_item button")
    )
    public List<WebElement> addButtonsList;

    @FindBys(
           @FindBy(css = ".inventory_item button.btn_secondary")
    )
    public List<WebElement> removeButtonsList;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;




    //---------------- Adding To Cart ----------------

    public void addingItemToCart(int i){
        addButtonsList.get(i).click();
    }

    //---------------- Removing From Cart ----------------

    public void removingItemFromCart(){
        List<WebElement> ListaRemoveButtonsPocetna = new ArrayList<>(removeButtonsList);
        for (WebElement rb:ListaRemoveButtonsPocetna){
            rb.click();
        }
    }

    //----------- Counting Cart ----------

    public int countingCart(){
      if (shoppingCartCounter.isEmpty()){
          return 0;
      }
      return Integer.parseInt(shoppingCartCounter.getFirst().getText());
    }


    //------------- Selecting Sorting By ----------

    public void selectSort(String sortiranje){
        Select select = new Select(sortDropdown);
        select.selectByValue(sortiranje);
    }

    //-------- List of String Items Names --------

    public List<String> getItemsNamesList() {
        List<String> itemsNames = new ArrayList<>();
        for (WebElement we: elementsNames){
            itemsNames.add(we.getText());
        }
        return itemsNames;
    }

    //-------- List of String Items Names From A To Z  --------

    public boolean isAscending(List<String>itemsNames){
        List<String> ascendingList = new ArrayList<>(itemsNames);
        Collections.sort(ascendingList);
        return itemsNames.equals(ascendingList);
    }

    //-------- List of String Items Names From Z To A  --------

    public boolean isDescending(List<String>itemsNames){
        List<String> descendingList = new ArrayList<>(itemsNames);
        descendingList.sort(Collections.reverseOrder());
        return itemsNames.equals(descendingList);
    }

    //-------- List of Doubles Items Prices --------

    public List<Double> getItemsPricesList (){
        List<Double> itemsPrices = new ArrayList<>();
        for (WebElement we: elementsPrices){
            itemsPrices.add(Double.parseDouble(we.getText().replace("$","")));
        }
        return itemsPrices;
    }

    //----- List of String Items Prices From Low To High  -----

    public boolean isAscendingPrices(List<Double>itemsPrices){
        List<Double> ascendingList = new ArrayList<>(itemsPrices);
        Collections.sort(ascendingList);
        return itemsPrices.equals(ascendingList);
    }

    //----- List of String Items Prices From High To Low  -----

    public boolean isDescendingPrices(List<Double>itemsPrices){
        List<Double> descendingList = new ArrayList<>(itemsPrices);
        descendingList.sort(Collections.reverseOrder());
        return itemsPrices.equals(descendingList);
    }

    public void loggingOut() throws InterruptedException {
        burgerMenuIcon.click();
        Thread.sleep(500);
        logoutLink.click();
    }

    public void clickOnTwitterButton(){
        twitterButton.click();
    }


}

