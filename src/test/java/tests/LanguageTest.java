package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LanguagePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LanguageTest extends BaseTest {
    @Test
    public void testLanguage() throws InterruptedException {

        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        homePage.tapHomeIcon();
        LanguagePage languagePage = new LanguagePage(getDriver());
        languagePage.selectLanguage("Español");//Espanol Français,English

    }

}
