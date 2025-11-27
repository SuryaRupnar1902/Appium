package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import pages.MyIdentityPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MyIdentityTest extends BaseTest {

    @Test
    public void updateBioSuccessfully() {
        // 1. Login
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        // 2. Navigate to "My Identity"
        homePage.tapHomeIcon();
        MyIdentityPage myIdentityPage = homePage.goToMyIdentity();

        // 3. Update bio
        myIdentityPage.updateBio("testing purpose");
    }
}
