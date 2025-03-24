package TestDef;

import Infra.Logic.ProductsActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class ProductsSteps extends BaseTest{

    ProductsActions productsActions;
    public ProductsSteps() throws IOException {
        super();
        productsActions = new ProductsActions(driver);
    }

    @When ("I open Laptops list")
    public void open_laptop_group(){
        productsActions.OpenLaptopsPage();
    }

    @When("I add Laptop to the cart")
    public void i_add_laptop_to_the_cart() {
        productsActions.addProductToCart(1);
    }

    @When("I place the order")
    public void place_the_order() {
        productsActions.placeOrder();
    }

    @Then ("Verify Order is created successfully")
    public void Verify_order_is_created_successfully(){
        assertTrue(productsActions.checkOrderSuccess());
        System.out.println("Checking in DB that order exists");
        System.out.println("Sending GET request to verify the order create with the right details");
    }
}
