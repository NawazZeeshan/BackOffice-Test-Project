package com.bo.qa.testCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bo.qa.base.TestBase;
import com.bo.qa.pages.CreateTransactionPage;
import com.bo.qa.pages.CreateTxnFailedPage;
import com.bo.qa.pages.HomePage;
import com.bo.qa.pages.LoginPage;
import com.bo.qa.util.TestUtil;

public class CreateTransactionPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	//ProfilePage profilePage;
	TestUtil testUtil;
	CreateTransactionPage createTxnPage;
	CreateTxnFailedPage createTxnFailPage;
	
	String sheetName = "CreateTxn";
	
	public CreateTransactionPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
	    loginPage = new LoginPage();
	    homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    homePage.clicktransactionLink();
	    homePage.clickCreateTransactionLink();
	    //profilePage = new ProfilePage();
		createTxnPage = new CreateTransactionPage();
		createTxnFailPage = new CreateTxnFailedPage();
	}
	
	
	
	
	
	//@Test(priority=1)
	public void createNewTransaction(){
		//String createdNewTxn =
		        createTxnPage.clickResetButton();
				createTxnPage.createTransaction("a1b2c3d4f2","7","PWR", "7","SUCCESS",
				                        "transaction succesfull amount debited",
				                        "30", "30", "Recharge", "Mobile",
				                        "Airtel", "abcdefghijkl123", "1a2b3c4d5e", "9840783416",
				                        "Captured", "Debit Card", "6012345678"); 
		//TestUtil.softAssertion(createdNewTxn, "Transaction created successfully");
				//createTxnPage.clickSubmitButton();
				createTxnFailPage.getText_TxnCreateFailed();
				TestUtil.softAssertion(createTxnFailPage.getText_TxnCreateFailed(), "Transaction created failed");
				System.out.println("Txn failed");
	}
	
	@DataProvider
	public  Object[][] getData_CreateTxn() throws InvalidFormatException, org.openxml4j.exceptions.InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1,dataProvider="getData_CreateTxn")
	public void createNewTransaction1(String TxnId,String CxId,String TxnInitBy,String MemEstId,
            String TxnStatus,String TxnRemarks,String MemTxnAmt,String CxTxnAmt,
            String MainSerCode,String SubSerCode,String Operator,String VndrRefNo,
            String OperRefNo,String PymtRefNo,String GteWaySts,String PymtThru, 
            String PayuIdRefNo){
		        createTxnPage.clickResetButton();
				createTxnPage.createTransaction(TxnId, CxId, TxnInitBy, MemEstId, 
						TxnStatus, TxnRemarks, MemTxnAmt,  CxTxnAmt, 
						MainSerCode, SubSerCode, Operator, VndrRefNo, 
						OperRefNo,
						PymtRefNo, GteWaySts, PymtThru, PayuIdRefNo);
				createTxnFailPage.getText_TxnCreateFailed();
				TestUtil.softAssertion(createTxnFailPage.getText_TxnCreateFailed(), "Transaction created failed");
				System.out.println("Txn failed");
				
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
