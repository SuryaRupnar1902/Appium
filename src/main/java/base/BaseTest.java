package base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public abstract class BaseTest {
    protected AndroidDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver
        DriverManager.initDriver();
        driver = DriverManager.getDriver(); // now driver is initialized

        // Ensure logout before every test
        HomePage homePage = new HomePage(driver);
        homePage.ensureLoggedOut();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    protected AndroidDriver getDriver() {
        return DriverManager.getDriver();

    }
}
