package test;

import base.CommonToAllTest;
import driver.SingleBrowser;
import org.testng.annotations.Test;
import pages.POM.DashBoard;
import pages.POM.LoginPage;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Map;



public class testcasepositive extends CommonToAllTest {


    @Test(dataProvider = "exceldata", dataProviderClass = ExcelReader.class)
    public void loginvalid(Map<String, String> data) throws IOException {

        LoginPage loginPage = new LoginPage(SingleBrowser.getDriver());
        loginPage.loginpage(data);
        DashBoard dashBoard = new DashBoard(SingleBrowser.getDriver());
        String username=dashBoard.dashboard();
        System.out.println(username);

    }


}
