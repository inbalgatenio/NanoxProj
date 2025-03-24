package Infra.Logic;

import Infra.Pages.CartPage;
import Infra.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartActions {

    private CartPage cartPage;

    public CartActions(WebDriver driver){
        this.cartPage = new CartPage(driver);
    }

    public boolean verifyPlaceOrderIsNotDisplayed(){
        return cartPage.isPlaceOrderFormDisplayed();
    }
}
