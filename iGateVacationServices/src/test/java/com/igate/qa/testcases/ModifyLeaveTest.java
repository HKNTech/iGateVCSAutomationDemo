package com.igate.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.igate.qa.base.TestBase;
import com.igate.qa.pages.HomePage;
import com.igate.qa.pages.LoginPage;
import com.igate.qa.pages.ModifyLeavePage;
import com.igate.qa.util.CommonUtil;

public class ModifyLeaveTest extends TestBase{

	ModifyLeavePage modifyleave;
	HomePage homePage;
	LoginPage loginPage;
	
	public ModifyLeaveTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException
	{
	 initialization();
	 modifyleave= new ModifyLeavePage();
	 loginPage= new LoginPage();
	 
	}
	
	
	@Test(priority=1)
	public void iGateModifyLeaveTest()
	{
		System.out.println("====================================================");
		System.out.println("System is going to execute the Modify Leave Test Case");
		System.out.println("====================================================");
		loginPage.loginFunction(user,pwd);
		try {
			modifyleave.ModifyLeave();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtil.refreshVariables();
		Assert.assertEquals(FinalStatus, "ACCEPTED");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
