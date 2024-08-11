package lendingPointUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.ApplyPage;
import PageObjects.BankInformationPage;
import PageObjects.SelectOfferPage;
import Utility.Log;

public class DTC_EndToEndFlowTest extends BaseClass{
	private ApplyPage applyPage;
	public SelectOfferPage selectOfferPage;
	public BankInformationPage bankInformationPage;


	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser); 
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	

	@Test(groups = {"Regression"})
	public void verifyDTC_EndToEndFlow() throws Throwable 
	{
			Log.startTestCase("verifyDTC_EndToEndFlow");
		applyPage = new ApplyPage();
		
			Log.info("user is going to click & Enter on LoanAmount field");
		applyPage.verifyLoanAmount(prop.getProperty("LoanAmount"));
		
			Log.info("user is going to click & Enter on LoanPurpose field");
		applyPage.verifyLoanPurpose(prop.getProperty("loanPurpose_option"));
		
			Log.info("user is going to click & Enter on FirstName field");
		applyPage.verifyFirstname(prop.getProperty("firstName"));
		
			Log.info("user is going to click & Enter on LastName field");
		applyPage.verifyLastname(prop.getProperty("lastName"));
		
			Log.info("user is going to click & Enter on DateOfBirth field");
		applyPage.verifyDob(prop.getProperty("dob"));
		
			Log.info("user is going to Enter on PhoneNumber field");
		applyPage.verifyPhoneNumber(prop.getProperty("phone"));
		
			Log.info("user is going to Enter on Email field");
		applyPage.verifyEmailId(prop.getProperty("email"));
		
			Log.info("user is going to Enter on Address field");
		applyPage.verifyAddress(prop.getProperty("street"));
		
			Log.info("user is going to Enter on Zip field");
		applyPage.verifyZip(prop.getProperty("zip"));
		
			Log.info("user is going to Enter on AnnualIncome field");
		applyPage.verifyAnnualIncome(prop.getProperty("annualIncome"));
		
			Log.info("user is going to click & Enter on LoanPurpose field");
		applyPage.verifyIncomeSource(prop.getProperty("IncomeSourcetext"));
		
			Log.info("user is going to click & Enter on SSN field");
		applyPage.verifyPassword(prop.getProperty("password"));
		
			Log.info("user is going to click & Enter on SSN field");
		applyPage.verifyssn(prop.getProperty("ssn"));
		
			Log.info("user is going to click on Submit Bttn");
		selectOfferPage = applyPage.ClickOnSubmitBttn();
			
			Log.info("Validate Offer Selection Page Opened or not");
		boolean selectOfferPage_result = selectOfferPage.verifySelectAnOfferText();		 	
		Assert.assertTrue(selectOfferPage_result);
			Log.info("Offer Selection page is opened");
			
			Log.info("user is going to click on Select Offer button");
		bankInformationPage = selectOfferPage.verifyOfferOnOffersPages();
		
			Log.info("Validate bankInformationPage Opened or not");
		boolean bankInformationPage_result = bankInformationPage.verifyBankInformationText();
		System.out.println("bankInformationPage_result:---------------- "   + bankInformationPage_result);
		Assert.assertTrue(bankInformationPage_result);
			Log.info("Offer bankInformationPage is opened");
			
		bankInformationPage.verifyConnectBankAccountBtn();
			Log.info("Plaid page is opened");
		bankInformationPage.verifyContinuetoBankPageBtn();
		bankInformationPage.SelectBankInformation(prop.getProperty("Plaid_BankName"));
		bankInformationPage.LoginIntoPlainBank(prop.getProperty("username"), prop.getProperty("Password_2"));	
		bankInformationPage.ClickOnPaymentSetupPageToGoNext();
		bankInformationPage.ClickOnContractSignCheckBoxes();
		
			Log.endTestCase("End Of verifyDTC_EndToEndFlow");
	}

}
