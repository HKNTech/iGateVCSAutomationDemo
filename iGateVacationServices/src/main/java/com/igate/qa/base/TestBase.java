package com.igate.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.igate.qa.util.WebEventListener;
import com.igate.qa.util.Xls_Reader;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener; 
	
	public static String process_ID;
	public static String empName=null;
    public static String FormID=null;
    public static String FormStatus=null;
    public static String user=null;
    public static String pwd="stc123";
    public static String nID=null;
    public static String cancelDateis=null;
    public static String function_id=null;
    
    String a_VACATION_TYPE_LABEL=null;
	String a_LEAVE_FUTURE=null;
	String a_LEAVE_FUTURE_LABEL=null;
    
    public static String status_A;
    public static String status_R;
    
    public static String FinalStatus;
    public static String Result_LoginPage= null;
    public static String Result_TelephoneRequestSubmit=null;
    public static String Result_LogoutPage=null;
    public static String Result_ApprovalProcess=null;
    public static String Result_user=null;
    public static String Result_reqno=null;
    public static String Result_status=null;
    public static String Result_approver=null;
    public static String Result_CreateCell=null;
    public static int Result_ctr=0;
    public static String Result_counter="9";
    public static int eRows=0;
    public static String form_no=null;
    public static int totalRow;
    public static int rowCtr=2;
	
    
    public static Xls_Reader reader= new Xls_Reader("D:/Selenium/iGATEVacationService/iGateVacationServices/src/main/java/com/igate/qa/testdata/VacationTestData.xlsx");
	
	
	
	
	
	
	
	public TestBase() throws IOException
	{
		
		prop= new Properties();
		try {
			FileInputStream fis= new FileInputStream("D:/Selenium/iGATEVacationService/iGateVacationServices/src/main/java/com/igate/qa/config/config.properties");
		    prop.load(fis);
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws IOException 
	{
		String browserName=prop.getProperty("browser");
		
		
				
		if (browserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver",prop.getProperty("driverCPath"));
		driver=new ChromeDriver();
		
		}
		
		else if (browserName.equals("FireFox"))
		{
		System.setProperty("webdriver.gecho.driver",prop.getProperty("driverFFPath"));
		driver=new FirefoxDriver();
		}
		
		 e_driver = new EventFiringWebDriver(driver);
		 eventListener = new WebEventListener();
		 e_driver.register(eventListener);
		 driver=e_driver;
		 
		 
		driver.manage().window().maximize();
		
		 process_ID=reader.getCellData("Testdata", "Operation", rowCtr);
		 cancelDateis=reader.getCellData("Testdata", "StartDate", rowCtr);
		 function_id=reader.getCellData("Testdata", "Function", rowCtr);
		 
		driver.get(prop.getProperty("baseUrl"));
		
		
			
	}
	
	
	
	
	
	
}
