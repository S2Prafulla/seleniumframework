package com.Omayo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Omayo.Utility.UtilityMethod;
import com.Omayo.pages.OmayoBlogPage;

public class VerifyCreateBlogButton {
	

	WebDriver driver;
	OmayoBlogPage omayoBlogPage;
	

	@BeforeMethod
	public void setup() throws IOException {
		this.driver = UtilityMethod.getwebdriver();

		driver.get(UtilityMethod.getProperty("url"));

		driver.manage().window().maximize();

		omayoBlogPage  = new OmayoBlogPage(driver);
		
		 
	}

	@Test

	public void verifyHomePage() {
		omayoBlogPage.getCreateBlog().click();
		
	
	}
	@AfterMethod

	public void tearDown() {

		driver.quit();
	}

}
