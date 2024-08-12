package lendingPointUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.Log;

import Base.BaseClass;
import PageObjects.ApplyPage;
import PageObjects.SelectOfferPage;

public class ApplyPageTest extends BaseClass{
	private ApplyPage applyPage;
	public SelectOfferPage selectOfferPage;


	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser); 
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Sanity"}, priority = 1)
	public void verifyLPTitle() throws Throwable {
			Log.startTestCase("verifyLPTitle");
		applyPage = new ApplyPage();
		String actTitle=applyPage.getLPTitle();
		Assert.assertEquals(actTitle, "Online Personal Loans | Check Your Rate Today");
			Log.endTestCase("verifyLPTitle");
	}

	@Test(groups = {"Smoke"}, priority = 2)
	public void verifyLoanApply() throws Throwable 
	{
			Log.startTestCase("verifyLoanApply");
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
			Log.endTestCase("loginTest");
	}

}
