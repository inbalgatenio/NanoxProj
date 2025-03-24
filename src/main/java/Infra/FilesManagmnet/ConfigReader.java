package Infra.FilesManagmnet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream
                ("src/test/resources/config.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getBrowserName() {
        return properties.getProperty("browserName");
    }
}
