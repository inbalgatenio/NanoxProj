package Infra.Logic;

import Infra.Pages.LoginPage;
import Infra.Pages.MainPage;
import org.openqa.selenium.WebDriver;

public class LoginActions {

    private final LoginPage loginPage;
    private final MainPage mainPage;

    public LoginActions(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
    }

    // Login method
    public void login(String username, String password) {
        mainPage.openLoginPage();  // Navigate to login page
        loginPage.enterUsername(username);  // Enter username
        loginPage.enterPassword(password);  // Enter password
        loginPage.clickLoginBtn();  // Click login button
    }

    public String getLoginPopMessage(){
        return loginPage.getLoginPopupMassage();
    }
}
