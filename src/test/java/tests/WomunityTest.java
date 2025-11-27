package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.WomanityMsgPage;

import static base.DriverManager.getDriver;

public class WomunityTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void validLoginShouldNavigateToHome() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login("mitali@mailinator.com", "Pass@1234");
        WomanityMsgPage womunity= new WomanityMsgPage( getDriver());
        womunity.printVisibleCategories();
        Thread.sleep(2000);
        womunity.loadNextCategory();
        Thread.sleep(2000);
        womunity.printAllCategories();
        Thread.sleep(2000);    }
}
