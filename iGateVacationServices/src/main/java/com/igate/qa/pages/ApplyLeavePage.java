package com.igate.qa.pages;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.igate.qa.base.TestBase;
import com.igate.qa.util.CommonUtil;

public class ApplyLeavePage extends TestBase{

		
	
	
	public ApplyLeavePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomePage iGateApplyLeave() throws Exception
	{
		//comUtil=new CommonUtil();
       

		String startdate= reader.getCellData("Testdata", "StartDate",  rowCtr);
		String enddate= reader.getCellData("Testdata", "EndDate",  rowCtr);
		String delegatedEmployee=  reader.getCellData("Testdata", "DelegatedEmployee",  rowCtr);
		String cash= reader.getCellData("Testdata", "CashAdvance",  rowCtr);
		
		
					
		/*System.out.println("Start Date : " + startdate);
		System.out.println("End Date : " + enddate);
		System.out.println("delegatedEmployee : " + delegatedEmployee);*/
		
			
		driver.navigate().to("https://igate-bat.stc.com.sa/en/group/i-gate/e-services/human-resources/trip-and-leave-service/vcs");
		Thread.sleep(5000);
		 driver.findElement(By.xpath( prop.getProperty("rdoApply"))).click();
			
		//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // WebElement Element =  driver.findElement(By.xpath(( prop.getProperty("rdoApply"))));
		
		//JavascriptExecutor js = (JavascriptExecutor)  driver;
		//js.executeScript("scroll(0, 250)");
		
		//js.executeScript("arguments[0].scrollIntoView();", Element);
		
		// driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		 
		// By loadingImage = By.xpath( prop.getProperty("rdoApply"));

		// WebDriverWait wait = new WebDriverWait(driver, 20);

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
		 
		// System.out.println("The Image found" + loadingImage);
				
		// driver.findElement(By.xpath(rdoApply)).click();
		
		
		// rdoApply.click();
		
		Select select= new Select( driver.findElement(By.xpath( prop.getProperty("cmbVacationType"))));
		select.selectByVisibleText("Annual Vacation إجازة سنوية");
		
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
		 ((JavascriptExecutor) driver).executeScript ("document.getElementById('OF.A_START_DATE').removeAttribute('readonly',0);"); // Enables the from date box

		 WebElement fromDateBox=  driver.findElement(By.id( prop.getProperty("txtStartDate")));
		 fromDateBox.clear();
		 fromDateBox.sendKeys(startdate);
		 
		 
		 ((JavascriptExecutor) driver).executeScript ("document.getElementById('OF.A_END_DATE').removeAttribute('readonly',0);"); // Enables the from date box

		 WebElement toDateBox=  driver.findElement(By.id( prop.getProperty("txtEndDate")));
		 toDateBox.clear();
		 toDateBox.sendKeys(enddate);
		 
		
		 
		Select sel= new Select( driver.findElement(By.xpath( prop.getProperty("txtCashAdvance"))));
		sel.selectByVisibleText(cash);
		
		 
		 driver.findElement(By.xpath( prop.getProperty("txtDelegatedEmployee"))).sendKeys(delegatedEmployee);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath( prop.getProperty("txtDelegatedEmployee"))).sendKeys(Keys.TAB);
		
				
		 driver.findElement(By.xpath(( prop.getProperty("btnA_Submit")))).click();
		
		//String str =  driver.findElement(By.xpath("//*[@id='error_msgs_content']/br[2]")).getText();
		//System.out.println("Message :" + str);
		
	
		
		
		
		 
		CommonUtil.iGateLogout(); 
		  
		 CommonUtil.ApprovalProcess(); 
		 
		 return new HomePage();
	}
}

