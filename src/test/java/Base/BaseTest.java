package Base;

import Pages.*;
import com.fasterxml.jackson.databind.JsonSerializable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public Base.ExcelReader excelReader;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public InventoryItems inventoryItems;
    public CartPage cartPage;
    public CheckoutStepOnePage checkoutStepOnePage;
    public CheckoutStepTwoPage checkoutStepTwoPage;
    public CheckOutCompletePage checkOutCompletePage;




    @BeforeClass
    public void setUp() throws IOException {

       WebDriverManager.firefoxdriver().setup();
       excelReader = new Base.ExcelReader("LoginUsers.xlsx");


    }





}
