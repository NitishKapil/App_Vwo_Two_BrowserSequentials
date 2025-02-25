package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Objects;

public class ParallelBrowser {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @Test
    @Parameters("browser")
    public  void main1(String browser) throws InterruptedException {
        init(browser);
        Thread.sleep(4000);
        down();
    }


    public  WebDriver getDriver() {
        return driver.get();
    }

    public void setup(WebDriver driver1) {
        driver.set(driver1);
    }

    public  void move() {
        driver.remove();
    }
@Parameters("browser")
    public  void init(String browser) {
        browser = browser.toLowerCase();
        if (Objects.isNull(getDriver())) {
            WebDriver localdriver =null;
            if (browser.equalsIgnoreCase("chrome")) {
                 localdriver = new ChromeDriver();


            } else if (browser.equalsIgnoreCase("firefox")) {

                 localdriver = new FirefoxDriver();


            }
            setup(localdriver);
        }
    }
public void down()
{
    if(Objects.nonNull(getDriver()))
    {
        getDriver().quit();
        move();
    }
}

}
