package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;
    Properties properties;

    public HomePage navigateToHome () {
        try {
            FileReader reader = new FileReader ("src/test/resources/testconfiguration.properties");

            properties = new Properties ();
            properties.load (reader);
        } catch (Exception e) {
            System.out.println ("Exception");
        }

        System.setProperty ("webdriver.chrome.driver", properties.getProperty ("driverPath"));
        driver = new ChromeDriver ();
        driver.manage ().timeouts ().implicitlyWait (30, TimeUnit.SECONDS);
        driver.get (properties.getProperty ("baseURL"));
        driver.manage ().window ().maximize ();
        return new HomePage ();
    }

    public static void scrollDown (String scrollValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("window.scrollBy(0," + scrollValue + ")");
    }

    public void closeBrowser () {
        driver.quit ();
    }
}
