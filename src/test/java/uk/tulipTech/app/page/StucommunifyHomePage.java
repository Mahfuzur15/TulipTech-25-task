package uk.tulipTech.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import uk.tulipTech.app.utilities.CommonMethods;


public class StucommunifyHomePage extends CommonMethods {

	By createPostBtn = By.xpath("//span[normalize-space()='Create Post']");

	By socialPostBtn = By.xpath("//div[contains(text(),'Social Post')]");
	By postInputField = By.xpath("//textarea[@placeholder='Write your thoughts...']");

	By uploadImageField1 = By.xpath("//span[normalize-space()='Upload Image']");
	By uploadImageField = By.xpath("//input[@type='file']");
	
    // Set the image file path
    String imagePath1 = "C:/Users/Reve/eclipse-workspace/tulipTech-automation-test/images/image1.jpeg";
    String imagePath2 = "C:/Users/Reve/eclipse-workspace/tulipTech-automation-test/images/image2.jpeg";


	By previewBtn = By.cssSelector("button[class='ant-btn css-1s7zzkx ant-btn-default flex justify-center place-items-center rounded-none h-8 text-primary font-bold border-none']");

	By publishBtn = By.xpath("//button[@type='submit']");

	By verifyPost = By.xpath("//div[@class='ant-notification-notice-description']");
	By verifyTitle = By.xpath("	//div[contains(@class,'text-base whitespace-pre-line')]//span[contains(text(),'this is my first post')]");

	public void fillUpSocialPost(String postText) throws InterruptedException {

		
		clickButton(createPostBtn);
		clickButton(socialPostBtn);
		sendText(postInputField, postText);
	

//Thread.sleep(5000);

hoverOnElement(uploadImageField1);



JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].style.display='block';", driver.findElement(uploadImageField));

//Upload the image by sending the file path
		sendText(uploadImageField,imagePath1);
		
		
		hoverOnElement(uploadImageField1);

		js.executeScript("arguments[0].style.display='block';", driver.findElement(uploadImageField));
		
		// Upload the image by sending the file path
		sendText(uploadImageField,imagePath2);
		
		clickButton(previewBtn);
		clickButton(publishBtn);
		
		
		
	}
	
	public String postCreatedSuccessfull() {

		return getText(verifyPost);
	}
	
	
	public String postTitleVerify() {

		return getText(verifyTitle);
	}
	
}