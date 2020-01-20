package servicensw.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceNSWSearchPageObject {
	@FindBy(css = ".search__results > div.search__result")
	protected List<WebElement> serviceSearchResults;
	
	@FindBy(xpath = "//a[contains(text(), 'Apply for a number plate')]")
	protected WebElement searchedServiceLink;
}
