package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
WebDriver driver;

@FindBy(xpath="//a[@href='#clientMenu']")
WebElement Clientsidebarbutton;

@FindBy(xpath="//a[@href='/client-list']")
WebElement Clientlist;

@FindBy(xpath="//button[normalize-space()='+ Add Client']")
WebElement addclient;

//formfill

@FindBy(xpath="(//input[@type='text'])[4]")
WebElement clientName;

@FindBy (xpath="//input[@autocomplete='new-email']")
WebElement emailfield;

@FindBy(xpath="//input[@id='job-2']")
WebElement jobcheckbox;

@FindBy(xpath="(//input[@type='text'])[5]")
WebElement phnnumber;

@FindBy(xpath="//input[@autocomplete='new-password']")
WebElement passwordfield;

@FindBy (xpath="(//input[@type='password'])[4]")
WebElement confirmpassword;

@FindBy (xpath="(//input[@type='text'])[6]")
WebElement Adress;

@FindBy(xpath="//button[normalize-space()='Add Client']")
WebElement addclientbutton;

public ClientPage (WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

public void addClient(String clname, String email,String phonnumber, String pass, String confrmpass , String Addr ) {
	Clientsidebarbutton.click();
	Clientlist.click();
	addclient.click();
	clientName.sendKeys(clname);
	emailfield.sendKeys(email);
	jobcheckbox.click();
	phnnumber.sendKeys(phonnumber);
	passwordfield.sendKeys(pass);
	confirmpassword.sendKeys(confrmpass);
	Adress.sendKeys(Addr);
	addclientbutton.click();
}



}
