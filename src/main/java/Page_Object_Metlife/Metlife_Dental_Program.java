package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Dental_Program extends Abstract_Class {

    ExtentTest logger;

    public Metlife_Dental_Program(WebDriver driver) {

        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of

    public Metlife_Dental_Program gettingDP(String userValue) {

        Reusable_Library_loggers.click(driver, "//*[@class='" + userValue + "']", "getting DP", logger);
        return new Metlife_Dental_Program(driver);

    }// end of getting dental program

    public Metlife_Dental_Program clickingEnroll() {

        Reusable_Library_loggers.click(driver, "//*[text()='ENROLL IN PROGRAM NOW']", "Click Enroll", logger);
        return new Metlife_Dental_Program(driver);


    }//end of clicking on enroll program now
    public Metlife_Dental_Program RefCode(String userValue){
        Reusable_Library_loggers.userKeys(driver,"//*[@class='form-control']",userValue,"Refer Code",logger);
        return new Metlife_Dental_Program(driver);

    }// end of writing the ref code
    public Metlife_Dental_Program clickGO(){

        Reusable_Library_loggers.click(driver,"//*[@id='enrollgobtn']","Click GO",logger);
        return new Metlife_Dental_Program(driver);

    }// end of clicking on go button
    public Metlife_Dental_Program Text(){
        Reusable_Library_loggers.captureText(driver,"//*[@id='lblRefCodeError']","Capture Text",logger);
        return new Metlife_Dental_Program(driver);

    }// end of capturing the error text
    public Metlife_Dental_Program enrollWithoutRefCode(){
        Reusable_Library_loggers.click(driver,"//*[@id='lblRefCodeError']","WIthout Ref Code",logger);
        return new Metlife_Dental_Program(driver);
    }// end of clicking on enroll without ref code




}//end of java class
