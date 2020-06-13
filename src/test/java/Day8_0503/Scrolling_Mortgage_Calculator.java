package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Mortgage_Calculator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //set some pre conditions using chromeOptions
        ChromeOptions Options= new ChromeOptions();
      // set the arguments i want for the driver
        Options.addArguments("start-maximized","incognito");
        //defining my driver
        WebDriver driver= new ChromeDriver(Options);
        //going to a website
        driver.navigate().to("https://mortgagecalculator.org");
        Thread.sleep(2500);

        //declare and define javascript
        JavascriptExecutor jse=(JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page
       // jse.executeScript("scroll(0,5000)");

        //Thread.sleep(2000);

        //scroll all the way up
        //jse.executeScript("scroll(0,-5000)");

        //scrolling to an element view
        try{
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);
        }
        catch (Exception e){
            System.out.println("unable to locate Loan Term " + e);
        }//end of loan term

    }//end of main method


}//end of java class
