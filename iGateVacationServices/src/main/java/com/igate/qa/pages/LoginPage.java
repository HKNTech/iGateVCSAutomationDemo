package com.igate.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.igate.qa.base.TestBase;
import com.igate.qa.util.Xls_Reader;

public class LoginPage extends TestBase {

	//public static Xls_Reader reader= new Xls_Reader("D:/Selenium/iGATEVacationService/iGateVacationServices/src/main/java/com/igate/qa/testdata/VacationTestData.xlsx");
	
	


//Initializing the page objects

@FindBy(id="_58_login")
WebElement txtLogin;

@FindBy(id="_58_password")
WebElement txtPassword;

@FindBy(css=".aui-button-input.aui-button-input-submit[type='submit']")
WebElement btnLogin;	

@FindBy(xpath="//*[@id='banner']/div/div[1]/div[1]/a/img")
WebElement stcLogo;

public LoginPage() throws IOException 
{
   
  PageFactory.initElements(driver,this);
	
}

// Actions
public String validateLoginPage()
{
	return driver.getTitle();
}

public HomePage loginFunction(String un, String pwd)
{
	Xls_Reader reader= new Xls_Reader("D:/Selenium/iGATEVacationService/iGateVacationServices/src/main/java/com/igate/qa/testdata/VacationTestData.xlsx");
	
	if (Result_ctr <=0 )
	{
		  
		user= reader.getCellData("Testdata", "UserName", rowCtr);
		pwd=reader.getCellData("Testdata", "PassWord", rowCtr);
		System.out.println("The Username in loginFunction is : "+ user);
		System.out.println("The rowctr in loginFunction is : "+ rowCtr);
	}
	else
		{
		user= empName;
		pwd=reader.getCellData("Testdata", "PassWord", rowCtr);
		System.out.println("The Username in loginFunction Else is : "+ user);
			
		}
	txtLogin.sendKeys(user);
	txtPassword.sendKeys(pwd);
	btnLogin.click();
	return new HomePage();
}

public String validateLoginSucessPage()
{
	return driver.getTitle();
}


public boolean validateSTClogo()
{
return 	stcLogo.isDisplayed();
}

}
