package TestDef;

import Infra.Pages.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.AssertJUnit.assertFalse;

public class CartSteps extends BaseTest {

    CartPage cartPage;

    public CartSteps() throws IOException {
        super();
        cartPage = new CartPage(driver);
    }

    @Given("There are no products in the cart")
    public void there_are_no_products_in_the_cart() {
        cartPage.OpenPage();
        if(!cartPage.isProductListEmpty()) cartPage.deleteAllProducts();
    }

    @When("Click to Place Order")
    public void click_to_place_order() {
        cartPage.clickPlaceOrderBtn();
    }

    @Then("Verify Place order page is not triggered")
    public void place_order_page_should_not_be_triggered() {
        boolean isPlaceOrderFormDisplayed = cartPage.isPlaceOrderFormDisplayed();
        assertFalse("Expected the Place Order form to NOT be displayed, but it was displayed.",
                isPlaceOrderFormDisplayed);
    }

    @Then("The Place Order button should be disabled")
    public void place_order_button_should_be_disabled() {
        boolean isPlaceOrderBtnDisplayed = cartPage.isPlaceOrderBtnDisplayed();
        assertFalse("Expected the Place Order button to be disabled (not displayed), but it was enabled (displayed).",
                isPlaceOrderBtnDisplayed);
        cartPage.clickCloseBtn();
    }

    @Then("The Place Order button should not be clickable")
    public void place_order_button_should_no_be_clickable() {
        boolean isPlaceOrderBtnEnabled = cartPage.isPlaceOrderBtnEnabled();
        assertFalse("Expected the Place Order button to be disabled (not clickable), " +
                "but it was enabled (clickable).", isPlaceOrderBtnEnabled);
    }
}
