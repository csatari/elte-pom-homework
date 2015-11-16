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
	 * Kikeresi a kérdésekbõl a legtöbb szavazatot kapottat.
	 * Ha több legtöbb szavazatot kapó kérdés van, akkor véletlenszerûen választ közülük
	 * Indok: "holtversenynél tetszõlegeset. A megoldás nem lehet beégetett kiválasztás, leellenõrizzük az algoritmust."
	 */
	private WebElement getHighestVotedAnsweredQuestion(ArrayList<WebElement> questions) {
		//Ebben tárolom le a legtöbb szavazatot kapó kérdéseket, majd a legnagyobb kulcsút választom ki
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
		//véletlenszerû választás a legmagasabb szavazatot kapó válaszok közül
		return highestVoted.get(new Random().nextInt(highestVoted.size()));
	}
	
	public StackoverflowTopicPage clickHighestVoted() {
		WebElement highestVoted = getHighestVotedAnsweredQuestion(getAnsweredQuestions());
		highestVoted.findElement(By.cssSelector("div.result-link > span > a")).click();
		return StackoverflowTopicPage.createPage(driver);
	}

}
