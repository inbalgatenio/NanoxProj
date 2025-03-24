package Infra.Logic;

import Infra.Pages.ContactPage;
import Infra.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactActions {

    ContactPage contactPage;
    MainPage mainPage;

    public ContactActions(WebDriver driver) {
        contactPage = new ContactPage(driver);
        mainPage = new MainPage(driver);
    }

    public void fillGetContactFields(String email, String name, String message) {
        mainPage.openContactPage();
        contactPage.enterRecipientEmail(email);
        contactPage.enterRecipientName(name);
        contactPage.enterMessage(message);
    }

    public void sendMessage(String email, String name, String message){
        fillGetContactFields(email, name, message);
        contactPage.clickSendMessageBtn();
    }

    public boolean verifySendMessageButtonIsNotEnabled(){
        contactPage.clickSendMessageBtn();
        return !contactPage.isSendMessageButtonEnabled();
    }

    public String getConfirmationMessageSent(){
        contactPage.clickSendMessageBtn();
        contactPage.wait.until(ExpectedConditions.alertIsPresent());
        return  contactPage.getSendMassageAlert();
    }
}
