package com.sqa.ks;

import java.io.*;
import java.util.concurrent.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class CraigslistTest {

	static int testNum = 0;

	static WebDriver driver;

	static String baseUrl = "http://sfbay.craigslist.org";

	public static boolean isElementPresent(By by) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void takeScreenshot(String name) {
		// Takes screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Move to screenshot folder
		try {
			FileUtils.copyFile(srcFile, new File("screenshots/" + name.toUpperCase() + ".PNG"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved correctly:" + name + ".png");
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "Quality Assurance" },
				new Object[] { "java QA" }, new Object[] { "QA engineer" },
				new Object[] { "java" }, new Object[] { "test java" },
				new Object[] { "javajunior" }, };
	}

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		baseUrl = "http://sfbay.craigslist.org";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "dp")
	public void testCraigslist(String keywords) {
		// Use a number count for tests
		this.testNum++;
		// display title
		System.out.println("Craigslist Test" + this.testNum + ": \"" + keywords + "\"");
		// go to base url
		driver.get(baseUrl + "/");
		// drive the test...collect item for jobs link text
		driver.findElement(By.cssSelector("a.jjj > span.txt")).click();
		// clear the field for search bar
		driver.findElement(By.id("query")).clear();
		// type the keys into search field
		driver.findElement(By.id("query")).sendKeys(keywords);
		// click on the submit button to search for results
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// locate webelement for the test for total and set to String variable
		if (isElementPresent(By.className("totalcount"))) {
			String output = driver.findElement(By.className("totalcount")).getText().trim();
			if (output.equalsIgnoreCase("")) {
				String rangeTo = driver.findElement(By.className("rangeTo")).getText().trim();
				System.out.println("number of results (" + keywords + "):" + rangeTo);
			} else {
				System.out.println("number of results (" + keywords + "):" + output);
				// } else if (isElementPresent(By.className("button pagenum")))
				// {
				// System.out.println("number of results (" + keywords + "):0");
			}
		} else {
			// String resultsCount =
			// driver.findElement(By.className("totalcount")).getText().trim();
			// log the number of results to console
			System.out.println("number of results (" + keywords + ") :0");
		}
		// click on the first link to go to the page
		driver.findElement(By.cssSelector("a.result-title.hdrlnk")).click();
		// take a screenshot of the current page
		takeScreenshot(keywords);
	}
}
