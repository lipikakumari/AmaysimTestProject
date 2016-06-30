package com.myAmaysim.helpclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {
	WebDriver driver;
	
	public CustomWaits(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToBeVisible(By selector, int timeToWaitInSeconds)
    {		
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
	
	public void waitForElementToBeClickable(By locator ,int seconds)
    {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
       
    }
	
	public void waitForElementToDisappear(By locator, int seconds)
    {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
	
	public void waitExplicitly(int milliseconds)
    {
		try{
		Thread.sleep(milliseconds);
		}catch(Exception e){
			System.out.println(e);
		}
    }
	

}
