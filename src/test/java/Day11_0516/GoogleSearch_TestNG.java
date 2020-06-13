package Day11_0516;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleSearch_TestNG {

    //When using annotation method your local driver
    //Must be declared outside sp I can call it
    //On all my annotation method
    WebDriver driver;
    ArrayList<String> cars = new ArrayList();
    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException {
     driver=Reusable_Library.setDriver();

     driver.navigate().to("https://www.google.com");
    }//end of BeforeMethod

    @AfterMethod
    public void quitDriver(){

        driver.quit();
    }//end of AfterClass

    @Test

    public void googleSearch() throws InterruptedException {

            //enter keyword car on my search field
            Reusable_Library.userKeys(driver, "//*[@name='q'] ", "cars", "Search Field");

            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK'] ", "Google Search Button");
            Thread.sleep(2000);

            //capture text print out the search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");


            //split the text and print the number

            String[] arraySearch = searchResult.split(" ");
            System.out.println("my search number " + arraySearch[1]);


    }//end of google test


}//end of java class
