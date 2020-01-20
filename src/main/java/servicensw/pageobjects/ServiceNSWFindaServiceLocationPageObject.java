package servicensw.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceNSWFindaServiceLocationPageObject {
	@FindBy(css = "input#locatorTextSearch")
	protected WebElement locationSearchInputBox;

	@FindBy(css = "div.location")
	protected List<WebElement> serviceLocationResults;
}
