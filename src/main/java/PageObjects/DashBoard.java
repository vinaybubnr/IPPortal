package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class DashBoard extends AbstractClass{
	WebDriver driver;

	public DashBoard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".navbar-brand")
	WebElement Logo;

	public String LogoLabelValidation() {
		return Logo.getText();
	}

}