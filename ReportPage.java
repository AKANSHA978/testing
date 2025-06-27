package Testfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ReportPage {
	
	WebDriver driver;
	
	@Test
	public void testreports() throws InterruptedException {
		
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://recpalapp.co.uk/");
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(30));
	
	driver.findElement(By.xpath("//button[normalize-space()='Admin Login']")).click(); 
	driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("merchant@gmail.com");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("merchant@123");
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    
	driver.findElement(By.xpath("//a[@href=\"/report\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@to=\"/StaffReport\"]")).click();
	driver.findElement(By.xpath("//button[@to=\"/ClientReport\"]")).click();
	driver.findElement(By.xpath("//button[@to='/BusinessUnitReport']")).click();
	driver.findElement(By.xpath("//button[@to='/InvoiceReport']")).click();
	driver.findElement(By.xpath("//button[@to='/DocumentReport']")).click();
	driver.findElement(By.xpath("//button[@to='/RateCardReport']")).click();
	
	
	
	
	
	
	
	
	
	}
	
	

}
