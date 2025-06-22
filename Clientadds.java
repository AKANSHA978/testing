package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Clientadds {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shivangi bidua\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://recpalapp.co.uk/");
		
		 WebElement adminLoginButton = driver.findElement(By.xpath("//button[contains(.,'Admin Login')]"));
		 adminLoginButton.click();
        
		 driver.findElement(By.id("inputEmail")).sendKeys("merchant@gmail.com");
		 driver.findElement(By.id("inputPassword")).sendKeys("merchant@123");
		 WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		 loginbutton.click();
		 Thread.sleep(2000);
		 
		 WebElement clientbutton = driver.findElement(By.xpath("(//a[@href='#clientMenu'])[1]"));
		 clientbutton.click();
		 driver.findElement(By.xpath("//a[@href='/client-list']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@class='btn btn-lg text-nowrap']")).click();
		Thread.sleep(3000);
		 WebElement	name = driver.findElement(By.xpath(("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")));
		 name.sendKeys("shreyansh");
				 WebElement email= driver.findElement(By.xpath("//input[@autocomplete='new-email']"));
		 email.sendKeys("shreyansh@gmail.com");
		 WebElement checkbox= driver.findElement(By.xpath("(//input[@id='job-9'])[1]"));
		 checkbox.click();
				 WebElement	phone= driver.findElement(By.xpath(("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/input[1]")));
				 phone.sendKeys("96888896695");	
				 WebElement	password= driver.findElement(By.xpath("//input[@autocomplete='new-password']"));
				 password.sendKeys("Shreyansh@123");
						 WebElement	confrmpassword= driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/input[1]"));
		 confrmpassword.sendKeys("Shreyansh@123");
		 Thread.sleep(2000);
		 WebElement address = driver.findElement(By.xpath("//div[4]//div[2]//div[1]//div[2]//input[1]"));
	address.sendKeys("abcindore");
	  driver.findElement(By.xpath("//button[normalize-space()='Add Client']")).click();
	
	
	
	
	}

}
