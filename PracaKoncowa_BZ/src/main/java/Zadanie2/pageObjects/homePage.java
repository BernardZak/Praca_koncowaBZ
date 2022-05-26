package Zadanie2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Log in to your customer account']")
    WebElement signInButton;

    @FindBy(css = ".product-miniature.js-product-miniature[data-id-product='2']")
    WebElement hummingbirdPrintedSweater;




    public void clicksignIn(){
        signInButton.click();
    }

    public void selectHummingbirdProduct(){
        hummingbirdPrintedSweater.click();
    }


}
