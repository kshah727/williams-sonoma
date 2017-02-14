package com.sqa.ks.helpers;

import java.util.concurrent.*;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class BasicTest extends Core {

	private String baseUrl;

	private WebDriver driver;

	private Logger log;

	public BasicTest(String baseUrl) {
		super();
		this.baseUrl = baseUrl;
		this.log = Logger.getLogger(BasicTest.class);
		this.log.info("created basic test object through constructor");
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	@BeforeMethod(groups = "chrome")
	public void setupChrome() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get(this.baseUrl);
	}

	@BeforeMethod(groups = "firefox")
	public void setupFirefox() {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get(this.baseUrl);
	}

	@BeforeMethod(groups = "safari")
	public void setupSafari() {
		this.driver = new SafariDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get(this.baseUrl);
	}

	@AfterMethod
	public void teardown() {
		this.driver.quit();
	}
}
