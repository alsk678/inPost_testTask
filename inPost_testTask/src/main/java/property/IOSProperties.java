package property;

public class IOSProperties {
    static String targetFile = "ios.properties";
    public static String appiumServerUrl = PropertyReader.findProperty(targetFile, "appium.server.url");
    public static String iosDeviceName = PropertyReader.findProperty(targetFile, "ios.device.name");
    public static String iosPlatformName = PropertyReader.findProperty(targetFile, "ios.platform.version");
    public static String iosUDID = PropertyReader.findProperty(targetFile, "ios.udid");
    public static String iosNoReset = PropertyReader.findProperty(targetFile, "ios.no.reset");
    public static String iosAppPath = PropertyReader.findProperty(targetFile, "ios.app.path");
    public static int defaultTimeout = Integer.parseInt(PropertyReader.findProperty(targetFile, "default.timeout"));

}
