package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;

import static driver.DriverManager.getDriver;

public class ClickHelper {

    public static void tapBottomCenter(WebElement element) {
        int[] coords = ElementUtils.getBottomCenterCoordinates(element);
        Sequence tap = TouchActionFactory.createTapSequence(coords[0], coords[1]);
        TouchActionFactory.performSequence(getDriver(), tap);
    }
}
