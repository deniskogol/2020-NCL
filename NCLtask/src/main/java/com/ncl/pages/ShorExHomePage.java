package com.ncl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ncl.base.TestBase;

public class ShorExHomePage extends TestBase{
	

	
	@FindBy(how = How.CSS, using = "button[onclick=\"NCL.findExcursions_onClick.call(this, '/shore-excursions/search')\"]")
	WebElement findExcursionsButton;
	
	public ShorExHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getShorExHomeTitle() {		
		return driver.getTitle();		
	}
	
	public ShorExSearchPage clickFindExcursionsButton() {
		findExcursionsButton.click();
		return new ShorExSearchPage();
	}

}
