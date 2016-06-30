package com.myAmaysim.helpclass;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomMethods {
	WebDriver driver;
	
	public CustomMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void mouseHoverAndClick(WebElement webElement ){
		
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement);	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			actions.click().build().perform();
		
	}
	
	public void waitAndClick(By locator , int secs ){
		
		new CustomWaits(driver).waitForElementToBeClickable(locator , secs);
		driver.findElement(locator).click();
	
	}
	
	public void clickAndWaitForElementToDisappear(By locator , int seconds){
		driver.findElement(locator).click();
		new CustomWaits(driver).waitForElementToDisappear(locator , seconds);
	}
	
	public void clickAndWait(By locator , int secs ){
		driver.findElement(locator).click();
		new CustomWaits(driver).waitForElementToBeClickable(locator , secs);
			
	}
	
	public void scrollForElement(WebElement webElement){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",webElement);
	}
	
}
