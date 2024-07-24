package Zadanie2.pageObjects;

import Zadanie3.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productPage extends BasePage {

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

    public productPage selectSize(String size) throws InterruptedException {
        dropdown.click();
        WebElement sizePage = BasePage.driver.findElement(By.cssSelector("option[title='" + size + "']"));
        Thread.sleep(500);
        sizePage.click();
        return this;
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
