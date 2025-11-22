package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileActions {

    // Scroll down once
    public static void scrollDownOnce(AndroidDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Dimension size = driver.manage().window().getSize();

        int left = 0;
        int top = (int) (size.getHeight() * 0.2);
        int width = size.getWidth();
        int height = (int) (size.getHeight() * 0.6);

        Map<String, Object> params = new HashMap<>();
        params.put("left", left);
        params.put("top", top);
        params.put("width", width);
        params.put("height", height);
        params.put("direction", "down");
        params.put("percent", 0.8);

        js.executeScript("mobile: scrollGesture", params);
    }

    // Scroll multiple times until element is visible
    public static WebElement scrollUntilVisible(AndroidDriver driver, String xpath, int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> elements = driver.findElements(AppiumBy.xpath(xpath));

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                return elements.get(0);
            }
            scrollDownOnce(driver);
        }
        throw new RuntimeException("Element not found after scrolling: " + xpath);
    }
}
