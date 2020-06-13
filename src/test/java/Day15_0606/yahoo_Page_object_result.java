package Day15_0606;

import Reusable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class yahoo_Page_object_result extends Abstract_Class {

  @Test
  public void Yahoo_search_result() throws InterruptedException {
      logger.log(LogStatus.INFO, "navigate to yahoo");
      driver.navigate().to("https://www.yahoo.com");
      Thread.sleep(2500);
      Yahoo_Base_Class.Yahoo_homepage().searchField("cars");
      Yahoo_Base_Class.Yahoo_homepage().searchIcon();
      Thread.sleep(2500);
      Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
      Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

  }

  }