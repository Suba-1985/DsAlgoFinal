package dsAlgo_StepDefinition;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_PageObject.EDataStructurePage;
import dsAlgo_PageObject.GLinkedListPage;
import dsAlgo_PageObject.KGraphPage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.PageUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class KGraphPage_SD {

	
		private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
		private KGraphPage graphPage=new KGraphPage(DriverFactory.getDriver());
		private WebDriver driver=DriverFactory.getDriver();
		private ConfigReader config=new ConfigReader();
		private PageUtils pageUtil=new PageUtils();
		private static String actualAlertText;
		private static String errormsg;
		private static String outputresult;
		
		
		
		@Given("user clicks the Graph getstart link")
		public void user_selects_the_linked_list_getstartitem() throws InterruptedException {
			driver.navigate().to(ConfigReader.homePage());
		   graphPage=  homePage.graph_getstart();
		   		}

		@Then("user is on the Graph Page")
		public void user_should_be_in_the_linked_list_page() throws InterruptedException {
		   String url=driver.getCurrentUrl();
		    Assert.assertTrue(url.contains("/graph/"));	
		}

		@Then("user checks for the title {string} in the Graph page")
		public void user_checks_for_the_title_in_the_linked_list_page(String title) {	 
			   String url=driver.getCurrentUrl();
			   Assert.assertTrue(url.contains("/graph/"));	
		       Assert.assertEquals(driver.getTitle(),title);
		}

		
		@When("The user select all option {string} from the graph page and Verifies the tryeditor Page with the valid python code for each option  {string} and {int}")
		public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_valid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			
			String pCode[]=pageUtil.getPythonCodefromExcel(sheetName,rownumber);	
		    outputresult=graphPage.validPythonCode(pCode[0],option);		
		    System.out.println(outputresult + pCode[1] +"compare" );
			Assert.assertEquals(outputresult, pCode[1]);	
		}
		
		@Then("user should be presented with the run result in the screen {string}")
		public void user_should_be_presented_with_the_run_result(String result)
		{  try {
			Assert.assertTrue(outputresult.contains(result));
		}catch(Exception e)
		{
			System.out.println(outputresult+ " something went wrong");
		}
		}
		
		@When("The user select all option {string} and Verifies the tryeditor Page with the Invalid python code for each option  {string} and {int}  in the graph page")
		public void The_user_select_all_option_and_Verifies_the_tryeditor_Page_with_the_Invalid_python_code_for_each_option_string_and_int_in_the_graph_page(String option, String sheetName, Integer rownumber) throws InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException, InterruptedException
		{
			String pCode[]=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
			 String outputresult=graphPage.inValidPythonCode(pCode[0],option);		
				Assert.assertEquals(outputresult, pCode[1]);
				actualAlertText=pCode[1];
		}
		
	   @Then("user should get the {string} on the screen")
	   public void user_should_get_the_erroroutput(String output)
	   {  Assert.assertEquals(output, actualAlertText);	
	   }


	}


