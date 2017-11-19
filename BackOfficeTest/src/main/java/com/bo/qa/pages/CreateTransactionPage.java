package com.bo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bo.qa.base.TestBase;

public class CreateTransactionPage extends TestBase {
	
	@FindBy(xpath ="//h3[text()='Create Transaction']")
	WebElement textInCreateTransactionPage;
	
	@FindBy(id ="//input[@id='txn_date']")
	@CacheLookup
	WebElement txnDate;
	
	@FindBy(name ="txn_id")
	@CacheLookup
	WebElement txnId;
	
	@FindBy(name ="cust_id")
	@CacheLookup
	WebElement cusId;
	
	@FindBy(id ="txn_init")
	@CacheLookup
	WebElement txnInit;
	
	@FindBy(id ="mem_estd_id")
	@CacheLookup
	WebElement memEstId;
	
	@FindBy(name ="txn_stat")
	@CacheLookup
	WebElement txnStatus;
	
	@FindBy(id ="txn_remarks")
	@CacheLookup
	WebElement txnRemarks;
	
	@FindBy(name ="cus_trans_amt")
	@CacheLookup
	WebElement cxTxnAmt;

	@FindBy(name ="mem_est_txn_amt")
	@CacheLookup
	WebElement memEstAmt;
	
	@FindBy(id ="main_service_code")
	@CacheLookup
	WebElement mainSrvcCode;
	
	@FindBy(id ="sub_service_code")
	@CacheLookup
	WebElement subSrvcCode;
	
	@FindBy(id ="operator")
	@CacheLookup
	WebElement operator;
	
	@FindBy(name ="optr_ref")
	@CacheLookup
	WebElement optrRef;
	
	@FindBy(name ="payment_ref")
	@CacheLookup
	WebElement pytRef;
	
	@FindBy(name ="txn_ref_vendor")
	@CacheLookup
	WebElement vndrRef;
	
	@FindBy(name ="gate_stat")
	@CacheLookup
	WebElement gatewaySts;
	
	@FindBy(name ="pay_throw")
	@CacheLookup
	WebElement payThrough;
	
	@FindBy(name ="txn_ref_gate")
	@CacheLookup
	WebElement gateWayRef;
	
	@FindBy(xpath ="//button[text()='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath ="//button[text()='Submit']")
	WebElement submitBtn;
	
	
	//Now Initialising the page objects using PageFactory
	public CreateTransactionPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods in CreateTransaction Page
	public String ValidateCreateTxnPageTitle(){
		return driver.getTitle();
	}
	
	public String validateCreateTxnPageText(){
		return textInCreateTransactionPage.getText();
	}
	
	public void txnInitBy(){
		txnInit.click();
	}
	public void txnInitDropDown(String userlevel){
		Select sel = new Select(txnInit);
		//sel.deselectAll();
		sel.selectByVisibleText(userlevel);
		
	}
	
	public void txnStatus(){
		txnStatus.click();
	}
	
	public void txnStatusDropDown(String status){
		Select sel = new Select(txnStatus);
		//sel.deselectAll();
		sel.selectByVisibleText(status);
	}
	
	public void txnRemarks(){
		txnRemarks.click();
	}
	
	public void txnRemarksDropDown(String rmkStatus){
		Select sel = new Select(txnRemarks);
		//sel.deselectAll();
		sel.selectByVisibleText(rmkStatus);
	}

	public void mainServiceCode(){
		mainSrvcCode.click();
	}
	
	public void mainServiceCodeDropDown(String mainSrv){
		Select sel = new Select(mainSrvcCode);
		//sel.deselectAll();
		sel.selectByVisibleText(mainSrv);
	}
	
	public void subServiceCode(){
		subSrvcCode.click();
	}
	
	public void subServiceCodeDropDown(String subSrv){
		Select sel = new Select(subSrvcCode);
		//sel.deselectAll();
		sel.selectByVisibleText(subSrv);
	}
	
	public void selectOperator(){
		operator.click();
	}
	
	public void selectOperatorDropDown(String optr){
		Select sel = new Select(operator);
		//sel.deselectAll();
		sel.selectByVisibleText(optr);
	}
	
	public void gateWayStatus(){
		gatewaySts.click();
	}
	
	public void gateWayStatusDropDown(String gteWaySts){
		Select sel = new Select(gatewaySts);
		//sel.deselectAll();
		sel.selectByVisibleText(gteWaySts);
	}
	
	public void paymentThrough(){
		payThrough.click();
	}
	
	public void paymentThroughDropDown(String pmtThru){
		Select sel = new Select(payThrough);
		//sel.deselectAll();
		sel.selectByVisibleText(pmtThru);
	}
	
	public void clickSubmitButton(){
		submitBtn.click();
	}
	
	public void clickResetButton(){
		resetBtn.click();
	}
	
	public CreateTransactionPage createTransaction(String trnId,String cxId,String userType,String memId,
			                      String status,String rmkSts,String cxAmt,String memEstiAmt,
			                      String msc,String ssc,String opertr,String optRef,
			                      String pmtRef,String vendrRef,String gtwaySts,String pmtThru, 
			                      String gteWayRef){
		try{
			System.out.println("To clear all Fields before entering new ones");
			resetBtn.click();
			
			txnId.sendKeys(trnId);
			cusId.sendKeys(cxId);
			txnInitDropDown(userType);
			memEstId.sendKeys(memId);
			txnStatusDropDown(status);
			txnRemarksDropDown(rmkSts);
			cxTxnAmt.sendKeys(cxAmt);
			memEstAmt.sendKeys(memEstiAmt);
			mainServiceCodeDropDown(msc);
			subServiceCodeDropDown(ssc);
			selectOperatorDropDown(opertr);
			optrRef.sendKeys(optRef);
			pytRef.sendKeys(pmtRef);
			vndrRef.sendKeys(vendrRef);
			gateWayStatusDropDown(gtwaySts);
			paymentThroughDropDown(pmtThru);
			gateWayRef.sendKeys(gteWayRef);
			
			submitBtn.click();
			System.out.println("All Data is entered and successfully a new transaction is created");
			
			return new CreateTransactionPage() ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
			
	}
}
