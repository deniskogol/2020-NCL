package com.ncl.util;


import com.ncl.base.TestBase;

public class TestUtil extends TestBase{
	
	public static int PAGE_LOAD_TIMEOUT = 30;
	public static int IMPLICIT_WAIT = 15;
	
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void switchToFrame(String framename) {
		driver.switchTo().frame(framename);
		}
	

}
