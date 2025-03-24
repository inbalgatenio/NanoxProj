package TestDef;

import Infra.Logic.LoginActions;
import Infra.Logic.MainActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps extends BaseTest {

    LoginActions loginActions;

    public LoginSteps() throws IOException {
        super();
        loginActions = new LoginActions(driver);
        mainActions = new MainActions(driver);
    }

    @Given("I open the website with default browser")
    public void openWebsiteWithDefaultBrowser() {
        System.out.println("Opening website with default browser...");
    }

    @Given("I run the test on {string} browser")
    public void open_website_with_specific_browser(String browser) {
     //   setDriver(browser);
        loginActions = new LoginActions(driver);
        mainActions = new MainActions(driver);
        System.out.println("Running test on: " + browser);
    }

    @When("I login with username and password")
    public void user_enters_username_and_password() {
        loginActions.login(username, password);
    }

    @Then("Login alert message popup contains {string} message")
    public void alert_message_popup_with_right_message(String expectedMess) {
        String actualMess = loginActions.getLoginPopMessage();
        assertEquals(actualMess, expectedMess);
    }


}
