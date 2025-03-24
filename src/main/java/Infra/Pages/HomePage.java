package Infra.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends GeneralPage{

    @FindBy(css = "#itemc")
    private List <WebElement> products;

    @FindBy(css = "#tbodyid > div:nth-child")
    private List <WebElement> Laptops;

    @FindBy(xpath = "//*[@id='tbodyid']/div")
    private List <WebElement> ProductsList;



    MainPage mainPage;
    public HomePage(WebDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
    }

    public List<WebElement> getListGroup(){
         return products;
    }

   public WebElement getProductGroup(int i){
        return products.get(i);
   }

   public WebElement getProductGroupByName(String name) {
       for (WebElement element : products) {
           if (element.getText().contains(name)) {
               element.click();
               return element;
           }
       }
           System.out.println("Can't find element " + name);
           return null;
       }

       public WebElement getProductFromList(int i){
           return ProductsList.get(i);

       }


   public boolean isEmptyListProductGroup(){
        return products.isEmpty();
   }
}
