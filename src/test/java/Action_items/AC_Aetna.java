package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class AC_Aetna {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("start-maximized","incognito");
        WebDriver driver=new ChromeDriver(Options);


       //defining Array list
        ArrayList<String> Zipcode = new ArrayList<>();
        Zipcode.add("11218");
        Zipcode.add("11201");
        Zipcode.add("11202");

        ArrayList<Integer> Milerange = new ArrayList<>();
        Milerange.add(42);
        Milerange.add(70);
        Milerange.add(80);


        for (int i = 0; i<3; i++) {
            driver.navigate().to("https://www.aetna.com");

            String title = driver.getTitle();
            if (title.equals("Health Insurance Plans | Aetna")) {
                System.out.println("title matches");
            } else {
                System.out.println("title does not match" + title);
            }//end of if else
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[contains(text(),'Shop for a plan')]")).click();

            } catch (Exception e) {

                System.out.println("not clicking on shop for a plan " + e);
            }//end of try n catch for clicking on shop for a plan

            try {
                driver.findElement(By.xpath("//*[text()='Medicare']")).click();

            } catch (Exception e) {
                System.out.println("not clicking on medicare " + e);
            }//end of try n catch for clicking on medicare

            try {
                driver.findElement(By.linkText("Find a doctor")).click();
            } catch (Exception e) {
                System.out.println("unable to click on find a doctor " + e);
            }//end of try n catch for finding a doc

            Thread.sleep(9000);
            try {
                driver.findElement(By.xpath("//*[contains(@class,'BtnWidth mgbutton w400')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on plans " + e);
            }//end of try n catch for clicking on med plans 4 yourself

            try {
                WebElement code = driver.findElement(By.xpath("//*[@id='medZip']"));
                code.clear();
                code.sendKeys(Zipcode.get(i));


            } catch (Exception e) {
                System.out.println("unable to go to zipcode box " + e);
            }//end of try n catch finding zipcode
            Thread.sleep(4000);

            try {
                driver.findElement(By.xpath("//*[contains(@ng-bind-html,'match.label')]")).click();
            } catch (Exception e) {
                System.out.println("unable to type zipcode " + e);
            }//end of try n catch for zipcode

            Thread.sleep(5000);
            //declaring slider equal to webelement

            try {
                WebElement Slider;
                Slider = driver.findElement(By.xpath("//*[@aria-valuemin='0']"));
                Actions MouseAction = new Actions(driver);

                for (int c = 0; c < 25; c++) {
                    Slider.sendKeys(Keys.ARROW_LEFT);
                    MouseAction.click(Slider).build().perform();
                }
                for (int c = 0; c < Milerange.get(i); c++) {
                    Slider.sendKeys(Keys.ARROW_RIGHT);
                    MouseAction.click(Slider).build().perform();
                }


            } catch (Exception e) {
                System.out.println("unable to get the slide button " + e);
            }//end of try n catch for slide button
            Thread.sleep(5000);
            try {
                driver.findElement(By.xpath("//button[text()='Skip plan selection*']")).click();
            } catch (Exception e) {
                System.out.println("unable to click plan selection " + e);
            }//end of try n catch for plan selection
            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[@class='adjustImg']")).click();
            } catch (Exception e) {
                System.out.println("unable to click medical doc " + e);
            }//end of try n catch for med doc and specialist
            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[@class='search-block-text']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on primary care " + e);
            }//end of try n catch for primary care
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[text()='All Primary Care Physicians']")).click();

            } catch (Exception e) {
                System.out.println("unable to click on all pri care " + e);
            }//end of try n catch for all pri care


            Thread.sleep(6000);

            String Doctor = driver.findElements(By.xpath("//*[contains(@class, 'FontForMobile')]")).get(0).getText();
            String Address = driver.findElements(By.xpath("//*[contains(@class, 'DisplayForAddress')]")).get(0).getText();

            System.out.println("The Doctor name " + Doctor + " And the Address is " + Address);


        }// end of for loop



    }//end of main method

}//end of java class
