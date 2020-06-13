package Day16_0607;

import Reusable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {


        @Test

        public void Yahoo_Search_result() throws InterruptedException {
            ArrayList<String> cars= new ArrayList<>();
            cars.add("Mercedes");
            cars.add("Infiniti");
            cars.add("Acura");

            for(int i = 0; i< cars.size(); i++) {

                logger.log(LogStatus.INFO, "navigating to yahoo homepage ");
                driver.navigate().to("https://www.yahoo.com");
                Thread.sleep(3000);
                //calling search field method from yahoo search result page

                Yahoo_Base_Class.Yahoo_homepage().searchField(cars.get(i));
                //calling searchIcon method from yahoo search result page
                Yahoo_Base_Class.Yahoo_homepage().searchIcon();
                Thread.sleep(3000);
                //calling scrollToBottom method from yahoo search result page
                Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
                /**calling searchNumber method from yahoo search result page */
                 Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

            }//end of for loop


        }//end of test method

    }// end of java class

