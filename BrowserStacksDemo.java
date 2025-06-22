package test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.Test; 

public class BrowserStacksDemo { 

   WebDriver driver;  

   @Test

   public void verifyTitle() {

         driver= new ChromeDriver();

         driver.get("https://www.browserstack.com/");

       Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
       if (driver.getTitle().equals("Most Reliable App & Cross Browser Testing Platform | BrowserStack")) {
    	    System.out.println("pass");
    	} else {
    	    System.out.println("failure detected");
    	}
         driver.quit();

   }

}