package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.action;
import Base.BaseClass;

public class SelectOfferPage extends BaseClass{
	
	public SelectOfferPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[text()='SELECT OFFER']")
	WebElement SelectAnOfferText;
	
	@FindBy(xpath="//div[@class='noUi-connects']")
	WebElement OfferSliderBar;
	
	@FindBy(xpath="//span[text()='Select']")
	WebElement SelectOnOfferSlider;
	
	@FindBy(xpath="(//button[@class='btn btn-default btn-block btn-offer ladda-click '])[1]")
	WebElement OfferChooseBtn;
	
	public boolean verifySelectAnOfferText() {
		action.waitForElementVisibility(getDriver(), SelectAnOfferText, 20);
		return action.isDisplayed(getDriver(), SelectAnOfferText);
	}
	
	public void verifyOfferSlider() {
		action.waitForElementVisibility(getDriver(), OfferSliderBar, 20);
		action.draggable(getDriver(), OfferSliderBar, 50, 241);	
	}
	
	public BankInformationPage verifySelectOnOfferSliderPage() {
		action.waitForElementVisibility(getDriver(), SelectOnOfferSlider, 3200);
		action.click(getDriver(), SelectOnOfferSlider);
		return new BankInformationPage();
	}
	
	public BankInformationPage verifyOfferChooseBtn() {
		 OfferChooseBtn.click();
		 return new BankInformationPage();
	}
	
	public BankInformationPage verifyOfferOnOffersPages() {
		action.waitForElementVisibility(getDriver(), SelectAnOfferText, 30);
		//System.out.println("Slider Location:---------------- "  + OfferSliderBar.getLocation());
		boolean result = action.isDisplayed(getDriver(), OfferSliderBar);
		System.out.println("result:---------------- "   + result);
		 if(result) 
		 {
			 verifySelectOnOfferSliderPage();
			 return new BankInformationPage();
		 } 
		 else 
			 verifyOfferChooseBtn();
		 return new BankInformationPage();
		 
	}
	
}
