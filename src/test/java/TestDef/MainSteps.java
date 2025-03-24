package TestDef;

import Infra.Logic.MainActions;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class MainSteps extends BaseTest {

    MainActions mainActions;

    public MainSteps() throws IOException {
        super();
        mainActions = new MainActions(driver);
    }

    @Then("The login button should change to {string}")
    public void verify_login_buttonName(String expected) {
        String actualButtonText = mainActions.checkLoginButtonName();
        assertEquals(expected, actualButtonText);
        assertNotEquals("Log in", actualButtonText);
    }

    @Then("The Sign in button should change to {string} username")
    public void verify_sign_buttonName(String expected) {
        String actualButtonText = mainActions.checkSigninButtonName();
        assertEquals(expected + " " + username, actualButtonText);
        assertNotEquals("Sign in", actualButtonText);
    }

}
