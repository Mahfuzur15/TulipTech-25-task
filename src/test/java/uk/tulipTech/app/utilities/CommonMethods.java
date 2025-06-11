package uk.tulipTech.app.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import uk.tulipTech.app.driver.BaseDriver;

public class CommonMethods extends BaseDriver {
	
	
	public void hoverOnElement(By element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element)).perform();

	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public String getText(By element) {
		return driver.findElement(element).getText();
	}

	public void sendText(By element, String value) {

		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(value);

	}

	public void clickButton(By element) {

		driver.findElement(element).click();
	}

	// Assertion Error Message Check
	public String getMessage(By message) {
		String textMessage = driver.findElement(message).getText();
		System.out.println(message);
		return textMessage;
	}


}
