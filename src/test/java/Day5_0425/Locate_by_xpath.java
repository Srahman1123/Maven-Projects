package Day5_0425;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_by_xpath {


    public static void main(String[] args) throws InterruptedException {
      //line below store your search field xpath as a string variable
        String searchPath = "//*[@name='field-keywords]";
       //line below store your search Icon xpath as a string variable
        String searchIconPath = "//*[@value='Go']";
        //line below store your image Icon xpath as a string variable
        String imagepath = "//*img[contains(@class,'s-image')]";


        //define your property

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //define the drive
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.amazon.com");
        //maximize the window
        driver.manage().window().maximize();
        //wait for  few seconds
        Thread.sleep(2000);

        //enter a keyword laptop on amazon search field by using x path
        driver.findElement(By.xpath("//* [@name='field-keywords' or @id='twotabsearchtextbox']")).sendKeys("laptop");

        //click on search icon
        driver.findElement(By.xpath("//*[@value='Go']")).submit();

        Thread.sleep(2500);
        //click on second image of the same elements within that page using index number
        driver.findElements(By.xpath("//*[@class='s-image']")).get(1).click();
        //renavigate back to home page
        driver.navigate().to("https://www.amazon.com");





    }//end of main method
}//enf of java class
