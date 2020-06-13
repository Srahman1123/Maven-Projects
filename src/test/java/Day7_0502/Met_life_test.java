package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_life_test {
    public static void main(String[] args) throws InterruptedException {
   //set the chrome path
   System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

//set some pre conditions using chromeOptions
        ChromeOptions Options= new ChromeOptions();
        Options.addArguments("start-maximized","incognito");

        WebDriver driver= new ChromeDriver(Options);
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(3000);

        //click on solution tab
        try{
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();

        }catch (Exception e){
            System.out.println("unable to click on SOLUTIONS " + e);
        }//end of solutions e
        Thread.sleep(1000);

        //click on take along link

        try{
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();

        }catch (Exception e){
            System.out.println("unable to click on MetLife TakeAlong Dental " + e);
        }//end of MetLife TakeAlong Dental exception

        Thread.sleep(3500);

        //click on enroll now

        try{
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();

        }catch (Exception e){
            System.out.println("unable to click on Enroll now " + e);
        }//end of enroll now exception

        //now define the array list to handle all current window tabs that are open

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));

        //enter your zipcode

        try{
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11210");

        }catch (Exception e){
            System.out.println("unable to enter on search field " + e);
        }//end of zipcode exception
        Thread.sleep(1500);
        //i want to close this tab
        driver.close();
        //switch to previous tab
        driver.switchTo().window(tabs.get(0));

        //close will only close the driver but not from your memory
        //quit will kill the driver from your task memory
        //if another tab open we need to redefine the new tab with array list.
        //tabs=new Arraylist<>(driver.getWindowhandles());

    }//end of main method


}//end of java class
