package com.teszt_hazi_2.webdriver;

import org.junit.Test;

import com.teszt_hazi_2.pagemodels.pages.StackoverflowSearchPage;
import com.teszt_hazi_2.pagemodels.widgets.StackoverflowSearchWidget;


public class BeadandoTest extends TestBase {

	@Test
    public void pageObjectSearchExample()
    {
		StackoverflowSearchWidget searchWidget = StackoverflowSearchPage.navigateTo(driver).getSearchWidget();
		searchWidget.setSearchtext("Webdriver Java");
		searchWidget.clickSearchButton();
    }
}
