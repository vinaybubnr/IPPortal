package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class LandingPage extends AbstractClass{

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement user;

	@FindBy(xpath = "//input[@id='user_pass']")
	WebElement pass;

	@FindBy(css = "#wp-submit")
	WebElement signIn;

	@FindBy(xpath = "//span[@class='error-msg']")
	WebElement userError;

	@FindBy(xpath = "//span[@class='error-msg']")
	WebElement passError;
	
	@FindBy(xpath = "//span[@class='error-msg']")
	WebElement Error;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot password']")
	WebElement forGotPassword;
	
	@FindBy(xpath = "//p[@class='right_heading']")
	WebElement SignInLogo;
	
	@FindBy(xpath = "//p/a")
	WebElement SignInLink;

	public DashBoard Login(String User, String Pass) throws InterruptedException {
		user.sendKeys(User);
		pass.sendKeys(Pass);
		Thread.sleep(5000);
		signIn.click();
		
		DashBoard dashboard = new DashBoard(driver);
		return dashboard;

	}

	public void goTo() {
		driver.get("https://qa-portal.qs.com/");
	}

	public String PassError() throws InterruptedException {

		return passError.getText();

	}
	
	public String UserError() throws InterruptedException {
		

		return userError.getText();

	}
	
	public String Error() {
		return Error.getText();
	}
	
	public String SignInLogo() {
		return SignInLogo.getText();
	}
	
	public ForGotPassword forgotPassword() {
		forGotPassword.click();
		ForGotPassword forgotpassword = new ForGotPassword(driver);
		return forgotpassword;
		
		
	}
	
	public void signIn() {
		
		SignInLink.click();
		
		
	}
	

}
