package Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_Class {

   ExtentTest logger;

    //we need to create a constructor method that defines
    //driver and logger to reuse locally to this page class
    //constructor inherits the same name as your java class
    public Yahoo_Homepage(WebDriver driver){

        super();
        PageFactory.initElements(driver,this);
        //local gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }// end of constructor
        // one method for search field
    public Yahoo_Homepage searchField(String userValue){
        Reusable_Library_loggers.userKeys(driver,"//*[@id='header-search-input']",userValue, "Search Field",logger);

        return new Yahoo_Homepage(driver);
        //the driver that I used is returning you the same
        //Yahoo_Homepage
    }//end of search field

    public Yahoo_Homepage searchIcon() {
        Reusable_Library_loggers.click(driver, "//*[@id='header-desktop-search-button']",  "Search Icon", logger);

        return new Yahoo_Homepage(driver);
    }//end of search icon method




    }//end of java
