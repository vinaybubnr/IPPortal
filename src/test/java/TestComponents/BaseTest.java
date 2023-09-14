package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // Logging Package
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public Logger logger; // For logging
	public ResourceBundle rb;

	public WebDriver initializeDriver() throws IOException {

		/*
		 * rb = ResourceBundle.getBundle("GlobalData"); String browserName =
		 * rb.getString("browser");
		 */

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");

		pro.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		}

		else if ((browserName.equalsIgnoreCase("firefox"))) {
			driver = new FirefoxDriver();

		}

		else if ((browserName.equalsIgnoreCase("edge"))) {
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		return driver;

	}

	// Screen Shot

	public String GetScreenShot(WebDriver driver, String TestCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + TestCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + TestCaseName + ".png";

	}

	/*
	 * public String randomeNumber() { String generatedString2 =
	 * RandomStringUtils.randomNumeric(10); return (generatedString2); }
	 */

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver();
		logger = LogManager.getLogger(this.getClass()); // Logging
		landingpage = new LandingPage(driver);
		landingpage.goTo();

		return landingpage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
