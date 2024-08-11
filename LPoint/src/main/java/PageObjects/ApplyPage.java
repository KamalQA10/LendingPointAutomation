package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.action;
import Base.BaseClass;

public class ApplyPage extends BaseClass{
	
	public ApplyPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy (xpath="//img[@src='/apply/img/3120241531/lendingpoint.svg']")
	WebElement LP_Logo;
	
	@FindBy(name="loanAmount") 
	WebElement LoanAmount;
	
	@FindBy(xpath="//*[@id='loanPurpose']")
	WebElement loanPurpose;
	
	@FindBy(id="firstName")
	WebElement FirstName;
	
	@FindBy(id="lastName")
	WebElement LastName;
	
	@FindBy(xpath="(//input[@class='form-control'])[3]")
	WebElement DOB;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//span[@class='glyphicon checking-req-phone checking-phone-ok glyphicon-ok font-med text-success']")
	WebElement PhoneNumberSucessFullTick;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//span[@class='glyphicon checking-req checking-email-ok glyphicon-ok font-med text-success']")
	WebElement EmailSucessFullTick;
	
	@FindBy(xpath="//input[@id='google-addres']")
	WebElement Address;
	
	@FindBy(id="postal_code")
	WebElement Zip;
	
	@FindBy(xpath="//img[@class='loading-inline requestzip']")
	WebElement ZipLoaderimg;
	
	@FindBy(xpath="//img[@class='loading-inline requestzip hide']")
	WebElement ZipLoaderimgDissapear;
		
	@FindBy(id="annualIncome")
	WebElement annualIncome;
	
	@FindBy(xpath="//select[@id='income-source']")
	WebElement IncomeSource;
	
	@FindBy(name="ssn")
	WebElement ssn;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Check my options']")
	WebElement SubmitBttn;
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), LP_Logo);
	}
	
	public String getLPTitle() {
		String getLPTitle=getDriver().getTitle();
		return getLPTitle;
	}
	
	public boolean verifyLoanAmount(String loanAmount) {
		action.JSClick(getDriver(), LoanAmount);
		return action.type(LoanAmount, loanAmount);
	}
	
	public void verifyLoanPurpose(String loanPurpose_option) throws InterruptedException {
		action.click(getDriver(), loanPurpose);
		action.selectByValue(loanPurpose, loanPurpose_option);
	}
	
	public boolean verifyFirstname( String firstName) {
		action.click(getDriver(), FirstName);
		return action.type(FirstName, firstName);
	}
	
	public boolean verifyLastname(String lastName) {
		action.click(getDriver(), LastName);
		return action.type(LastName, lastName);
	}
	
	public boolean verifyDob(String DOBText) {
		action.click(getDriver(), DOB);
		return action.selectBySendkeys(DOBText, DOB);
	}
	
	public boolean verifyPhoneNumber(String PhoneNumber_Text) {
		return action.selectBySendkeys(PhoneNumber_Text, PhoneNumber);
	}
	
	public boolean verifyEmailId(String Email_Id) {
		action.waitForElementVisibility(getDriver(), PhoneNumberSucessFullTick, 10);
		return action.selectBySendkeys(Email_Id, Email);
	}
	
	public boolean verifyAddress(String Address1) {
		return action.selectBySendkeys(Address1, Address);
	}
	
	public boolean verifyZip(String postalCode) {
		return action.selectBySendkeys(postalCode, Zip);
	}
	
	public boolean verifyAnnualIncome(String AnnualIncome) {
		action.waitForElementVisibility(getDriver(), EmailSucessFullTick, 10);
		action.waitForElementInVisibility(getDriver(), ZipLoaderimgDissapear, 10);
		//action.waitForElementVisibility(getDriver(), ZipLoaderimg, 3);
		return action.type(annualIncome, AnnualIncome);
	}
	
	public void verifyIncomeSource(String IncomeSourcetext) throws InterruptedException {
		action.click(getDriver(), IncomeSource);
		action.selectByValue(IncomeSource, IncomeSourcetext);
	}
	
	public boolean verifyssn(String SSN) {
		action.click(getDriver(), ssn);
		return action.selectBySendkeys(SSN, ssn);
	}
	
	public boolean verifyPassword(String Passw) {
		return action.type(password, Passw);
	}
	
	public SelectOfferPage ClickOnSubmitBttn() {
		action.click(getDriver(), SubmitBttn);
		return new SelectOfferPage();
	}
	
}
