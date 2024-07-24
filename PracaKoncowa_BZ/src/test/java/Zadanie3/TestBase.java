package Zadanie3;

import Zadanie2.pageObjects.productPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
//    private String a = System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    protected static WebDriver driver;

    @Before
    public void setUpBeforeTestCase() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.manage().window().maximize();
    }

    @After
    public void tearDownAfterTestCase() {
        driver.quit();
    }
}
