package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends GeneralPage{

    @FindBy(css = "#tbodyid > div.row > div > a")
    private WebElement addToCartBtn;

    @FindBy(css = "#tbodyid > h3")
    private WebElement prodPrice;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > h2")
    private WebElement purchaseMessage;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    private WebElement purchaseOKMessage;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public String getProductPrice(){
        return prodPrice.getText().toLowerCase().replace("$", "");
    }

    public String getPurchaseMessage(){
        return purchaseMessage.getText();
    }

    public void clickOkInPurchaseConfirmation(){
        clickBtn(purchaseOKMessage);
    }
}
