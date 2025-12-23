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
import java.util.ArrayList;

public class SocialLinksTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();

        driver.navigate().to("https://www.saucedemo.com/");

        String validUsername = excelReader.getStringData("Users", 1, 1);
        String validPassword = excelReader.getStringData("Users", 1, 2);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);

        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCanNavigateToTwitterClickingOnTwitterButtonTest() throws InterruptedException {

        inventoryPage.clickOnTwitterButton();
        Thread.sleep(1000);

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://x.com/saucelabs";
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test
    public void userCanNavigateToFacebookClickingOnFacebookButtonTest() throws InterruptedException {

        inventoryPage.clickOnFacebookButton();
        Thread.sleep(1000);

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/saucelabs";
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test
    public void userCanNavigateToLinkedInClickOnLinkedInButtonTest() throws InterruptedException {

        inventoryPage.clickOnLinkedInbutton();
        Thread.sleep(1000);

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
