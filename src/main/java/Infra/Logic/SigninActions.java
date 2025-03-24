package Infra.Logic;

import Infra.Pages.MainPage;
import Infra.Pages.SigninPage;
import org.openqa.selenium.WebDriver;

public class SigninActions {

    SigninPage signinPage;
    MainPage mainPage;

    public SigninActions(WebDriver driver) {
        this.signinPage = new SigninPage(driver);
        this.mainPage = new MainPage(driver);
    }

    // Sign in
    public void signin(String username, String password) {
        mainPage.openSignupPage();  // Navigate to login page
        signinPage.enterSingUsername(username);  // Enter username
        signinPage.enterSingPassword(password);  // Enter password
        signinPage.clickSingBtn();  // Click login button
    }

    public String getSigninPopMessage(){
        return signinPage.getMessageFromAlert();
    }

    public Boolean isUserExists(String userName){
        System.out.println("Sending GET request to users with the user name to check if exists");
        return false;
    }
}
