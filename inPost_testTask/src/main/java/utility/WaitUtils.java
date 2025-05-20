package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;
import static property.IOSProperties.defaultTimeout;

public class WaitUtils {

    public static WebElement waitForElementToBeVisible(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(defaultTimeout))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
