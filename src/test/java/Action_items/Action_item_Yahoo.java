package Action_items;

import Reusable_Classes.Abstract_Class;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Action_item_Yahoo extends Abstract_Class{

    @Test
    public void yahooTest() throws InterruptedException{

        driver.navigate().to("https://www.yahoo.com");


        //yahoo search box
        driver.findElement(By.xpath("//*[contains(@class,'Bgc(t) Bd Bdrsbstart(2')]")).sendKeys("QA");
        //click on submit
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //clicking on qa wikipedia
        Thread.sleep(2000);

        try {
            driver.findElement(By.xpath("//*[text()='Quality assurance - Wikipedia']")).click();
        }catch (Exception e){
            System.out.println("unable to click on the link" + e);

        }
        Thread.sleep(3000);
        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String message= driver.findElement(By.xpath("//a[@title='Middle Ages']")).getText();
        System.out.println("the reference word is " + message);



    }//enf test




}//end of java

