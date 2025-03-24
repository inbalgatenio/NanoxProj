package Infra.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {

    public WebDriverWait wait;
    protected WebDriver driver;
    protected String url;
    Alert alert;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initializes all the WebElements declared in the page class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // WebDriverWait for waiting elements to be visible or clickable
    }

    //Open page
    public void OpenPage() {
        driver.get(url);
    }

    //Click button
    public void clickBtn(WebElement element) {
        element.click();
    }

    //Check if button is displayed
    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    //Check if button is enabled
    public boolean isBtnEnabled(WebElement element){
        return element.isEnabled();
    }

    public String getButtonName(WebElement element){
        return element.getText();
    }

    // Helper method to wait for an element to be visible
    void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getMessageFromAlert(){
        alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
        return  alert.getText();
    }

    public void clickOKOnAlert(){
        alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
        alert.accept();
    }
}
