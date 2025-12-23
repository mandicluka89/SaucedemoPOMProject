package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTests extends BaseTest {

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
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();

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

    }

    @Test (priority = 1)
    public void userCanProceedToCheckoutSecondStepWithValidCredentialsTest(){

        String validFirstname = excelReader.getStringData("CheckOut",1,1);
        String validLastname = excelReader.getStringData("CheckOut",1,2);
        String validPostalCode = excelReader.getStringData("CheckOut",1,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        double actualSummaryOfPrice = Double.parseDouble(checkoutStepTwoPage.summaryPriceOfItems.getText().replace("Item total: $",""));
        double expectedSummaryOfPrice = checkoutStepTwoPage.summaryOfPrices();

        Assert.assertEquals(actualSummaryOfPrice,expectedSummaryOfPrice);

    }
    @Test (priority = 2)
    public void userCanNotProceedToCheckoutSecondStepWithoutFirstNameTest(){

        String emptyFirstname = excelReader.getStringData("CheckOut",4,1);
        String validLastname = excelReader.getStringData("CheckOut",4,2);
        String validPostalCode = excelReader.getStringData("CheckOut",4,0);

        checkoutStepOnePage.inputFirstname(emptyFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        String expectedErrorMessage = "Error: First Name is required";
        String actualErrorMessage = checkoutStepOnePage.errorMessage.getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test (priority = 3)
    public void UserCanNotProceedToCheckoutSecondStepWithoutLastNameTest(){

        String validFirstname = excelReader.getStringData("CheckOut",3,1);
        String emptyLastname = excelReader.getStringData("CheckOut",3,2);
        String validPostalCode = excelReader.getStringData("CheckOut",3,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(emptyLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        String expectedErrorMessage = "Error: Last Name is required";
        String actualErrorMessage = checkoutStepOnePage.errorMessage.getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test (priority = 4)
    public void userCanNotProceedToCheckoutSecondStepWithoutPostalCodeTest(){

        String validFirstname = excelReader.getStringData("CheckOut",2,1);
        String validLastname = excelReader.getStringData("CheckOut",2,2);
        String emptyPostalCode = excelReader.getStringData("CheckOut",2,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(emptyPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        String expectedErrorMessage = "Error: Postal Code is required";
        String actualErrorMessage = checkoutStepOnePage.errorMessage.getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test (priority = 5)
    public void userCanNotProceedToCheckoutSecondStepWithEmptyCredentialsTest(){

        String emptyFirstname = excelReader.getStringData("CheckOut",5,1);
        String emptyLastname = excelReader.getStringData("CheckOut",5,2);
        String emptyPostalCode = excelReader.getStringData("CheckOut",5,0);

        checkoutStepOnePage.inputFirstname(emptyFirstname);
        checkoutStepOnePage.inputLastname(emptyLastname);
        checkoutStepOnePage.inputPostalCode(emptyPostalCode);

        checkoutStepOnePage.clickOnContinueButton();

        Assert.assertTrue(checkoutStepOnePage.errorMessage.isDisplayed());

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @Test (priority = 6)
    public void userCanCancelFromCheckoutTwoPageAndContinueShoppingTest(){

        String validFirstname = excelReader.getStringData("CheckOut",1,1);
        String validLastname = excelReader.getStringData("CheckOut",1,2);
        String validPostalCode = excelReader.getStringData("CheckOut",1,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.clickOnCancelButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        int ActualCount = inventoryPage.countingCart();
        int AfterCancelCount = 3;
        Assert.assertEquals(ActualCount,AfterCancelCount);
    }

    @Test (priority = 7)
    public void UserCanFinishCheckoutClickingOnFinishButtonTest(){

        String validFirstname = excelReader.getStringData("CheckOut",1,1);
        String validLastname = excelReader.getStringData("CheckOut",1,2);
        String validPostalCode = excelReader.getStringData("CheckOut",1,0);

        checkoutStepOnePage.inputFirstname(validFirstname);
        checkoutStepOnePage.inputLastname(validLastname);
        checkoutStepOnePage.inputPostalCode(validPostalCode);

        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.clickOnFinishButton();

        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Assert.assertTrue(checkOutCompletePage.backToProductsButton.isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
