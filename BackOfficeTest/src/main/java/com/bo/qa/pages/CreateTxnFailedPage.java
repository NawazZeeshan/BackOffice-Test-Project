package com.bo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bo.qa.base.TestBase;

public class CreateTxnFailedPage extends TestBase {

	@FindBy(xpath ="//strong[text()='Transaction created failed']")
	WebElement TxnCreateFailedText;
	
	//Now Initialising the Page Objects
	public CreateTxnFailedPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods 
	public String getText_TxnCreateFailed(){
		String getText_failCrtTxn =TxnCreateFailedText.getText();
		return getText_failCrtTxn;
	}
	
	
	
	
	
	
	
}
