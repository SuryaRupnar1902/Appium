package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;
import base.BasePage;
import utils.ConfigReader;

import javax.security.auth.login.LoginContext;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void validLoginShouldNavigateToHome() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));
            Assert.assertTrue(homePage.isHomeIconDisplayed(),
                    "Home icon is not displayed. Login may have failed.");

        //homePage.tapHomeIcon();

        System.out.println("Login test completed successfully.");
    }
}
