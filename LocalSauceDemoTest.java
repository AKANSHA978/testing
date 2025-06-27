package Testfile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;


public class LocalSauceDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
     //   WebDriver.chromedriver().setup(); // optional if you're using WebDriverManager
        driver = new ChromeDriver();             // ✅ correct assignment to class-level driver
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void verifyTitle() {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Swag Labs"), "Title does not match!");
    }

    @Test(priority = 2, groups = {"regression"}, dataProvider = "loginData")
    public void loginTest(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        boolean success = driver.findElements(By.className("inventory_item")).size() > 0;
        Assert.assertTrue(success, "Login failed for user: " + username);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"problem_user", "secret_sauce3"}
        };
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
