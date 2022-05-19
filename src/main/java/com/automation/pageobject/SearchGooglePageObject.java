package com.automation.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.util.Locators;
import com.automation.util.UtilFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SearchGooglePageObject extends PageObject {
	UtilFactory utilFactory;
	
	public SearchGooglePageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = Locators.GOOGLE_SEARCH_BOX)
	private WebElement googleSearchBox;
	
	
	
	public void enterGivenWord(String input) {
		googleSearchBox.sendKeys(utilFactory.readJSON("search", input, "search"),Keys.ENTER);
	}

}
