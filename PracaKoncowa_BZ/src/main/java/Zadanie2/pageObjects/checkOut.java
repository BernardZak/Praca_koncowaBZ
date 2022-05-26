package Zadanie2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOut {
    private WebDriver driver;

    public checkOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='custom-radio'] span")
    WebElement address;

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    WebElement confirmAddress;

    @FindBy(xpath = "//div[@class='delivery-options']//div[1]//div[1]//span[1]//span[1]")
    WebElement prestaShopDelivery;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    WebElement confirmDelivery;

    @FindBy(id = "payment-option-1")
    WebElement payByCheck;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement acceptTerms;

    @FindBy(xpath = "//button[normalize-space()='Order with an obligation to pay']")
    WebElement orderProduct;

    public void chooseAddress(){
        address.click();
        confirmAddress.click();
    }

    public void chooseDelivery(){
        prestaShopDelivery.click();
        confirmDelivery.click();
    }

    public void choosePayment(){
        payByCheck.click();
        acceptTerms.click();
    }

    public void finishOrder(){
        orderProduct.click();
    }
}
