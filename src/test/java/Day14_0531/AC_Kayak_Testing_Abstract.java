package Day14_0531;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AC_Kayak_Testing_Abstract extends Abstract_Class {


    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet excelSheet;


    //initiate row count
    int row;


    @Test
    public void KayakTestCase() throws InterruptedException, WriteException, IOException, BiffException {


            //defining the read able workbook path

            readableFile= Workbook.getWorkbook(new File("src//main//resources//AC_Kayak.xls"));
            //define the sheet

            readableSheet= readableFile.getSheet(0);
            //define the writable work book path
            WritableWorkbook writableFile;
            writableFile= Workbook.createWorkbook(new File("src//main//resources//AC_Kayak_results.xls"),readableFile);
            //defining writable sheet

            excelSheet= writableFile.getSheet(0);
            row = excelSheet.getRows();




            logger.log(LogStatus.INFO,"Navigating to Kayak page");
            for(int i = 1; i < 5; i++) {
                driver.navigate().to("https://www.kayak.com");
                Thread.sleep(2000);
                //click on Search field
                Reusable_Library_loggers.click(driver,"//*[contains(@id,'pickup-field')]","Search Filed",logger);
                //enter keyword on search field
                String airports = excelSheet.getCell(0,i).getContents();
                Reusable_Library_loggers.userKeys(driver,"//*[@name='pickup']",airports,"Search Field",logger);

                //click on car result item as first one
                Reusable_Library_loggers.click(driver,"//*[@class='item-info']","Car Result",logger);

                //click on drop off
                Reusable_Library_loggers.click(driver,"//*[@data-placeholder='Drop-off']","Drop-off Date",logger);
                Thread.sleep(2000);
                //enter pick up date
                String dropOffDate = excelSheet.getCell(3,i).getContents();
                Reusable_Library_loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'dropoff-date-input')]",dropOffDate,"Drop-off Date",logger);
                Thread.sleep(2000);
                //click somewhere outside
                Reusable_Library_loggers.click(driver,"//*[@class='title dark']","Text Content",logger);

                //click on drop off time
                Thread.sleep(1000);
                Reusable_Library_loggers.click(driver,"//*[contains(@id,'end-time-select')]","Drop off Time",logger);
                //choose drop off up time
                Thread.sleep(2000);
                String dropOffTime = excelSheet.getCell(4,i).getContents();
                Reusable_Library_loggers.Mouseclick(driver,"//*[contains(@id,'end-time-select-option') and @data-title='"+dropOffTime+"']","Choose Drop-off Time",logger);

                //click on pick up date
                Reusable_Library_loggers.click(driver,"//*[@data-placeholder='Pick-up']","Pick-up Date",logger);
                Thread.sleep(2000);
                //enter pick up date
                String pickupDate = excelSheet.getCell(1,i).getContents();
                Reusable_Library_loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'pickup-date-input')]",pickupDate,"Pick-up Date",logger);
                //click somewhere outside
                Reusable_Library_loggers.click(driver,"//*[@class='title dark']","Text Content",logger);

                //choose pick up time
                Thread.sleep(2000);
                String pickupTime = excelSheet.getCell(2,i).getContents();
                Reusable_Library_loggers.Mouseclick(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+pickupTime+"']","Choose Drop-off Time",logger);

                //click on search icon
                Reusable_Library_loggers.click(driver,"//*[@title='Search cars']","Search Icon",logger);
                Thread.sleep(4000);
                //click on vehicle size checkbox
                String vehicleSize = excelSheet.getCell(5,i).getContents();
                Reusable_Library_loggers.click(driver,"//div[text()='"+vehicleSize+"']","Vehicle Size Checkbox",logger);

                //click on second View Deal button
                Thread.sleep(5000);
                Reusable_Library_loggers.clickByIndex(driver,"//*[text()='View Deal']",1,"View Deal",logger);

                ArrayList<String> list = new ArrayList(driver.getWindowHandles());
                driver.switchTo().window(list.get(1));
                Thread.sleep(2000);
                String result = Reusable_Library_loggers.captureText(driver,"//*[contains(@class,'bui-panel') or @class='search' or @class='booking-section' or @class='addressGrid']","Car Info",logger);
                Label label = new Label(6,i,result);
                excelSheet.addCell(label);
                driver.close();
                driver.switchTo().window(list.get(0));
                driver.manage().deleteAllCookies();


            }//end of loop

                writableFile.write();
                writableFile.close();
                readableFile.close();
                //driver.quit();

        }//end of test method

}// end of java class
