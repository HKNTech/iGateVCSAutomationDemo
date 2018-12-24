package com.igate.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.igate.qa.base.TestBase;
import com.igate.qa.util.CommonUtil;

public class CancelLeavePage extends TestBase{

	public CancelLeavePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public  void CancelLeave() throws Exception
	{
		
				
		 driver.navigate().to("https://igate-bat.stc.com.sa/en/group/i-gate/e-services/human-resources/trip-and-leave-service/vcs");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath( prop.getProperty("rdoCancel"))).click();
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 List<WebElement> elements =  driver.findElements((By.xpath("//table[contains(@class,'t1 cancelVacation')] /tbody/tr[1]/td[1]/parent::*/parent::*/parent::*")));
			
		 for(WebElement ele:elements)
			{

			 			 
			  //   System.out.println("The Id is : " + ele.getAttribute("id"));     // for getting id of each element

			  //   System.out.println("The test is : " + (ele.getText()).substring(0,10));              //for getting text of each element
			       
			     String cancelDate= (ele.getText()).substring(0,10);
			     
			     if (cancelDate.equals( cancelDateis)) 
			     {
			    	  nID= ele.getAttribute("id");
			     }

			}
		 
		  driver.findElement(By.xpath("//input[contains(@value,'"+  nID +"')]")).click();
		  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("doFormSubmit()");
		  
		  
		 
			
		
		   CommonUtil.iGateLogout(); 
		   CommonUtil.ApprovalProcess();  
		  
		  	 
	}
	
	
	
}
