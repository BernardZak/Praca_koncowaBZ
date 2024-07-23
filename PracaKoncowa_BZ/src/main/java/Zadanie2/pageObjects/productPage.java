package Zadanie2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productPage {
    private WebDriver driver;

    public productPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement dropdown;

    @FindBy(id = "quantity_wanted")
    WebElement number;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = "a[class='btn btn-primary']")
    WebElement proceedToCheckoutButton;


    public void selectSize(String size) {
        dropdown.click();
        WebElement sizePage = driver.findElement(By.cssSelector("option[title='" + size + "']"));
        sizePage.click();
    }

    public void selectQuantity(String selectedQuantity) {
        number.clear();
        number.sendKeys(selectedQuantity);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
