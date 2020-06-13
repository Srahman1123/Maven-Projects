package Reusable_Classes;





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.IOException;
import java.util.ArrayList;

public class Reusable_Library {

    static int timeout = 20;

    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
       //kill the chrome driver instance
        Thread.sleep(2000);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver83.exe /T");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver,String expectedTitle){
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with Actual " + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
        }
    }//end of verify title method


    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
        }
    }//end of drop down by text method

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
           Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Submitting a value on element " + elementName);
            Reporter.log("Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            Reporter.log("Unable to submit element " + elementName);
        }
    }//end of submit

        //method to return text from an element
        public static String captureText(WebDriver driver,String locator,String elementName){
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            String result = null;
            try {
                System.out.println("Capturing a text from element " + elementName);
                Reporter.log("Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
                System.out.println("My Text result is " + result);
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
                Reporter.log("Unable to capture text on element " + elementName + " " + e);
            }

            return result;

        }//end of capture text method

    //mehtod to mouse hovering
    public static void mouseHover(WebDriver driver,String locator, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try{
            System.out.println("able to hovering the mouse " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions mouseHover= new Actions(driver);
            mouseHover.moveToElement(element).perform();
        }catch(Exception e){
            System.out.println("unable to hovering the mouse " + elementName + " " + e);
        }

    }//end of mousehover method

    //Mouse click method

    public static void Mouseclick(WebDriver driver, String locator, String elementName)   {
        WebDriverWait wait = new WebDriverWait(driver, timeout);


        try {
            System.out.println("clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions Mouse = new Actions(driver);
            Mouse.moveToElement(element).click().perform();


        } catch (Exception e) {
            System.out.println("unable to mouseclick on element " + elementName + e);
        }

        }//end of mouse clicking method

        //method to click by index on an element
        public static void clickByIndex(WebDriver driver,String locator,int index, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                System.out.println("Clicking a value by index " + index + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click by index " + index + " on element " + elementName + " " + e);
            }
        }//end of click by index method


            //method to enter user input on send keys
            public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName){
                WebDriverWait wait = new WebDriverWait(driver,timeout);
                try{
                    System.out.println("Entering a value on element " + elementName);
                    Reporter.log("Entering a value on element " + elementName);
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                    element.clear();
                    element.sendKeys(userInput);
                    Thread.sleep(3000);
                    element.sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    System.out.println("Unable to enter element " + elementName + " " + e);
                    Reporter.log("Unable to enter element " + elementName + " " + e);
                }
            }//end of userTypeAndHitEnter method

            //Method to switching tab
        public static void switchTabs (WebDriver driver,String){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Switiching Tabs");
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        }
        }//end of handling tabs method


}//end of java class

