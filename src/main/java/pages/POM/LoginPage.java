package pages.POM;

import base.CommonToAllPages;
import driver.SingleBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DataProperties;

import java.io.IOException;
import java.util.Map;


public class LoginPage extends CommonToAllPages {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By rmbcheckbox = By.xpath("//label[@class=\"checkbox-radio-label Mstart(10px)\"]/span[2]");
    private By signbtn = By.id("js-login-btn");

    /*------------------ActionOnPage-----------------------*/
    public void loginpage(Map<String, String> data) throws IOException {
        max();
        url("url");
        loadpage();
        input(username, data, "Username");
        input(password, data, "Password");
        try {
            explicitWait(rmbcheckbox,"click");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            click(signbtn);
        }


    }


}
