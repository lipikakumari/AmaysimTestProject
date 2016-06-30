package com.myAmaysim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.myAmaysim.helpclass.CustomWaits;


public class Dashboards {
	
	WebDriver driver;
	
	public Dashboards(WebDriver driver) {
		this.driver = driver;
	}
	
	private By mySettings = By.xpath("//div[@id='main_menu_container']/nav/ul/li[9]");
	private By customerGreet = By.cssSelector(".customer-name-greeting");
	
	public Dashboards waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(customerGreet,30);
		return this;
	}
	
	public MySettings clickMySettings() {
		
		new CustomWaits(driver).waitForElementToBeVisible(mySettings,30);
		driver.findElement(mySettings).click();
		return new MySettings(driver).waitForPageToLoad();
	}
	

}
