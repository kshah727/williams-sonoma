package com.sqa.ks.helpers;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class BasicPage extends Core {

	private WebDriver driver;

	private Logger log;

	public BasicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.log = Logger.getLogger(BasicTest.class);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	public boolean isElementpresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by);
	}

	public boolean takeScreenshot() {
		return AutoBasics.takeScreenShot(getDriver(), "Nestle:");
	}

	public boolean takeScreenshot(String name) {
		return AutoBasics.takeScreenShot(getDriver(), "Nestle:" + name);
	}
}
