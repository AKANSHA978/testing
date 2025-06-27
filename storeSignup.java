package Testfile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class storeSignup {
	WebDriver driver;

	public storeSignup(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements( driver,this);
	}
		
		
		@FindBy(id="signin2")
		WebElement Signin;
		
		@FindBy(xpath="//input[@id='sign-username']")
		WebElement usernamee;
		
		@FindBy(xpath="//input[@id='sign-password']")
		WebElement passwords;
		
		@FindBy(xpath="//button[@onclick='register()']")
		WebElement signupbutton;
		
		@FindBy(xpath="(//button[@type='button'][normalize-space()='Close'])[1]")
		WebElement closebutton;
		
		public void Signup(String username, String password)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Signin.click();	
		usernamee.sendKeys(username);
		passwords.sendKeys(password);
		signupbutton.click();
		closebutton.click();	
		
		}

}
