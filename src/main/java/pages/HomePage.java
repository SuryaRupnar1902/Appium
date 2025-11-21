package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Your "Womunity" image before it
    private final By homeIcon = AppiumBy.xpath("//android.view.View[@content-desc='Womunity']/preceding-sibling::android.widget.ImageView");
    private final By myIdentityButton = AppiumBy.xpath("//android.widget.Button[@content-desc=\"My Identity\"]");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage tapHomeIcon() {
        click(homeIcon);
        return this;
    }

    public MyIdentityPage goToMyIdentity() {
        click(myIdentityButton);
        return new MyIdentityPage(driver);
    }
}
