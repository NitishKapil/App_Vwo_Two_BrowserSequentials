package driver;


import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
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




