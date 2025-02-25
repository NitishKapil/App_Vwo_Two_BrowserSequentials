package base;

import driver.SingleBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataProperties;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import static driver.SingleBrowser.getDriver;

public class CommonToAllPages {


    public void max() {
        getDriver().manage().window().maximize();
    }

    public void url(String url) throws IOException {
        getDriver().get(DataProperties.dataReader(url));
    }

    public void loadpage() {
        WebDriverWait wait =
                new WebDriverWait(getDriver(), Duration.ofSeconds(5000));
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        System.out.println("Page Fully loaded");
    }

    public void input(By by, Map<String, String> dataval, String username) {

        getDriver().findElement(by).sendKeys(dataval.get(username));
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public String explicitWait(By by,String action) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

        if(action.equalsIgnoreCase("click"))
        {
            element.click();
            return null;
        } else if(action.equalsIgnoreCase("gettext"))
        {
            return element.getText();
        }else {
            throw new IllegalArgumentException("Invalid action: " + action);

        }


    }



}
