package Testfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
		
public class netflix {
	public static void main (String[]args) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.netflix.com/in/");
		WebElement text= driver.findElement(By.xpath("(//*[name()='svg'][@class='default-ltr-cache-1d568uk ev1dnif2'])[1]"));
     System.out.println("it is" +text.isDisplayed());
     Thread.sleep(3000);
    WebElement lang= driver.findElement(By.xpath("//select[@id=':r1:']//option[@value='pt-IN'][normalize-space()='Português']"));
    Select sc= new Select(lang);
    sc.selectByVisibleText("हिन्दी");
  
   
		driver.close();
		
	}
}
