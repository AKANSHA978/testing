//import org.openqa.selenium.Alert;
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class demosQa {
    public static void main(String[] args) throws InterruptedException {
        // Optional: Set this if chromedriver is not in PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

         
            // Open DemoQA homepage
            driver.get("https://demoqa.com/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Wait a bit for page to load
            Thread.sleep(2000);
          WebElement e=  driver.findElement(By.xpath("//div[@class='card mt-4 top-card']//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']\r\n"
          		+ ""));
            e.click();
            
       
    }
    
    
    
  

}