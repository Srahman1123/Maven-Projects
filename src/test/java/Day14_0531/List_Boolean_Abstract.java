package Day14_0531;


import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_Boolean_Abstract extends Abstract_Class {



    @Test
    public void yahoo_verification() throws InterruptedException {
    //define and start the test

        //navigate to yahoo web page
        logger.log(LogStatus.INFO,"navigating to yahoo home page");
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(3500);

        //I want to count all the links in yahoo homepage and print it
        logger.log(LogStatus.INFO,"getting the list count for all links");
        List<WebElement> Linkcount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));

        //verify if link count returns you 12 links

        if (Linkcount.size()==13){
            System.out.println("my yahoo homepage link count matches and it is" + Linkcount.size());
            logger.log(LogStatus.PASS,"my yahoo homepage link count matches and it is " + Linkcount.size());
        }else {
            System.out.println("my yahoo home page link count doesn't matches and actual is " + Linkcount.size());
            logger.log(LogStatus.FAIL,"my yahoo home page link count doesn't matches and actual is" + Linkcount.size());

        }//end of if else

        //click on sign in link
        Reusable_Library_loggers.click(driver,"//*[@id='header-signin-']","Sign In",logger);

        //Wait few seconds
        Thread.sleep(3000);

        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState==true){
            System.out.println("checkbox is selected by default");
        }else{
            System.out.println("checkbox is not selected by default");
        }//end of if else
    }//end of test
}//end of java class
