package pages.POM;

import base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard extends CommonToAllPages {

    WebDriver driver;

    public DashBoard(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    public String dashboard()
    {
          String name= explicitWait(username,"gettext");
           return name;
    }






}
