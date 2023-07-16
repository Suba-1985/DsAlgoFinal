//package dsAlgo_TestRunner;
//
//	import org.testng.annotations.DataProvider;
//
//	import io.cucumber.junit.CucumberOptions;
//	import io.cucumber.testng.AbstractTestNGCucumberTests;
//
//	@io.cucumber.testng.CucumberOptions(
//	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/cucumber.html" ,"json:target/cucumber.json"}, //reporting purpose
//	monochrome=false,  //console output color
//	 
//	features = {"src/test/resources/Features"},
//	tags = " "			,	
//	glue={"dsAlgo_StepDefinition","hooks"})//location of  step definition files
//	public class TestRunner  extends AbstractTestNGCucumberTests{
//		
//		@Override
//	    @DataProvider(parallel = false)
//	    public Object[][] scenarios() {
//					
//			return super.scenarios();
//	    }
//		
//		}	
	
package dsAlgo_TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.LoggerLoad;
import hooks.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	@io.cucumber.testng.CucumberOptions(
			plugin = {"pretty","html:target/cucumber.html" ,"json:target/cucumber.json",
					 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
	monochrome=false,  //console output color
	//features = {"src/test/resources/Features/DLoginPage.feature","src/test/resources/Features/KGraphPage.feature"},
			features = {"src/test/resources/Features"},
	tags = " ",//tags from feature file,	
	//tags={"@Login"}, //location of feature files 
	glue={"dsAlgo_StepDefinition","hooks"})//location of  step definition files
	public class TestRunner  extends AbstractTestNGCucumberTests{
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
		
		 public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();
		@BeforeTest
		@Parameters({"browser"})
		public void browserType(String browser) throws Throwable
		{ 
		TestRunner.BROWSER.set(browser);
		LoggerLoad.info("setting the browser type from test runner class "+browser);
		}
		}	
	
		
	
	
	
	
	
	
	

