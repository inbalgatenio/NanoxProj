package Infra.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class CartPage extends GeneralPage {

    @FindBy(className = "success")
    private List<WebElement> products;

    @FindBy(className = "modal-content")
    private List<WebElement> placeOrderForm;

    @FindBy(css = "#page-wrapper > div > div.col-lg-1 > button")
    private WebElement placeOrderBtn;

    @FindBy(css = "#orderModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement purchaseBtn;

    @FindBy(className = "close")
    private WebElement close;

    public CartPage(WebDriver driver) {
        super(driver);
        url = "https://www.demoblaze.com/cart.html";
    }

    public void clickPlaceOrderBtn() {
        clickBtn(placeOrderBtn);
    }

    public void clickCloseBtn() {
        clickBtn(close);
    }

    public void clickPurchaseBtn() {
        clickBtn(purchaseBtn);
    }

    public boolean isPlaceOrderBtnEnabled() {
        return isBtnEnabled(placeOrderBtn);
    }

    public boolean isPlaceOrderBtnDisplayed() {
        return isDisplayed(placeOrderBtn);
    }

    public boolean isPlaceOrderFormDisplayed() {
        return placeOrderForm.isEmpty();
    }

    public boolean isProductListEmpty() {
        return products.isEmpty();
    }

    public void deleteAllProducts() {
        for (WebElement element : products) {
            element.findElement(By.tagName("a")).click();
        }
    }

        public void fillCustomerDetailsInPlaceOrderForm(Map<String, String> detailsMap){
            for (java.util.Map.Entry<String, String> entry : detailsMap.entrySet()) {
                driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }

}
