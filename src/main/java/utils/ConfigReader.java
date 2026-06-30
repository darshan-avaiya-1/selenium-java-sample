package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config\\config.properties";

        try (FileInputStream fileInputStream = new FileInputStream(configFilePath)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while loading configuration : ", e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("base.url");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("wait.implicit"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("wait.explicit"));
    }

}
