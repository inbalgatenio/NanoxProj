package Infra.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SigninPage extends GeneralPage {

    @FindBy(id = "sign-username")
    private WebElement signUsernameInput;

    @FindBy(id = "sign-password")
    private WebElement signPasswordInput;

    @FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(),'Sign up')]")
    private WebElement signinButton;

    @FindBy(css = ".modal-body")
    private WebElement signPopup;

    public SigninPage(WebDriver driver) {
        super(driver);
        url = "https://www.demoblaze.com/";
    }


    // Fill in the username field with the provided username
    public void enterSingUsername(String username) {
        waitForElement(signUsernameInput);
        signUsernameInput.clear();
        signUsernameInput.sendKeys(username);
    }

    // Fill in the password field with the provided password
    public void enterSingPassword(String password) {
        signPasswordInput.clear();
        signPasswordInput.sendKeys(password);
    }

    // Click login button and wait for the form to appear
    public void clickSingBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signinButton));
        signinButton.click();
    }


    public String getSignPopupMassage() {
        // Wait for the alert to appear and accept it
        alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
        return alert.getText();
    }
}
