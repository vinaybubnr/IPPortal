package Code;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ForGotPassword;
import TestComponents.BaseTest;

public class TC2_ForgotPassword extends BaseTest {

	@Test
	public void resetPasswordWithRegisteredEmailId() {

		logger.info("****Checking ForGot Password *******");

		ForGotPassword forgotpassword = landingpage.forgotPassword();
		forgotpassword.resetPassword("vinay@qs.com");

		String message = forgotpassword.validatingSucessMessage();
		String[] msg = message.split(",");
		Assert.assertEquals(msg[0], "Check your email for the confirmation link");

	}

	@Test
	public void resetPasswordWithUnRegisteredEmailId() {

		ForGotPassword forgotpassword = landingpage.forgotPassword();
		forgotpassword.resetPassword("vinayy@qs.com");
		String Error = forgotpassword.validatingNoAccountErrorMessage();
		Assert.assertEquals(Error, "There is no account with that username or email address.");

	}

	@Test
	public void resetPasswordWithEmptyEmailId() {
		ForGotPassword forgotpassword = landingpage.forgotPassword();
		forgotpassword.resetPassword("");
		String Error = forgotpassword.validatEmptyEmailErrorMessage();
		Assert.assertEquals(Error, "Please fill this field.");

	}

	@Test
	public void VerifyLogInButton() {
		ForGotPassword forgotpassword = landingpage.forgotPassword();
		forgotpassword.validatingLogInLink();
		String message = landingpage.SignInLogo();
		Assert.assertEquals(message, "Sign in");

	}

}
