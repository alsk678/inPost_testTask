package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;

import static driver.DriverManager.getDriver;

public class SwipeHelper {

    private static final int MAX_SWIPE_ATTEMPTS = 5;

    public static void swipeToElement(WebElement element) {
        int attempts = 0;
        while (attempts < MAX_SWIPE_ATTEMPTS) {
            try {
                if (element.isDisplayed()) return;
            } catch (NoSuchElementException ignored) {}

            performSwipeUp();
            attempts++;
        }
        throw new NoSuchElementException("Element not found after " + MAX_SWIPE_ATTEMPTS + " swipes: ");
    }

    private static void performSwipeUp() {
        Dimension size = getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        Sequence swipe = TouchActionFactory.createSwipeSequence(startX, startY, startX, endY);
        TouchActionFactory.performSequence(getDriver(), swipe);
    }
}
