package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.*;

public class WomanityMsgPage extends BasePage {

    private final By WomanityMsg= AppiumBy.xpath("//android.view.View[@clickable='true'][@index='2']");
    private final By categoryItems = By.xpath("//android.widget.ImageView[\n" +
            "   @content-desc='Mom/Child Outing' or\n" +
            "   @content-desc='Chatting Over Coffee' or\n" +
            "   @content-desc='Shared Interests & Fun' or\n" +
            "   @content-desc='Connect & Talk Online' or\n" +
            "   @content-desc='Support & Advice Exchange' or\n" +
            "   @content-desc='Trips & Retreats For Moms'\n" +
            "]\n");
    private final By categoryContainer = By.xpath("//android.widget.ScrollView/android.view.View");


    public WomanityMsgPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnWomanityMsg(){
        click(WomanityMsg);
    }
    public void printVisibleCategories() {
        List<WebElement> categories = driver.findElements(categoryItems);

        System.out.println("Visible Categories Count: " + categories.size());

        for (WebElement category : categories) {
            System.out.println("Category: " + category.getAttribute("content-desc"));
        }
    }
    public void scrollCategoriesRight() {
        WebElement categoryList = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View"));

        int centerY = categoryList.getLocation().getY() + (categoryList.getSize().getHeight() / 2);

        int startX = (int) (categoryList.getLocation().getX() + categoryList.getSize().getWidth() * 0.80); // RIGHT side
        int endX   = (int) (categoryList.getLocation().getX() + categoryList.getSize().getWidth() * 0.20); // LEFT side

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }


    public void loadNextCategory() {
        scrollCategoriesRight();
    }
    public void printAllCategories() {

        Set<String> categories = new LinkedHashSet<>();

        By categoryLocator = By.xpath("//android.widget.ScrollView//android.widget.ImageView");

        int maxScrolls = 6;   // enough to reveal all items

        for (int i = 0; i < maxScrolls; i++) {

            List<WebElement> visible = driver.findElements(categoryLocator);

            for (WebElement e : visible) {
                String name = e.getAttribute("content-desc");

                if (name != null
                        && !name.contains("Student")
                        && !name.trim().isEmpty())
                {
                    categories.add(name.trim());
                }
            }

            // scroll right for next batch
            scrollCategoriesRight();
        }

        System.out.println("------ ALL CATEGORIES ------");
        for (String c : categories) {
            System.out.println(c);
        }
        System.out.println("Total Categories: " + categories.size());
    }

}






