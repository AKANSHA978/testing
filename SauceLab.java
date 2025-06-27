package Testfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceLab {
	public static void main (String[] args)
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	//addto cart 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("akansha");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("bidua");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("458909");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
	WebElement abc=	driver.findElement(By.xpath("//div[text()='Payment Information:']"));
	System.out.println(abc.isDisplayed());
	driver.findElement(By.xpath("//button[@id='finish']")).click();
	WebElement verify=	driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
	System.out.print(verify.isDisplayed());
	driver.close();
     
		
		
	}
}
