package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class DropdownsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testStandardDropdown() {
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdownElement);

        // Select by visible text
        select.selectByVisibleText("Purple");

        // Assert the selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Purple");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
