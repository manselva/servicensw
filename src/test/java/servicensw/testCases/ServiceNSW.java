package servicensw.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import servicensw.testBase.TestBase;
import servicensw.*;
import servicensw.pages.ServiceNSWApplyForANumberPlatePage;
import servicensw.pages.ServiceNSWFindaServiceLocationPage;
import servicensw.pages.ServiceNSWHomePage;
import servicensw.pages.ServiceNSWSearchPage;
import servicensw.utility.*;

public class ServiceNSW extends TestBase {
	public WebDriver driver;
	private Logger Logger = org.apache.log4j.Logger.getLogger(ServiceNSW.class.getName());

	public ServiceNSW()
	{
		super();
	}

	@BeforeTest
	public void launch() throws Exception {
		Logger.info("Initializing Driver");
		driver = setupAndReturnDriver();
		util.loadCSV();
	}

	@Test
	public void validateNavigationToApplyaNumberPlate() throws Exception{
		ServiceNSWHomePage home = new ServiceNSWHomePage(driver);
		home.navHomePage();
		home.validateHomePage();
		home.searchandSelectServiceOnServiceNSWHomePage(util.getTestData("serviceApplynumberPlate"));
		
		ServiceNSWSearchPage searchPage = new ServiceNSWSearchPage(driver);
		searchPage.verifyServiceSearchSuccessfulAndSelect();
		
		ServiceNSWApplyForANumberPlatePage applyForNumPlatePage=new ServiceNSWApplyForANumberPlatePage(driver);
		applyForNumPlatePage.validateApplyForaNumberPlatePage();
		applyForNumPlatePage.clickOnFindlocations();
		
		ServiceNSWFindaServiceLocationPage findLocPage=new ServiceNSWFindaServiceLocationPage(driver);
		findLocPage.validateFindAServiceLocationPageAvailable();
		findLocPage.searchForServiceLocation(util.getTestData("serviceLocation"));
		findLocPage.verifyServiceLocationsFound();
		findLocPage.verifyServiceCentreIsAvailableInSearchResults(util.getTestData("serviceCentre"));
	}
	
	@AfterTest
	public void quit() throws Exception {
		Logger.info("Tearing Down");
		tearDown();
	}
}
