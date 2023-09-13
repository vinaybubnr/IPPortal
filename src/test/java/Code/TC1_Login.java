package Code;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.DashBoard;
import PageObjects.LandingPage;
import TestComponents.BaseTest;
import TestComponents.ExcelUtility;

public class TC1_Login extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Sanity" })

	public void loginWithValidCredential(String user, String pass) throws IOException, InterruptedException {
		logger.debug("Application Logs");
		logger.info("******Starting TC1_Login*******");
		DashBoard dashboard = landingpage.Login(user, pass);
		String message = dashboard.LogoLabelValidation();
		Assert.assertEquals(message, "Institution Portal");
		logger.info("****Complete Login******");

	}

	@Test(dependsOnMethods = { "loginWithValidCredential" })

	public void LoginWithInvalidPassword() throws InterruptedException {

		landingpage.Login("vinay@qs.com", "Admin@12534");
		String Error = landingpage.PassError();

		Assert.assertEquals(Error, "Incorrect password. Please try again.");

	}

	@Test(dependsOnMethods = { "LoginWithInvalidPassword" })

	public void LoginWithInvalidUser() throws InterruptedException {

		landingpage.Login("vinayy@qs.com", "Admin@1234");
		String Error = landingpage.UserError();
		Assert.assertEquals(Error, "Data not found.");

	}

	@Test

	public void LoginWithOutCredential() throws InterruptedException {

		landingpage.Login("", "");
		String Error = landingpage.Error();
		Assert.assertEquals(Error, "Please fill this field.");

	}

	@DataProvider

	public String[][] getData() throws IOException {
		// return new Object[][] { { "vinay@qs.com", "Admin@1234" }, {
		// "vinaybubgsit@gmail.com", "Vinay@490" } };




		String fileName = System.getProperty("user.dir") + "\\TestData\\IPLOGIN.xlsx";// taking xl file from testData
		ExcelUtility utilss = new ExcelUtility(fileName);

		int totalrows = utilss.getRowCount("Login");
		int totalcols = utilss.getCellCount("Login", 1);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = utilss.getCellData("Login", i, j); // 1,0
			}
		}
		return logindata;// returning two dimension array

	}

}
