package Reusable_Classes;





import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Reusable_Library_loggers {

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
    public static void verifyTitle(WebDriver driver, String expectedTitle, ExtentTest logger){
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with Actual " + expectedTitle);
            logger.log(LogStatus.INFO,"Expected title matches with actual " + expectedTitle);
        } else {
            System.out.println("Expected title doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected title doesn't match with actual title " + actualTitle);
            getScreenShot(driver,logger,actualTitle);
        }
    }//end of verify title method


    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Selecting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of drop down by text method

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName,  ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName);
            logger.log(LogStatus.FAIL,"unable to enter element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"clicking on a value " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Submitting a value on element " + elementName);
            Reporter.log("Submitting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            Reporter.log("Unable to submit element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to submit element " + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of submit

        //method to return text from an element
        public static String captureText(WebDriver driver,String locator,String elementName,ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            String result = null;
            try {
                System.out.println("Capturing a text from element " + elementName);
                Reporter.log("Capturing a text from element " + elementName);
                logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
                System.out.println("My Text result is " + result);
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
                Reporter.log("Unable to capture text on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

            return result;

        }//end of capture text method

    //mehtod to mouse hovering
    public static void mouseHover(WebDriver driver,String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try{
            System.out.println("able to hovering the mouse " + elementName);
            logger.log(LogStatus.INFO,"able to hovering the mouse " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions mouseHover= new Actions(driver);
            mouseHover.moveToElement(element).perform();
        }catch(Exception e){
            System.out.println("unable to hovering the mouse " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hovering the mouse " + " " + e);
            getScreenShot(driver,logger,elementName);
        }

    }//end of mousehover method

    //Mouse click method

    public static void Mouseclick(WebDriver driver, String locator, String elementName, ExtentTest logger)   {
        WebDriverWait wait = new WebDriverWait(driver, timeout);


        try {
            System.out.println("clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions Mouse = new Actions(driver);
            Mouse.moveToElement(element).click().perform();


        } catch (Exception e) {
            System.out.println("unable to mouseclick on element " + elementName + e);
            logger.log(LogStatus.FAIL,"Unable to mouseclick on element " + e);
            getScreenShot(driver,logger,elementName);
        }

        }//end of mouse clicking method

        //method to click by index on an element
        public static void clickByIndex(WebDriver driver,String locator,int index, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                System.out.println("Clicking a value by index " + index + " on element " + elementName);
                logger.log(LogStatus.INFO,"Clicking on value by index " + index + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click by index " + index + " on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click by index " + index + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click by index method


            //method to enter user input on send keys
            public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
                WebDriverWait wait = new WebDriverWait(driver,timeout);
                try{
                    System.out.println("Entering a value on element " + elementName);
                    Reporter.log("Entering a value on element " + elementName);
                    logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                    element.clear();
                    element.sendKeys(userInput);
                    Thread.sleep(3000);
                    element.sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    System.out.println("Unable to enter element " + elementName + " " + e);
                    Reporter.log("Unable to enter element " + elementName + " " + e);
                    logger.log(LogStatus.FAIL,"Unable to enter element " + " " + e);
                    getScreenShot(driver,logger,elementName);
                }
            }//end of userTypeAndHitEnter method

        //method to capture screenshot when logger fails
        public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
            try {
                String fileName = imageName + ".png";
                String directory = "src//main//java//HTML_Report//Screenshots//";
                File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(directory + fileName));
                //String imgPath = directory + fileName;
                String image = logger.addScreenCapture("Screenshots//" + fileName);
                logger.log(LogStatus.FAIL, "", image);
            } catch (Exception e) {
                logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
                e.printStackTrace();
            }
        }//end of screenshot method





}//end of java class

