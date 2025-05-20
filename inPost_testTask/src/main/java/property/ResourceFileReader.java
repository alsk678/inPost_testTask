package property;

import java.io.InputStream;

public class ResourceFileReader {

    public static InputStream getResourceInputStream(String resourceName) {
        return ResourceFileReader.class.getClassLoader().getResourceAsStream(resourceName);
    }
}
