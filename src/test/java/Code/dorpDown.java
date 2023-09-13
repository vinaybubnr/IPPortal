package Code;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dorpDown {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-portal.qs.com/signup/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//input[@id='search-country']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
		for(WebElement option : options) {
			String value = option.getText();
			if(value.equalsIgnoreCase("India")) {
				option.click();
				break;
				
			}
		
		}

	}

}
