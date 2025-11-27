package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import base.BaseTest;

public class LanguagePage extends BasePage {

   private final By Language= AppiumBy.xpath("//android.widget.Button[@content-desc=\"Languages\"]");
    private final String languageOption = "//android.widget.ImageView[@content-desc='%s']";
    private final By confirmButton=AppiumBy.xpath("//android.widget.Button[@content-desc=\"Confirm\"]");



    public LanguagePage(AndroidDriver driver) { super(driver);
    }

    public  void  selectLanguage(String language) {

        clickLanguageButton();
        String finalXpath = String.format(languageOption, language);
        waitForVisible(By.xpath(finalXpath));
        driver.findElement(AppiumBy.xpath(finalXpath)).click();
        click(confirmButton);


    }

   public void clickLanguageButton(){
      click(Language);
   }
    }

