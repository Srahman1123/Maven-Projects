package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Zipcode extends Abstract_Class {
    ExtentTest logger;

    public Metlife_Zipcode(WebDriver driver) {

        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;

    }//end of zipcode cosntructor

    public Metlife_Zipcode SearchBox(String userValue){

        Reusable_Library_loggers.userKeys(driver,"//*[@id='txtZipCode']",userValue,"Zipcode",logger);
        return new Metlife_Zipcode(driver);
    }//end of entering zipcode

    public Metlife_Zipcode clickGo(){

        Reusable_Library_loggers.click(driver,"//*[@id='txtZipCodetxt']","Click Go",logger);
        return new Metlife_Zipcode(driver);


    }//end of click go method






}//end of java class
