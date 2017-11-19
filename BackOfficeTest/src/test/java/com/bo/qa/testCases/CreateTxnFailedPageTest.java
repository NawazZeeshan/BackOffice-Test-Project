package com.bo.qa.testCases;

import org.testng.annotations.BeforeMethod;

import com.bo.qa.base.TestBase;
import com.bo.qa.pages.HomePage;
import com.bo.qa.pages.LoginPage;
import com.bo.qa.util.TestUtil;

public class CreateTxnFailedPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	
	
	public CreateTxnFailedPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clicktransactionLink();
		
	}
	
	
	
	
}
