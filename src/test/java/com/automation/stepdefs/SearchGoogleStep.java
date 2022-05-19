package com.automation.stepdefs;

import java.util.List;

import com.automation.pageobject.SearchGooglePageObject;
import com.automation.util.URLConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class SearchGoogleStep extends PageObject {
	SearchGooglePageObject searchGooglePageObject;

	public SearchGoogleStep() {
	}
	
	@Given("^google homepage$")
	public void loadGoogleHomepage() throws InterruptedException {
		searchGooglePageObject.openAt(URLConstants.GOOGLE_HOMEPAGE);
		Thread.sleep(4000);
	}
	
	@When("^I search in home page$")
	public void enterGivenWord(DataTable details) throws InterruptedException {
//		List<List<String>> data = details.raw();
		List<List<String>> data = details.asLists(String.class);
		final String input = data.get(0).get(0);
		System.out.println(input);
		searchGooglePageObject.enterGivenWord(input);
		Thread.sleep(4000);
	}
	
	@Then("^it will give proper output$")
	public void showOutput() throws InterruptedException {
		Thread.sleep(4000);
	}
}
