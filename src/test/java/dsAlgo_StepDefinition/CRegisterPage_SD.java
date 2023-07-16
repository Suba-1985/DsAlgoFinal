package dsAlgo_StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.diagnostics.logging.Logger;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerLoad;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRegisterPage_SD {
	private ALandingPage landingPage=new ALandingPage(DriverFactory.getDriver());
	private BHomePage homePage=new BHomePage(DriverFactory.getDriver());	
	private CRegisterPage registerPage=new CRegisterPage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader reader=new ConfigReader();
	private DLoginPage loginPage=new DLoginPage(DriverFactory.getDriver());
	Properties prop;
	WebDriverWait wait;
	String error;
	
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() throws InterruptedException {
		registerPage=homePage.register_Btn();
		LoggerLoad.info("Navigated to registerurl "+driver.getCurrentUrl());
		
	}

	@When("User click Register with all empty field")
	public void the_user_clicks_register_button_with_all_fields_empty() {
		 registerPage.clickregister();		
	}

	@Then("It should display an error {string} below username textbox")
	public void it_should_display_an_error_below_username_textbox(String expected_errormsg) {		    
	    Assert.assertEquals(registerPage.clickregister(),expected_errormsg);
	}

	@When("The user clicks Register button after entering username with other fields empty")
	public void the_user_clicks_register_button_after_entering_username_with_other_fields_empty(DataTable uname) throws InterruptedException {
		List<Map<String,String>> list=uname.asMaps(); //******Using Map for with header datatable
		String userName=list.get(0).get("username");
		error=registerPage.clickregisterWith_username(userName);
	}
	
	@Then("It should display an error {string} below password textbox")
	public void it_should_display_an_error_below_password_textbox(String expected_errormsg) {
		String actual_errormsg=error;	
		Assert.assertEquals(actual_errormsg,expected_errormsg);
	}	
	
	@When("The user clicks Register button after entering password with other fields empty")
	public void the_user_clicks_register_button_after_entering_password_with_other_fields_empty(DataTable pwd) throws InterruptedException {
		List<Map<String,String>> list=pwd.asMaps(); 
		String pwd1=list.get(0).get("password");
		error=registerPage.clickregisterWith_pwd(pwd1);
	}
	

	@When("The user clicks Register button after entering confirmation password with other fields empty")
	public void the_user_clicks_register_button_after_entering_confirmation_password_with_other_fields_empty(DataTable pswd) throws InterruptedException {
		List<Map<String,String>> list=pswd.asMaps(); 
		String pwd1=list.get(0).get("confirm password");
		error=registerPage.clickregisterWithconfirm_pwd(pwd1);
		
	}
	@Then("It should display an error {string} below Password Confirmation textbox")
	public void it_should_display_an_error_below_password_confirmation_textbox(String expected_errormsg) {
		String actual_errormsg=error;	
		Assert.assertEquals(actual_errormsg,expected_errormsg);
	}	
	
	
	@When("User enters username and password only and click register")
	public void User_enters_username_and_password_only_and_click_register( DataTable credentials) {
		List<Map<String,String>> list=credentials.asMaps();
		String uName=list.get(0).get("username");
		String pwd=list.get(0).get("password");
		error=registerPage.login_entry(uName, pwd);	    
	}
	@Then("User verify the message at confirmpassword on Register Page as {string}")
	public void user_verify_the_message_at_confirmpassword_on_register_page_as(String expected_errormsg) {
	    String actual_errormsg=error;	
		Assert.assertEquals(actual_errormsg,expected_errormsg);
	}	
		
	@When("user enter invalid {string},{string} and {string}")
	public void user_enter_username_password_and_confirmpassword(String username,String password,String confirmpassword) throws InterruptedException {
	    error= registerPage.invalidDataCredentials(username, password, confirmpassword);
	   	}
	
	@Then("User verifies for the mismatch error message {string}")
	public void user_verifies_for_the_mismatch_error_message(String mismatcherror) {
	    Assert.assertEquals(error,mismatcherror);
	}
	
	@When("user enter the sheetname {string} and row number {int}")
	public void user_enter_the_sheetname_and_row_number(String sheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
	    ExcelReader excel=new ExcelReader();
	    List<Map<String,String>> list=excel.getData(ConfigReader.excelPath(), "validcredentials");
	    String uname=list.get(rownumber).get("username");
	    String pwd=list.get(rownumber).get("password");
	    String cpwd=list.get(rownumber).get("confirmpassword");
	    loginPage=registerPage.validDataCredentials(uname, pwd, cpwd);
	   LoggerLoad.info("LandingPage after register "+driver.getCurrentUrl());
	}

	@Then("User verifies for the successful registration message")
	public void user_verifies_for_the_mismatch_error_message() throws InterruptedException {
		
	  Assert.assertEquals(driver.getCurrentUrl(),ConfigReader.homePage());
	  Assert.assertEquals(driver.getTitle(), "NumpyNinja");
	  loginPage.success_logout();
	}
	
	
}
