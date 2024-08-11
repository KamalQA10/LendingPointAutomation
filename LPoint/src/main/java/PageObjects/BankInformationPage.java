package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ActionDriver.action;
import Base.BaseClass;

public class BankInformationPage extends BaseClass{
	
	public BankInformationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[text()='Bank Information']")
	WebElement BankInformationText;
	
	@FindBy(xpath="//span[text()='CONNECT YOUR BANK ACCOUNT NOW']")
	WebElement ConnectBankAccountBtn;
	
    @FindBy(css = "#plaid-link-iframe-1")
    WebElement frame;
	
	@FindBy(xpath = "//span[text()='Continue']")
    WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement BankNameTextBox;
	
	@FindBy(xpath = "//button[@class='SearchAndSelectPane-module__resultButton']")
	WebElement SearchedBankName;
	
	@FindBy(xpath = "(//h2[text()='First Platypus Bank'])[2]")
	WebElement SecondrySearchedBankName;
	
	@FindBy(id = "aut-input-0")
	WebElement BankUserName;
	
	@FindBy(id = "aut-input-1")
	WebElement BankPassWord;
	
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement PlaidLoginBtn;
	
	@FindBy(xpath = "(//div[@class='BaseInput-module_container__zxe0D Checkbox-module_container__rgP4a ListItem-module_inputContainer__RfoLT'])[2]")
	WebElement BankCheckBox;
	
	@FindBy(xpath = "//span[text()='Allow']")
	WebElement PlaidAllowBtn;
	
	@FindBy(xpath = "//*[text()='Next']")
	WebElement PaymentSetup_NextBtn;
	
	@FindBy(xpath = "(//*[@class='black text-left font-small']/input)[1]")
	WebElement ContractSignCheckBox1;
	@FindBy(xpath = "(//*[@class='black text-left font-small']/input)[2]")
	WebElement ContractSignCheckBox2;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement SubmitSignLoanAggrementBtn;
	

	public boolean verifyBankInformationText() {
		action.fluentWaitForElementVisibility(getDriver(), BankInformationText);
		return action.isDisplayed(getDriver(), BankInformationText);	
	}	
	
	public void verifyConnectBankAccountBtn() {
		action.fluentWaitForElementVisibility(getDriver(), ConnectBankAccountBtn);
		action.click(getDriver(), ConnectBankAccountBtn);	
	}
	
	public void verifyContinuetoBankPageBtn() {
		action.waitForElementVisibility(getDriver(), frame, 50);
		action.switchToFrameAndClick(getDriver(), frame, continueButton);	
	}
	
	public void SelectBankInformation(String text) {
		action.type(BankNameTextBox, text);
		action.click(getDriver(), SearchedBankName);
		action.waitForElementVisibility(getDriver(), SecondrySearchedBankName, 20);
		action.click(getDriver(), SecondrySearchedBankName);
	}
	
	public void ClickOnPlaidAllowBtn() {
		action.fluentWait(getDriver(), PlaidAllowBtn, 4);
	}
	
	public void LoginIntoPlainBank(String Username1, String Password2) {
		action.waitForElementVisibility(getDriver(), BankUserName, 20);
		action.type(BankUserName, Username1);
		action.type(BankPassWord, Password2);
		action.click(getDriver(), PlaidLoginBtn);
		action.waitForElementVisibility(getDriver(), BankCheckBox, 20);
		action.click(getDriver(), BankCheckBox);		
		action.click(getDriver(), continueButton);
		ClickOnPlaidAllowBtn();
	}
	
	public void ClickOnPaymentSetupPageToGoNext() {
		action.switchOutToFrame(getDriver());
		action.waitForElementVisibility(getDriver(), PaymentSetup_NextBtn, 20);
		action.click(getDriver(), PaymentSetup_NextBtn);
	}
	
	/* Signed Contract Page
	 * Click on checkboxes and sign Contract Page
	 */
	public void ClickOnContractSignCheckBoxes() {
		action.JSClick(getDriver(),ContractSignCheckBox1);
		action.JSClick(getDriver(),ContractSignCheckBox2);
		action.click(getDriver(), SubmitSignLoanAggrementBtn);
	}
	
}