package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;


public class SingleBrowser {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is null! Initialize the browser before calling getDriver().");
        }
        return driver;
    }

    @Parameters("browser")
    public static void init(String browser) {
        browser = browser.toLowerCase();
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-gpu"); // Fix UI-related issues
                    chromeOptions.addArguments("--no-sandbox"); // Required when running as root
                    chromeOptions.addArguments("--disable-dev-shm-usage"); // Prevent memory issues
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("No browser fouund");
            }
        }

    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}




