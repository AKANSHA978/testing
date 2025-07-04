package test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkChecker {
    public static void main(String[] args) {
        // Set the ChromeDriver path
     //   System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // URL to test
        String testUrl = "https://the-internet.herokuapp.com/status_codes";
        driver.get(testUrl);

        // Find all <a> tag links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total hyperlinks found: " + links.size());

        // Loop through each link and check status
        for (WebElement element : links) {
            String url = element.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("Link URL is either null or empty.");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(" Broken link: " + url + " --> Response Code: " + responseCode);
                } else {
                    System.out.println(" Valid link: " + url + " --> Response Code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println(" Error in link: " + url + " --> " + e.getMessage());
            }
        }

        driver.quit();
    }
}
