package Code;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	
	
	@Test
	public void Portal() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://qa-portal.qs.com/");
	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("vinaybubgsit@gmail.com");
	driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("Vinay@490");
	driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	driver.findElement(By.cssSelector("#navbarSupportedContent1 li:nth-child(2) a")).click();
	driver.findElement(By.cssSelector("#navbarSupportedContent1 li:nth-child(4) a")).click();
	
	Set<String> windows = driver.getWindowHandles();
	
/*	for(String window : windows) {
		
		String msg = driver.switchTo().window(window).getTitle();
		System.out.println(msg);
	}
	
	for (String window : windows) {
		if(driver.switchTo().window(window).getTitle().equals("About QS | Higher Education")) {
			driver.close();
		}  */
	
	List<String> wins = new ArrayList<String>(windows);
	
	String parent = wins.get(0);
	String child1 = wins.get(1);
	String child2 = wins.get(2);
	
	driver.switchTo().window(child1);
	
	System.out.println(driver.getTitle());
	
	driver.switchTo().window(parent);
	driver.close();
	
	
	
	
	
	

	
	
	}

}
