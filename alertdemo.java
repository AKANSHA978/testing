package test;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	
		public class alertdemo {
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Set ChromeDriver path if needed
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demoqa.com/alerts");
	    }

	    @Test
	    public void testSimpleAlert() throws InterruptedException {
	        // Click the button to trigger alert
	        driver.findElement(By.id("alertButton")).click();

	        // Switch to the alert
	        Alert alert = driver.switchTo().alert();

	        // Get and verify alert text
	        String alertText = alert.getText();
	        System.out.println("Alert text: " + alertText);
	        Assert.assertEquals(alertText, "You clicked a button");

	        // Accept the alert
	        alert.accept();
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}



