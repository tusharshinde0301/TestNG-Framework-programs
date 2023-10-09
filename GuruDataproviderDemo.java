package testng;


import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;


public class GuruDataproviderDemo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test(dataProvider = "getLoginTestData")
	public void guruLoginTest(String username, String password) {
	  driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
  }
  
  @DataProvider
  public Iterator<Object[]> getLoginTestData() {
	  
	  ArrayList<Object[]> loginData = new ArrayList<Object[]>();
	// Import excel sheet.
			File dataFile = new File("C:\\Users\\Tushar\\eclipse-workspace-new\\selenium\\src\\main\\java\\resources\\GuruLoginDataProvider.xlsx");

			// Load the file.
			FileInputStream finput=null;
			try {
				finput = new FileInputStream(dataFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Finds the workbook instance for XLSX file
//			HSSFWorkbook myWorkBook=null;
	        XSSFWorkbook myWorkBook=null;
			try {
				myWorkBook = new XSSFWorkbook (finput);
//				myWorkBook = new HSSFWorkbook(finput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Return first sheet from the XLSX workbook
	        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
//			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

	        int my_rows = mySheet.getPhysicalNumberOfRows();
	        for (int i=1; i<my_rows; i++)
	        {
	        	XSSFRow my_row = mySheet.getRow(i);
//	        	HSSFRow my_row = mySheet.getRow(i);
	        	String username = my_row.getCell(0).getStringCellValue();
	        	String password = my_row.getCell(1).getStringCellValue();
	        	loginData.add(new Object[] {username, password});
	 			
	        }
	        
	        return loginData.iterator();

}
  
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
}
