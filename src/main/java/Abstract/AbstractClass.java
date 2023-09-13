package Abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AbstractClass {
	
	WebDriver driver;
	
	public AbstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Select dropdownSelect(WebElement value) {
		
		Select sc = new Select(value);
		return sc;
		
	}

}
