package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void validLoginShouldNavigateToHome() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login("mitali@mailinator.com", "Pass@1234");


        homePage.tapHomeIcon();

        System.out.println("Login test completed successfully.");
    }
}
