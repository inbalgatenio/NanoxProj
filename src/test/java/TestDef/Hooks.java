package TestDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = BaseTest.getDriver();
        System.out.println("Browser initialized.");
    }

    @After
    public void tearDown() {
        BaseTest.closeDriver();
        System.out.println("Browser closed.");
    }
}
