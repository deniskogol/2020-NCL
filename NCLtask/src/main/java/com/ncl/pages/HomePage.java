package com.ncl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ncl.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "a[title='Explore']")
	WebElement exploreDropList;
	
	@FindBy(how = How.CSS, using = "a[href='/excursions']")
	WebElement exploreListShoreExcursions;
	
	public ShorExHomePage clickExploreShoreEx() {
		actions.moveToElement(exploreDropList);
		exploreDropList.click();
//		waitUntilVisible(exploreListShoreExcursions);
//		wait.until(ExpectedConditions.visibilityOf(exploreListShoreExcursions));
		exploreListShoreExcursions.click();		
		return new ShorExHomePage();
	}
	
}
