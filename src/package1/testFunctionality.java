package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testFunctionality {
	private static Properties properties;
	private String baseUrl;
	//initialization of chrome driver
	public static WebDriver driver = new ChromeDriver();
	@BeforeClass
	public void initilize() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream("C:\\Users\\H379379\\Desktop\\Java\\HRMlivePrj\\Config\\Config2.properties");
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
	}
		
	@Test(priority=3)
	public static void resetButtonEmployee() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nameLocator = properties.getProperty("name.Locator");
		String idLocator = properties.getProperty("id.Locator");
		String statusLocator = properties.getProperty("status.Locator");
		String supervisorNameLocator = properties.getProperty("supervisorName.Locator");
		String jobTitleLocator = properties.getProperty("jobTitle.Locator");
		String subUnitLocator = properties.getProperty("subUnit.Locator");
		String resetButtonLocator = properties.getProperty("resetButton.Locator");
		
		String name = properties.getProperty("name.value");
		String id = properties.getProperty("id.value");
		String supervisorName = properties.getProperty("supervisorName.value");
		
		driver.findElement(By.xpath(nameLocator)).sendKeys(name);
		driver.findElement(By.xpath(idLocator)).sendKeys(id);
		driver.findElement(By.xpath(statusLocator)).click();
		driver.findElement(By.xpath(supervisorNameLocator)).sendKeys(supervisorName);
		driver.findElement(By.xpath(jobTitleLocator)).click();
		driver.findElement(By.xpath(subUnitLocator)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(resetButtonLocator)).click(); // reset button check
	}
	
	
	@Test(priority=4)
	public static void searchButtonEmployee() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nameLocator = properties.getProperty("name.Locator");
		String idLocator = properties.getProperty("id.Locator");
		String statusLocator = properties.getProperty("status.Locator");
		String supervisorNameLocator = properties.getProperty("supervisorName.Locator");
		String jobTitleLocator = properties.getProperty("jobTitle.Locator");
		String subUnitLocator = properties.getProperty("subUnit.Locator");
		String searchButtonLocator = properties.getProperty("searchButton.Locator");
		
		String name = properties.getProperty("name.value");
		String id = properties.getProperty("id.value");
		String supervisorName = properties.getProperty("supervisorName.value");
		
		driver.findElement(By.xpath(nameLocator)).sendKeys(name);
		driver.findElement(By.xpath(idLocator)).sendKeys(id);
		driver.findElement(By.xpath(statusLocator)).click();
		driver.findElement(By.xpath(supervisorNameLocator)).sendKeys(supervisorName);
		driver.findElement(By.xpath(jobTitleLocator)).click();
		driver.findElement(By.xpath(subUnitLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(searchButtonLocator)).click(); // search button check
	}

	
	@Test(priority=5, dataProvider = "Adddata")
	public static void addButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String addButtonLocator = properties.getProperty("addButton.Locator");
		String firstNameLocator = properties.getProperty("firstName.Locator");
		String middleNameLocator = properties.getProperty("middleName.Locator");
		String lastNameLocator = properties.getProperty("lastName.Locator");
		String saveButtonLocator = properties.getProperty("saveButton.Locator");
		String empListLocator = properties.getProperty("empList.Locator");
		
		String firstName = properties.getProperty("firstName.value");
		String middleName = properties.getProperty("middleName.value");
		String lastName = properties.getProperty("lastName.value");
		
	//add button
		driver.findElement(By.xpath(addButtonLocator)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name(firstNameLocator)).sendKeys(firstName);
		driver.findElement(By.name(middleNameLocator)).sendKeys(middleName);
		driver.findElement(By.name(lastNameLocator)).sendKeys(lastName);
		driver.findElement(By.xpath(saveButtonLocator)).click();
		
		driver.findElement(By.xpath(empListLocator)).click();
	}
	
	@AfterClass
	public static void Exit() {
		driver.quit();
	}
}
