package Zadanie3;

import Zadanie2.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestTwo {
    private static WebDriver driver;

    @org.junit.Test
    public void test2() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
        WebElement menClothes = driver.findElement(By.xpath("//*[@id='category-3']/*[@class='dropdown-item']"));
        menClothes.click();
        Test.takeSnapShot(driver, "C:\\Users\\zakrz\\IdeaProjects\\Praca_koncowaBZ\\PracaKoncowa_BZ\\src\\test\\java\\Zadanie3\\yo.png");
        driver.quit();
    }
}
