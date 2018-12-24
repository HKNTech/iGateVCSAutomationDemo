package com.igate.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.igate.qa.base.TestBase;

import com.igate.qa.pages.HomePage;
import com.igate.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException
	{
	 initialization();
	 loginPage= new LoginPage();
	 
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPage();
		Assert.assertEquals(title,"Login - iGate");
		
	}
	
	@Test(priority=2)
	public void loginLogoImageTest()
	{
		boolean flag=loginPage.validateSTClogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage= loginPage.loginFunction(user,pwd);
		
		String titleSuccess=loginPage.validateLoginSucessPage();
		Assert.assertEquals(titleSuccess,"Home - iGate");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
