package com.igate.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.igate.qa.base.TestBase;
import com.igate.qa.util.CommonUtil;

public class ModifyLeavePage extends TestBase{

	public ModifyLeavePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public  void ModifyLeave() throws Exception
	{
		
		 
		
		//FileInputStream fis=new FileInputStream("D:/Selenium/iGATE/VacationService/src/VacationAutomation/config.properties");
		// prop.load(fis);	
		
		 driver.navigate().to("https://igate-bat.stc.com.sa/en/group/i-gate/e-services/human-resources/trip-and-leave-service/vcs");
		
		
		String startdate= reader.getCellData("Testdata", "MStartDate",  rowCtr);
		String enddate= reader.getCellData("Testdata", "MEndDate",  rowCtr);
		String delegatedEmployee=  reader.getCellData("Testdata", "DelegatedEmployee",  rowCtr);
		String cash= reader.getCellData("Testdata", "CashAdvance",  rowCtr);
		String modifydate= reader.getCellData("Testdata", "StartDate",  rowCtr);
		
		Thread.sleep(5000);
		 driver.findElement(By.xpath( prop.getProperty("rdoModify"))).click();
		
		
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 List<WebElement> elements =  driver.findElements((By.xpath("//table[contains(@class,'t1 cancelVacation')] /tbody/tr[1]/td[1]/parent::*/parent::*/parent::*")));
			
		 for(WebElement ele:elements)
			{

			  //   System.out.println("The Id is : " + ele.getAttribute("id"));     // for getting id of each element

			  //   System.out.println("The test is : " + (ele.getText()).substring(0,10));              //for getting text of each element
			       
			     String cancelDate= (ele.getText()).substring(0,10);
			     
			     if (cancelDate.equals(modifydate)) 
			     {
			    	  nID= ele.getAttribute("id");
			    	 System.out.println("The Element Xpath is : "+ nID);
			     }

			}
		 
		  driver.findElement(By.xpath("//input[contains(@value,'"+  nID +"')]")).click();
		  
		  ((JavascriptExecutor) driver).executeScript ("document.getElementById('OF.A_START_DATE').removeAttribute('readonly',0);"); // Enables the from date box

			 WebElement fromDateBox=  driver.findElement(By.id( prop.getProperty("txtStartDate")));
			 fromDateBox.clear();
			 fromDateBox.sendKeys(startdate);
			 
			 
			 ((JavascriptExecutor) driver).executeScript ("document.getElementById('OF.A_END_DATE').removeAttribute('readonly',0);"); // Enables the from date box

			 WebElement toDateBox=  driver.findElement(By.id( prop.getProperty("txtEndDate")));
			 toDateBox.clear();
			 toDateBox.sendKeys(enddate);
			 
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			Select sel= new Select( driver.findElement(By.xpath( prop.getProperty("txtCashAdvance"))));
			sel.selectByVisibleText(cash);
			
			 driver.findElement(By.xpath( prop.getProperty("txtDelegatedEmployee"))).sendKeys(delegatedEmployee);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.findElement(By.xpath( prop.getProperty("txtDelegatedEmployee"))).sendKeys(Keys.TAB);
			
			
		  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("doFormSubmit()");
		
		 
			
		  System.out.println("The Modification request is created");
		  
		  CommonUtil.iGateLogout(); 
		  
		   CommonUtil.ApprovalProcess(); 
		  
		  	 
	}
	
	
	
	
	
}
