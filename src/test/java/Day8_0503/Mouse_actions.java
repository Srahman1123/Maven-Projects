package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_actions {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //set some pre conditions using chromeOptions
        ChromeOptions Options= new ChromeOptions();
        // set the arguments i want for the driver
        Options.addArguments("start-maximized","incognito");
        //defining my driver
        WebDriver driver= new ChromeDriver(Options);
        //going to a website
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2500);

        //call your mouse actions
        Actions mouse= new Actions(driver);

        //hover to mail&ship tab
        try{
            WebElement mailandship= driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            //call your actions command to move the element
            mouse.moveToElement(mailandship).perform();
        }catch (Exception e){
            System.out.println("unable to locate Main & ship " + e);
        }// end of mail and ship exceptions

        Thread.sleep(2000);
        //click on click and ship using actions
        try{
           // WebElement ClickandShip= driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));

            //WebElement ClickandShip= driver.findElement(By.xpath("//*[@class='tool-cns']/following::a[text()='Click-N-Ship']"));
           //we could also use 3rd syntaxd
            WebElement ClickandShip= driver.findElement(By.xpath("//a[text()='Click-N-Ship']"));
            //call your actions command to move the element and then use mouse to click
            mouse.moveToElement(ClickandShip).click().perform();
            //this is to submit using keyboard 'Enter' for mouse actions
           // ClickandShip.submit();
           // mouse.moveToElement(ClickandShip).sendKeys(Keys.ENTER).perform();

        }catch (Exception e) {
            System.out.println("unable to locate Click-N-Ship " + e);
        }// end of clock and ship








    }//end of main method
}//end of java class
