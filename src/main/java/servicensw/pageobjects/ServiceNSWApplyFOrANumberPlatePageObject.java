package servicensw.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceNSWApplyFOrANumberPlatePageObject {
	@FindBy(xpath = "//a[contains(text(), 'Find locations')]")
	protected WebElement findLlocationsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Number plates')]")
	protected WebElement numberPlatesLink;
}
