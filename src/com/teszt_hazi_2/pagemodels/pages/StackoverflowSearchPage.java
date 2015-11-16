package com.teszt_hazi_2.pagemodels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.teszt_hazi_2.pagemodels.widgets.BaseWidget;
import com.teszt_hazi_2.pagemodels.widgets.StackoverflowSearchWidget;

public class StackoverflowSearchPage extends BaseWidget {
	
	private StackoverflowSearchWidget searchWidget;

	public StackoverflowSearchPage(WebDriver driver) {
		super(driver);
		searchWidget = StackoverflowSearchWidget.createWidget(this.driver);
	}
	
	public static StackoverflowSearchPage createPage(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowSearchPage.class);
	}
	
	public StackoverflowSearchWidget getSearchWidget() {
		return searchWidget;
	}
	
	public static StackoverflowSearchPage navigateTo(WebDriver driver) {
		driver.get("http://stackoverflow.com/search");
		return PageFactory.initElements(driver, StackoverflowSearchPage.class);
	}

}
