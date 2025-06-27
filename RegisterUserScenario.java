package Testfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterUserScenario {
	
	public static void main (String[]args) {
		
	WebDriver driver= new ChromeDriver();
	
	driver.get("https://www.automationexercise.com/");
	
	driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	driver.findElement(By.xpath("(//input[@data-qa='signup-name'])[1]")).sendKeys("akku");
	driver.findElement(By.xpath("(//input[@data-qa='signup-email'])[1]")).sendKeys("akanshag@gmail.com");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ab@123");
    WebElement days=driver.findElement(By.xpath("//select[@id='days']"));
    Select sc=new Select(days);
    sc.selectByValue("2");;
		
    WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
    Select mnth=new Select(month);
    mnth.selectByValue("2");	
	
    WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
    Select yr=new Select(year);
    yr.selectByValue("2021");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//input[@name='newsletter']")).click();
    driver.findElement(By.xpath("//input[@name='optin']")).click();
    driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("akansha");
    driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("bidua");
    driver.findElement(By.xpath("//input[@name='company']")).sendKeys("pixotic");
    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("indre");
  WebElement country= driver.findElement(By.xpath("//select[@id='country']"));
    Select cn= new Select(country);
    cn.selectByValue("India");
    		
    driver.findElement(By.xpath("//input[@name='state']")).sendKeys("mp");
    driver.findElement(By.xpath("//input[@name='city']")).sendKeys("ind");
    driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("89689");
    driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys("8579470954");
    driver.findElement(By.xpath("//button[text()='Create Account']")).click();
    
    Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());
	}
}
