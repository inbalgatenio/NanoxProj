package Infra.Logic;

import Infra.Pages.CartPage;
import Infra.Pages.HomePage;
import Infra.Pages.MainPage;
import Infra.Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;


public class ProductsActions {

    private final MainPage mainPage;
    private final HomePage homePage;
    private final ProductPage productPage;
    private final CartPage cartPage;
    String productElem;
    Map<String, String> map;

    public ProductsActions(WebDriver driver) {
        this.mainPage = new MainPage(driver);
        this.homePage = new HomePage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.map = new HashMap<>();
    }

    public void OpenLaptopsPage(){
        OpenProductsGroupPage("Laptops");
    }

    public void OpenProductsGroupPage(String productGroup){
        mainPage.openHomePage();
        homePage.getProductGroupByName(productGroup).click();
    }

    public void addProductToCart(int i){
        WebElement prodElem = homePage.getProductFromList(i);
        productElem = prodElem.getText();
        prodElem.click();
        productPage.addToCart();
        productPage.clickOKOnAlert();

      //  cartPage.getCartProductDetails(i);
    }

    public void placeOrder(){
        mainPage.openCartPage();
        cartPage.clickPlaceOrderBtn();
        initialMap();
        cartPage.fillCustomerDetailsInPlaceOrderForm(map);
        cartPage.clickPurchaseBtn();
    }

    public void initialMap(){
        map.put("name", "testUser");
        map.put("country", "testcountry");
        map.put("city", "testcity");
        map.put("card", "testcard");
        map.put("month", "testmonth");
        map.put("year", "testyear");
    }

     public boolean checkOrderSuccess(){
        boolean IsMessage =  productPage.getPurchaseMessage().equals("Thank you for your purchase!");
        productPage.clickOkInPurchaseConfirmation();
        return IsMessage;
     }

}
