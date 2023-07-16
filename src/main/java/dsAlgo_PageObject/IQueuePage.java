package dsAlgo_PageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_Utilities.PageUtils;

public class IQueuePage {
	 private  WebDriver driver=DriverFactory.getDriver();
	    private PageUtils pageUtil=new PageUtils();
	    private static String queue_url;
	    private static String queue_title;
	    private String alertText;
	    private String alert;
	    private String result;

	public IQueuePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		    
	  @FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement drop_down;
	  @FindBy(xpath="//div[@class='dropdown-menu']/a")private WebElement menu_List;
	  @FindBy(xpath="//h4[contains(@class,'bg-secondary text-white')]")private WebElement title_header;
	  @FindBy(xpath="//a[text()='Try here>>>']")private WebElement try_Btn;
	  @FindBy(xpath="//*[@id='answer_form']/div/div/div[1]/textarea")private WebElement tryEditor;
	  @FindBy(xpath="//button[text()='Run']")private WebElement runBtn;
	  @FindBy(xpath="//pre[@id='output']")private WebElement output;
	  @FindBy(xpath="//div[@class='dropdown-menu']/a") private List<WebElement> list;
	  @FindBy(xpath="//a[text()='Practice Questions']") private WebElement practice_QuestionsLink;
	  @FindBy(xpath="//ul/a[@class='list-group-item']") private  List<WebElement> topics; 
		

		public void drop_downClick(String menuitem) {
			drop_down.click();	
			PageUtils.menu_click(driver, topics,menuitem);
		}	
		
		public String get_url()
		{ 
			return queue_url;		
		}
		
		public String get_title()
		{				
			return queue_title;
		}


		public String validPythonCode(String pCode, String options ) throws InterruptedException {
			
					PageUtils.menu_click(driver, topics, options);
			    	try_Btn.click();			
					tryEditor.sendKeys(pCode);
					runBtn.click();		       
					result=output.getText();
					return result;
			}
		  
			
		public String inValidPythonCode(String pCode, String options ) throws InterruptedException {		
			
					PageUtils.menu_click(driver, topics, options);
				 	try_Btn.click();
					//PageUtils.mouse_action(driver, tryEditor);
					tryEditor.sendKeys(pCode);
					runBtn.click();		       
					alert=isAlertPresent();
					return alert;
			}
			

		public String isAlertPresent() {
		   
		    try {	       
		        Alert alert = driver.switchTo().alert();	       
		        alertText=alert.getText();
		        alert.accept();    
		    } catch (NoAlertPresentException ex) {	      
		        ex.printStackTrace();
		    }
		    return alertText;
		}

		public void practice_link(String practice) {
			
			PageUtils.practice_click(practice_QuestionsLink);
		}

}
