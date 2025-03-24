package Infra.Logic;

import Infra.Pages.LoginPage;
import Infra.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainActions {

    private final MainPage mainPage;

    public MainActions(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    // Check the login button text after login
    public String checkLoginButtonName() {
        mainPage.waitToLogout();
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.getLoginButtonFromNavbar()));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mainPage.getLoginButtonFromNavbar().getText();  // Return the button text
    }

    // Check the login button text after login
    public String checkSigninButtonName() {
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.getSigninButtonFromNavbar()));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mainPage.getSigninButtonFromNavbar().getText();  // Return the button text
    }
}
