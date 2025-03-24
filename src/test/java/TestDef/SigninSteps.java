package TestDef;

import Infra.Logic.SigninActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class SigninSteps extends BaseTest {

    private final SigninActions signActions;

    public SigninSteps () throws IOException {
        super();
        signActions = new SigninActions(driver);
    }

    @When("I sign in with username {string} and password {string}")
    public void user_signin_with_enters_username_and_password(String userName, String password) {
        signActions.signin(userName, password);
    }

    @Then("I get error message popup contains {string} message")
    public void alert_message_popup_with_right_message(String expectedMess) {
        String equalsMess = signActions.getSigninPopMessage();
        assertEquals(expectedMess, equalsMess);
    }

    @Given("The {string} user doesn't exist in the system")
    public void theUser_oesnt_exist_in_the_system(String userName) {
        assertFalse(signActions.isUserExists(userName));
    }

    @Then("I don't get {string} message")
    public void dont_get_message(String expectedMess) {
        String equalsMess = signActions.getSigninPopMessage();
        assertNotEquals(equalsMess, expectedMess);
    }
}
