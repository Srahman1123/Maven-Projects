package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AC_3_Weight_Watchers {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources/chromedriver83.exe");


        ChromeOptions Options=new ChromeOptions();
        Options.addArguments("start-maximized","incognito");
       //define the webdriver
        WebDriver driver= new ChromeDriver(Options);
        //creating arrays

        String[] zipcode = new String[3];
        zipcode[0] = "11210";
        zipcode[1] = "11201";
        zipcode[2]= "11218";
        //using for loop
        for (int i = 0;i < zipcode.length;i++) {

            //navigating to the actual webpage

            driver.navigate().to("https://www.weightwatchers.com");

           //declaring the title using if else
            String title= driver.getTitle();

            if(title.equals( "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA")){
                System.out.println("title matches with expected");
            } else {
                System.out.println("Title does not match " + title);}

            driver.findElement(By.xpath("//*[@class='find-a-meeting']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//*[@name='meetingSearch']")).sendKeys(zipcode[i]);

            driver.findElement(By.xpath("//*[@type='button']")).click();

         if(i==0) {
             System.out.println("click on the second studio link");
             driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(1).click();

         }

         if (i==1){
             System.out.println("click on the third studio link");
             driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(1).click();

         }

         if (i==2) {

             System.out.println("click on the  studio link");
             driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(0).click();


         }
            String message = driver.findElement(By.xpath("//*[@class='location']")).getText();
            System.out.println("my address is " + message);

            String schedule = driver.findElement(By.xpath("//*[@class='schedule-detailed']")).getText();
            System.out.println("My dietians schedule is " + schedule);
            Thread.sleep(3000);
        }//end of for loop
        driver.quit();
    }//end of main method

}//end of java class
