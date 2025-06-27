package Testfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTest
{
    WebDriver driver;
    storeSignup storesignup;
    
    @BeforeClass
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/"); // Replace with actual URL

        
        storesignup = new storeSignup(driver);
    }
	@Test
	
	public void storetest()
	{
		storesignup.Signup("akansha", "akansh76");
	}
	
	 @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
}
	
	
	

