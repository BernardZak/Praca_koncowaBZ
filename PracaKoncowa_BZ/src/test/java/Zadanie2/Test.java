package Zadanie2;

import Zadanie2.pageObjects.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Test {
    WebDriver driver;


    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileHandler.copy(SrcFile, DestFile);

    }



    @org.junit.Test
    public void test1() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
        homePage homepage = new homePage(driver);
        homepage.clicksignIn();
        myAccountPage myaccountpage = new myAccountPage(driver);
        myaccountpage.signIn("hnzduyspsosqumujeh@bvhrk.com","TestUser");
        myaccountpage.returnToHomePage();
        homepage.selectHummingbirdProduct();
        productPage productpage = new productPage(driver);
        productpage.selectSize("L");
        productpage.selectQuantity("5");
        productpage.addToCart();
        Thread.sleep(500);
        productpage.proceedToCheckout();
        shoppingCart shoppingcart = new shoppingCart(driver);
        shoppingcart.proceedToCheckout();
        checkOut checkout = new checkOut(driver);
        checkout.chooseAddress();
        checkout.chooseDelivery();
        checkout.choosePayment();
        checkout.finishOrder();
        takeSnapShot(driver,"C:\\Users\\berna\\Desktop\\Coderslab\\PracaKoncowa_BZ\\src\\test\\java\\Zadanie2\\screen.png");
    }
}
