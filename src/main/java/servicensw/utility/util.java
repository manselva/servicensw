package servicensw.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import servicensw.testBase.TestBase;


public class util extends TestBase {
	public static long impliciWait = 60;
	public static long explicitWait = 100;
	public static WebDriverWait wait;
	public static BufferedReader br;
	public static HashMap<String, String> hData;
	private static Logger Logger = org.apache.log4j.Logger.getLogger(util.class.getName());
	static File workspacePath = new File(".." + File.separator);
	public static String sFunName = "";

	/*
	 * Function to read Test Data from CSV and load into HashMap
	 */
	public static void loadCSV() throws IOException {
		Logger.info("Inside : loadCSV");
		String sLine;
		hData = new HashMap<String, String>();
		try {
			Logger.info("Loading the CSV File and Reading Contents");
			br = new BufferedReader(new FileReader(
					System.getProperty("user.dir") + "/src/main/java/servicensw/resources/TestData.csv"));
			while ((sLine = br.readLine()) != null) {
				Logger.info(sLine);
				// use comma as separator
				String[] sKeyValue = sLine.split(",");
				String sKey = sKeyValue[0];
				String sVal = sKeyValue[1];
				hData.put(sKey, sVal);
			}
		} catch (Exception e) {
			Logger.info("Could not Read CSV File" + e);
		}

		br.close();
	}

	/*
	 * Function to get specific value from CSV for the given Key
	 * 
	 * @param String, Key that needs to be searched in CSV
	 * 
	 * @return String, Value found for the Key given
	 */
	public static String getTestData(String sKey) {
		Logger.info("Inside : getTestData");
		String sVal = "";
		boolean bFound = false;
		if (hData.containsKey(sKey)) {
			sVal = hData.get(sKey);
			bFound = true;
		} else {
			Logger.info("Value is not available");
			Assert.assertTrue(bFound);
		}
		return sVal;
	}

	/*
	 * Function to verify whether the element is available in UI and wait till it is
	 * available
	 * 
	 * @param element, element that needs to be verified if it is present
	 * 
	 * @return boolean, True if element is present else false
	 */
	public static boolean explicitlyWaitUntilElementIsPresent(WebElement element) {
		Logger.info("Inside : explicitlyWaitUntilElementIsPresent");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean explicitlyWaitUntilElementIsClickable(WebElement element) {
		Logger.info("Inside : explicitlyWaitUntilElementIsPresent");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * Function to verify whether the element is available in UI and wait till it is
	 * available
	 */
	public static void waitForPageToLoad() {
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	/*
	 * Function to verify whether the Text is available in element
	 * 
	 * @param element, element that needs to be verified
	 * 
	 * @param text, value that needs to be available
	 * 
	 * @return boolean, True if element is present else false
	 */
	public static boolean explicitlyWaitUntilTextIsAvailavleOnElement(WebElement element, String sValue) {
		Logger.info("Inside : explicitlyWaitUntilTextIsAvailavleOnElement");
		Logger.info(element.getText());
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, sValue));
			Logger.info(element.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getOsName() {
		// This method is used to get the operating system name
		String osName = System.getProperty("os.name");
		return osName;
	}
}