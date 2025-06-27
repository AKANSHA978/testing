package Testfile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product {
	public static void main(String[]args)
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://google.com");
WebElement entertext=	driver.findElement(By.name("q"));
	entertext.sendKeys("akansha"+Keys.ENTER);
		
		
	}

}
