package com.teszt_hazi_2.webdriver;

import org.junit.Test;

import com.teszt_hazi_2.pagemodels.pages.StackoverflowSearchPage;


public class BeadandoTest extends TestBase {

	@Test
    public void pageObjectSearchExample()
    {
		StackoverflowSearchPage.navigateTo(driver);
    }
}
