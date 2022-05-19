package com.automation.stepdefs;

import java.util.List;

import com.automation.pageobject.VettedLoginPageObject;
import com.automation.util.URLConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class VettedLoginStepDef extends PageObject {
	VettedLoginPageObject vettedLoginPageObject;

	public VettedLoginStepDef() {
	}
	
	@Given("^vetted login url$")
	public void loadVettedLoginPage() throws InterruptedException {
		vettedLoginPageObject.openAt(URLConstants.VETTED_LOGIN_URL);
	}
	@Then("^user login through creds$")
	public void userLogin() throws InterruptedException {
		vettedLoginPageObject.login();
		Thread.sleep(4000);
	}
}
