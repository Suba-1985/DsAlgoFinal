package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_TestRunner.TestRunner;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerLoad;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	private static DriverFactory driverFactory;
	private static WebDriver driver;
	private static ConfigReader configReader;
	static Properties prop;
	static WebDriverWait wait ;
	static ExcelReader reader=new ExcelReader();
	
	
	@BeforeAll(order=0)
	public static void getProperty() throws Throwable
	{  
		configReader =new ConfigReader();
		prop=configReader.init_prop();	
    	String browserName = TestRunner.BROWSER.get(); //gets the browsername from the testrunner parameter
	//	String browserName=prop.getProperty("browser");
		String geturl=prop.getProperty("url");
		LoggerLoad.info("Launching the URL :"+geturl);
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName,geturl);
	}
	
	@BeforeAll(order=1)
	public static void getStart() throws IOException
	{  
		BHomePage homePage=new BHomePage(driver);
	try {
		homePage.click_Btn();
	    } catch (InterruptedException e)
	    {
		e.printStackTrace();
	    }
	}

	@AfterAll(order=1)// will execute after "1" then order 0
	public static void quitBrowser()
	{
		LoggerLoad.info("Closing App");
		
	//	prop.clear();
		driver.close();
	}
	
	
	@After(order=0)//for After it will start from 1 and then 0
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())//take ScreenShot;
		{	LoggerLoad.error("Scenario Failed");
			String screenShotName=scenario.getName().replaceAll("", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", screenShotName);
		}
	}
}
