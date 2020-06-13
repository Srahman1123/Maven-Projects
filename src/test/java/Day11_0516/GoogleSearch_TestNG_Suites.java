package Day11_0516;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearch_TestNG_Suites {

      //When using annotation method your local driver
     //Must be declared outside sp I can call it
    // On all my annotation method
   // WebDriver driver;

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }//end of AfterSuites



    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
     driver=Reusable_Library.setDriver();

    }//end of BeforeSuites

    WebDriver driver;
    String getUrl;

    @Test(priority = 1)
    public void searchIngoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keyword car on my search field
        Reusable_Library.userKeys(driver, "//*[@name='q'] ", "cars", "Search Field");

        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK'] ", "Google Search Button");
        Thread.sleep(2000);
        //capture the current url for search result page
        getUrl = driver.getCurrentUrl();


    }//end of test 1
    //when you use dependsonMethods in your @test that means your second test is dependant
    //on your first test if first test fails second test will be skipped
    //if all test has priorities they might or might not be dependant on each other

    //test priority 2
   @Test(dependsOnMethods = "searchIngoogle")
   public void captureTheResult()throws InterruptedException{
       driver.navigate().to(getUrl);
       Thread.sleep(2000);
       //capture text print out the search number
       String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']", "Search Result");


       //split the text and print the number
        String[] arraySearch = searchResult.split(" ");
        System.out.println("my search number " + arraySearch[1]);
       Reporter.log("my search number " + arraySearch[1]);

    }//end of test 2 priority


}//end of java class
