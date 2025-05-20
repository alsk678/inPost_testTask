package driver;

import io.appium.java_client.ios.options.XCUITestOptions;

import java.time.Duration;

import static property.IOSProperties.defaultTimeout;
import static property.IOSProperties.iosAppPath;
import static property.IOSProperties.iosDeviceName;
import static property.IOSProperties.iosNoReset;
import static property.IOSProperties.iosPlatformName;
import static property.IOSProperties.iosUDID;

public class IOSCapabilitiesBuilder {

    public static XCUITestOptions build() {
        return new XCUITestOptions()
                .setDeviceName(iosDeviceName)
                .setPlatformVersion(iosPlatformName)
                .setAutomationName("XCUITest")
                .setUdid(iosUDID)
                .setApp(iosAppPath)
                .setNoReset(Boolean.parseBoolean(iosNoReset))
                .setCommandTimeouts(Duration.ofSeconds(defaultTimeout));
    }
}
