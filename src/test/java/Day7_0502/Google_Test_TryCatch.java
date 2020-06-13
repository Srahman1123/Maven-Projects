package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_TryCatch {
    // This class is showing how to use try&catch and use of array list.

        public static void main(String[] args) throws InterruptedException {

            // set the system chrome driver path at least once in one of your main method

            //webdriver.chrome.driver needs to be in lower case string followed by your driver path
            System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

            // you declare and define the driver
            WebDriver driver = new ChromeDriver();

            // set the ArrayList for the cars
            //dont need to define the size/length and also don't need to define the index numbers
            // its resizeable array
            ArrayList<String> cars = new ArrayList<>();
            cars.add("Mercedes");
            cars.add ("Infiniti");
            cars.add ("Acura");

            for(int i = 0; i<cars.size(); i++ ) {
            // use the word size instead of length in for loop when you do arraylist

                // opening the browser automatically to go to google home page
                driver.navigate().to("https://www.google.com");

                // wait few seconds after navigating to page so browser can load properly
                //sleep statement handles in miliseconds so example 1 sec = 1000 miliseconds
                Thread.sleep(2000);

                driver.manage().window().maximize();

                try {
                    // locate the search field by inspecting it first and then enter a keyword lets say cars
                    driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(cars.get(i));
                } catch (Exception e) {
                    System.out.println("Unable to enter data search field " + e);
                } // end of search field exception


                try {

                    driver.findElement(By.xpath("//*[@name='btnK']")).submit();
                } catch (Exception e) {
                    System.out.println("Unable to submit on search icon" + e);
                } // end of search icon exception

                Thread.sleep(2000);
                // maximize your browser


                try {
                    // to capture a text from web site you need to
                    String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                    // using array variable to split above message
                    String[] arrayResult = message.split(" ");
                    System.out.println("My search number is " + arrayResult[1]);
                } catch (Exception e) {
                    System.out.println("unable to capture on search Result " + e);
                } // end of search result exception


            } // end of for loop !

            // how to find Xpath using (contains)
            // when you inspect an element and most of the time it takes you to the lowest tag and property within it
            // but i can still use the tags before and the properties of it as long as it highlights the same elements in the page



    }// end of main method


}//end of java class