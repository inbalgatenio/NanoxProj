package Infra.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends GeneralPage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "recipient-email")
    private WebElement recipientEmail;

    @FindBy(id = "recipient-name")
    private WebElement recipientName;

    @FindBy(id = "message-text")
    private WebElement messageField;

    @FindBy(css = "#exampleModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement sendMessageBtn;


    // Fill in the RecipientName field
    public void enterRecipientEmail(String email) {
        waitForElement(recipientEmail);
        recipientEmail.clear();
        recipientEmail.sendKeys(email);
    }

    // Fill in the Recipient Name field with the provided password
    public void enterRecipientName(String name) {
        recipientName.clear();
        recipientName.sendKeys(name);
    }

    // Fill in the message
    public void enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
    }

    // Click send MessageBtn button
    public void clickSendMessageBtn() {
        clickBtn(sendMessageBtn);
    }

    public boolean isSendMessageButtonEnabled(){
        return sendMessageBtn.isEnabled();
    }

    public String getSendMassageAlert(){
        return getMessageFromAlert();
    }
}

