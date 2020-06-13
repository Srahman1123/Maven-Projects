package Day12_0517;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_TestNG {

WebDriver driver;
@BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
    driver = Reusable_Library.setDriver();

}//end of before suite

    @Test
    public void KayakTestCase() throws InterruptedException {
    driver.navigate().to("https://www.kayak.com");
    Thread.sleep(3000);
    //verify the tittle using hard assertion
       // Assert.assertEquals(driver.getTitle(),"Search Hotels, Cars");
        //using soft assertion
        SoftAssert softAss = new SoftAssert();
        softAss.assertEquals(driver.getTitle(),"Search Hotels, Cars ");
        //click on airport or city
        Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Field");
        //enter the airport
        Reusable_Library.userKeys(driver,"//*[@name='pickup']","JFK","Search Field");
        Thread.sleep(3000);
        //pass assertAll so that way it doesn't skip all your test steps
        softAss.assertAll();
    }//end of test

    @AfterSuite
    public void closeSession(){
    driver.quit();
    }//end of method

}//end of java class
