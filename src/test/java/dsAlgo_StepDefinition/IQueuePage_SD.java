package dsAlgo_StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.IQueuePage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.PageUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IQueuePage_SD {
	private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
	private IQueuePage queuePage=new IQueuePage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader config=new ConfigReader();
	private PageUtils pageUtil=new PageUtils();
	private static String actualAlertText;
	private static String errormsg;
	private static String outputresult;
	
	
	
	@Given("user clicks the queue getstart link")
	public void user_selects_the_queue_getstartitem() throws InterruptedException {
		driver.navigate().to(ConfigReader.homePage());
		queuePage=homePage.queue_getstart();
	   		}
		@Then("user is on the queue Page")
	public void user_should_be_in_the_queue_page() throws InterruptedException {
	   String url=driver.getCurrentUrl();
	    Assert.assertTrue(url.contains("/queue/"));	
	}
	@Then("user checks for the title {string} in the queue page")
	public void user_checks_for_the_title_in_the_queue_list_page(String title) {	 
		   String url=driver.getCurrentUrl();
		   Assert.assertTrue(url.contains("/queue/"));	
	       Assert.assertEquals(driver.getTitle(),title);
	}
	
	@When("The user select all option {string} from the queue page and Verifies the tryeditor Page with the valid python code for each option  {string} and {int}")
	public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_valid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		String pCode[]=pageUtil.getPythonCodefromExcel(sheetName,rownumber);	
	    String result=queuePage.validPythonCode(pCode[0],option);		
		Assert.assertEquals(result, pCode[1]);	
	}
	
	@When("The user select all option {string} and Verifies the tryeditor Page with the Invalid python code for each option  {string} and {int}  in the queue page")
	public void The_user_select_all_option_and_Verifies_the_tryeditor_Page_with_the_Invalid_python_code_for_each_option_string_and_int_in_the_queue_page(String option, String sheetName, Integer rownumber) throws InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException, InterruptedException
	{		 String pCode[]=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
	         System.out.println(pCode[0]+ pCode[1]);
		  	String out=queuePage.inValidPythonCode(pCode[0],option);					
			outputresult=pCode[1];
			Assert.assertEquals(out, pCode[1]);
	}
	
	 @Then("user should get the {string} on the screen in the queue page")
	   public void user_should_get_the_erroroutput(String output)
	   {  Assert.assertEquals(output, outputresult);	
	   }
	
}
