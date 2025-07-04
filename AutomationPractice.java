package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractice {
	public static void main (String[]args) throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://recpalapp.co.uk/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Admin Login']")).click();
		driver.findElement(By.id("inputEmail")).sendKeys("merchants@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("passwordsss@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/shift-list']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='btn btn-lg text-white']")).click();
		WebElement dropdown= driver.findElement(By.id("selectClients"));
		Select drp = new Select(dropdown);
		drp.selectByValue("57");
		Thread.sleep(3000);
		WebElement dropdown2= driver.findElement(By.id("selectBusinessUnit"));
		Select drp2 = new Select(dropdown2);
		drp2.selectByValue("65");
		WebElement jobtitle= driver.findElement(By.id("selectJobTitle"));
		Select title = new Select(jobtitle);
		title.selectByValue("7");
		driver.findElement(By.xpath("//input[@type='date']")).click();
		Thread.sleep(3000);
		WebElement starttime= driver.findElement(By.id("selectShiftStart"));
		Select stime = new Select(starttime);
		stime.selectByValue("03:00 AM");
		WebElement endtime= driver.findElement(By.id("selectShiftEnd"));
		Select etime = new Select(endtime);
		etime.selectByIndex(5);
		driver.findElement(By.xpath("//div[@class='col-12 input-container']//input[@type='text']")).sendKeys("10");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("4");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("8");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("4");
		WebElement t= driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		Select s= new Select(t);
		s.selectByValue("25");
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("4");
		driver.findElement(By.xpath("//input{@class='form-control']")).sendKeys("test");
		//click on add shift 
		driver.findElement(By.xpath("//button[normalize-space()='Add Shift']")).click();
		
		
	}

}
