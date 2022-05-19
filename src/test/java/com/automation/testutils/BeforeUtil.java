package com.automation.testutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.automation.util.ResourcePathConstants;

import net.thucydides.core.webdriver.DriverSource;

/**
 * 
 * @author Kishan Sakhiya
 * 
 *         This class is used for os detection and based on it drivers are
 *         picked as per name of browser from properties file
 *
 */
public class BeforeUtil implements DriverSource {
	public WebDriver driver;
	String browser;
	DesiredCapabilities capability = new DesiredCapabilities();

	@SuppressWarnings("deprecation")
	@Override
	public WebDriver newDriver() {
		String os = System.getProperty("os.name").toUpperCase();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("serenity.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		browser = prop.getProperty("browser");
		System.out.println("Browser: " + browser);
		if (os.contains("WINDOWS") || os.contains("LINUX") || os.contains("MAC")) {
			if (browser.equalsIgnoreCase("chrome")) {
				if (os.contains("WINDOWS")) {
					System.out.println("@Windows : "+ResourcePathConstants.CHROME_DRIVER_WINDOWS);
					System.out.println(ResourcePathConstants.CHROME_DRIVER_WINDOWS);
					System.setProperty("webdriver.chrome.driver", ResourcePathConstants.CHROME_DRIVER_WINDOWS);
				} else if (os.contains("MAC")) {
					System.setProperty("webdriver.chrome.driver", ResourcePathConstants.CHROME_DRIVER_MAC);
				} else if (os.contains("LINUX")) {
					System.setProperty("webdriver.chrome.driver", ResourcePathConstants.CHROME_DRIVER_LINUX);
					System.out.println("@LINUX : "+ResourcePathConstants.CHROME_DRIVER_LINUX);
					System.out.println(ResourcePathConstants.CHROME_DRIVER_LINUX);
				}
				//capability = DesiredCapabilities.chrome();
				//capability.setCapability("marionette", true);
				driver = new ChromeDriver();
				System.out.println("Chrome Driver Initailized" + driver);
				return driver;

			} else if (browser.equalsIgnoreCase("firefox")) {
				if (os.contains("WINDOWS")) {
					System.setProperty("webdriver.gecko.driver", ResourcePathConstants.FIREFOX_DRIVER_WINDOWS);
				} else if (os.contains("MAC")) {
					System.setProperty("webdriver.gecko.driver", ResourcePathConstants.FIREFOX_DRIVER_MAC);
				} else if (os.contains("LINUX")) {
					System.setProperty("webdriver.gecko.driver", ResourcePathConstants.FIREFOX_DRIVER_LINUX);
				}
//				capability = DesiredCapabilities.firefox();
//				capability.setCapability("marionette", true);
				driver = new FirefoxDriver(capability);
				System.out.println("FireFox Driver Initailized" + driver);
				return driver;
			}
		}
		return null;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
