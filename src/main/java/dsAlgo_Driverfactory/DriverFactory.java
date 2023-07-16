package dsAlgo_Driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgo_Utilities.LoggerLoad;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	WebDriverWait  explicit_wait_Example;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser,String url)
	{
		LoggerLoad.info("Driver : Initializing the driver first");
		
		if(browser.equals("chrome"))
		{   LoggerLoad.info(browser + " Browser is Opening");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			LoggerLoad.info(browser + " Browser is Opening");
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else if(browser.equals("firefox"))
		{
			LoggerLoad.info(browser + " Browser is Opening");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else
		{
			LoggerLoad.info("Browser Name is Missing");
		}

	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(url);
	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
	return getDriver();
	}

//this is used to get the driver with thread local
public static synchronized WebDriver getDriver()
{
	return tlDriver.get();
}
}
