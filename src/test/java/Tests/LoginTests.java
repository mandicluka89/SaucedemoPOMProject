package Tests;

import Base.BaseTest;
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

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp()  {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();

        driver.navigate().to("https://www.saucedemo.com/");

    }

    @Test (priority = 1)
    public void userCanLoginWithValidCredentialsTest(){

        String validUsername = excelReader.getStringData("Users",1,1);
        String validPassword = excelReader.getStringData("Users",1,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        Assert.assertEquals(actualUrl,expectedUrl);
        Assert.assertTrue(inventoryPage.shoppingCartIcon.isDisplayed());

    }

    @Test (priority = 2)
    public void userCanNotLoginWithInvalidUsernameTest(){

        String invalidUsername = excelReader.getStringData("Users",2,1);
        String validPassword = excelReader.getStringData("Users",2,2);

        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(actualUrl,expectedUrl);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test (priority = 3)
    public void userCanNotLoginWithInvalidPasswordTest(){

        String validUsername = excelReader.getStringData("Users",4,1);
        String invalidPassword = excelReader.getStringData("Users",4,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);

        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(actualUrl,expectedUrl);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test (priority = 4)
    public void userCanNotLoginWithOutUsernameTest (){

        String emptyUsername = excelReader.getStringData("Users",3,1);
        String validPassword = excelReader.getStringData("Users",3,2);

        loginPage.inputUsername(emptyUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(actualUrl,expectedUrl);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test (priority = 5)
    public void userCanNotLoginWithOutPasswordTest(){

        String validUsername = excelReader.getStringData("Users",5,1);
        String emptyPassword = excelReader.getStringData("Users",5,2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(emptyPassword);

        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(actualUrl,expectedUrl);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
