package Action_items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import org.testng.annotations.Test;

public class Weight_Watchers_Abstract extends Abstract_Class {
    @Test
    public void WeightCase() throws InterruptedException {


        //creating arrays
        String[] zipcode = new String[3];
        zipcode[0] = "11210";
        zipcode[1] = "11201";
        zipcode[2]= "11218";
        //using for loop


        for (int i = 0;i < zipcode.length;i++) {

            //navigating to the actual webpage

            driver.navigate().to("https://www.weightwatchers.com");

           //declaring the title using if else
            String title= driver.getTitle();

            Reusable_Library_loggers.verifyTitle(driver, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA",logger);



           Reusable_Library_loggers.click(driver,"//*[text()='Find a Workshop']","clicking on", logger);
            Thread.sleep(4000);


            Reusable_Library_loggers.userKeys(driver,"//*[@name='meetingSearch']",zipcode[i],"zipCode",logger);

           Reusable_Library_loggers.click(driver,"//*[@type='button']","clicking",logger);

         if(i==0) {


             Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",1,"2ndlink", logger );

         }

         if (i==1){

             Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",1,"2ndlink", logger );

         }

         if (i==2) {


             Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",0,"2ndlink", logger );


         }
             Reusable_Library_loggers.captureText(driver,"//*[@class='location']","Message",logger);


             Reusable_Library_loggers.captureText(driver,"//*[@class='schedule-detailed']","capture text",logger);

        }//end of for loop

    }//end of main method

}//end of java class
