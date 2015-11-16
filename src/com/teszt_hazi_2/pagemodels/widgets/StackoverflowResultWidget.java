package com.teszt_hazi_2.pagemodels.widgets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.teszt_hazi_2.pagemodels.pages.StackoverflowTopicPage;

public class StackoverflowResultWidget extends BaseWidget {

	@FindBy(css = ".search-results")
	public WebElement questions;
	
	@FindBys(value = { @FindBy(css = ".question-summary") })
	public List<WebElement> allQuestions;
	
	public StackoverflowResultWidget(WebDriver driver) {
		super(driver);
	}
	
	public static StackoverflowResultWidget createWidget(WebDriver driver) {
		return PageFactory.initElements(driver, StackoverflowResultWidget.class);
	}
	
	private ArrayList<WebElement> getAnsweredQuestions() {
		ArrayList<WebElement> answeredQuestions = new ArrayList<>();
		for(WebElement question : allQuestions) {
			if(!question.findElements(By.cssSelector("div.answered-accepted")).isEmpty()) {
				answeredQuestions.add(question);
			}
		}
		return answeredQuestions;
	}
	
	/**
	 * Kikeresi a k�rd�sekb�l a legt�bb szavazatot kapottat.
	 * Ha t�bb legt�bb szavazatot kap� k�rd�s van, akkor v�letlenszer�en v�laszt k�z�l�k
	 * Indok: "holtversenyn�l tetsz�legeset. A megold�s nem lehet be�getett kiv�laszt�s, leellen�rizz�k az algoritmust."
	 */
	private WebElement getHighestVotedAnsweredQuestion(ArrayList<WebElement> questions) {
		//Ebben t�rolom le a legt�bb szavazatot kap� k�rd�seket, majd a legnagyobb kulcs�t v�lasztom ki
		TreeMap<Integer, ArrayList<WebElement>> answeredQuestions = new TreeMap<>();
		for(WebElement question : questions) {
			Integer votes = Integer.parseInt(question.findElement(By.cssSelector(".vote-count-post strong")).getText());
			if(!answeredQuestions.containsKey(votes)) {
				answeredQuestions.put(votes, new ArrayList<WebElement>());
			}
			ArrayList<WebElement> currentQuestions = answeredQuestions.get(votes);
			currentQuestions.add(question);
			answeredQuestions.put(votes, currentQuestions);
		}
		if(answeredQuestions.isEmpty()) {
			Assert.fail("Didn't found any accepted answers");
		}
		ArrayList<WebElement> highestVoted = answeredQuestions.get(answeredQuestions.lastKey());
		//v�letlenszer� v�laszt�s a legmagasabb szavazatot kap� v�laszok k�z�l
		return highestVoted.get(new Random().nextInt(highestVoted.size()));
	}
	
	public StackoverflowTopicPage clickHighestVoted() {
		WebElement highestVoted = getHighestVotedAnsweredQuestion(getAnsweredQuestions());
		highestVoted.findElement(By.cssSelector("div.result-link > span > a")).click();
		return StackoverflowTopicPage.createPage(driver);
	}

}
