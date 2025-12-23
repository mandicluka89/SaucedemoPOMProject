package Tests;

import Base.BaseTest;
import Pages.InventoryItems;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryItemsTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        inventoryItems = new InventoryItems();

        driver.navigate().to("https://www.saucedemo.com/");

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

    }

    @Test(priority = 1)
    public void visibilityOfItemsOnItemPageTest(){

        Assert.assertTrue(inventoryPage.shoppingCartIcon.isDisplayed());
        Assert.assertTrue(inventoryPage.burgerMenuIcon.isDisplayed());
    }

    @Test (priority = 2)
    public void visibilityOfItem0Test(){

        Assert.assertTrue(inventoryItems.bikeLightAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.bikeLightImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.bikeLightLink.isDisplayed());
        Assert.assertTrue(inventoryItems.bikeLightDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.bikeLightPrice.isDisplayed());
    }
    @Test (priority = 2)
    public void visibilityOfItem1Test(){

        Assert.assertTrue(inventoryItems.tShirtAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.tShirtImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.tShirtLink.isDisplayed());
        Assert.assertTrue(inventoryItems.tShirtDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.tShirtPrice.isDisplayed());
    }
    @Test (priority = 2)
    public void visibilityOfItem2Test() {

        Assert.assertTrue(inventoryItems.onesieAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.onesieImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.onesieLink.isDisplayed());
        Assert.assertTrue(inventoryItems.onesieDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.onesiePrice.isDisplayed());
    }
    @Test (priority = 2)
    public void visibilityOfItem3Test(){

        Assert.assertTrue(inventoryItems.redTShirtAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.redTShirtImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.redTShirtLink.isDisplayed());
        Assert.assertTrue(inventoryItems.redTShirtDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.redTShirtPrice.isDisplayed());
    }
    @Test (priority = 2)
    public void visibilityOfItem4Test(){

        Assert.assertTrue(inventoryItems.backpackAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.backpackImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.backpackLink.isDisplayed());
        Assert.assertTrue(inventoryItems.backpackDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.backpackPrice.isDisplayed());
    }
    @Test (priority = 2)
    public void visibilityOfItem5Test(){

        Assert.assertTrue(inventoryItems.fleeceJacketAddToCartButton.isDisplayed());
        Assert.assertTrue(inventoryItems.fleeceJacketImageLink.isDisplayed());
        Assert.assertTrue(inventoryItems.fleeceJacketLink.isDisplayed());
        Assert.assertTrue(inventoryItems.fleeceJacketDescription.isDisplayed());
        Assert.assertTrue(inventoryItems.fleeceJacketPrice.isDisplayed());
    }

    @Test(priority = 3)
    public void userCanSortItemsUsingNamesFromAtoZTest(){

        String sorting = "az";
        inventoryPage.selectSort(sorting);

        Assert.assertTrue(inventoryPage.isAscending(inventoryPage.getItemsNamesList()));

    }

    @Test(priority = 3)
    public void userCanSortItemsUsingNamesFromZtoATest(){

        String sorting = "za";
        inventoryPage.selectSort(sorting);

        Assert.assertTrue(inventoryPage.isDescending(inventoryPage.getItemsNamesList()));
    }

    @Test(priority = 3)
    public void userCanSortItemsUsingPriceFromLowToHighTest(){

        String sorting = "lohi";
        inventoryPage.selectSort(sorting);

        Assert.assertTrue(inventoryPage.isAscendingPrices(inventoryPage.getItemsPricesList()));

    }

    @Test(priority = 3)
    public void userCanSortItemsUsingPriceFromHighToLowTest(){

        String sorting = "hilo";
        inventoryPage.selectSort(sorting);

        Assert.assertTrue(inventoryPage.isDescendingPrices(inventoryPage.getItemsPricesList()));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
