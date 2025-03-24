package TestDef;

import Infra.DriverManagment.DriverManger;
import Infra.FilesManagmnet.ConfigReader;
import Infra.Logic.MainActions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseTest {

    protected static WebDriver driver;
    protected static String browserName;
    protected final String username;
    protected final String password;

    MainActions mainActions;

    public BaseTest() throws IOException {
        ConfigReader configReader = new ConfigReader();
        this.username = configReader.getUsername();
        this.password = configReader.getPassword();
        browserName = configReader.getBrowserName();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverManger.initDriver(System.getProperty("browser", "chrome"));  // Default to Chrome
        }
        return driver;
    }

    public static WebDriver setDriver(String browser) {
            driver = DriverManger.initDriver(browser);  // Default to Chrome
        return driver;
    }

        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
}