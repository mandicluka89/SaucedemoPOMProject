package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutStepOnePage;
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

public class ShoppingCartTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp()  {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutStepOnePage = new CheckoutStepOnePage();

    }

    @Test(priority = 1)
    public void singleItemIsAddedToShoppingCartOnInventoryPageTest() throws InterruptedException{

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        int ActualCountStart = inventoryPage.countingCart();
        int StartCount = 0;
        Assert.assertEquals(ActualCountStart,StartCount);

        Thread.sleep(1000);
        inventoryPage.addingItemToCart(0);

        int ActualCountAfter = inventoryPage.countingCart();
        int AfterAddingCount = 1;
        Thread.sleep(1000);
        Assert.assertEquals(ActualCountAfter,AfterAddingCount);
    }

    @Test(priority = 2)
    public void multipleItemsAreAddedToShoppingCartOnInventoryPageTest() throws InterruptedException {

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        int ActualCountStart = inventoryPage.countingCart();
        int StartCount = 0;
        Assert.assertEquals(ActualCountStart,StartCount);

        Thread.sleep(1000);
        inventoryPage.addingItemToCart(0);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        int ActualCountAfter = inventoryPage.countingCart();
        int AfterAddingCount = 3;
        Assert.assertEquals(ActualCountAfter,AfterAddingCount);

    }


    @Test(priority = 3)
    public void multipleItemsAreAddedToShoppingCartAndVisibleOnCartPageTest() {

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        inventoryPage.addingItemToCart(0);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        inventoryPage.shoppingCartIcon.click();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));

        int ItemsInCart = cartPage.countingCart();
        int ItemsLinkVisible = cartPage.ListOfItemsInCart.size();

        Assert.assertEquals(ItemsInCart,ItemsLinkVisible);
    }

    @Test (priority = 4)
    public void itemsAreRemovedFromShoppingCartOnInventoryPageTest() {

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        inventoryPage.addingItemToCart(1);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        inventoryPage.removingItemFromCart();

        int ActualCount = inventoryPage.countingCart();
        int AfterRemovingCount = 0;
        Assert.assertEquals(ActualCount,AfterRemovingCount);

    }

    @Test (priority = 5)
    public void itemsAreRemovedFromShoppingCartOnCartPageTest() throws InterruptedException {

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        inventoryPage.addingItemToCart(1);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        inventoryPage.shoppingCartIcon.click();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));

        int ActualCountBeforeRemoving = cartPage.countingCart();
        int ExpectedCountBeforeRemoving = 3;

        Assert.assertEquals(ActualCountBeforeRemoving,ExpectedCountBeforeRemoving);
        Thread.sleep(1000);

        cartPage.removingItemFromCart();

        int ActualCount = cartPage.countingCart();
        int AfterRemovingCount = 0;
        Assert.assertEquals(ActualCount,AfterRemovingCount);

    }

    @Test (priority = 6)
    public void continueShoppingButtonFunctionalityTest(){

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        inventoryPage.addingItemToCart(1);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        inventoryPage.shoppingCartIcon.click();

        cartPage.clickOnContinueShoppingButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        int expectedCounter = Integer.parseInt(inventoryPage.shoppingCartCounter.getFirst().getText());
        int actualCounter = inventoryPage.countingCart();

        Assert.assertEquals(actualCounter,expectedCounter);

    }

    @Test (priority = 7)
    public void userCanProceedToCheckoutTest(){

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        inventoryPage.addingItemToCart(1);
        inventoryPage.addingItemToCart(2);
        inventoryPage.addingItemToCart(5);

        inventoryPage.shoppingCartIcon.click();

        cartPage.clickOnCheckoutButton();

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(checkoutStepOnePage.cancelButton.isDisplayed());

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
