package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AC_libertymutual {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(Options);

        String[] zipcode= new String[4];
        zipcode[0]="11210";
        zipcode[1]="11218";
        zipcode[2]="11226";
        zipcode[3]="11201";

        for (int i = 0;i < zipcode.length;i++){

            driver.navigate().to("https://www.libertymutual.com");

            String title = driver.getTitle();

            if (title.equals("Start Saving with a Free Custom Quote | Liberty Mutual")){
                System.out.println("title matches with expected");
            } else{
                System.out.println("title does not matches" + title);
            }

            driver.findElement(By.xpath("//*[@class='field']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@name='location']")).sendKeys(zipcode[i]);
            driver.findElement(By.xpath("//button[contains(@class,'submitButton btn')]")).click();

            Thread.sleep(4000);

           if (i==0){
                System.out.println("click on the first link");
                driver.findElements(By.xpath(".//*[text()='Show agents in this office']")).get(0).click();
            }


           if(i==1){
               System.out.println("click on the 3rd  link");
               driver.findElements(By.xpath(".//*[text()='Show agents in this office']")).get(2).click();

           }

           if (i==2){
               System.out.println("click on the 4th link");
               driver.findElements(By.xpath(".//*[text()='Show agents in this office']")).get(3).click();
           }


           if (i==3){
               System.out.println("click on the 2nd link");
               driver.findElements(By.xpath(".//*[text()='Show agents in this office']")).get(1).click();

           }

           Thread.sleep(4000);

            String message = driver.findElement(By.xpath("//*[@class='jsx-188877792 office']")).getText();
            System.out.println("My address zipcode is " + "and my agents hours and numbers are " + message);


            Thread.sleep(3000);



        }//end of for loop
        driver.quit();

    }//end of main method
}//end of java class
