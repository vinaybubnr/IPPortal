package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class ForGotPassword extends AbstractClass{

	WebDriver driver;

	public ForGotPassword(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement EmailAddress;

	@FindBy(xpath = "//span[@class='text-success']")
	WebElement SucessMessage;

	@FindBy(css = "span[id='userError'] span")
	WebElement NoAccountError;

	@FindBy(css = "span[id='userError'] span ul li")
	WebElement EmptyEmailIdError;

	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement LogIn;

	@FindBy(css = "#wp-submit")
	WebElement submit;

	public void resetPassword(String email) {

		EmailAddress.sendKeys(email);
		submit.click();

	}

	public String validatingSucessMessage() {
		return SucessMessage.getText();
	}

	public String validatingNoAccountErrorMessage() {
		return NoAccountError.getText();
	}

	public String validatEmptyEmailErrorMessage() {
		return EmptyEmailIdError.getText();
	}

	public void validatingLogInLink() {
		LogIn.click();

	}
}
