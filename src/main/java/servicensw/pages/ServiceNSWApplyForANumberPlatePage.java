package servicensw.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import servicensw.pageobjects.ServiceNSWApplyFOrANumberPlatePageObject;
import servicensw.pageobjects.ServiceNSWHomePageObject;
import servicensw.utility.util;

public class ServiceNSWApplyForANumberPlatePage extends ServiceNSWApplyFOrANumberPlatePageObject {
	WebDriver driver = null;
	private static Logger Logger = org.apache.log4j.Logger.getLogger(ServiceNSWApplyForANumberPlatePage.class.getName());
	public String sFunName = "";
	boolean bStatus;

	public ServiceNSWApplyForANumberPlatePage(WebDriver driverPassed) {
		this.driver = driverPassed;
		PageFactory.initElements(driver, this);
		System.out.println("Driver Initialized");
	}

	/*
	 * Function to Validate Apply for a number plate page is available
	 */
	public void validateApplyForaNumberPlatePage() throws InterruptedException {
		sFunName = "validateApplyForaNumberPlatePage";
		System.out.println("Inside : validateApplyForaNumberPlatePage");
		String currentURL = driver.getCurrentUrl();
		System.out.println(sFunName + " : Current URL : " + currentURL);
		util.waitForPageToLoad();
		bStatus = util.explicitlyWaitUntilElementIsPresent(numberPlatesLink);
		Assert.assertTrue(bStatus, "Number Plates Link Found");
		String title = driver.getTitle();
		System.out.println(sFunName + " page title Is : " + title);
		Assert.assertEquals("Apply for a number plate | Service NSW", title);
	}

	/*
	 * Function to click on FInd LOcations to open search Location page
	 * 
	 */
	public void clickOnFindlocations() {
		sFunName = "clickOnFindlocations";
		Logger.info("Inside : clickOnFindlocations");
		Logger.info(sFunName + " : Verify and Click on Find Locations link");
		bStatus = util.explicitlyWaitUntilElementIsPresent(findLlocationsLink);
		Assert.assertTrue(bStatus, "Service Search Text field not Found");
		findLlocationsLink.click();
	}
}
