package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WomanityMsgPage extends BasePage {

    private final By WomanityMsg= AppiumBy.xpath("//android.view.View[@clickable='true'][@index='2']");
    public WomanityMsgPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnWomanityMsg(){
        click(WomanityMsg);
    }
}
