package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AC_2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
// declare and define the driver
        WebDriver driver = new ChromeDriver();
        // create dynamic array fro the state loop
        String[]state = new String[5];
        state[0] = "New York";
        state[1] ="New Jersey";
        state[2] = "Ohio";
        state[3] = "Maryland";
        state[4] = "California";

        //start your for loop
        for (int i = 0; i < state.length; i++){

            //now I will be opening the browser automatically
            driver.navigate().to("https://www.bing.com");

            //now I will maximize the browser automatically
            driver.manage().window().maximize();

            //wait for few seconds
            Thread.sleep(2000);

          //locating the search field by inspecting first.
            driver.findElement(By.id("sb_form_q")).sendKeys(state[i]);


            driver.findElement(By.id("sb_form_q")).submit();

            //putting it back to sleep
            Thread.sleep(1000);

            //now im going to capture a text from the website
            String message = driver.findElement(By.className("sb_count")).getText();
            String[]arrayResult = message.split(" ");
            System.out.println("My state is " + state[i] + " and search number is " + arrayResult[0]);
            
        }//end of for loop

        Thread.sleep(1000);
        driver.quit();
    }//end of main method


}//end of java class
