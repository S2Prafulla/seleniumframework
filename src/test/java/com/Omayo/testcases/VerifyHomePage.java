package com.Omayo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Omayo.Utility.UtilityMethod;
import com.Omayo.pages.OmayoHomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	OmayoHomePage omayoHmePage;
	SoftAssert softassert;

	@BeforeMethod
	public void setup() throws IOException {
		this.driver = UtilityMethod.getwebdriver();

		driver.get(UtilityMethod.getProperty("url"));

		driver.manage().window().maximize();

		omayoHmePage = new OmayoHomePage(driver);
		
		 softassert = new SoftAssert();
	}

	@Test

	public void verifyHomePage() {
		//Hard Assert
		/*assertEquals(omayoHmePage.verifyPageTittle(), "omayo (QAFox.com)");
		assertTrue(omayoHmePage.verifyPageTittle().equals("omayo (QAFox.com)"));
		
		assertNotEquals(omayoHmePage.verifyPageTittle(), "omayo (QAFox.com");
		assertFalse(omayoHmePage.verifyPageTittle().equals("omayo (QAFox.com"));*/
		
		//Soft Assert
		softassert.assertEquals(omayoHmePage.verifyPageTittle(), "omayo (QAFox.com)");
		softassert.assertTrue(omayoHmePage.verifyPageTittle().equals("omayo (QAFox.com)"));
		
		softassert.assertNotEquals(omayoHmePage.verifyPageTittle(), "omayo (QAFox.com");
		softassert.assertFalse(omayoHmePage.verifyPageTittle().equals("omayo (QAFox.com"));
		
		assertEquals(omayoHmePage.getOnepagelink().getText(), "Page One");
		
		assertFalse(omayoHmePage.getMaleradioButton().isSelected());
		softassert.assertAll();
	}
	@AfterMethod

	public void tearDown() {

		driver.close();
	}


}
