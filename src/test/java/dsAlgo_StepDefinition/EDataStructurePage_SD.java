package dsAlgo_StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.EDataStructurePage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerLoad;
import dsAlgo_Utilities.PageUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EDataStructurePage_SD {
	private EDataStructurePage dataStructurePage=new  EDataStructurePage(DriverFactory.getDriver());
	private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader config=new ConfigReader();
	private PageUtils pageUtil=new PageUtils();
	private String code;
	private String actualresult;;
	private String expectedresult;

	@Given("The user is on the {string} page")
	public void the_user_is_on_the_ds_after_logged_in(String string) throws InterruptedException {
		driver.navigate().to(ConfigReader.homePage());
		dataStructurePage=homePage.datastructure_getstart();			
		LoggerLoad.info("User is in :" +driver.getTitle());
	}
	@When("The user clicks {string} button of Datastructure page")
	public void the_user_clicks_button_of_datastructure_page(String string) {
		dataStructurePage.datastructuremenu_click(string);
	}
	@Then("The user in  {string} of Datastructure page")
	public void the_user_in_of_datastructure_page(String string) {
		Assert.assertEquals(driver.getTitle(),string);		
	}


@Given("The user is in a {string} page having an tryEditor with a Run button to test for DS")
public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test_for_ds(String string) throws InterruptedException {
	driver.navigate().to(ConfigReader.datastructurePage());
	//dataStructurePage=homePage.datastructure_getstart();	
	dataStructurePage.datastructuremenu_click(string);
	dataStructurePage.tryedit_click();
}
@When("The user enter valid python DS code in tryEditor from sheet {string} and {int}")
public void the_user_enter_valid_python_ds_code_in_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
	String pCode[]=pageUtil.getPythonCodefromExcel(SheetName,rowno);	
	expectedresult=pCode[1];
	dataStructurePage.enter_code(pCode[0]);   
	
}

@When("The user clicks on run button for DS")
public void the_user_clicks_on_run_button_for_ds() {
    dataStructurePage.click_run();
}

@Then("The user should be presented with Run result for DS")
public void the_user_should_be_presented_with_run_result_for_ds() {
	actualresult=dataStructurePage.present_result();
	//Assert.assertEquals(actualresult, expectedresult);
}

@When("The user enter python DS code with invalid syntax in tryEditor from sheet {string} and {int}")
public void the_user_enter_python_ds_code_with_invalid_syntax_in_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
	String pCode[]=pageUtil.getPythonCodefromExcel(SheetName,rowno);
	dataStructurePage.enter_code(pCode[0]);   
	expectedresult=pCode[1];
	System.out.println(pCode[0] +pCode[1] + "code check");
}
@Then("The user should be presented with error message for DS")
public void the_user_should_be_presented_with_error_message_for_ds() {
		actualresult=dataStructurePage.present_invalidmsg();
	//	Assert.assertEquals(actualresult, expectedresult);
		System.out.println(actualresult+expectedresult + "code check");
		
}
	
	
}