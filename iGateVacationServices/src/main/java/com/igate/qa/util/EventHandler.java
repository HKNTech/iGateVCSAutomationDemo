package com.igate.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.igate.qa.base.TestBase;

public  class EventHandler extends TestBase implements WebDriverEventListener {
	
	

	public EventHandler() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		 
		 
		 System.out.println("inside method afterChangeValueOf on " + arg0.toString());
		 }
		 
		 public void afterClickOn(WebElement arg0, WebDriver arg1) {
		 
			 System.out.println("inside method afterClickOn on " + arg0.toString());
		 }
		 
		 public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		 
			 System.out.println("Find happened on " + arg1.toString() + " Using method " + arg0.toString());
		 }
		 
		 public void afterNavigateBack(WebDriver arg0) {
		 
		 
			 System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
		 }
		 
		 public void afterNavigateForward(WebDriver arg0) {
		 
			 System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
		 }
		 
		 public void afterNavigateTo(String arg0, WebDriver arg1) {
		 
			 System.out.println("Inside the afterNavigateTo to " + arg0);
		 }
		 
		 public void afterScript(String arg0, WebDriver arg1) {
		 
			 System.out.println("Inside the afterScript to, Script is " + arg0);
		 }
		 
		 public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		 
		 
			 System.out.println("Inside the beforeChangeValueOf method");
		 }
		 
		 public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		 
			 System.out.println("About to click on the " + arg0.toString());
		 
		 }
		 
		 public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		 
			 System.out.println("Just before finding element " + arg1.toString());
		 
		 }
		 
		 public void beforeNavigateBack(WebDriver arg0) {
		 
			 System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
		 
		 }
		 
		 public void beforeNavigateForward(WebDriver arg0) {
		 
			 System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
		 
		 }
		 
		 public void beforeNavigateTo(String arg0, WebDriver arg1) {
		 
			 System.out.println("Just before beforeNavigateTo " + arg0);
		 }
		 
		 public void beforeScript(String arg0, WebDriver arg1) {
		 
			 System.out.println("Just before beforeScript " + arg0);
		 }
		 
		 public void onException(Throwable arg0, WebDriver arg1) {
		 
			 System.out.println("Exception occured at " + arg0.getMessage());
		 
		 }

		@Override
		public void afterAlertAccept(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterAlertDismiss(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
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
		public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
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
		public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}

		
}
