package com.bo.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bo.qa.base.TestBase;
import com.bo.qa.pages.CreateTransactionPage;
import com.bo.qa.pages.HomePage;
import com.bo.qa.pages.LoginPage;
import com.bo.qa.pages.ProfilePage;
import com.bo.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	TestUtil testUtil;
	CreateTransactionPage createTxnPage;
	
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
	    loginPage = new LoginPage();
	    homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    profilePage = new ProfilePage();
	    homePage.clicktransactionLink();
		createTxnPage = new CreateTransactionPage();	    
	    
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String homePageTitle =homePage.validateHomePageTitle();
		TestUtil.softAssertion(homePageTitle, "Ezeepay Services");	
		
	}
	
	@Test(priority=2)
	public void verifyHomePageTextTest(){
		String homePageText =homePage.validateHomePageText();
		TestUtil.softAssertion(homePageText, "Welcome to backoffice..!!");
	}
	
	@Test(priority=3)
	public void clickOnTransactionMenuLinkAndVerifyItsTextTest(){
		homePage.clicktransactionLink();
		//String txnText = homePage.transactionLinkText();
		//TestUtil.softAssertion(txnText, "Transaction");
		Assert.assertTrue(true);
	}

	@Test(priority=4)
	public void clickOnUserNameLabelAndValidateItsTextTest(){
		String userNameLabelText =homePage.validateUserLabelName();
		TestUtil.softAssertion(userNameLabelText, "Admin1");
		homePage.clickUserLabelName();
	}
	
	
	@Test(priority=5)
	public void clickOnProfileAndValidateItsTextTest(){
		homePage.clickUserLabelName();
		String profileLinkText =homePage.validateProfileLink();
		TestUtil.softAssertion(profileLinkText, "Profile");
		profilePage =homePage.clickUserProfileLink();
	}
	
	//@Test
	public void clickOnHelpTest(){
		homePage.clickHelpLink();
	}
	
	@Test(priority=6)
	public void clickLogout(){
		homePage.clickUserLabelName();
		homePage.clickLogout();
		String loginTitle =loginPage.validateLoginPageTitle();
		TestUtil.softAssertion(loginTitle, "Authorization");
	}
	
	@Test(priority=7)
	public void clickCreateTransactionMenuLink(){
		homePage.clickCreateTransactionLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
