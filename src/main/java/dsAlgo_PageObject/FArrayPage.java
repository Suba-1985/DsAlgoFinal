package dsAlgo_PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsAlgo_Utilities.*;
public class FArrayPage extends PageUtils{
	private WebDriver driver;
	public FArrayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
					}
	private String result;
	 @FindBy(xpath = "//ul/a[text()='Arrays in Python']")private WebElement arrayinpython;
	 @FindBy(xpath = "//a[text()='Try here>>>']")private WebElement tryhere;
	 @FindBy(xpath = "//button[text()='Run']" )private WebElement runbtn;
	 @FindBy(xpath = "//input[@value='Submit']" )private WebElement submitbtn;	
	 @FindBy(id = "output")private WebElement outputbox;
	  @FindBy(xpath="//form/div/div/div/textarea")private WebElement tryEditor;
	 @FindBy(xpath = "//a[text()='Practice Questions']") WebElement practicequestionlink;
	 @FindBys(value = { @FindBy(how = How.XPATH,using="//div[contains(@style,'margin-bottom')]/ul")}) private List<WebElement> arraymenu;
	 @FindBys(value = { @FindBy(how = How.XPATH,using="//div[@class='list-group']/a")}) private List<WebElement> practicemenu;
	 private PageUtils pageutil=new PageUtils();	
	
public void arrayinpython_click() 
{  	PageUtils.scrolldown(driver);
	//PageUtils.explicit_wait(driver, arrayinpython);
	arrayinpython.click();
}
public void arrymenu_click(String option)
{PageUtils.menu_click(driver, arraymenu, option);}

public void practicemenu_click(String option)
{PageUtils.menu_click(driver, practicemenu, option);}


public void tryedit_click()
{	PageUtils.scrolldown(driver);
    PageUtils.scrolldown(driver);
	tryhere.click();
} 
public void practice_click()
{	//PageUtils.explicit_wait(driver, practicequestionlink);
	practicequestionlink.click();
}
public void enter_code(String code) throws InterruptedException 
{String text=code;
((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+text+"')", tryEditor);
tryEditor.sendKeys(code);
	Thread.sleep(2000);
	}

public void entercodepractice(String code) throws InterruptedException 
{
PageUtils.entercode(driver,tryEditor,code);

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
	result= driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	return result; 
}
}




