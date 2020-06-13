package Day13_0530;

import Reusable_Classes.Reusable_Library;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_htmlreport {

//declare the driver outside
    WebDriver driver;
    //declare the report variable outside
    ExtentReports reports;
    //declare the logger (extent test)
    ExtentTest logger;

    @BeforeSuite
    public void startSession() throws IOException, InterruptedException {
        driver= Reusable_Library.setDriver();
        //define the report path here as a before suite
        reports= new ExtentReports("src//main//java//HTML_Report//AutomationReport.html",true);

    }//end of before test

    @Test
    public void yahoo_verification() throws InterruptedException {
    //define and start the test
        logger=reports.startTest("yahoo verification");
        //navigate to yahoo web page
        logger.log(LogStatus.INFO,"navigation to yahoo home page");
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
        Reusable_Library.click(driver,"//*[@id='header-signin-link']","Sign In");

        //Wait few seconds
        Thread.sleep(3000);

        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState==true){
            System.out.println("checkbox is selected by default");
        }else{
            System.out.println("checkbox is not selected by default");
        }//end of if else


        reports.endTest(logger);



    }//end of test

    @AfterSuite
    public void clossinguptheSession(){
      //  driver.quit();
        // flushing= writing the logs(loggers)back to your automation report that you defined
        reports.flush();

    }//end of after suite















}//end of java class
