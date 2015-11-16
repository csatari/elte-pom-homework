package com.teszt_hazi_2.pagemodels.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StackoverflowSearchWidget extends BaseWidget {

	//@FindBy(how = How.NAME, using = "q")
	@FindBy(how = How.CLASS_NAME, using = "textbox")
	public WebElement searchInput;
	
	@FindBy(css = ".col2 input")
	public WebElement searchButton;
	
	public StackoverflowSearchWidget(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static StackoverflowSearchWidget createWidget(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowSearchWidget.class);
	}
	
	public void setSearchtext(String text)  {
		searchInput.sendKeys(text);
	}
	
	public void clickSearchButton() {
		searchButton.click();
		//return ElviraSearchResultPage.createPage(driver);
	}

}
