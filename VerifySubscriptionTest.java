package Testfile;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VerifySubscriptionTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

  
    
    @Test
    public void testCase8_verifyAllProductsAndProductDetails() {
        driver.get("https://automationexercise.com");

        // Step 3: Verify home page
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        // Step 4: Click on 'Products'
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // Step 5: Verify navigation to 'ALL PRODUCTS'
        WebElement allProductsTitle = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(allProductsTitle.isDisplayed(), "'All Products' title not visible");

        // Step 6: Verify product list is visible
        WebElement productList = driver.findElement(By.className("features_items"));
        Assert.assertTrue(productList.isDisplayed(), "Product list is not visible");

        // Step 7: Click 'View Product' on first product
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();

        // Step 8: Verify landing on product detail page
        WebElement productInfo = driver.findElement(By.className("product-information"));
        Assert.assertTrue(productInfo.isDisplayed(), "Product detail section not visible");

        // Step 9: Verify all required product details
        Assert.assertTrue(productInfo.getText().contains("Category"), "Category not visible");
        Assert.assertTrue(productInfo.getText().toLowerCase().contains("availability"), "Availability not visible");
        Assert.assertTrue(productInfo.getText().toLowerCase().contains("condition"), "Condition not visible");
        Assert.assertTrue(productInfo.getText().toLowerCase().contains("brand"), "Brand not visible");

        WebElement price = driver.findElement(By.xpath("//span[@itemprop='price']"));
        Assert.assertTrue(price.isDisplayed(), "Price not visible");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
