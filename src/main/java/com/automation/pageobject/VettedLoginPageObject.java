package com.automation.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.util.Locators;
import com.automation.util.UtilFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class VettedLoginPageObject extends PageObject {
	UtilFactory utilFactory;
	
	public VettedLoginPageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = Locators.CERTA_ASSOCIATE_BUTTON)
	private WebElementFacade certaAssociateButton;
	@FindBy(xpath = Locators.LOGIN_EMAIL_PASSWORD_BUTTON)
	private WebElementFacade loginemailpasswordButton;
	@FindBy(xpath = Locators.USERNAME_TEXTBOX)
	private WebElementFacade usernameTextbox;
	@FindBy(xpath = Locators.PASSWORD_TEXTBOX)
	private WebElementFacade passwordTextbox;
	@FindBy(xpath = Locators.LOGIN_BUTTON)
	private WebElementFacade loginButton;

	public void login() throws InterruptedException {
		Thread.sleep(6000);
		utilFactory.highlight(certaAssociateButton);
		certaAssociateButton.click();
		System.out.println("------"+loginemailpasswordButton);
		utilFactory.scrollToBottom();
		loginemailpasswordButton.waitUntilVisible();
		utilFactory.highlight(loginemailpasswordButton);
		loginemailpasswordButton.click();
		utilFactory.highlight(usernameTextbox);
		usernameTextbox.sendKeys("hina+testing@getcerta.com");
		utilFactory.highlight(passwordTextbox);
		passwordTextbox.sendKeys("Hina@1234");
		utilFactory.highlight(loginButton);
		loginButton.click();
	}
}
