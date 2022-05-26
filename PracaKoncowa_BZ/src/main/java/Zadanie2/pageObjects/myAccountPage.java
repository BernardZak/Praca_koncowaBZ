package Zadanie2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
    private WebDriver driver;

    public myAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[class='form-control']")
    WebElement usernameloginPage;

    @FindBy(css = "input[name='password']")
    WebElement passwordloginPage;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @FindBy(css = "img[alt='PrestaShop']")
    WebElement tohomePage;

    public void signIn(String user, String password){
        usernameloginPage.clear();
        passwordloginPage.clear();
        usernameloginPage.sendKeys(user);
        passwordloginPage.sendKeys(password);
        signInButton.click();
    }

    public void returnToHomePage(){
        tohomePage.click();
    }
}
