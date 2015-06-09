package com.homeoffice.moj.virtuoso.sitrotaidam.ebay;

import uk.gov.homeoffice.virtuoso.framework.ExecutionContext;
import uk.gov.homeoffice.virtuoso.framework.element.PageElement;
import uk.gov.homeoffice.virtuoso.framework.page.BasePage;

public class EbayHomePage extends BasePage {

	private static final PageElement SEARCH_BAR = PageElement.byId("gh-ac",
			"Home Page search bar");
	private static final PageElement AUTO_COMPLETE_FIRST_OPTION = PageElement
			.byCssSelector(".ghAC_hl", "Autocomplete menu first option");

	public static EbayHomePage launch(String url) {
		ExecutionContext.getInstance().getPilot().navigateTo(url);
		return new EbayHomePage();
	}

	public void enterSearchTerm(String item) {
		pilot.sendKeys(SEARCH_BAR, item);
	}

	/**
	 * Click search bar.
	 */
	public void clickSearchBar() {
		pilot.click(SEARCH_BAR);
	}

	public String getAutoCompleteFirstOptionText() {
		return pilot.getText(AUTO_COMPLETE_FIRST_OPTION);
	}

	/**
	 * Select the first option from autocomplete drop down.
	 * 
	 * @return EbayItemSearchPage
	 */
	public EbayItemSearchPage selectFirstOptionFromAutoCompleteDropDown() {
		pilot.click(AUTO_COMPLETE_FIRST_OPTION);
		return new EbayItemSearchPage();
	}

}
