package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 *
 */
public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl = "https://demo.nopcommerce.com/";

    public void openBrowser(String baseUrl) {
        //driver = new ChromeDriver();                    //To launch the URL
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);                            //To open the URL into Browser using Get method
        driver.manage().window().maximize();            //To maximise the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //We give implicit wait to driver
    }

    public void closeBrowser() {
        //To close all the open windows
        driver.quit();
    }
}
