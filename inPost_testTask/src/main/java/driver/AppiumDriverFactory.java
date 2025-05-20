package driver;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import static property.IOSProperties.appiumServerUrl;
import static property.IOSProperties.defaultTimeout;

public class AppiumDriverFactory {

    public IOSDriver initializeDriver() throws MalformedURLException {
        IOSDriver driver = new IOSDriver(URI.create(appiumServerUrl).toURL(), IOSCapabilitiesBuilder.build());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeout));
        return driver;
    }
}
