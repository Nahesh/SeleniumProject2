package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class prj2 {
	private static Properties properties;
	private String baseUrl;
	//initialization of chrome driver
	public static WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public void initilize() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream("C:\\Users\\H379379\\Desktop\\Java\\HRMlivePrj\\Config\\Config1.properties");
			properties = new Properties();
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		baseUrl = properties.getProperty("baseurl"); 
		//Defining chrome property & path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H379379\\Desktop\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		//maximizing the window
		driver.manage().window().maximize(); 
		driver.get(baseUrl);	// opening the url 
 		String actualUrl = properties.getProperty("actual.Url");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
		}
	
	@Test(priority=0)
	public static void invalidLogin() {
		String usernameLocator = properties.getProperty("username.Locator");
		String passwordLocator = properties.getProperty("password.Locator");
		String loginLocator = properties.getProperty("login.Locator");
		String errLocator = properties.getProperty("err.Locator");
		
		String user = properties.getProperty("user.value");
		String pass = properties.getProperty("pass.value");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name(usernameLocator)).sendKeys(user);
		driver.findElement(By.name(passwordLocator)).sendKeys(pass);
		driver.findElement(By.xpath(loginLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.findElement(By.xpath(errLocator)).getText();
		String expected = "Invalid credentials";
		Assert.assertEquals(expected, actual);
	}

	@Test(priority=1)
	public static void validLogin() {
		String usernameLocator = properties.getProperty("username.Locator");
		String passwordLocator = properties.getProperty("password.Locator");
		String loginLocator = properties.getProperty("login.Locator");
		
		String user = properties.getProperty("validUser.value");
		String pass = properties.getProperty("validPass.value");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name(usernameLocator)).sendKeys(user);
		driver.findElement(By.name(passwordLocator)).sendKeys(pass);
		driver.findElement(By.xpath(loginLocator)).click();
 		String actualUrl = properties.getProperty("actual.Url1");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=2)
	public static void testPIMButton() {
		String pimButtomLocator = properties.getProperty("pimButtom.Locator");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(pimButtomLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
	}
		
	@Test(priority=3)
	public static void testOptFieldButton() { 
		String configButtonLocator = properties.getProperty("configButton.Locator");
		String optfieldButtonLocator = properties.getProperty("optfieldButton.Locator");
		
		driver.findElement(By.xpath(configButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath(optfieldButtonLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		String actualUrl = properties.getProperty("actual.Url2");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=4)
	public static void testCustfieldButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String configButtonLocator = properties.getProperty("configButton.Locator");
		String custFieldButtonLocator = properties.getProperty("custFieldButton.Locator");
		
		driver.findElement(By.xpath(configButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath(custFieldButtonLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		String actualUrl = properties.getProperty("actual.Url3");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=5)
	public static void testDataImportButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String configButtonLocator = properties.getProperty("configButton.Locator");
		String dataImportButtonLocator = properties.getProperty("dataImportButton.Locator");
		
		driver.findElement(By.xpath(configButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath(dataImportButtonLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		String actualUrl = properties.getProperty("actual.Url4");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=6)
	public static void testReportMethodButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String configButtonLocator = properties.getProperty("configButton.Locator");
		String reportButtonLocator = properties.getProperty("reportButton.Locator");
		
		driver.findElement(By.xpath(configButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath(reportButtonLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		String actualUrl = properties.getProperty("actual.Url5");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=7)
	public static void testTerminationButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String configButtonLocator = properties.getProperty("configButton.Locator");
		String terminationButtonLocator = properties.getProperty("terminationButton.Locator");
		
		driver.findElement(By.xpath(configButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath(terminationButtonLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		String actualUrl = properties.getProperty("actual.Url6");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	
	@AfterClass
	public static void Exit() {
		driver.close();
		driver.quit();
	}
}
