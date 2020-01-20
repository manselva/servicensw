package servicensw.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import servicensw.pageobjects.ServiceNSWFindaServiceLocationPageObject;
import servicensw.pageobjects.ServiceNSWHomePageObject;
import servicensw.utility.util;

public class ServiceNSWFindaServiceLocationPage extends ServiceNSWFindaServiceLocationPageObject {
	WebDriver driver = null;
	private static Logger Logger = org.apache.log4j.Logger
			.getLogger(ServiceNSWFindaServiceLocationPage.class.getName());
	public String sFunName = "";
	boolean bStatus;

	public ServiceNSWFindaServiceLocationPage(WebDriver driverPassed) {
		this.driver = driverPassed;
		PageFactory.initElements(driver, this);
		System.out.println("Driver Initialized");
	}

	/*
	 * Function to Validate Find a service location page is available
	 */
	public void validateFindAServiceLocationPageAvailable() {
		sFunName = "validateFindAServiceLocationPageAvailable";
		System.out.println("Inside : validateFindAServiceLocationPageAvailable");
		String currentURL = driver.getCurrentUrl();
		System.out.println(sFunName + " : Current URL : " + currentURL);
		String title = driver.getTitle();
		System.out.println(sFunName + " page title Is : " + title);
		Assert.assertEquals("Find a Service NSW location | Service NSW", title);
	}

	/*
	 * Function to find and search for a service Location
	 * 
	 * @param serviceLocation, location to be searched with the postal code (eg
	 * Sydney 2000)
	 */
	public void searchForServiceLocation(String serviceLocation) {
		sFunName = "searchForServiceLocation";
		Logger.info("Inside : searchForServiceLocation");
		Logger.info(sFunName + " : service lcoation passed : " + serviceLocation);
		bStatus = util.explicitlyWaitUntilElementIsPresent(locationSearchInputBox);
		Assert.assertTrue(bStatus, "Service Search Text field not Found");
		locationSearchInputBox.sendKeys(serviceLocation);
		Logger.info(sFunName + " : Search the service location by pressing enter");
		locationSearchInputBox.sendKeys(Keys.ENTER);
		
	}
	
	/*
	 * Function to verify the service search is successful and Select the service
	 * found
	 */
	public void verifyServiceLocationsFound() {
		sFunName = "verifyServiceLocationsFound";
		System.out.println("Inside : verifyServiceLocationsFound");
		if (serviceLocationResults.size() > 0) {
			System.out.println(sFunName + " Service Location found # " + serviceLocationResults.size());
		} else {
			Assert.fail(sFunName + "Service Locations not found");
		}
	}
	
	/*
	 * Function to verify the service centre is found in the search result
	 */
	public void verifyServiceCentreIsAvailableInSearchResults(String serviceCentre) {
		sFunName = "verifyServiceCentreIsAvailableInSearchResults";
		int i=0;
		boolean foundCentre=false;
		System.out.println("Inside : verifyServiceCentreIsAvailableInSearchResults");
		while(i<serviceLocationResults.size()) {
			String centre=serviceLocationResults.get(i).getText();
			if(centre.contains(serviceCentre)) {
				foundCentre=true;
				break;
			}
			i++;	
		}
		if (foundCentre==true) {
			System.out.println(sFunName + " Service Centre found # " + serviceCentre);
		} else {
			Assert.fail(sFunName + "Service centre not found");
		}
	}
}
