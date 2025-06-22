package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ClientTest {

    WebDriver driver;
    RecpalloginBase loginPage;
    ClientPage clientPage;

    @BeforeClass
    public void setup() {
        // Launch browser
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://recpalapp.co.uk/"); // Replace with actual URL

        // Initialize page objects
        loginPage = new RecpalloginBase(driver);
        clientPage = new ClientPage(driver);
    }

    @Test
    public void testAddClient() {
        // Perform login
        loginPage.login("merchant@gmail.com", "merchant@123");
        loginPage.buttonclick();

        // Add a new client
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        clientPage.addClient("Anshika", "anshika@gmail.com", "9898989898", "Anshika@123", "Anshika@123", "Indore");
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}


