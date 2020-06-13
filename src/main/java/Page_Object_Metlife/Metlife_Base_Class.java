package Page_Object_Metlife;

import Reusable_Classes.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Base_Class extends Abstract_Class {
    public Metlife_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);


    }//end of constructor
    //creaitng metlife base class

    public static Metlife_Homepage metlife_homepage(){
       Metlife_Homepage metlife_homepage = new Metlife_Homepage(driver);
        return metlife_homepage;
    }//end of object references for MetLife homepage

    public static Metlife_Enroll_Now metlife_enroll_now(){
        Metlife_Enroll_Now metlife_enroll_now = new Metlife_Enroll_Now(driver);
        return metlife_enroll_now;
    }//end of object references for metlife enroll now page

    public static Metlife_Zipcode metlife_zipcode(){

        Metlife_Zipcode metlife_zipcode = new Metlife_Zipcode(driver);
        return metlife_zipcode;
    }//end of references for zipcode object

    public static Metlife_Dental_Program metlife_dental_program(){
        Metlife_Dental_Program metlife_dental_program = new Metlife_Dental_Program(driver);
        return metlife_dental_program;
    }// end of dental program and reference code




    //object/method for Metlife search result page
    public static Metlife_Ppo_Text metlife_ppo_text (){
        Metlife_Ppo_Text metlife_ppo_text = new Metlife_Ppo_Text(driver);
        return metlife_ppo_text;

    }//end of object reference for Metlife search result page






}// nd of java class