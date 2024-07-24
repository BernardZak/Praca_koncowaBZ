package Zadanie3;

import Zadanie2.Test;
import Zadanie2.pageObjects.productPage;
import Zadanie3.pageObjects.homePage;
import org.openqa.selenium.support.PageFactory;


public class TestTwo extends TestBase {
    productPage productpage = new productPage(driver);

    @org.junit.Test
    public void test2() throws Exception {
        new homePage(driver).clickMenClothes()
                            .returnToHomPage()
                            .goToHummingBirdSweater();
        new productPage(driver).selectSize("L");
        Test.takeSnapShot(TestBase.driver, "C:\\Users\\zakrz\\IdeaProjects\\Praca_koncowaBZ\\PracaKoncowa_BZ\\src\\test\\java\\Zadanie3\\yo.png");
        TestBase.driver.quit();
    }
}
