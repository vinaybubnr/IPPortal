package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Abstract.AbstractClass;

public class SignUpPage extends AbstractClass {

	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='search-country']")
	WebElement drop1;

	@FindBy(xpath = "//div[@class='menu transition visible']/div")
	List<WebElement> countryList;

	@FindBy(xpath = "//input[@id='search-institute']")
	WebElement instituteSearch;

	// //div[@class='menu transition visible']/div

	@FindBy(xpath = "//div[@class='menu transition visible']/div")
	List<WebElement> InstitutionList;

	@FindBy(xpath = "//form[@id='custom-signup-form1']/div[3]")
	WebElement userTypeSearch;

	@FindBy(xpath = "//div[@class='menu transition visible']/div")
	List<WebElement> userTypeList;

	@FindBy(css = "#custom-signup-submit1")
	WebElement submit1;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='jobTitle']")
	WebElement jobTitle;
	
	@FindBy(css ="div[class='form-group col-sm-12 f-field form-type-select'] div[class='no-cross-mark qs-ranking-year no-jcf _semantic_select required selection ui dropdown'")
	WebElement department;
	
	@FindBy(xpath ="//div[@class='menu transition visible']/div")
	WebElement departmentOptions;

	public void clickCountry() {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOf(drop1));
		 */
		drop1.click();

	}

	public void countrySelection(String countryName) throws InterruptedException {

		Thread.sleep(3000);
		for (WebElement country : countryList) {

			String Name = country.getText();
			if (Name.equalsIgnoreCase(countryName)) {
				country.click();
				break;

			}

		}

	}

	public void InstitutionSelection(String InstitutionName) {

		instituteSearch.click();
		for (WebElement Institution : InstitutionList) {

			String Name = Institution.getText();
			if (Name.equalsIgnoreCase(InstitutionName)) {
				Institution.click();
				break;

			}

		}

	}

	public void UserTypeSelection(String userTypeName) {

		userTypeSearch.click();
		for (WebElement userType : userTypeList) {

			String Name = userType.getText();
			if (Name.equalsIgnoreCase(userTypeName)) {
				userType.click();
				break;

			}

		}

	}

	public void submit1() {
		submit1.click();

	}
	
	public void signup2() {
		
		
		
	}

}
