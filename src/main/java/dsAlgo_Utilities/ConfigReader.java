package dsAlgo_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	
	public Properties init_prop() throws IOException
	{
		prop=new Properties();
		try
		{
			FileInputStream ip=new FileInputStream("src\\test\\resources\\dsAlgo_Config\\Config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;		
	}
	
	public static String getUrl1()
	{   
		
		String getUrl=prop.getProperty("url");
		if(getUrl!=null)
		{
			return getUrl;
		}else
		{
			System.out.println("url is not mentioned in config properties");
		}	return getUrl;	
	}
	
	public static String homePage() {
		String homepageurl = prop.getProperty("homePageUrl");
		if (homepageurl != null)
			return homepageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}
	
	public static String registerPage()
	{
		String registerpageurl=prop.getProperty("registerPageUrl");
		if(registerpageurl != null)
		return registerpageurl;
		else throw new RuntimeException("RegisterationPageurl not specified in the Config.properties file");			
	}
	public static String ArrayPage()
	{
		String arraypageurl=prop.getProperty("arrayPageUrl");
		if(arraypageurl != null)
		return arraypageurl;
		else throw new RuntimeException("ArrayPageurl not specified in the Config.properties file");			
	}
	public static String datastructurePage()
	{
		String datastructurepageurl=prop.getProperty("datastructurePageUrl");
		if(datastructurepageurl != null)
		return datastructurepageurl;
		else throw new RuntimeException("dataStructurepageurl not specified in the Config.properties file");			
	}
	
	public static String timecomplexityurl()
	{
		String timecomplexity=prop.getProperty("timecomplexity");
		if(timecomplexity != null)
		return timecomplexity;
		else throw new RuntimeException("dataStructurepageurl not specified in the Config.properties file");			
	}
	public static String stackPage()
	{
		String stackpageurl=prop.getProperty("stackPageUrl");
		if(stackpageurl != null)
		return stackpageurl;
		else throw new RuntimeException("stackPageurl not specified in the Config.properties file");			
	}
	public static String treePage()
	{
		String treepageurl=prop.getProperty("treePageUrl");
		if(treepageurl != null)
		return treepageurl;
		else throw new RuntimeException("treePageurl not specified in the Config.properties file");			
	}
	public static String linkedlistPage()
	{
		String linkedlistpageurl=prop.getProperty("linkedlistPageUrl");
		if(linkedlistpageurl != null)
		return linkedlistpageurl;
		else throw new RuntimeException("linkedlistPageurl not specified in the Config.properties file");			
	}
	public static String graphPage()
	{
		String graphpageurl=prop.getProperty("graphPageUrl");
		if(graphpageurl != null)
		return graphpageurl;
		else throw new RuntimeException("graphPageurl not specified in the Config.properties file");			
	}
	public static String queuePage()
	{
		String queuepageurl=prop.getProperty("queuePageUrl");
		if(queuepageurl != null)
		return queuepageurl;
		else throw new RuntimeException("queuePageurl not specified in the Config.properties file");			
	}
	public static String loginPage()
	{
		String loginpageurl=prop.getProperty("loginPageUrl");
		if(loginpageurl != null)
		return loginpageurl;
		else throw new RuntimeException("loginPageurl not specified in the Config.properties file");			
	}
	public static String excelPath()
	{
		String ExcelPath=prop.getProperty("ExceldataPath");
		if(ExcelPath!=null)		
			return ExcelPath;
			else throw new RuntimeException("Excel data path missing");
		
	}
	public static String programdataExcelpath()
	{
		String ExcelPath=prop.getProperty("programdataExcel");
		if(ExcelPath!=null)		
			return ExcelPath;
			else throw new RuntimeException("Excel data path missing");
		
	}
}
