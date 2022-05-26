package Zadanie2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shoppingCart {
    private WebDriver driver;

    public shoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='btn btn-primary']")
    WebElement proceedToCheckoutButton;

    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
