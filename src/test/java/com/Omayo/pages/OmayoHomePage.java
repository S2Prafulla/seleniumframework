package com.Omayo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OmayoHomePage {

	// Home Page Related Locaters
	WebDriver driver;
	WebElement MultiSelectDropdown;
	WebElement onepagelink;
	WebElement MaleradioButton;
	WebElement CreateBlog;
	WebElement Frame;

	public OmayoHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMultiSelectDropdown() {
		setMultiSelectDropdown();
		return MultiSelectDropdown;
	}

	public void setMultiSelectDropdown() {
		MultiSelectDropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
	}

	public void SelectMultiSelectDropDownOption(String VisibleText) {
		Select select = new Select(getMultiSelectDropdown());
		select.selectByVisibleText(VisibleText);
	}

	public List<String> GetAllSelectedOptions() {
		Select select = new Select(getMultiSelectDropdown());
		List<String> optionsSelectedFromDropDown = new ArrayList<String>();
		List<WebElement> listofwebelement = select.getAllSelectedOptions();

		for (WebElement elm : listofwebelement) {

			optionsSelectedFromDropDown.add(elm.getText());
		}

		return optionsSelectedFromDropDown;

	}

	public WebElement getOnepagelink() {
		setOnepagelink();
		return onepagelink;
	}

	public void setOnepagelink() {
		this.onepagelink = driver.findElement(By.xpath("//a[text()='Page One']"));
	}

	public WebElement getMaleradioButton() {
		setMaleradioButton();
		return MaleradioButton;
	}

	public void setMaleradioButton() {
		MaleradioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

	public WebElement getCreateBlog() {
		setCreateBlog();
		return CreateBlog;
	}

	public void setCreateBlog() {
		CreateBlog = driver.findElement(By.xpath("//a[@id='b-getorpost']"));
	}

	public WebElement getFrame() {
		setFrame();
		return Frame;
	}

	public void setFrame() {
		Frame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
	}
 
	public String verifyPageTittle() {

		return driver.getTitle();
	}

	public String verifyPageCurrenturl() {

		return driver.getCurrentUrl();
	}
	
	
}
