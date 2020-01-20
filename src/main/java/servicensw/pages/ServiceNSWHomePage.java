package servicensw.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import servicensw.pageobjects.ServiceNSWHomePageObject;
import servicensw.utility.util;

public class ServiceNSWHomePage extends ServiceNSWHomePageObject {
	WebDriver driver = null;
	private static Logger Logger = org.apache.log4j.Logger.getLogger(ServiceNSWHomePage.class.getName());
	public String sFunName = "";
	boolean bStatus;

	public ServiceNSWHomePage(WebDriver driverPassed) {
		this.driver = driverPassed;
		PageFactory.initElements(driver, this);
		System.out.println("Driver Initialized");
	}

	/*
	 * Function to Navigate to Service NSW Home Page
	 */
	public void navHomePage() {
		sFunName = "navHomePage";
		System.out.println("Inside : navHomePage");
		String url = System.getProperty("env");
		System.out.println(sFunName + ": Navigating URL To : " + url);
		driver.get(url);
	}

	/*
	 * Function to Validate Home page is available
	 */
	public void validateHomePage() {
		sFunName = "validateHomePage";
		System.out.println("Inside : validateHomePage");
		String currentURL = driver.getCurrentUrl();
		System.out.println(sFunName + " : Current URL : " + currentURL);
		String title = driver.getTitle();
		System.out.println(sFunName + " page title Is : " + title);
		Assert.assertEquals("Home | Service NSW", title);
	}

	/*
	 * Function to find and search for a service on the Service NSW Home Page and
	 * select the same
	 * 
	 * @param service = service to be searched on the service NSW home page
	 */
	public void searchandSelectServiceOnServiceNSWHomePage(String service) {
		sFunName = "searchServiceOnServiceNSWHomePage";
		Logger.info("Inside : searchServiceOnServiceNSWHomePage");
		Logger.info(sFunName + " : service passed : " + service);
		bStatus = util.explicitlyWaitUntilElementIsPresent(searchServiceInputTextBox);
		Assert.assertTrue(bStatus, "Service Search Text field not Found");
		searchServiceInputTextBox.sendKeys(service);
		searchServiceInputTextBox.sendKeys(Keys.ENTER);
		util.waitForPageToLoad();
		/*
		System.out.println(sFunName + " : Verify and Click on the suggestion");
		if (serviceSuggestionList.size() > 0) {
			Logger.info(sFunName + " List of service provided # " + serviceSuggestionList.size());
			Logger.info(sFunName + " : Verify service to be selected");
			bStatus = util.explicitlyWaitUntilElementIsPresent(serviceSelectionElement);
			Assert.assertTrue(bStatus, "Service Element available");
			serviceSelectionElement.click();
		} else {
			Assert.fail(sFunName + "Service not Listed");
		}*/
	}
}
