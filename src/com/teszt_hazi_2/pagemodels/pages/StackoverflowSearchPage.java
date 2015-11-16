package com.teszt_hazi_2.pagemodels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.teszt_hazi_2.pagemodels.widgets.BaseWidget;

public class StackoverflowSearchPage extends BaseWidget {

	public StackoverflowSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static StackoverflowSearchPage createPage(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowSearchPage.class);
	}
	
	public static StackoverflowSearchPage navigateTo(WebDriver driver) {
		driver.get("http://stackoverflow.com/search");
		return PageFactory.initElements(driver, StackoverflowSearchPage.class);
	}

}
