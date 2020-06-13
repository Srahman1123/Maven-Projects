package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Homepage extends Abstract_Class {
    ExtentTest logger;

    public Metlife_Homepage(WebDriver driver){

        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }// end of creating constructor class

    public Metlife_Homepage ClickSolution(){
        Reusable_Library_loggers.click(driver,"//*[contains(text(),'SOLUTIONS')]","Click Solution",logger);
        return new Metlife_Homepage(driver);

    }//end of clicking on solution

    public Metlife_Homepage ClickOnDental() {
        Reusable_Library_loggers.click(driver, "//*[text()='MetLife TakeAlong Dental']", "Click Dental", logger);

        return new Metlife_Homepage(driver);
    }//end of clicking on dental







}//end of java class
