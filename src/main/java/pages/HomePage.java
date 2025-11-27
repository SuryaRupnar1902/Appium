package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Your "Womunity" image before it
    private final By homeIcon = AppiumBy.xpath("//android.view.View[@content-desc='Womunity']/preceding-sibling::android.widget.ImageView");
    private final By myIdentityButton = AppiumBy.xpath("//android.widget.Button[@content-desc=\"My Identity\"]");
    private final By logoutButton= AppiumBy.xpath("//android.view.View[@content-desc=\"Logout\"]");
    private final By logout=AppiumBy.xpath("//android.widget.Button[@content-desc=\"Logout\"]");


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
    public boolean isHomeIconDisplayed() {
        return driver.findElement(homeIcon).isDisplayed();
    }
    // Check if logout option is visible
    public void ensureLoggedOut() {
        try {
            tapHomeIcon();              // show menu where logout button appears
            if (isLogoutVisible()) {    // if logout exists
                tapLogout();
                click(logout);// click logout
            }
        } catch (Exception e) {
            // Do nothing — means already logged out or home menu not needed
        }}
        public boolean isLogoutVisible() {
            return isElementDisplayed(logoutButton);
        }
    public LoginPage tapLogout() {
        click(logoutButton);
        return new LoginPage(driver);
    }

}
