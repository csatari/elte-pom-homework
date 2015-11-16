package com.teszt_hazi_2.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestBase {
	protected WebDriver driver = null;

	@Before
	public void classSetup() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(false);
		driver = new FirefoxDriver(profile);	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
//		driver.quit();
	}
}
