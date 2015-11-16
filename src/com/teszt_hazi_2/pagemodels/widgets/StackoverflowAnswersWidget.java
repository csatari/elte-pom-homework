package com.teszt_hazi_2.pagemodels.widgets;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.Matchers.greaterThan;

public class StackoverflowAnswersWidget extends BaseWidget {

	
	
	public StackoverflowAnswersWidget(WebDriver driver) {
		super(driver);
	}

	public static StackoverflowAnswersWidget createWidget(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowAnswersWidget.class);
	}
	
	public void verifyThatTheGreenArrowCanBeFound() {
		Assert.assertThat(getNoOfGreenCheckMark(), greaterThan(0));
	}
	
	private int getNoOfGreenCheckMark() {
		return driver.findElements(By.cssSelector("span.vote-accepted-on")).size();
	}
}
