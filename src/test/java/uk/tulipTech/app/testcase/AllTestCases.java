package uk.tulipTech.app.testcase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import uk.tulipTech.app.driver.BaseDriver;
import uk.tulipTech.app.page.StucommunifyHomePage;
import uk.tulipTech.app.page.SignInPage;

public class AllTestCases extends BaseDriver {

	StucommunifyHomePage homepage = new StucommunifyHomePage();
	SignInPage signInpage = new SignInPage();

	// Every Test case are Independent

	@Test
	public void loginFunctionality() throws InterruptedException {

		signInpage.clickLoginWithValidCredentials("qa_test@mail.com", "QATest@123");

	}
	
	
	@Test
	public void checkLoginSuccessful() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		signInpage.clickLoginWithValidCredentials("qa_test@mail.com", "QATest@123");
		String expectedUrl = "https://dev.stucommunify.co.uk/";
		Thread.sleep(2000);
	    String actualUrl = signInpage.assertLoginSuccessful();
	    softAssert.assertEquals(actualUrl, expectedUrl);
		softAssert.assertAll();
	}
	

	@Test
	public void createSocialPost() throws InterruptedException {

		// Got to Sign Page
		signInpage.clickLoginWithValidCredentials("qa_test@mail.com", "QATest@123");

		homepage.fillUpSocialPost("I am Testing a new feature");
	}
	
	
	@Test
	public void verifySocialPostCreation() throws InterruptedException {

		// Got to Sign Page
		signInpage.clickLoginWithValidCredentials("qa_test@mail.com", "QATest@123");

		SoftAssert softAssert = new SoftAssert();
		
		homepage.fillUpSocialPost("I am Testing a new feature");
		
		
		String expectedText = "Social post has been successfully created";
		Thread.sleep(2000);
	    String actualText = homepage.postCreatedSuccessfull();
	    softAssert.assertEquals(actualText, expectedText);

		softAssert.assertAll();
	}
	
	
	@Test
	public void verifyPostTitle() throws InterruptedException {

		// Got to Sign Page
		signInpage.clickLoginWithValidCredentials("qa_test@mail.com", "QATest@123");

		SoftAssert softAssert = new SoftAssert();
		
		homepage.fillUpSocialPost("I am Testing a new feature");
		
		
		String expectedText = "Social post has been successfully created";
		Thread.sleep(2000);
	    String actualText = homepage.postTitleVerify();
	    softAssert.assertEquals(actualText, expectedText);

		softAssert.assertAll();
	}



}
