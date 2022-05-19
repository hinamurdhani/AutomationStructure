package com.serenity.runner;
/*
 * @author Hina Murdhani
 */
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(CustomCucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" },
	features = { "src/test/resources/features" }, 
	glue = { "classpath:com.automation.stepdefs" })
public class CommonRunner {
}