package TestDef;

import Infra.Logic.ContactActions;
import Infra.Logic.LoginActions;
import Infra.Logic.MainActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ContactSteps extends BaseTest{

    ContactActions contactActions;

    public ContactSteps() throws IOException {
        super();
        contactActions = new ContactActions(driver);
    }

    @When("I send message in Contact Form without to fill the email address field")
    public void i_send_message_in_contact_form_without_to_fill_the_email_address_field() {
        contactActions.fillGetContactFields("", "Contact name",
                "Please call me, I need your help");
    }

    @Then("The Send message button should not be Clickable and enabled")
    public void the_send_message_button_should_not_be_clickable_and_enabled() {
        assertTrue( "Send Message button is enables, it should be disabled",
                contactActions.verifySendMessageButtonIsNotEnabled());
    }

    @Then("Verify message wasn't sent")
    public void verify_message_wasnt_send() {
        String actual = contactActions.getConfirmationMessageSent();
        assertNotEquals("The Message was sent and confirmation message appears"
                , "Thanks for the message!!",actual);
    }
}
