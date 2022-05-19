package com.automation.util;

import net.serenitybdd.core.pages.PageObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;



/**
 * @author Hina Murdhani
 *
 *         This class contains all the common functions needed in the project
 */
public class UtilFactory extends PageObject {

	public WebDriver driver;
	String browser;

	DesiredCapabilities capability = new DesiredCapabilities();

	/**
	 * Constructor to get driver
	 *
	 * @param driver
	 *            It will be chrome/firefox driver which will open respective
	 *            browser instance
	 */
	public UtilFactory(WebDriver driver) {
		driver = super.getDriver();
	}

	/**
	 * @param element
	 *            This method will highlight elements on UI when automation runs
	 */
	public void highlight(WebElement element) {
		driver = super.getDriver();
		executeScript(driver, "arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
	}

	private Object executeScript(WebDriver driver, String javascriptToExecute, Object... parameters) {
		return ((JavascriptExecutor) driver).executeScript(javascriptToExecute, parameters);
	}

	/**
	 * This method is used to generate the client name instantly for passing to
	 * register client
	 *
	 * @return randomString
	 */
	public String getRandomString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)));
		for (int i = 0; i < 5; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);
		return sb.toString();
	}

	/**
	 * This method is used to scroll down or up in the page uptil the WebElement passed as param to method
	 *
	 * @param element
	 * 			WebElement upto which we want to scroll
	 */
	public void scrollToElement(WebElement element) {
		driver = super.getDriver();
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * This method is used to scroll to bottom of the page. 500 is the static index given
	 */
	public void scrollToBottom() {
		driver = super.getDriver();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}

	/**
	 *
	 * This method reads data.json file from resources and gives the value of
	 * the key mentioned when method is called for respective feature and
	 * scenario number
	 *
	 * @param featureName
	 * @param scenarioNo
	 * @param key
	 * @return json value for key mentioned in params
	 */
	public String readJSON(String featureName, String scenarioNo, String key) {
		JSONParser parser = new JSONParser();
		try {
			Object objectFromDataFile = parser.parse(new FileReader(ResourcePathConstants.JSON_DATA_FILE_PATH));
			JSONObject jsonObjectFromDataFile = (JSONObject) objectFromDataFile;
			JSONObject featureObject = (JSONObject) jsonObjectFromDataFile.get(featureName);
			JSONObject scenarioObject = (JSONObject) featureObject.get(scenarioNo);
			return (String) scenarioObject.get(key);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return "Error while getting json value";
	}

}
