package Action_items;

import Page_Object_Metlife.Metlife_Base_Class;
import Reusable_Classes.Abstract_Class;
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

public class Metlife_Test_Result extends Abstract_Class {
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet excelSheet;
    int row;



    @Test
    public void Metlife_Result () throws IOException, BiffException, InterruptedException, WriteException {
        //defining the read able workbook path

        readableFile= Workbook.getWorkbook(new File("src//main//resources//Metlife.xls"));
        //define the sheet

        readableSheet= readableFile.getSheet(0);
        //define the writable work book path
        WritableWorkbook writableFile;
        writableFile= Workbook.createWorkbook(new File("src//main//resources//Metlife_result.xls"),readableFile);
        //defining writable sheet

        excelSheet= writableFile.getSheet(0);
        row = excelSheet.getRows();

        logger.log(LogStatus.INFO," Navigating to metlife webpage ");
        for (int i = 1; i < row; i++){

            String dProgram = excelSheet.getCell(0, i).getContents();
            String Zipcode = excelSheet.getCell(1, i).getContents();
            String ReferenceCode = excelSheet.getCell(2, i).getContents();
            String capturedText = excelSheet.getCell(3, i).getContents();

            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(3000);
            Metlife_Base_Class.metlife_homepage().ClickSolution();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_homepage().ClickOnDental();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_enroll_now().clickEnroll();
            Thread.sleep(4000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Metlife_Base_Class.metlife_zipcode().SearchBox(Zipcode);
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_zipcode().clickGo();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().gettingDP(dProgram);
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().clickingEnroll();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().RefCode(ReferenceCode);
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().clickGO();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().Text();
            Thread.sleep(4000);
            Metlife_Base_Class.metlife_dental_program().enrollWithoutRefCode();
            Thread.sleep(4000);
            String result = Metlife_Base_Class.metlife_ppo_text().GetCapturedMessage();
            Thread.sleep(4000);
            Label label = new Label(3,i,result);
            excelSheet.addCell(label);

            driver.close();
            //switching back first tab
            driver.switchTo().window(tabs.get(0));



        }//end of for loop
        writableFile.write();
        writableFile.close();
        readableFile.close();




    }//end of met life result

}// end of java class
