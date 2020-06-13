package Day16_0607;

import Page_Object_Metlife.Metlife_Base_Class;
import Reusable_Classes.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Metlife_Test_Result2 extends Abstract_Class {




    @Test
    public void Metlife_Result () throws IOException, BiffException, InterruptedException, WriteException {


        logger.log(LogStatus.INFO," Navigating to metlife webpage ");
        for (int i = 0; i < 3; i++){

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
            ArrayList<String> Refcode = new ArrayList<>();
            Refcode.add("2345");
            Refcode.add("4567");
            Refcode.add("7980");

            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(3000);
            Metlife_Base_Class.metlife_homepage().ClickSolution();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_homepage().ClickOnDental();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_enroll_now().clickEnroll();
            Thread.sleep(4000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Metlife_Base_Class.metlife_zipcode().SearchBox(Zipcode.get(i));
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_zipcode().clickGo();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().gettingDP(dprogram.get(i));
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().clickingEnroll();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().RefCode(Refcode.get(i));
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().clickGO();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().Text();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().enrollWithoutRefCode();
            Thread.sleep(4000);
             Metlife_Base_Class.metlife_ppo_text().GetCapturedMessage();
            Thread.sleep(4000);


            driver.close();
            //switching back first tab
            driver.switchTo().window(tabs.get(0));



        }//end of for loop





    }//end of metlife result

}// end of java class
