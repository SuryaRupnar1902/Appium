package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.WomanityMsgPage;

public class WomantyMsgTest extends BaseTest {

   @Test
    public void WomantyMsgTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login("mitali@mailinator.com", "Pass@1234");
        WomanityMsgPage WomanityPage= new WomanityMsgPage( getDriver());
        WomanityPage.clickOnWomanityMsg();
    }

}
