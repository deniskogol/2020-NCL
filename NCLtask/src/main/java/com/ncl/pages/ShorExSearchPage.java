package com.ncl.pages;

import java.util.List;

import org.apache.http.util.Asserts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	//*[@id="searchResults"]/li[1]/article/div/div[1]/div[3]/ul/li[1]/strong/text()
//	@FindBys( {
//		   @FindBy(className = "class1")
//		   @FindBy(className = "class2")
//		} )
//		private List<WebElement> elementsWithBoth_class1ANDclass2;
//
//	
	public boolean verifyPricesLessThan30() {
		actions.moveToElement(priceSlider2);
		boolean flag = true;
		for (int i = 0; i < pricesAllElements.size(); i++) {
//			System.out.println(pricesAllElements.get(i).getText()+"   <=");
			Float iPrice = Float.parseFloat(pricesAllElements.get(i).getText().substring(1, 6));
			System.out.println(iPrice+ "   should be less than $30");
			if (iPrice > 30.00) {
				flag = false;
					}
		}
		return flag;

	}
	
	public void scrollIntoViewPriceSlider () throws InterruptedException {
		Thread.sleep(800);
	    jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", priceSliderValuesStripe);	

	}
	
	public void priceSlider2sendLeftKey() throws InterruptedException {
		Thread.sleep(800);
		actions.moveToElement(priceSlider2);
		priceSlider2.sendKeys(Keys.LEFT);
		Thread.sleep(1000);
	}
//	public void moveSlider2untill$30() {
//		actions.clickAndHold(priceSlider2);
//		String rangeString = priceRange.getText();
//		int highPrice = Integer.parseInt(rangeString.substring(4));
//		while (highPrice<30) {
//			actions.moveByOffset(-1, 0).build().perform();
//			highPrice = Integer.parseInt(rangeString.substring(4));
//		}
//	}
	
	public void slider2MoveCloseTo30() throws InterruptedException {
//		Actions actions = new Actions(driver);
		Thread.sleep(500);
		actions.moveToElement(priceSlider2);
		
//		int x = (int) ((priceSliderValuesStripe.getSize().getWidth()- priceSlider2.getSize().getWidth()/2)*0.985);
		int x = (int) ((priceSliderValuesStripe.getSize().getWidth())*0.975);
		System.out.println(x);
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println(browserName);
		   x =  x+1;
			}
		System.out.println(x);
//		actions.clickAndHold(priceSlider2);
//		actions.moveByOffset(-x, 0).build().perform(); //try add moveToelement for refresh
		actions.dragAndDropBy(priceSlider2, -x, 0).build().perform();
	}
	
	public boolean verifyDisplayedSlider() {
		return priceSliderValuesStripe.isDisplayed();
		
	}
	
	public WebElement getPriceSlider2() {
		return priceSlider2;
		
	}

}
