package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class TouchActionFactory {

    private static final String FINGER_NAME = "finger";
    private static final PointerInput.Kind INPUT_KIND = PointerInput.Kind.TOUCH;
    private static final PointerInput.MouseButton BUTTON = PointerInput.MouseButton.LEFT;

    public static void performSequence(AppiumDriver driver, Sequence sequence) {
        driver.perform(Collections.singletonList(sequence));
    }

    public static Sequence createTapSequence(int x, int y) {
        return buildSequence(x, y, x, y, Duration.ZERO);
    }

    public static Sequence createSwipeSequence(int startX, int startY, int endX, int endY) {
        return buildSequence(startX, startY, endX, endY, Duration.ofMillis(500));
    }

    private static Sequence buildSequence(int startX, int startY, int endX, int endY, Duration moveDuration) {
        PointerInput finger = new PointerInput(INPUT_KIND, FINGER_NAME);
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(BUTTON.asArg()));
        sequence.addAction(finger.createPointerMove(moveDuration, PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(BUTTON.asArg()));
        return sequence;
    }
}
