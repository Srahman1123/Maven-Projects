package Action_items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Metlife_Abstract extends Abstract_Class {



   @Test
    public void MetlifeTest() throws InterruptedException {




        //using array list to define your dental program
        ArrayList<String> dprogram = new ArrayList<>();
        dprogram.add("PPO-LOW");
        dprogram.add("PPO-MEDIUM");
        dprogram.add("PPO-HIGH");

        //using array list to define your zipcode
        ArrayList<String> Zipcode = new ArrayList<>();
        Zipcode.add("11201");
        Zipcode.add("11218");
        Zipcode.add("11202");

        //using array list to define referral code
        ArrayList<String> refcode = new ArrayList<>();
        refcode.add("2345");
        refcode.add("4567");
        refcode.add("7980");

        logger.log(LogStatus.INFO,"Navigating to met life");
        for (int i = 0; i< 3; i++) {


            //navigating to the webpage
            driver.navigate().to("https://www.metlife.com");

            Thread.sleep(2000);


            //matching the title

            Reusable_Library_loggers.verifyTitle(driver, "Insurance and Employee Benefits | MetLife", logger);


            Reusable_Library_loggers.click(driver, "//*[contains(text(),'SOLUTIONS')]", "clickingonelement", logger);


            Thread.sleep(1000);


            Reusable_Library_loggers.click(driver, "//*[text()='MetLife TakeAlong Dental']", "metlifetakealong", logger);


            // verifying the title for next tab
            Reusable_Library_loggers.verifyTitle(driver, "MetLife TakeAlong Dental | MetLife", logger);

            //click on enroll now and go to next tab

            Thread.sleep(2500);

            Reusable_Library_loggers.click(driver, "//*[contains(text(),'Enroll Now')]", "enroll now", logger);

            //define array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //getting the search box

            Reusable_Library_loggers.userKeys(driver, "//*[@id='txtZipCode']", Zipcode.get(i), "searchbox", logger);


            //clicking on go

            Reusable_Library_loggers.click(driver, "//*[@id='txtZipCodetxt']", "clickingonGO", logger);


            Thread.sleep(3000);

            //getting the dental program


            Reusable_Library_loggers.click(driver, "//*[@class='" + dprogram.get(i) + "']", "dentalProgram", logger);


            //click on enroll now

            Reusable_Library_loggers.click(driver, "//*[text()='ENROLL IN PROGRAM NOW']", "Enroll program", logger);

            Thread.sleep(3000);


            //writing the ref code

            Reusable_Library_loggers.userKeys(driver, "//*[@class='form-control']", refcode.get(i), "ref code", logger);


            Thread.sleep(2000);

            //clicking on go after writing the refcode

            Reusable_Library_loggers.click(driver, "//*[@id='enrollgobtn']", "clicking on go", logger);

            Thread.sleep(3000);
            //catching the text

            Reusable_Library_loggers.captureText(driver, "//*[@id='lblRefCodeError']", "gettext", logger);


            Thread.sleep(4000);
            //now enroll without a ref code

            Reusable_Library_loggers.click(driver, "//*[text()='Enroll without a Referral Code']", "enrollwithougrefcode",
                    logger);

            Thread.sleep(3000);

            //getting the ppo text

            Reusable_Library_loggers.captureText(driver, "//*[@class='col-sm-8']", "capturetext", logger);


            //switching back first tab

            driver.switchTo().window(tabs.get(0));
            Thread.sleep(3000);
        }//end of loop


    }//end of main method

}//end of java class

