package tests;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyPreferencesPage;
import utils.ConfigReader;

public class MyPreferencesTest extends BaseTest {

    //public MyPreferencesTest() {}


    @Test
    public void myPreferencesTest(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));
        homePage.tapHomeIcon();
        // 2. Navigate to "My Identity"
        MyPreferencesPage preferencesPage = new MyPreferencesPage(getDriver());
        preferencesPage.clickOnMyPreferences();

        preferencesPage.clickPreferenceByName("Mom/Child Outing");
        preferencesPage.clickPreferenceByName("Chatting Over Coffee");
        preferencesPage.clickPreferenceByName("Connect & Talk Online");
//        preferencesPage.clickPreferenceByName("Shared Interests & Fun");
//        preferencesPage.clickPreferenceByName("Support & Advice Exchange");
//        preferencesPage.clickPreferenceByName("Trips & Retreats For Moms");


        preferencesPage.updateIdentity();
        System.out.println("My preference updated successfully");
    }
}
