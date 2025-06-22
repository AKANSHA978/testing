package test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class h {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shivangi bidua\\Downloads\\chromedriver-win64\\chromedriver.exe"); // Update path

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");

            // Close ad if present
            try {
                WebElement closeAd = driver.findElement(By.id("close-fixedban"));
                if (closeAd.isDisplayed()) closeAd.click();
            } catch (Exception ignored) {}

            // Fill in form details
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Doe");
            driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
            WebElement genderMale = driver.findElement(By.xpath("//label[text()='Male']"));
            js.executeScript("arguments[0].click();", genderMale);

            driver.findElement(By.id("userNumber")).sendKeys("9876543210");

            // Set Date of Birth
            WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
            dobInput.click();

            // Select year
            WebElement yearSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));
            yearSelect.findElement(By.xpath(".//option[text()='1990']")).click();

            // Select month
            WebElement monthSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));
            monthSelect.findElement(By.xpath(".//option[text()='May']")).click();

            // Select day
            WebElement day15 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'react-datepicker__day') and text()='15' and not(contains(@class,'outside-month'))]")));

            // Fallback to JS click if regular click fails
            try {
                day15.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", day15);
            }
            // Subjects (with wait for suggestions)
            WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
            subjectInput.sendKeys("Computer Science");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__menu")));
            subjectInput.sendKeys(Keys.ENTER);

            // Select Hobbies
            driver.findElement(By.xpath("//label[text()='Sports']")).click();
            driver.findElement(By.xpath("//label[text()='Reading']")).click();

            // Upload Picture
            File imageFile = new File("C:\\Users\\shivangi bidua\\OneDrive\\Pictures\\Screenshots\\Screenshot (134).png"); // Update path
            driver.findElement(By.id("uploadPicture")).sendKeys(imageFile.getAbsolutePath());

            // Address
            driver.findElement(By.id("currentAddress")).sendKeys("123 Main St, Springfield");

            // Scroll to and select State
            WebElement state = driver.findElement(By.id("state"));
            js.executeScript("arguments[0].scrollIntoView(true);", state);
            state.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-3-option-0')]"))).click();

            // Select City
            WebElement city = driver.findElement(By.id("city"));
            city.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-4-option-0')]"))).click();

            // Submit form
            driver.findElement(By.id("submit")).click();

            // Confirmation
            WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
            if ("Thanks for submitting the form".equals(modalTitle.getText())) {
                System.out.println("✅ Form submitted successfully!");
            } else {
                System.out.println("❌ Submission may have failed.");
            }

            // Optional: Wait to view result
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Ensures full browser session is closed
        }
    }
}
