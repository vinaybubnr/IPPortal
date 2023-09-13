package Code;

import org.testng.annotations.Test;

import PageObjects.SignUpPage;
import TestComponents.BaseTest;

public class TC3_SignUp extends BaseTest{
	
	@Test
	
	public void signUp1() throws InterruptedException {
		
		landingpage.signIn();
		SignUpPage signuppage = new SignUpPage(driver);
		Thread.sleep(4000);
		signuppage.clickCountry();
		signuppage.countrySelection("India");
		Thread.sleep(4000);
		signuppage.InstitutionSelection("Indian Institute of Foreign Trade");
		Thread.sleep(4000);
		signuppage.UserTypeSelection("I work for a university"); 
		signuppage.submit1();
		
	}
	
	@Test
	
	public void signUp2() throws InterruptedException {
		
		signUp1();
		
		
	}

}
