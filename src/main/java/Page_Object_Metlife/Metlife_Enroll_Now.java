package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Enroll_Now extends Abstract_Class {
ExtentTest logger;
public Metlife_Enroll_Now(WebDriver driver){
    super();
    PageFactory.initElements(driver,this);
    this.logger = super.logger;




}//end of method
    public Metlife_Enroll_Now clickEnroll(){

        Reusable_Library_loggers.click(driver,"//*[contains(text(),'Enroll Now')]","Click Enroll",logger);
        return new Metlife_Enroll_Now(driver);
    }// end of clicking on enroll now

}//end of java class
