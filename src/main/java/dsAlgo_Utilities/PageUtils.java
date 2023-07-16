package dsAlgo_Utilities;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	static Properties prop;
	static WebDriverWait wait ;
			
			
		 	public static void scrolldown(WebDriver driver)
		   {	
		 		JavascriptExecutor jse = (JavascriptExecutor)driver;
			    jse.executeScript("window.scrollBy(0,500)", "");
			}
	 	
	 	public static void scrolldown(WebDriver driver,WebElement e)
		{	JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)", e);
			
		}
	 
	 	public static void explicit_wait(WebDriver driver,WebElement e)
	 	{
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(e));
		}
	
	 	public static void menu_click(WebDriver driver,List<WebElement> e,String option)
	 	{
		//scrolldown(driver);
		for (WebElement item : e) 
		{
		explicit_wait(driver, item);
		if(item.getText().equalsIgnoreCase(option))
		{item.click();
		 break;		
		}
		}
		}
	 	
	 	public static void entercode(WebDriver driver,WebElement e,String code) throws InterruptedException
	 	{		
	 		for (int j=0;j<=40;j++) { 
			  	e.sendKeys(Keys.DELETE); 
			  	} 
	 		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+code+"')", e);
	 		e.sendKeys(code);
	 			Thread.sleep(2000);
	 			
		}
	 	
	 	public static void mouse_action(WebDriver driver,WebElement e) 
	 	{
		Actions act=new Actions(driver);
		act.scrollToElement(e);	
		}
	 	
	 	
		public static String[] getPythonCodefromExcel(String sheetname, int rownumber) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			ExcelReader reader = new ExcelReader();
			String arrayinput[]=new String[2];
			List<Map<String, String>> testdata = reader.getData(ConfigReader.programdataExcelpath(), sheetname);
			String pcode = testdata.get(rownumber).get("Pythoncode");	
			String result=testdata.get(rownumber).get("Result");
			arrayinput[0]=pcode;
			arrayinput[1]=result;
			return arrayinput;			

		}
		
		
		public static void practice_click(WebElement pQ)
	 	{	
	 		pQ.click();
	 		
	 	}
			
}
