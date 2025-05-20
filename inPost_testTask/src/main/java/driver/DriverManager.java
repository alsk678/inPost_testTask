package driver;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.Optional;

public final class DriverManager {
    private static final ThreadLocal<IOSDriver> driver = new ThreadLocal<>();
    private static final AppiumDriverFactory factory = new AppiumDriverFactory();

    public static IOSDriver getDriver() {
        return Optional.ofNullable(driver.get())
                .orElseGet(() -> {
                    try {
                        IOSDriver newDriver = factory.initializeDriver();
                        driver.set(newDriver);
                        return newDriver;
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Appium server URL is invalid", e);
                    }
                });
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
        driver.remove();
    }
}
