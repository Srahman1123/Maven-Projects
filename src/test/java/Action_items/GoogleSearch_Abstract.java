package Action_items;

import Reusable_Classes.Abstract_Class_Parameter;
import Reusable_Classes.Reusable_Library_loggers;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleSearch_Abstract extends Abstract_Class_Parameter {

    //When using annotation method your local driver
    //Must be declared outside sp I can call it
    //On all my annotation method




    @Test

    public void googleSearch() throws InterruptedException {
        ArrayList<String> cars = new ArrayList();
        driver.navigate().to("https://www.google.com");

            //enter keyword car on my search field
           Reusable_Library_loggers.userKeys(driver, "//*[@name='q'] ", "cars", "Search Field",logger);

            //click on submit
          Reusable_Library_loggers.submit(driver, "//*[@name='btnK'] ", "Google Search Button",logger);
            Thread.sleep(2000);

            //capture text print out the search number
            String searchResult = Reusable_Library_loggers.captureText(driver, "//*[@id='result-stats']", "Search Result",logger);


            //split the text and print the number

            String[] arraySearch = searchResult.split(" ");
            System.out.println("my search number " + arraySearch[1]);



    }//end of google test


}//end of java class
