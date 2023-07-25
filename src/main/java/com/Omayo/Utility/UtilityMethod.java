package com.Omayo.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethod {

	static WebDriver driver;
	private static int lastCellNum;

	public static WebDriver getwebdriver() {

		driver = new ChromeDriver();
		return driver;

	}

	public static String getProperty(String Key) throws IOException {
		File file = new File("src/main/resources/testData.properties");
		FileInputStream fileinputstream = new FileInputStream(file);

		Properties properties = new Properties();
		properties.load(fileinputstream);

		return properties.getProperty(Key);
	}

	public static void switchToFrame(WebDriver driver, WebElement frameLocator)
	{
		driver.switchTo().frame(frameLocator);
	}

	public static void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void WaitTOLocatorsAvailable(WebDriver driver, long duration, String elm) {
	WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elm)));
	}
	

	
	public static void readExcelFile() throws IOException {
		File file = new File("src\\test\\resources\\Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		XSSFWorkbook xssfworkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfworkbook.getSheet("Sheet1");
		
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum;
		XSSFRow row;
		
		for (int i=0; i<lastRowNum;i++) {
			row = sheet.getRow(i);
			lastCellNum = row.getLastCellNum();
			
		for (int j=0; j<lastCellNum;j++)	{
			System.out.println(row.getCell(j).getStringCellValue());
		}
			
		}
		
		
	}
}
