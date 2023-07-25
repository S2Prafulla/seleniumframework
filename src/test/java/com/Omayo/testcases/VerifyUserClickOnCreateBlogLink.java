package com.Omayo.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Omayo.Utility.UtilityMethod;
import com.Omayo.pages.OmayoBlogPage;
import com.Omayo.pages.OmayoHomePage;

public class VerifyUserClickOnCreateBlogLink {
	
	WebDriver driver;
	OmayoHomePage omayoHmePage;
	OmayoBlogPage omayoBlogPage;
	

	@BeforeMethod
	public void setup() throws IOException {
		this.driver = UtilityMethod.getwebdriver();

		driver.get(UtilityMethod.getProperty("url"));

		driver.manage().window().maximize();

		omayoHmePage = new OmayoHomePage(driver);
		
		omayoBlogPage = new OmayoBlogPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));		
		 
	}

	@Test

	public void verifyHomePage() {
		UtilityMethod.switchToFrame(driver, omayoHmePage.getFrame());
		omayoHmePage.getCreateBlog().click();
		UtilityMethod.switchToDefault(driver);
		UtilityMethod.WaitTOLocatorsAvailable(driver, 60, "//a[text()='Create your blog']");
		omayoBlogPage.getCreateBlog().click();	
	}
	@AfterMethod

	public void tearDown() {

		driver.quit();
	}


}
