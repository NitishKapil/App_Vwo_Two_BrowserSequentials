package base;


import driver.SingleBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class CommonToAllTest {


    @BeforeMethod
    @Parameters("browser")
    public void strt(String browser) {

        SingleBrowser.init(browser);
    }

    @AfterMethod
    public void teardown() {

        SingleBrowser.down();

    }
}
