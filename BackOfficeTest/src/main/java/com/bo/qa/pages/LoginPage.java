package com.bo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bo.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR(OBJECT REPOSITORY)
	@FindBy(xpath ="//a[text()='login']")
	WebElement initialLoginBtn;
	
	@FindBy(name ="firstname")
	@CacheLookup
	WebElement username;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath ="//span[text()='Show password']")
	WebElement showPassword;
	
	@FindBy(xpath ="//input[@type='submit'][@value='SIGNIN']")
	WebElement submitBtn;
	
	@FindBy(xpath ="//img[contains(@src,'/backoffice/resources/images/logo_backoffice.png')]")
	WebElement ezeepayLogo;
	
	//Now Initialising the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	/*
	public String validateHomePageTitle(){
		return driver.getTitle();
	}*/
	
	public boolean validateEzeepayLogo(){
		return ezeepayLogo.isDisplayed();
	}
	 
	
	
	public HomePage login(String un, String pwd){

		 initialLoginBtn.click();
		 //WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(username));
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", submitBtn);
		 //submitBtn.click();
		 
		 return new HomePage();
	}
	
	
	public boolean validateShowPassword(String un,String pwd){
		initialLoginBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		if(!showPassword.isSelected()){
			showPassword.click();
			System.out.println("showPassword checkbox is selected");
		}
		
		return this != null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
