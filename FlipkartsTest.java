package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

public class FlipkartsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\shivangi bidua\\Downloads\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void flipkartAddToCartTest() {
        driver.get("https://www.flipkart.com");

        // Close login popup if present
        try {
            WebElement closeBtn = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }

        // Search for iPhone
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        // Click first product
        WebElement firstProduct = driver.findElement(By.cssSelector("div._1AtVbE:nth-child(3) a"));
        firstProduct.click();

        // Switch to new tab
    //    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    //    driver.switchTo().window(tabs.get(1));

        // Click add to cart
        WebElement addToCart = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCart.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
