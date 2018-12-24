package com.igate.qa.util;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.igate.qa.base.TestBase;
import com.igate.qa.pages.LoginPage;



public class CommonUtil extends TestBase{

	static LoginPage loginPage;
	static Xls_Reader reader= new Xls_Reader("D:/Selenium/iGATEVacationService/iGateVacationServices/src/main/java/com/igate/qa/testdata/VacationTestData.xlsx");
	
	
	
public CommonUtil() throws IOException {
		super();
		
		// TODO Auto-generated constructor stub
	}

public static void iGateLogout() throws IOException
{
driver.navigate().to("https://igate-bat.stc.com.sa/c/portal/logout");
}

public static void main(String[] args) 

{
	try {
		String[] ApprovalDetails= getCurrentAdmin();
		System.out.println(Arrays.toString(ApprovalDetails));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static String[] getCurrentAdmin()throws Exception{
		
		String CurrentAdmin=null;
		String FormID=null;
		String FormStatus=null;
			
		try{
			Connection conn = getConnection();
			if(conn != null){
			Statement st=conn.createStatement();
        	String sql="Select Form_ID,Employee_Email,current_Admin,form_status,creation_date from EIP.STC_VACATION_SERVICE "
        			+ "where Form_ID=(Select MAX(Form_ID) from EIP.STC_VACATION_SERVICE  "
        			+ "where to_date(creation_date, 'dd-mm-yyyy') =to_date(sysdate, 'dd-mm-yyyy' ))";
        	
        	ResultSet rs=st.executeQuery(sql);
        	while(rs.next())
        	{
        		FormID=rs.getString(1);
        		CurrentAdmin=rs.getString(3);
        		FormStatus=rs.getString(4);
             	}
        	
         	conn.close();
			}
        }catch (Exception e){
        	
        	System.err.println(e);
        }
		  return new String[] {FormID,CurrentAdmin,FormStatus} ;
	}
	
	public static Connection getConnection()throws Exception{
		Connection conn = null;
		 try{
         
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 
       	String dbUrl = "jdbc:oracle:thin:@172.21.54.8:1521:BATIG";
       	conn = DriverManager.getConnection(dbUrl,"eip", "eip22");
        	//System.out.println("Connection Successful");
       	
        	
       }catch (Exception e){
       	
       	System.err.println(e);
       }
		 return conn;
	}
	
	
	
	public static void ApprovalProcess() throws Exception 
	{
		loginPage= new LoginPage();
		
		CaptureApprover();
		
				  boolean breakLoop = false;
				
				
				  while (!breakLoop)
				  {
						 if (status_A == "ACCEPTED")
						 {
							 System.out.println("The form final status is:" +    status_A);
							 System.out.println("                        "); 
							  System.out.println("                        ");
							  // Result_ApprovalProcess="PASS";
							 // ScreenShot.takeSnapShot(driver);
							  Result_status=status_A;
							  
							   reader.setCellData("Testdata","NewFormID",  rowCtr,  FormID);
							   reader.setCellData("Testdata","FormStatus",  rowCtr,  status_A);
							   reader.setCellData("Testdata","TestStatus",  rowCtr, "PASS");
					
							  breakLoop= true;
						 }
					 
						 else if ( status_R=="REJECTED")
						 {
							 System.out.println("The form final status is:" +    status_R);
							 System.out.println("                        "); 
							  System.out.println("                        ");
							 //  Result_ApprovalProcess="PASS";
							 // ScreenShot.takeSnapShot(driver);
							   Result_status= status_R;
							  
							   reader.setCellData("Testdata","NewFormID",  rowCtr,  FormID);
							   reader.setCellData("Testdata","FormStatus",  rowCtr,  status_R);
							   reader.setCellData("Testdata","TestStatus",  rowCtr, "PASS");
						 
							 breakLoop= true;
						 }	 
						 
						 else
						 {
						 	  
							  Result_ctr= Result_ctr+1;
							 
							 
							 loginPage.loginFunction(empName,pwd);	  
						    	
						  System.out.println(" The form id is " +  FormID);
						   driver.navigate().to("https://igate-bat.stc.com.sa/en/group/i-gate/e-services/online-form/-/view/i/"+ FormID+"/st?strip=yes" );    
						  
						  System.out.println("https://igate-bat.stc.com.sa/en/group/i-gate/e-services/online-form/-/view/i/"+ FormID+"/st?strip=yes" );
											  
						  System.out.println("The selected process Id is : "+  process_ID);
						  
						  if ( process_ID.equals("Approval"))
							  {
							  
							  
						         System.out.println("System is going to approve the request");
		                  
									 	     
									          // SectionManager Approval
									    if (  driver.findElement(By.xpath("//*[@id='OF.D_APPROVAL']")).isDisplayed())
										  {
									    	  driver.findElement(By.xpath("//*[@id='OF.D_APPROVAL']")).sendKeys("Approve");
											  				
										  }
								 
									    // vacation_ksaho@stc.com.sa 
										  else if (  driver.findElement(By.xpath("//*[@id='OF.H_APPROVAL']")).isDisplayed())
							  			  {
											   driver.findElement(By.xpath("//*[@id='OF.H_APPROVAL']")).sendKeys("Approve");
								  				
								  	      }					  									  
									 	     // hr_accounting@stc.com.sa approval
										  else if (  driver.findElement(By.xpath("//*[@id='OF.I_APPROVAL']")).isDisplayed())
							  			  {
											   driver.findElement(By.xpath("//*[@id='OF.I_APPROVAL']")).sendKeys("Approve");
								  				
								  	      }
									 	     
					 		    	     else
										  {
									    	
									    	  Result_ApprovalProcess="FAILED";  
									    	
									      }
									    System.out.println("Submit button is to be pressed");
									     JavascriptExecutor js=(JavascriptExecutor) driver;
										  js.executeScript("doFormSubmit()");
										  System.out.println("Submit button pressed");
										  
										 
										  
										  System.out.println("The Request is submitted sucessfully by :" +  empName);
										   iGateLogout();
										 
											
						
							 	
							  }
						 
						  if ( process_ID.equals("Rejection"))
						  {
						  
						  
							  System.out.println("System is going to reject the request");
			                    
							    if (  driver.findElement(By.xpath("//*[@id='OF.D_APPROVAL']")).isDisplayed())
									  {
								    	 driver.findElement(By.xpath("//*[@id='OF.D_APPROVAL']")).sendKeys("Reject");
								    	 driver.findElement(By.xpath("//*[@id='OF.D_COMMENTS']")).sendKeys("Comments are mandatory while rejecting a request.");
										 
									  }
				
				    					else 
										  {
									    	
				    						System.out.println("The element ID in the source code is changed");
							                 
									    	
									      }
								
									     JavascriptExecutor js=(JavascriptExecutor) driver;
										  js.executeScript("doFormSubmit()");
										  System.out.println("The request is Rejected sucessfully by :" +  empName);
										   iGateLogout();
										 
						  }
							  
						 CaptureApprover();
						   
				        }	 
				   }
				  
				}
	
	
	public static void CaptureApprover()
	  {
		   	    
		  
		  
		  try {
			  String[] NextApprover=getCurrentAdmin();
		
			   FormID  = NextApprover[0];
			   Result_reqno=NextApprover[0];
			  System.out.println("Form ID    :" +  FormID);
			   FormStatus=NextApprover[2];
			   Result_status=NextApprover[2];
			   Result_approver=NextApprover[1];
			  
			
			  System.out.println("Form Status:" +  FormStatus);
				  if (NextApprover[1] != null)
					  {		 
					   empName = NextApprover[1];
					   Result_approver=NextApprover[1];
					   FormStatus=NextApprover[2];
										  		
					  }
				  else 
					  {	  
					 //  empName="NOBODY";
					   Result_approver="NOBODY";
						  // The below two lines needs to be refined
					   if (FormID == null)
					   {
						   status_A=null;
						   status_R=null; 
					   }
					   else
					   {
						   status_A="ACCEPTED";
						   status_R="REJECTED";   
					   }
					   
					   
					   if (status_A=="ACCEPTED")
					   {
						   FinalStatus ="ACCEPTED" ;
					   }
					   else if (status_R=="REJECTED")
					   {
						   FinalStatus ="REJECTED" ;
					   }
					   else
					   {
						   FinalStatus ="NOT ACCEPTED" ;
					   }
						  
					  }
			  System.out.println("Approver Name:" +  empName);
			  		 
					  
			} catch (Exception e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));;
		
		
		
	}

	public static void refreshVariables(){
		
		process_ID=null;
		empName=null;
	    FormID=null;
	    FormStatus=null;
	    user=null;
	    pwd="stc123";
	    nID=null;
	    cancelDateis=null;
	    function_id=null;
	    	      
	    status_A=null;
	    status_R=null;
	    Result_LoginPage= null;
	    Result_TelephoneRequestSubmit=null;
	    Result_LogoutPage=null;
	    Result_ApprovalProcess=null;
	    Result_user=null;
	    Result_reqno=null;
	    Result_status=null;
	    Result_approver=null;
	    Result_CreateCell=null;
	    Result_ctr=0;
	    Result_counter="9";
	    eRows=0;
	    form_no=null;
	    totalRow=0;
	    rowCtr=2;
	}
	
	

}
