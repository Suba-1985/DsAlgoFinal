package dsAlgo_PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.PageUtils;



public class BHomePage {
	private WebDriver driver;
	 String str2;
	 WebDriverWait wait;
	 String homePageurl=ConfigReader.homePage();
	 
	 @FindBy (xpath = "//h5[text()='Data Structures-Introduction']/..//a")private WebElement getStartedDSintro_link;
	@FindBy(xpath="//div[@class='dropdown-menu']//a")private WebElement menu_Options; 
	@FindBy(xpath="//div[@class='alert alert-primary']")private WebElement error_msg;
	@FindBy(xpath="//a[text()='Data Structures']")private WebElement menudropdown;
	@FindBy(xpath="//button[text()='Get Started']")private WebElement getStarted_btn;
	@FindBy(xpath="//a[text()='Sign in']")private WebElement signIn;
	@FindBy(xpath="//a[text()=' Register ']")private WebElement register;
	@FindBy(xpath = "//div[contains(@class,'alert ')]")private WebElement signinalert;
	@FindBy(xpath = "//h5[text()='Array']/..//a")private WebElement arraygetstart;
	@FindBy(xpath = "//h5[text()='Stack']/..//a")private WebElement stackgetstart;
	@FindBy(xpath = "//h5[text()='Tree']/..//a")private WebElement treegetstart;
	@FindBy(xpath = "//h5[text()='Graph']/..//a")private WebElement graphgetstart;
	@FindBy(xpath = "//h5[text()='Queue']/..//a")private WebElement queuegetstart;
	@FindBy(xpath="//a[@href='linked-list']") private WebElement linkedliststart;
	@FindBys(value = { @FindBy(how = How.XPATH,using="//div[contains(@class,'dropdown-')]/a")}) public List<WebElement> menulist;
	
	
	
	public BHomePage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	 public BHomePage click_Btn() throws InterruptedException
	    {   PageUtils.explicit_wait(driver, getStarted_btn);
	    	getStarted_btn.click();
			return new BHomePage(driver);    	
	    }
	
	public void homepage() {
		driver.get(homePageurl);		
	}	
	
	
   public void dropDownList(String string) throws InterruptedException
   { 
	 //new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(menudropdown));
	 		menudropdown.click();
	 			for (WebElement getitem : menulist) {
	 			new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(getitem));
	 			if(getitem.getText().equals(string))
	 			{	
	 				getitem.click();
	 				str2= signinalert.getText();
	 				break;	 				
	 			}
	 			}
   }		
   
   public void getStartBtn_click()
   {
	   List<WebElement> getStartList=driver.findElements(By.xpath("//a[text()='Get Started']"));
	  // System.out.println(getStartList.size());
	   for(WebElement getList:getStartList)
	   {
		   getList.click();
		   String error=error_msg.getText();
		   break;		
	   }	   
   }
   
   public String getErr_msg()
	{
		String error=error_msg.getText();
		return error;
	}	
	
	public DLoginPage signin_Btn()
	{	PageUtils.explicit_wait(driver, signIn);
		signIn.click();
		return new DLoginPage(driver);
	}
	
	public CRegisterPage register_Btn() throws InterruptedException
	{  PageUtils.explicit_wait(driver, register);
		register.click();		
		return new CRegisterPage(driver);
	}

	public void menuDropDown() {
		menudropdown.click();
	}
	public void getStartBtn_click(String option)throws InterruptedException
	{		
	 // WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optlst));
	 String message=signinalert.getText();
	 if(message.equalsIgnoreCase("You are logged in"))
	 {
		 WebElement optlst= driver.findElement(By.xpath("//h5[text()='"+option+"']/../a")); 
		 optlst.click();
	 }
	 }
	 public FArrayPage array_getstart() throws InterruptedException
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		arraygetstart.click();
		return new FArrayPage(driver); 
	 }
	 public EDataStructurePage datastructure_getstart() throws InterruptedException
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		 getStartedDSintro_link.click();
		return new EDataStructurePage(driver); 
	 }
	 public HStackPage stack_getstart()
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		stackgetstart.click();
		return new HStackPage(driver); 
	 }
	 public KGraphPage graph_getstart()
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		graphgetstart.click();
		return new KGraphPage(driver); 
	 }
	 public GLinkedListPage ll_getStart() throws InterruptedException
		{    
		 	linkedliststart.click();
			return new GLinkedListPage(driver);		
		}
	 public JTreePage tree_getstart()
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		treegetstart.click();
		return new JTreePage(driver); 
	 }
	 public IQueuePage queue_getstart()
	 {
		//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
		queuegetstart.click();
		return new IQueuePage(driver); 
	 }
}
