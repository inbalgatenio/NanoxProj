package Infra.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends GeneralPage{

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li")
    private List<WebElement> navbar;

    @FindBy(css = "#navbarExample > ul > li.nav-item.active > a")
    private WebElement homeBtn;

    @FindBy(id = "login2")
    private WebElement loginBtn;

    @FindBy(id = "logout2")
    private WebElement logoutBtn;

    @FindBy(css = "#navbarExample > ul > li:nth-child(4) > a")
    private WebElement cartBtn;

    @FindBy(id = "signin2")
    private WebElement signupBtn;

    @FindBy(css = "#navbarExample > ul > li:nth-child(2) > a")
    private WebElement contactBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        url = "https://www.demoblaze.com/";
    }

    public void clickHomeBtn(){
        clickBtn(homeBtn);
    }

    public void clickLoginBtn(){
        clickBtn(loginBtn);
    }

    public void clickSignupBtn(){
        clickBtn(signupBtn);
    }

    public void clickContactBtn(){
        clickBtn(contactBtn);
    }

    public void clickCartBtn(){
        clickBtn(cartBtn);
    }

    public boolean isLoginBtnDisplayed(){
        return isDisplayed(loginBtn);
    }

    public boolean isLogoutBtnDisplayed(){
        return isDisplayed(logoutBtn);
    }

    public WebElement getButtonFromNavbar(int i){
        return navbar.get(i);
    }

    public WebElement getLoginButtonFromNavbar(){
        return navbar.get(5);
    }

    public WebElement getSigninButtonFromNavbar(){
        return navbar.get(6);
    }

    // Open home form
    public void openHomePage() {
        OpenPage();
        clickHomeBtn();
    }

    // Open login form
    public void openLoginPage() {
        OpenPage();
        clickLoginBtn();
    }
    // Open signup form
    public void openCartPage(){
        OpenPage();
        clickCartBtn();
    }
        // Open signup form
        public void openSignupPage(){
            OpenPage();
            clickSignupBtn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    // Open login form
    public void openContactPage() {
        OpenPage();
        clickContactBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitToLogout(){
        this.waitForElement(logoutBtn);
    }
}
