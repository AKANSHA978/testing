package test;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickAboutsSidebar {
    public static void main(String[] args) throws InterruptedException {
    	
    	ChromeOptions options = new ChromeOptions();

    	// Disable Chrome password manager popup
    	options.addArguments("--disable-save-password-bubble");
    	options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
    	    put("credentials_enable_service", false);
    	    put("profile.password_manager_enabled", false);
    	}});

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        

        // Step 1: Open SauceDemo
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 2: Click on menu (sidebar)
        Thread.sleep(1000); // wait for page to load
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Step 3: Wait for menu animation
        Thread.sleep(1000);

        // Step 4: Click "About"
        WebElement aboutBtn = driver.findElement(By.id("about_sidebar_link"));
        aboutBtn.click();

        // Done – it should open https://saucelabs.com/
    }
}

