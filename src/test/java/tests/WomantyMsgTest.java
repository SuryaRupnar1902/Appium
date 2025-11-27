package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.WomanityMsgPage;
import utils.ConfigReader;

public class WomantyMsgTest extends BaseTest {

   @Test
    public void WomantyMsgTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login(ConfigReader.get("usernameusername"),ConfigReader.get("password"));
        WomanityMsgPage WomanityPage= new WomanityMsgPage( getDriver());
        WomanityPage.clickOnWomanityMsg();
    }

}
