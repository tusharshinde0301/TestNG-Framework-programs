package testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class BuyProductTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
              
    }

    @Test
    public void buyProductTest() {
    
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("calculator");
        searchBox.submit();

        WebElement LinkTest = driver.findElement(By.linkText("Casio MJ-12D 150 Steps Check and Correct Desktop Calculator"));
        LinkTest.click();
        
        //Select Quantity=new Select(driver.findElement(By.cssSelector("#quantity")));
       // Quantity.selectByIndex(1);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));        
        addToCartButton.submit();

       //ebElement cartItem = driver.findElement(By.id("attach-sidesheet-checkout-button-announce"));
       //ssert.assertTrue(cartItem.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}




