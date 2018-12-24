package com.igate.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.igate.qa.base.TestBase;

public class WebEventListener  extends TestBase implements WebDriverEventListener{

	public WebEventListener() throws IOException {
		super();
		
	}

	
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to : '" +url +"'");
		
	}
	
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to : '" +url +"'");
		
	}
	
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		System.out.println("Value of the :" + element.toString() + " before any changes made");
		
	}
	
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		System.out.println("Element value changed to :" + element.toString());
		
	}
	
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on :" + element.toString());
		
	}
	
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on :" + element.toString());
		
	}
	
	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
	}
	
	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		
	}
	
	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		
	}
	

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		
	}
	

	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured :" + error);
		try {
			CommonUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element by :" + by.toString());
	}
	
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element by :" + by.toString());
	}
	
	
	
	
	
	
	//=========================================
	
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	


	

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	



	

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}


}