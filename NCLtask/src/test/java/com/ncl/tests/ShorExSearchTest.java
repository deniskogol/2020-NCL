package com.ncl.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ncl.base.TestBase;
import com.ncl.pages.HomePage;
import com.ncl.pages.ShorExHomePage;
import com.ncl.pages.ShorExSearchPage;
import com.ncl.util.TestUtil;

public class ShorExSearchTest extends TestBase {
	HomePage homePage;
	ShorExHomePage shorExHomePage;
	ShorExSearchPage shorExSearchPage;
	TestUtil testUtil;

	
	public ShorExSearchTest() {
		super(); //calls TestBase constructor	
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialize();
		testUtil = new TestUtil();
		homePage = new HomePage();   //object created	
		shorExHomePage = homePage.clickExploreShoreEx();
		shorExSearchPage = shorExHomePage.clickFindExcursionsButton();
	}
	
	@Test
	public void ShorExSearchPagePrice0to30Test() throws InterruptedException {
		shorExSearchPage.slider2MoveCloseTo30();
		shorExSearchPage.priceSlider2sendLeftKey();
		Assert.assertTrue(shorExSearchPage.verifyPricesLessThan30());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
