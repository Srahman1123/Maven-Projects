package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AC_Metlife {

    public static void main(String[] args) throws InterruptedException {

        //set your property

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        //setting up pre condition using chrome options
        ChromeOptions Options = new ChromeOptions();
        //set arguments for the driver.
        Options.addArguments("start-maximized", "incognito");
        //defining my driver
        WebDriver driver = new ChromeDriver(Options);
        //using array list to define your dental program
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
        ArrayList<String> refcode = new ArrayList<>();
        refcode.add("2345");
        refcode.add("4567");
        refcode.add("7980");

        for (int i = 0; i < 3; i++) {


            //navigating to the webpage
            driver.navigate().to("https://www.metlife.com");

            Thread.sleep(2000);


            //matching the title

            String title = driver.getTitle();
            if (title.equals("Insurance and Employee Benefits | MetLife")) {
                System.out.println("title matches with expected");
            } else {
                System.out.println("title does not match " + title);
            }//end of if else

            try {
                driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();

            } catch (Exception e) {
                System.out.println("unable to click on solutions " + e);
            }// end of try and catch solutions
            Thread.sleep(1000);
            try {
                driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
            } catch (Exception e) {
                System.out.println("dont click metlife take along " + e);
            }//end of try and catch

            // verifying the title for next tab

            String titles = driver.getTitle();
            if (titles.equals("MetLife TakeAlong Dental | MetLife")) {
                System.out.println("title2 matches as expected");
            } else {
                System.out.println("title2 does not match " + titles);
            }//end of if else
            //click on enroll now and go to next tab

            Thread.sleep(2500);
            try {
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            } catch (Exception e) {
                System.out.println("dont click enroll now " + e);
            }//end of try&catch
            //define array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //getting the search box

            try {
               WebElement code= driver.findElement(By.xpath("//*[@id='txtZipCode']"));
               code.clear();
               code.sendKeys(Zipcode.get(i));

            } catch (Exception e) {
                System.out.println("unable to enter on searchbox " + e);
            }//end of try&catch

            //clicking on go
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on go " + e);
            }//end of try n catch
            Thread.sleep(3000);




           //getting the dental program

            try{

                driver.findElement(By.xpath("//*[@class='"+ dprogram.get(i) +"']")).click();

            } catch (Exception e) {
                System.out.println("unable to click on box " + e);
            }//end of try and catch

            //click on enroll now
            try {
                driver.findElement(By.xpath("//*[text()='ENROLL IN PROGRAM NOW']")).click();
            } catch (Exception e) {
                System.out.println("unable to trace the checkbox " + e);
            }
                Thread.sleep(3000);


            //writing the ref code
            try {
                driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys(refcode.get(i));
            } catch (Exception e) {
                System.out.println("unable to get the search box " + e);
            }// end of try and catch
            Thread.sleep(2000);

            //clicking on "go" after writing the refcode
            try {
                driver.findElement(By.xpath("//*[@id='enrollgobtn']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on go " + e);

            }//end of try
            Thread.sleep(3000);
            //catching the text
            try {
              String text = driver.findElement(By.xpath("//*[@id='lblRefCodeError']")).getText();
                System.out.println(text);

            }catch (Exception e){
                System.out.println("unable to recognize code " + e);

            }//end of try

            Thread.sleep(4000);
            //now enroll without a ref code
            try{
                driver.findElement(By.xpath("//*[text()='Enroll without a Referral Code']")).click();
            }catch(Exception e){
                System.out.println("unable to click on enroll without a ref code " + e);
            }//end of try n catch
        Thread.sleep(3000);

            //getting the ppo text
           try {
               String Metlife= driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();
               if(Metlife.contains(dprogram.get(i))){
                   System.out.println("get text as expected" + Metlife);
               }else {

                   System.out.println("text does not match " + Metlife);
               }//end of if else
           }catch(Exception e){
               System.out.println("unable to get the text " + e);

           }//end of try catch for ppo text
            //closing my tab
            driver.close();
           //switching back first tab
           driver.switchTo().window(tabs.get(0));
           Thread.sleep(3000);
        }//end of for loop
        driver.quit();

    }//end of main method

}//end of java class

