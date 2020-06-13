package Action_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class action {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().to("https://www.faculty.washington.edu/chudler/java/boxes.html");

        //clicking all the links
        List<WebElement> elements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println(elements.size());
        for (WebElement el : elements) {
            el.click();
        }

    }//end 0f method



}//end of java
