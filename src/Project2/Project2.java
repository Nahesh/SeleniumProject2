package Project2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Assert;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

/*
 * Project2
 * Version information : 2023-03 (4.27.0)
 * 20 July 2023
 * Author Name : Mahesh Bhapkar
 * Copyright notice
 */
public class Project2 {
	String path= "C:\\Users\\H379379\\Desktop\\SeleniumJars";
	Workbook wb;
	Sheet sh;
	int numrow;
	//initialization of chrome driver
	public static WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public void Initilize() {
		//Defining chrome property & path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H379379\\Desktop\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		//maximizing the window
		driver.manage().window().maximize(); 
		driver.get("https://opensource-demo.orangehrmlive.com/");	// opening the url 
		}
	
	@Test(priority=0, dataProvider = "Logindata")
	public static void Login(String User,String Pass) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("username")).sendKeys(User);
		driver.findElement(By.name("password")).sendKeys(Pass);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
		@DataProvider(name = "Logindata")
		public Object[][] Testdatafeed() throws JXLException, IOException{
			//reading the data from excel
			wb = Workbook.getWorkbook(new File(path));
			sh = wb.getSheet(0);
			numrow = sh.getRows();
			Object[][] data = new Object[numrow][sh.getColumns()];
			for (int i=0; i<numrow ;i++) {
				data[i][0] = sh.getCell(0, i).getColumn();
				data[i][1] = sh.getCell(1, i).getColumn();
			}
			return data;
		}

	
	@Test(priority=1)
	public static void PIM() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
	}
	
	@Test(priority=2, dataProvider = "Searchdata")
	public static void Search(String name,String id) {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys(name);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys(id);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click(); // search button check
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")).click(); // reset button check
	}
	
	@DataProvider(name = "Searchdata")
	public Object[][] Testdatafeed1() throws JXLException, IOException{
		//reading the data from excel
		wb = Workbook.getWorkbook(new File(path));
		sh = wb.getSheet(0);
		numrow = sh.getRows();
		Object[][] data = new Object[numrow][sh.getColumns()];
		for (int i=0; i<numrow ;i++) {
			data[i][0] = sh.getCell(0, i).getColumn();
			data[i][1] = sh.getCell(1, i).getColumn();
		}
		return data;
	}
	
	@Test(priority=3, dataProvider = "Adddata")
	public static void Add(String firstName, String middleName, String lastName) {
	//add button
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]")).click();
	}
	
	@DataProvider(name = "Adddata")
	public Object[][] Testdatafeed2() throws JXLException, IOException{
		//reading the data from excel
		wb = Workbook.getWorkbook(new File(path));
		sh = wb.getSheet(0);
		numrow = sh.getRows();
		Object[][] data = new Object[numrow][sh.getColumns()];
		for (int i=0; i<numrow ;i++) {
			data[i][0] = sh.getCell(0, i).getColumn();
			data[i][1] = sh.getCell(1, i).getColumn();
			data[i][2] = sh.getCell(2, i).getColumn();
		}
		return data;
	}
	
	
	@Test(priority=4)
	public static void OptField() {
		// configuration 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[1]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
	}
	
	@Test(priority=5)
	public static void custfield() {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[2]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(2)); //switches to new tab
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
	}
	
	@Test(priority=6)
	public static void dataimport() {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[3]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(3)); //switches to new tab
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
	}
	
	@Test(priority=7)
	public static void reportmethod() {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[4]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(4)); //switches to new tab
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
	}
	
	@Test(priority=8)
	public static void termination() {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[5]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(5)); //switches to new tab
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
	}

	
	@AfterClass
	public static void Exit() {
		driver.close();
		driver.quit();
	}
}
