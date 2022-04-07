package keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords {

	public WebDriver driver;
	public Properties prop;
	public Properties envProp;

	public void openBrowser(String browser) {
		System.out.println("Opening the browser " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void navigate(String urlKey) {
		System.out.println("Navigating to " + urlKey);
		driver.get(envProp.getProperty(urlKey));
	}

	public void click(String locatorKey) {
		System.out.println("Clicking on " + locatorKey);
		getElement(locatorKey).click();
	}

	public void type(String locatorKey, String data) {
		System.out.println("Typing in " + locatorKey + " .Data " + data);
		getElement(locatorKey).sendKeys(data);

	}

	public void select(String locator, String data) {

	}

	public void getText(String locator) {

	}

	// central function to extract the element
	public WebElement getElement(String locatorKey) {
		// check the presence
		if (!isElementPresent(locatorKey)) {
			System.out.println("Element not present " + locatorKey);
			// report failure
		}

		// check the visibility
		if (!isElementVisible(locatorKey)) {
			System.out.println("Element not visible " + locatorKey);

		}
		WebElement e = null;
		if (locatorKey.endsWith("_id"))
			e = driver.findElement(By.id(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_xpath"))
			e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_css"))
			e = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_name"))
			e = driver.findElement(By.name(prop.getProperty(locatorKey)));
		return e;
	}

	// true - present
	// false -not present

	public boolean isElementPresent(String locator) {
		System.out.println("Checking presence of " + locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty(locator))));
		} catch (Exception e) {

			return false;

		}

		return true;

	}

	// true - visible
	// false - not visible

	public boolean isElementVisible(String locator) {
		System.out.println("Checking visibility of " + locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty(locator))));
		} catch (Exception e) {

			return false;

		}

		return true;

	}

}
