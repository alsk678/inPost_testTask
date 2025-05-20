package property;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import static listener.TestListener.logger;

public class PropertyReader {

    private PropertyReader() {
    }

    private static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = ResourceFileReader.getResourceInputStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                logger.error("Property file doesn't exist. Probably run started from CI");
            }
        } catch (IOException e) {
            logger.error("Error loading properties file", e);
        }
        return properties;
    }

    public static String findProperty(String targetFile, String... keys) {
        for (String key : keys) {
            logger.info("Starting search of the requested property: <{}>", key);
            String envVariable = System.getenv(key);
            Properties properties = getProperties(targetFile);
            String property = properties.getProperty(key);
            if (property != null) {
                logger.info("Found property in properties file: <{}> with value <{}>", key, property);
                return property;
            }
            if (envVariable != null) {
                logger.info("Found property in environment variables: <{}> with value <{}>", key, envVariable);
                return envVariable;
            }
        }
        logger.error("Cannot find variable in range: {}. Set default value: 'false'", Arrays.toString(keys));
        return "false";
    }
}
