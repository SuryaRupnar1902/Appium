package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.MobileActions;

public class MyIdentityPage extends BasePage {

    // bio is the last EditText on the screen
    private final By bioField = AppiumBy.xpath("//android.widget.EditText[last()]");
    private final By updateIdentityButton = AppiumBy.accessibilityId("Update Identity");

    public MyIdentityPage(AndroidDriver driver) {
        super(driver);
    }

    public MyIdentityPage scrollToBio() {
        // one scroll for now – can change to scrollUntilVisible if needed
        MobileActions.scrollDownOnce(driver);
        return this;
    }

    public MyIdentityPage enterBio(String bioText) {
        WebElement bio = waitForVisible(bioField);
        bio.click();
        bio.clear();
        bio.sendKeys(bioText);
        driver.hideKeyboard();
        return this;
    }

    public MyIdentityPage updateBio(String bioText) {
        scrollToBio();
        enterBio(bioText);
        click(updateIdentityButton);
        return this;
    }
}
