package com.homeoffice.moj.virtuoso.sitrotaidam.test;

import org.junit.Test;

import com.homeoffice.moj.virtuoso.sitrotaidam.ebay.EbayHomePage;
import com.homeoffice.moj.virtuoso.sitrotaidam.ebay.EbayItemSearchPage;

import uk.gov.homeoffice.virtuoso.framework.test.SeleniumTest;

public class EbayTest extends SeleniumTest {

	 @Test
	  public void itemSearchAutoComplete() {
	    
	    // Test Step 1
	    EbayHomePage ebayHomePage = EbayHomePage.launch(testData.getInputValue("HomePage", "Url"));
	    
	    // Expected Result 1
	    assertor.assertEquals("eBay home page verification",
	        testData.getExpectedResult("HomePage", "Title"), ebayHomePage.getTitle());
	    
	    // Test Step 2
	    ebayHomePage.clickSearchBar();
	    ebayHomePage.enterSearchTerm(testData.getInputValue("HomePage", "SearchItemText"));
	    
	    // Expected Result 2
	    assertor.assertEquals("Autocomplete first option text",
	        testData.getExpectedResult("Search", "AutoComplete", "FirstOption"),
	        ebayHomePage.getAutoCompleteFirstOptionText());
	    
	    // Test Step 3
	    EbayItemSearchPage ebayItemSearchPage =
	        ebayHomePage.selectFirstOptionFromAutoCompleteDropDown();
	    
	    // Expected Result 3
	    assertor.assertEquals("First autocomplete option title verification",
	            testData.getExpectedResult("Search", "FirstOption", "Title"),
	            ebayItemSearchPage.getTitle());;
	  }

}
