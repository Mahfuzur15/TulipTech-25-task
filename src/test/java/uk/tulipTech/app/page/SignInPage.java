package uk.tulipTech.app.page;

import org.openqa.selenium.By;

import uk.tulipTech.app.utilities.CommonMethods;

public class SignInPage extends CommonMethods {

	// Locator for Email field
	By mail = By.xpath("//input[@placeholder='admin@communify.com']");

	// Locator for password field
	By pswd = By.xpath("//input[@placeholder='******']");

	By loginBtn = By.xpath("//span[normalize-space()='Log in']");


	// Method valid Login
	public void clickLoginWithValidCredentials(String email, String password) throws InterruptedException {

		sendText(mail, email);

		sendText(pswd, password);
		clickButton(loginBtn);

	}

//	public void clickLoginWithValidUserInvalidPassword(String email, String password) {
//
//		sendText(uName, email);
//		sendText(pswd, password);
//		clickButton(loginBtn);
//
//	}



	public String assertLoginSuccessful() {

		System.out.println(getPageURL());
		return getPageURL();

	}

}