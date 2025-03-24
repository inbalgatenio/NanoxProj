package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends GeneralPage {

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement loginBtn;

    @FindBy(css = "#logInModal > div > div")
    private WebElement loginPopup;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Fill in the username field with the provided username
    public void enterUsername(String username) {
        waitForElement(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    // Fill in the password field with the provided password
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Click login button and wait for the form to appear
    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public String getLoginPopupMassage() {
        wait.until(ExpectedConditions.visibilityOf(loginPopup));
        return loginPopup.getText();
    }

}
