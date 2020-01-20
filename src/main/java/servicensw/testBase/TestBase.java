package servicensw.testBase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import servicensw.utility.util;

public class TestBase {
	protected static Properties prop = new Properties();
	protected static WebDriver driver;
	static Logger Logger = org.apache.log4j.Logger.getLogger(TestBase.class.getName());

	public TestBase() {

	}

	/*
	 * Function to close browsers and quit driver
	 */
	public static void tearDown() throws IOException {
		System.out.println("Inside : tearDown");
		System.out.println("Quiting Driver");
		driver.quit();
	}

	/*
	 * Function to get the web driver
	 */
	public static WebDriver getDriver() throws IOException {
		System.out.println("Inside : getDriver");
		System.out.println("Returning WEB Driver");
		return driver;
	}

	/*
	 * Function to setup Driver
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver setupAndReturnDriver() {
		System.out.println("Inside : setup");
		String browserVal = System.getProperty("browser");
		if (browserVal.equalsIgnoreCase("chrome")) {
			String osName = util.getOsName();
			Logger.info("OS->" + osName);
			if (osName.contains("Windows")) {
				Logger.info("Set Driver for Windows");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromedriver.exe");
			} else if (osName.contains("Linux")) {
				Logger.info("Set Driver for Linux");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "chromedriver_linux");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromedriver_linux");
			} else if (osName.contains("Mac")) {
				Logger.info("Set Driver for Mac");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "chromedriver_mac");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromedriver_mac");
			}
			Logger.info("Created the chrome driver capabilities");
			driver = new ChromeDriver();
		} else if (browserVal.equalsIgnoreCase("firefox")) {
			Logger.info("Setup for Firefox");
			String osName = util.getOsName();
			Logger.info("OS->" + osName);
			Logger.info("Set Capabilities");
			if (osName.contains("Windows")) {
				Logger.info("Set Driver for Windows");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "geckodriver_win.exe");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
						+ File.separator + "geckodriver_win.exe");
			} else if (osName.contains("Linux")) {
				Logger.info("Set Driver for Linux");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "geckodriver_linux");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
						+ File.separator + "geckodriver_linux");
			} else if (osName.contains("Mac")) {
				Logger.info("Set Driver for Mac");
				Logger.info(System.getProperty("user.dir") + File.separator + "drivers" + File.separator
						+ "geckodriver_mac");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
						+ File.separator + "geckodriver_mac");
			}
			Logger.info("Created the chrome driver capabilities");
			driver = new FirefoxDriver();
		} else if (browserVal.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(util.impliciWait, TimeUnit.SECONDS);
		util.wait = new WebDriverWait(driver, util.explicitWait);
		return driver;
	}
}