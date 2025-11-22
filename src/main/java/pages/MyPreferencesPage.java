package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MyPreferencesPage extends BasePage {


    private final By preference = AppiumBy.accessibilityId("My preferences & intentions");
    private final By Identity= AppiumBy.accessibilityId("Update Identity");

    public MyPreferencesPage(AndroidDriver driver) {
        super(driver);
    }

    public  HomePage clickOnMyPreferences(){

       click(preference);
        return new HomePage(driver);
    }

    public void clickPreferenceByName(String preferenceName){

        click(AppiumBy.accessibilityId(preferenceName));
    }

    public void updateIdentity(){
        click(Identity);
    }

}
