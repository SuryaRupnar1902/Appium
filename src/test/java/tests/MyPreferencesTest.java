package tests;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyPreferencesPage;

public class MyPreferencesTest extends BaseTest {

    //public MyPreferencesTest() {}


    @Test
    public void myPreferencesTest(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login("mitali@mailinator.com", "Pass@1234");
        homePage.tapHomeIcon();
        // 2. Navigate to "My Identity"
        MyPreferencesPage preferencesPage = new MyPreferencesPage(getDriver());
        preferencesPage.clickOnMyPreferences();

        preferencesPage.clickPreferenceByName("Mom/Child Outing");
        preferencesPage.clickPreferenceByName("Chatting Over Coffee");
        preferencesPage.clickPreferenceByName("Connect & Talk Online");

        preferencesPage.updateIdentity();
        System.out.println("My preference updated successfully");
    }
}
