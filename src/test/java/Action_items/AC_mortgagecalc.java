package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AC_mortgagecalc {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions Options= new ChromeOptions();
        Options.addArguments("start-maximized","incognito");
        WebDriver driver= new ChromeDriver(Options);
        driver.navigate().to("https://www.mlcalc.com/");

        Thread.sleep(3000);
        String title= driver.getTitle();

        if(title.equals("Mortgage Calculator & Loan Calculator")){
            System.out.println("title matches with expected");
        }
        else {
            System.out.println("title doesnot match " + title);

        }//end of if else

        String[]Pprice= new String[3];
        Pprice[0]="400000";
        Pprice[1]="500000";
        Pprice[2]="700000";

        String[]Dp= new String[3];
        Dp[0]="30";
        Dp[1]="40";
        Dp[2]="50";

        String[]intrate= new String[3];
        intrate[0]="5";
        intrate[1]="7";
        intrate[2]="8";

        String[]propertyins= new String[3];
        propertyins[0]="2000";
        propertyins[1]="3000";
        propertyins[2]="4000";

        String[]startmonth=new String[3];
        startmonth[0]="May";
        startmonth[1]="Jun";
        startmonth[2]="Jul";

        String[]startyear=new String[3];
        startyear[0]="2020";
        startyear[1]="2022";
        startyear[2]="2025";
        //using while loop
        int i = 0;
        while(i < 6){
            i = i + 1;//incrementation and you put this at the end of your statements

        try {
           driver.findElement(By.xpath("//*[@type='text']")).click();


        }catch(Exception e){
            System.out.println("unable to clear code" + e);
        }//end of try
        }// end of while loop







    }//end of main method
}//end of java class
