package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    private static AndroidDriver driver;

    private DriverManager() {
        // prevent instantiation
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void initDriver() {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName(ConfigReader.get("device.name"));
            options.setUdid(ConfigReader.get("device.udid"));
            options.setPlatformName(ConfigReader.get("platform.name"));
            options.setPlatformVersion(ConfigReader.get("platform.version"));
            options.setAutomationName("UIAutomator2");

            options.setAppPackage(ConfigReader.get("app.package"));
            options.setAppActivity(ConfigReader.get("app.activity"));
            options.setNoReset(true);
            options.setCapability("ignoreHiddenApiPolicyError", true);

            try {
                driver = new AndroidDriver(
                        new URL(ConfigReader.get("appium.server.url")),
                        options
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL", e);
            }

            int implicitWait = Integer.parseInt(ConfigReader.get("implicit.wait.seconds"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
