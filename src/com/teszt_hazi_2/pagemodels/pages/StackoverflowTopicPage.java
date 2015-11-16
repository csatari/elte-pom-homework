package com.teszt_hazi_2.pagemodels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.teszt_hazi_2.pagemodels.widgets.BaseWidget;
import com.teszt_hazi_2.pagemodels.widgets.StackoverflowAnswersWidget;

public class StackoverflowTopicPage extends BaseWidget {

	private StackoverflowAnswersWidget answersWidget;
	
	
	public StackoverflowTopicPage(WebDriver driver) {
		super(driver);
		answersWidget = StackoverflowAnswersWidget.createWidget(this.driver);
	}
	
	public static StackoverflowTopicPage createPage(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowTopicPage.class);
	}
	
	public StackoverflowAnswersWidget getAnswerWidget() {
		return answersWidget;
	}

}
