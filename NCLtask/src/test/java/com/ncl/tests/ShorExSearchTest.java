package com.ncl.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
//		Assert.assertEquals(testUtil.getPageTitle(), "Shore Excursion Search | Norwegian Cruise Line");	
		shorExSearchPage = shorExHomePage.clickFindExcursionsButton();
//		Assert.assertEquals(testUtil.getPageTitle(), "Shore Excursions | Norwegian Cruise Line", "Page title doesn't match");
//		System.out.println("@BeforeSuite annotation executed completelly");
	}
	
	@Test(priority = 1)
	public void ShorExSearchPagePrice0to30Test() throws InterruptedException {
//		actionsEnable();
//		Assert.assertEquals(testUtil.getPageTitle(), "Shore Excursions | Norwegian Cruise Line", "Page title doesn't match");	
//		Assert.assertTrue(shorExSearchPage.verifyDisplayedSlider());
	//	shorExSearchPage.scrollIntoViewPriceSlider();
     //shorExSearchPage.priceSlider2sendLeftKey();
//		shorExSearchPage.moveSlider2untill$30();
		shorExSearchPage.slider2MoveCloseTo30();
		shorExSearchPage.priceSlider2sendLeftKey();
	//	shorExSearchPage.scrollIntoViewPriceSlider();
//		shorExSearchPage.verifyPricesLessThan30();
		Assert.assertTrue(shorExSearchPage.verifyPricesLessThan30());
//		shorExHomePage = homePage.clickExploreShoreEx(); 
//		String title = shorExHomePage.getShorExHomeTitle();   //replaced with testUtil  Method
//		Assert.assertEquals(title, "Shore Excursion Search | Norwegian Cruise Line");	
	}
//	@Test(priority = 2)
//	public void ShorExSearchPageTitleTest() {
//		shorExSearchPage = shorExHomePage.clickFindExcursionsButton();
//		String pageTitle = testUtil.getPageTitle(); 
//		Assert.assertEquals(pageTitle, "Shore Excursions | Norwegian Cruise Line", "Page title doesn't match");	
//	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
