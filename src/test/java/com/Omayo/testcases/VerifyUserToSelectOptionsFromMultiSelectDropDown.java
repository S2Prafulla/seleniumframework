package com.Omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Omayo.Utility.UtilityMethod;
import com.Omayo.pages.OmayoHomePage;

public class VerifyUserToSelectOptionsFromMultiSelectDropDown {

	WebDriver driver;
	OmayoHomePage omayoHmePage;

	@BeforeMethod
	public void setup() throws IOException {
		this.driver = UtilityMethod.getwebdriver();

		driver.get(UtilityMethod.getProperty("url"));

		driver.manage().window().maximize();

		omayoHmePage = new OmayoHomePage(driver);
	}

	@Test

	public void verifyUserToSelectOptionsFromMultiSelectDropDown() {
		omayoHmePage.SelectMultiSelectDropDownOption("Audi");
		omayoHmePage.SelectMultiSelectDropDownOption("Swift");

		List<String> allSelectedOptions = omayoHmePage.GetAllSelectedOptions();

		for(String s:allSelectedOptions) {
			
			System.out.println(s);
		}
		assertEquals(allSelectedOptions.size(), 2);
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();
	}

}
