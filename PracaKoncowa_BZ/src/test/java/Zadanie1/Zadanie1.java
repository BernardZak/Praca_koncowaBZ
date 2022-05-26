package Zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie1 {
    private WebDriver driver;

    @Given("user logged on store")
    public void signInMyStore() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
        WebElement signInButton = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        signInButton.click();
        WebElement email = driver.findElement(By.cssSelector("input[class='form-control']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        if (email.isEnabled()) {
            email.clear();
            email.sendKeys("hnzduyspsosqumujeh@bvhrk.com");
        }
        if (password.isEnabled()) {
            password.clear();
            password.sendKeys("TestUser");
        }
        WebElement signIn = driver.findElement(By.id("submit-login"));
        signIn.click();
    }

    @And("choose option to change address")
    public void changeAddress() throws InterruptedException {
        WebElement Addresses = driver.findElement(By.id("addresses-link"));
        Addresses.click();
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[href='https://mystore-testlab.coderslab.pl/index.php?controller=address']"));
        createNewAddress.click();
    }

    @When("^fills and submit New Address form: (.*),(.*),(.*),(.*),(.*),(.*)")
    public void fillForm(String Alias, String Address, String City, String PostalCode, String Country, String Phone) {
        WebElement alias = driver.findElement(By.cssSelector("input[name='alias']"));
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement address = driver.findElement(By.cssSelector("input[name='address1']"));
        WebElement city = driver.findElement(By.cssSelector("input[name='city']"));
        WebElement postalCode = driver.findElement(By.cssSelector("input[name='postcode']"));
        WebElement country = driver.findElement(By.cssSelector("input[name='postcode']"));
        WebElement phone = driver.findElement(By.cssSelector("input[name='phone']"));
        WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn btn-primary float-xs-right']"));
        alias.clear();
        alias.sendKeys(Alias);
        address.clear();
        address.sendKeys(Address);
        city.clear();
        city.sendKeys(City);
        postalCode.clear();
        postalCode.sendKeys(PostalCode);
        phone.clear();
        phone.sendKeys(Phone);
        country.click();
        saveButton.click();
    }

    @Then("^New Address is added: (.*),(.*),(.*),(.*),(.*),(.*)")
    public void checkData(String Alias, String Address, String City, String PostalCode, String Country, String Phone) {
        WebElement addedAddress = driver.findElement(By.xpath("//article//div[contains(.,'"+Alias+"')]"));
        String firstName = "Marian";
        String lastName = "Kapusta";
        addedAddress.getText();
        String realAddress = Alias + "\n" + firstName + " " + lastName + "\n" + Address + "\n" + City + "\n" + PostalCode + "\n" + Country + "\n" + Phone;
        if (addedAddress.getText().equals(realAddress)) {
            System.out.println("Address is created correctly");
        } else {
            System.out.println("Something goes wrong");
        }
    }


    @And("quit site")
    public void quitSite() {
        driver.quit();
    }


}



