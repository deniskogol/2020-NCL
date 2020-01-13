package com.ncl.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ncl.base.TestBase;

public class ShorExSearchPage extends TestBase {
	
	public ShorExSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "price-slider-values")
	WebElement priceSliderValuesStripe;
	
	@FindBy(how = How.CSS, using = "span[class='column text']")
	WebElement shorElementExColumnText;
	
	@FindBy(how = How.XPATH, using = "//*[@class='ui-slider-handle ui-corner-all ui-state-default'][2]")
	WebElement priceSlider2;
	
	@FindBy (how = How.CSS, using = "span[class='legend-column extremes']")
	WebElement priceRange;
	
	@FindBy (how = How.XPATH, using = "//ul[@class='price']/li/strong")
	List<WebElement> pricesAllElements;

	public boolean verifyPricesLessThan30() throws InterruptedException {
		actions.moveToElement(priceSlider2);
		Thread.sleep(500);
		boolean flag = true;
		for (int i = 0; i < pricesAllElements.size(); i++) {		
			Float iPrice = Float.parseFloat(pricesAllElements.get(i).getText().substring(1, 6));
//			System.out.println(iPrice+ "  and should be less than $30");
			if (iPrice > 30.00) {
				flag = false;
					}
		}
		return flag;

	}
	
	public void priceSlider2sendLeftKey() throws InterruptedException {
		Thread.sleep(800);
		actions.moveToElement(priceSlider2);
		priceSlider2.sendKeys(Keys.LEFT);
	}
	
	public void slider2MoveCloseTo30() throws InterruptedException {
		Thread.sleep(500);
		actions.moveToElement(priceSlider2);
		
		int x = (int) ((priceSliderValuesStripe.getSize().getWidth())*0.975);
		if (browserName.equalsIgnoreCase("firefox")) {
		   x =  x+1;
			}
		actions.dragAndDropBy(priceSlider2, -x, 0).build().perform();
	}
	
	public boolean verifyDisplayedSlider() {
		return priceSliderValuesStripe.isDisplayed();
		
	}
	
	public WebElement getPriceSlider2() {
		return priceSlider2;
		
	}

}
