package com.bo.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bo.qa.base.TestBase;
import com.bo.qa.pages.HomePage;
import com.bo.qa.pages.LoginPage;
import com.bo.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title =loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Authorization");
	}
	
	@Test(priority=2)
	public void ezeepayLogoImageTest(){
		boolean flag =loginPage.validateEzeepayLogo();
		Assert.assertTrue(flag);
		System.out.println("EzeePay Logo is visible : " +flag);
	}
	
	//@Test //check the method throughly 
	public void checkShowPassword(){
		loginPage.validateShowPassword(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle =homePage.validateHomePageTitle();
		TestUtil.softAssertion(homePageTitle, "Ezeepay Services");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
