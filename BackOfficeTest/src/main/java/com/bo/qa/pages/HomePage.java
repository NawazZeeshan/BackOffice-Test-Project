package com.bo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bo.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver,15);
	
	
	//PageObjects -OR(Object Repository)
	@FindBy(xpath ="//h2[text()='Welcome to backoffice..!!']")
	WebElement textInHomePage;
	
	@FindBy(xpath ="//a[contains(@class,'user-profile dropdown-toggle')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//a[text()='Profile']")
	WebElement userProfile;
	
	@FindBy(xpath ="//a[text()='Profile']")
	WebElement help;
	
	@FindBy(xpath ="//a[@id='signOut']")
	WebElement logOut;
    
	@FindBy(xpath ="//i[contains(@class,'fa fa-money')]")
	WebElement transactionMenuLink;
	
	@FindBy(id ="createtxn")
	@CacheLookup
    WebElement createTransactionLink;
	
	//Now Initialising the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions or Methods
	public String validateHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public String validateHomePageText(){
		return textInHomePage.getText();
	}
	
	public String validateUserLabelName(){
		return userNameLabel.getText();
	}
	
	public HomePage clickUserLabelName(){
		userNameLabel.click();
		return this;
	}
	
	
	public String validateProfileLink(){
		return userProfile.getText();
	}
	public ProfilePage clickUserProfileLink(){
		userProfile.click();
		return new ProfilePage();
	}
	
	
	public HelpPage clickHelpLink(){
		help.click();
		return new HelpPage();
	}
	
	public LoginPage clickLogout(){
		logOut.click();
		return new LoginPage();
	}
	

	public HomePage clicktransactionLink(){
		transactionMenuLink.click();
		return this;
	}
	
	public String transactionLinkText(){
		String txnText =transactionMenuLink.getText();
		return txnText;
	}
	
	
	
	public CreateTransactionPage clickCreateTransactionLink(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("createTransactionLink")));
		createTransactionLink.click();
		return new CreateTransactionPage();
	}
	
	public String createTransactionLinkText(){
		String crtTxnsText =createTransactionLink.getText();
		return crtTxnsText;
	}
	
	/*for dynamic values use the following below to pass it
	eg:
	public void selectContactsByName(String name){
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
	+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	
	*/
	
	

}
