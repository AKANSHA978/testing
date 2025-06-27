package Testfile;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EbayTest {
	 public static void main (String[]args) throws InterruptedException {
	 ChromeOptions options= new ChromeOptions();
	 options.addArguments("--incognito");
		 
		 
	 WebDriver driver =new ChromeDriver(options);
	 driver.get("https://www.ebay.com/");
	 driver.manage().window().maximize();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,800)");
	 Thread.sleep(3000);
  WebElement element=   driver.findElement(By.xpath("(//div[@class='vl-cta__default evo'][normalize-space()='Shop now'])[5]"));
	Actions actions= new Actions(driver);
	actions.moveToElement(element).click().build().perform();
	
	
	
	}

}
