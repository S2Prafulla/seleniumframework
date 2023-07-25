package com.Omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoBlogPage {
	
	// Blog Page Related Locaters
		WebDriver driver;
		WebElement CreateBlog;
		
		public OmayoBlogPage(WebDriver driver) {
			this.driver = driver;
		}

		public WebElement getCreateBlog() {
			setCreateBlog();
			return CreateBlog;
		}

		public void setCreateBlog() {
			CreateBlog = driver.findElement(By.xpath("//a[text()='Create your blog']"));
		}

}
