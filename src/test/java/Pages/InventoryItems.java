package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InventoryItems extends BaseTest{


    public InventoryItems(){

        PageFactory.initElements(driver, this);
    }

    //----------- Item 0 ---------------

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLightAddToCartButton;

    @FindBy(id="item_0_title_link")
    public WebElement bikeLightLink;

    @FindBy(id = "item_0_img_link")
    public WebElement bikeLightImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_0_title_link) .inventory_item_desc")
    public WebElement bikeLightDescription;

    @FindBy(css = ".inventory_item_description:has(#item_0_title_link) .inventory_item_price")
    public WebElement bikeLightPrice;

    //----------- Item 1 ---------------

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement tShirtAddToCartButton;

    @FindBy(id="item_1_title_link")
    public WebElement tShirtLink;

    @FindBy(id = "item_1_img_link")
    public WebElement tShirtImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_1_title_link) .inventory_item_desc")
    public WebElement tShirtDescription;

    @FindBy(css = ".inventory_item_description:has(#item_1_title_link) .inventory_item_price")
    public WebElement tShirtPrice;

    //----------- Item 2 ---------------

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieAddToCartButton;

    @FindBy(id="item_2_title_link")
    public WebElement onesieLink;

    @FindBy(id = "item_2_img_link")
    public WebElement onesieImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_2_title_link) .inventory_item_desc")
    public WebElement onesieDescription;

    @FindBy(css = ".inventory_item_description:has(#item_2_title_link) .inventory_item_price")
    public WebElement onesiePrice;

//----------- Item 3 ---------------

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement redTShirtAddToCartButton;

    @FindBy(id="item_3_title_link")
    public WebElement redTShirtLink;

    @FindBy(id = "item_3_img_link")
    public WebElement redTShirtImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_3_title_link) .inventory_item_desc")
    public WebElement redTShirtDescription;

    @FindBy(css = ".inventory_item_description:has(#item_3_title_link) .inventory_item_price")
    public WebElement redTShirtPrice;

//----------- Item 4 ---------------

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpackAddToCartButton;

    @FindBy(id="item_4_title_link")
    public WebElement backpackLink;

    @FindBy(id = "item_4_img_link")
    public WebElement backpackImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_4_title_link) .inventory_item_desc")
    public WebElement backpackDescription;

    @FindBy(css = ".inventory_item_description:has(#item_4_title_link) .inventory_item_price")
    public WebElement backpackPrice;

    //---------------- Item 5 ----------------

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacketAddToCartButton;

    @FindBy(id="item_5_title_link")
    public WebElement fleeceJacketLink;

    @FindBy(id = "item_5_img_link")
    public WebElement fleeceJacketImageLink;

    @FindBy(css = ".inventory_item_description:has(#item_5_title_link) .inventory_item_desc")
    public WebElement fleeceJacketDescription;

    @FindBy(css = ".inventory_item_description:has(#item_5_title_link) .inventory_item_price")
    public WebElement fleeceJacketPrice;


    //---------------------------


}



