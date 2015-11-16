package com.teszt_hazi_2.pagemodels.widgets;

import org.openqa.selenium.WebDriver;

public class BaseWidget {

	protected WebDriver driver;
	
	public BaseWidget(WebDriver driver) {
		this.driver = driver;
	}
}