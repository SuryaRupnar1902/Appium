package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailField = AppiumBy.xpath("(//android.widget.EditText)[1]");
    private final By passwordField = AppiumBy.xpath("(//android.widget.EditText)[2]");
    private final By loginButton = AppiumBy.accessibilityId("Log In");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        type(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public HomePage tapLogin() {
        click(loginButton);
        return new HomePage(driver);
    }

    public HomePage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        driver.hideKeyboard();
        return tapLogin();
    }

}
