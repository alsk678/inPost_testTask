package helpers;

import org.openqa.selenium.WebElement;

public class ElementUtils {

    public static int[] getBottomCenterCoordinates(WebElement element) {
        int startX = element.getLocation().getX();
        int startY = element.getLocation().getY();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        int centerX = startX + width / 2;
        int bottomY = startY + height - 1;
        return new int[]{centerX, bottomY};
    }
}
