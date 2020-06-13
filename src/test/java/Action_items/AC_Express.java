package Action_items;

import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AC_Express {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/express.xls"));

        Sheet readableSheet = readableFile.getSheet(0);

        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/Resource/express_Results.xls"),readableFile);
        //create writable sheet
        WritableSheet writableSheet = writeableFile.getSheet(0);

        //get the total rows that are not empty
        int rows = writableSheet.getRows();



        //now simply define your chrome driver
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i=1; i<rows;i++) {

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String Email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAddress = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CreditCardNumber = writableSheet.getCell(10, i).getContents();
            String ExpMonth = writableSheet.getCell(11, i).getContents();
            String ExpYear = writableSheet.getCell(12, i).getContents();
            String CvvCode = writableSheet.getCell(13, i).getContents();
            String ErrorMessage = writableSheet.getCell(14, i).getContents();


            //navigate to express home page
            driver.navigate().to("https://www.express.com");
            Thread.sleep(5000);


            //hovering mouse
            Reusable_Library.mouseHover(driver, "//*[contains(@role,'menuitem')]", "express");
            Thread.sleep(1000);

            //clicking on women dress
            Reusable_Library.click(driver, "//*[text()='Dresses']", "Clicking on Dress");
            Reusable_Library.click(driver, "//div[@class='L_d7U']", "express women dress");
            //choosing the size for the dress
            Reusable_Library.click(driver,"//*[text()='" + size + "']" , "women size");

            //adding the dress to my bag
            Reusable_Library.click(driver, "//*[text()='Add to Bag']", "adding to bag");
            Thread.sleep(5000);

            //hovering the mouse to shopping bag
            Reusable_Library.mouseHover(driver, "(//*[contains(@class,'HoverableSlideOutModal_modal_')]) [3]", "shopping box");
            Thread.sleep(3000);
            //adding the item to the cart
            Reusable_Library.click(driver, "//a[@class='btn _9yfmt _194FD _2tFXQ']", "adding to bag");

            Thread.sleep(3000);
            //View Bag & Check Out
            Reusable_Library.dropdownByText(driver, "//*[contains(@class,'dropdown__select _2')]", quantity, "Quantity");

            //checking out the item
            Reusable_Library.click(driver, "//*[@id='continue-to-checkout']", "checkout");

            //checking out as a guest
            Reusable_Library.click(driver, "//*[text()='Continue as Guest']", "as guest");
            Thread.sleep(3000);

            //enter first name value
            Reusable_Library.userKeys(driver, "//*[@name='firstname']", firstName, "First Name");

            //enter last name value
            Reusable_Library.userKeys(driver, "//*[@name='lastname']", lastName, "Last Name");

            //enter email address
            Reusable_Library.userKeys(driver, "//input[@name='email']", Email, "Email Add");

            //confirm email address
            Reusable_Library.userKeys(driver, "//input[@name='confirmEmail']", Email, "Confirm Email");

            //entering phone number
            Reusable_Library.userKeys(driver, "//*[@name='phone']", phoneNumber, "Phone Number");

            //clicking on continue
            Reusable_Library.click(driver, "//*[text()='Continue']", "Firstcontinue");
            Thread.sleep(3000);

            //street address box
            Reusable_Library.userKeys(driver, "//input[@name='shipping.line1']", streetAddress, "StreetAddress");

            //entering Postal code
            Reusable_Library.userKeys(driver, "//*[@name='shipping.postalCode']", postalCode, "PostalCode");

            //entering city
            Reusable_Library.userKeys(driver, "//*[@name='shipping.city']", City, "cityname");

            //dropdown for state
            Reusable_Library.dropdownByText(driver, "//*[@name='shipping.state']", State, "NY");

            //clicking on continue
            Reusable_Library.click(driver, "//*[text()='Continue']", "Secondcontinue");
            Thread.sleep(2000);

            //clicking on continue again
            Reusable_Library.click(driver, "//*[text()='Continue']", "Thirdcontinue");
            Thread.sleep(3000);

            //entering creditcard number
            Reusable_Library.userKeys(driver, "//*[@name='creditCardNumber']", CreditCardNumber, "creditcardnumber");

            //choosing exp month
            Reusable_Library.dropdownByText(driver, "//*[@name='expMonth']", ExpMonth, "expiremonth");

            //choosing exp years
            Reusable_Library.dropdownByText(driver, "//*[@name='expYear']", ExpYear, "expireyear");

            //entering cvv code
            Reusable_Library.userKeys(driver, "//*[@name='cvv']", CvvCode,"cvvcode");

            //clicking on to place order
            Reusable_Library.click(driver, "//*[text()='Place Order']", "placeorder");

            //capture the text
            String Result = Reusable_Library.captureText(driver, "//*[@id='rvn-note-NaN']", "capturetext");
            System.out.println("The message I captured " + Result);

            //sending the message back excel
            Label label = new Label(14, i, Result);

            //adding it to the writable sheet
            writableSheet.addCell(label);
            driver.manage().deleteAllCookies();

        }//end of for loop

        writeableFile.write();
        writeableFile.close();
        readableFile.close();


    }//end of main method
    }//end of java class

