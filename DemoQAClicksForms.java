package test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAClicksForms {
    public static void main(String[] args) {
        // Optional: Set this if chromedriver is not in PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open DemoQA homepage
            driver.get("https://demoqa.com/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Wait a bit for page to load
            Thread.sleep(2000);

            // Scroll down slightly (if needed) to make "Forms" visible
            // You can use JavaScriptExecutor if needed, but usually not required

            // Locate the "Forms" card and click it
            WebElement formsCard = driver.findElement(By.xpath("//h5[text()='Forms']/ancestor::div[contains(@class,'card')]"));
            formsCard.click();

            // Wait to observe the click action
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


