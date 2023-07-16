package dsAlgo_PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.PageUtils;

public class EDataStructurePage {
		private String result;
		 @FindBy(xpath = "//a[text()='Try here>>>']")private WebElement tryhere;
		 @FindBy(xpath = "//button[text()='Run']" )private WebElement runbtn;
		 @FindBy(xpath = "//input[@value='Submit']" )private WebElement submitbtn;	
		 @FindBy(id = "output")private WebElement outputbox;
		 @FindBy (xpath="//a[@href='/tryEditor']")WebElement tryEditor_link;
		  @FindBy(xpath="//form/div/div/div/textarea")private WebElement tryEditor;
	@FindBy(xpath ="//button[text()='Run']")private WebElement runBtn;
	 @FindBys(value = {@FindBy(how = How.XPATH,using="//div[contains(@style,'margin-bottom')]/ul")}) private List<WebElement> datastructuremenu;
	private WebDriver driver;

	public EDataStructurePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	public void datastructuremenu_click(String option)
	{PageUtils.menu_click(driver, datastructuremenu, option);
	}
	
	public void tryedit_click()
	{	PageUtils.scrolldown(driver);
	PageUtils.scrolldown(driver);
		tryhere.click();
	} 
	public void tryEditorlink() {
		tryEditor_link.click();
	}
	
	public void enter_code(String code) throws InterruptedException 
	{			
		String text=code;
	 ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+text+"')", tryEditor);
	 tryEditor.sendKeys(code);
	Thread.sleep(2000);
	
	}
	public void click_run() 
	{	
		PageUtils.mouse_action(driver, runbtn);
		//PageUtils.explicit_wait(driver,runbtn);
		runbtn.click();
	}
	public void click_submit()
	{
		PageUtils.mouse_action(driver, submitbtn);
		submitbtn.click();
		//result= driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		
	}
	public String present_result()
	{
	result=	outputbox.getText();
	return result;
	}
	public String present_invalidmsg()
	{
		result=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return result; 
	}

	
}
	