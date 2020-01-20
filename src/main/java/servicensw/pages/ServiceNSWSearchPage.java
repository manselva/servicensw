package servicensw.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import servicensw.pageobjects.ServiceNSWSearchPageObject;
import servicensw.utility.util;

public class ServiceNSWSearchPage extends ServiceNSWSearchPageObject {
	WebDriver driver = null;
	private static Logger Logger = org.apache.log4j.Logger.getLogger(ServiceNSWHomePage.class.getName());
	public String sFunName = "";
	boolean bStatus;

	public ServiceNSWSearchPage(WebDriver driverPassed) {
		this.driver = driverPassed;
		PageFactory.initElements(driver, this);
		System.out.println("Driver Initialized");
	}
	
	/*
	 * Function to verify the service search is successful and Select the service
	 * found
	 */
	public void verifyServiceSearchSuccessfulAndSelect() throws InterruptedException {
		sFunName = "verifyServiceSearchSuccessful";
		System.out.println("Inside : verifyServiceSearchSuccessful");
		if (serviceSearchResults.size() > 0) {
			System.out.println(sFunName + " Service Search Results provided # " + serviceSearchResults.size());
			Logger.info(sFunName + " : Verify service to be selected");
			util.waitForPageToLoad();
			bStatus = util.explicitlyWaitUntilElementIsPresent(searchedServiceLink);
			Assert.assertTrue(bStatus, "Service Link available");
			System.out.println(searchedServiceLink.getText());
			searchedServiceLink.click();
		} else {
			Assert.fail(sFunName + "Service search not successful");
		}
	}
}
