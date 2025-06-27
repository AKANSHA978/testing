package Testfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTest {
	public static void main(String[]args) throws InterruptedException
	{
WebDriver driver= new ChromeDriver();
driver.get("https://www.automationexercise.com/");
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("akansha");
driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("akansha7@gmail.com");
driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();


}
}