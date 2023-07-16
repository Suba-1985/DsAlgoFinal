package dsAlgo_StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DLoginPage_Sd {
	//private ALandingPage landingPage=new ALandingPage(DriverFactory.getDriver());
	private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
	private DLoginPage loginPage=new DLoginPage(DriverFactory.getDriver());
	private CRegisterPage registerPage=new CRegisterPage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader config=new ConfigReader();
	private static String error;
	private static String result;
	private static String msg;
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		driver.navigate().to(ConfigReader.homePage());
	    loginPage=homePage.signin_Btn();	   
	    LoggerLoad.info("User is on login page "+driver.getCurrentUrl());	  
	}
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
	    error= loginPage.login_click();
	   LoggerLoad.info("empty field error chek  "+error);
	 
	}
	
	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String string) {
		  Assert.assertEquals(error, string, "Please fill out this field.");
	}	
	
	@When("User enters invalid username as {string} and password as {string} and gets the result {string}")
	public void user_enters_invalid_username_as_and_password_as_and_gets_the_result(String uname, String pwd, String Result) {
	  loginPage.login_entry(uname, pwd);
	  result=Result;
	}
	
	@When("User clicks login button")
	public void user_clicks_login_button() {
	  msg= loginPage.logBtn_click();
	}
	
	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String string) {
	 		Assert.assertEquals(msg,string);
	}
	
		
	@When("User enters valid username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	  loginPage.valid_login(uname, pwd);
	}
	
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		result=loginPage.success_login();
	}
	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String string) {
	 Assert.assertEquals(result, string);
	}
	
		@When("User clicks on signout")
	public void user_clicks_on_signout() throws InterruptedException {
		loginPage=homePage.signin_Btn();	
		String uname=config.getUserName();
		String pwd=config.getPassword();
		 loginPage.valid_login(uname, pwd);
		 result=loginPage.success_login();
	   msg=loginPage.success_logout();
		  
	}
	@Then("Message displayed LoggedOut Successfully")
	public void message_displayed_logged_out_successfully() throws InterruptedException {
	 
	   LoggerLoad.info(msg +" Loggedoutsuccessfully");
	}
	
	
	
	@When("User clicks on login button with username as {string} only")
	public void user_clicks_on_login_button_with_username_as_only(String string) {
	  error=loginPage.username_login(string);
	  	}
	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String string) {
		Assert.assertTrue(error.equals(string));
	  	}
	
	@When("User clicks on login button with password as {string} only")
	public void user_clicks_on_login_button_with_password_as_only(String string) {
	  error=loginPage.password_login(string);
	  	}
	@Then("User verify the message at user as {string}")
	public void user_verify_the_message_at_user_as(String string) {
		Assert.assertTrue(error.equals(string));
	}
	

}
