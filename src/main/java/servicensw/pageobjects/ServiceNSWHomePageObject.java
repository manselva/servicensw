package servicensw.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceNSWHomePageObject {

	@FindBy(css = "div#homeAutosuggest > input")
	protected WebElement searchServiceInputTextBox;

	@FindBy(css = "#homeAutosuggestList > li")
	protected List<WebElement> serviceSuggestionList;

	@FindBy(xpath = "//li[contains(text(), 'apply for a number plate')]")
	protected WebElement serviceSelectionElement;
	
	@FindBy(css = ".search__results > div.search__result")
	protected List<WebElement> serviceSearchResults;
	
	@FindBy(xpath = "//a[contains(text(), 'Apply for a number plate')]")
	protected WebElement searchedServiceLink;
}
