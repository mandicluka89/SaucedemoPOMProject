package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutStepOnePage = new CheckoutStepOnePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();

        driver.navigate().to("https://www.saucedemo.com/");

        String validUsername = excelReader.getStringData("Users", 1, 1);
        String validPassword = excelReader.getStringData("Users", 1, 2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

    }

    @Test
    public void userCanLogOutFromInventoryPageTest() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", inventoryPage.logoutLink);

        inventoryPage.loggingOut();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLogOutFromCartPageTest() throws InterruptedException {

        inventoryPage.shoppingCartIcon.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cartPage.logoutLink);

        cartPage.loggingOut();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLogOutFromCheckoutStepOnePageTest() throws InterruptedException {

        inventoryPage.shoppingCartIcon.click();
        cartPage.clickOnCheckoutButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkoutStepOnePage.logoutLink);

        checkoutStepOnePage.loggingOut();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLogOutFromCheckoutStepTwoPageTest() throws InterruptedException {

        inventoryPage.shoppingCartIcon.click();
        cartPage.clickOnCheckoutButton();

        String validFirstname = excelReader.getStringData("CheckOut",1,1);
        String validLastname = excelReader.getStringData("CheckOut",1,2);
        String validPostalCode = excelReader.getStringData("CheckOut",1,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkoutStepTwoPage.logoutLink);

        checkoutStepTwoPage.loggingOut();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLogOutFromCheckoutCompletePageTest() throws InterruptedException {

        inventoryPage.shoppingCartIcon.click();
        cartPage.clickOnCheckoutButton();

        String validFirstname = excelReader.getStringData("CheckOut",1,1);
        String validLastname = excelReader.getStringData("CheckOut",1,2);
        String validPostalCode = excelReader.getStringData("CheckOut",1,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.clickOnFinishButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkOutCompletePage.logoutLink);

        checkOutCompletePage.loggingOut();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
