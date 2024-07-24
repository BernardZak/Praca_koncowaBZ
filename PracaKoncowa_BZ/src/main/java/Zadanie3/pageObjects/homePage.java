package Zadanie3.pageObjects;

import Zadanie2.pageObjects.productPage;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends BasePage {

    public homePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Name("Clothes button")
    @FindBy(xpath = "//*[@id='category-3']/*[@class='dropdown-item']")
    WebElement menClothes;

    @Name("Humming Bird Printed Sweater")
    @FindBy(css = ".product-miniature.js-product-miniature[data-id-product='2']")
    WebElement hummingbirdPrintedSweater;

    @Name("Return to homepage image")
    @FindBy(css = "img.logo")
    WebElement returnToHomePage;

    public homePage clickMenClothes() {
        menClothes.click();
        return this;
    }

    public homePage returnToHomPage(){
        returnToHomePage.click();
        return this;
    }

    public productPage goToHummingBirdSweater() {
        hummingbirdPrintedSweater.click();
        return new productPage(driver);
    }
}
