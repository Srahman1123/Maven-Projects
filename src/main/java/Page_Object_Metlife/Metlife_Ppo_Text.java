package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Ppo_Text extends Abstract_Class {
    ExtentTest logger;
    public Metlife_Ppo_Text (WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }// end of constructor

    public String GetCapturedMessage(){
        String Message = Reusable_Library_loggers.captureText(driver,"//*[@class='col-sm-8']","capture Text",logger);
        return Message;

    }//end of getting the ppo text


}//end of java class
