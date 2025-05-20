package pageobject;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static property.IOSProperties.defaultTimeout;


public class BasePage {
    public AppiumDriver driver = DriverManager.getDriver();

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(defaultTimeout)), this);
    }
}
