package com.myAmaysim.pages;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.myAmaysim.helpclass.CustomMethods;
import com.myAmaysim.helpclass.CustomWaits;
import com.myAmaysim.helpclass.GetTestData;


public class MySettings extends Dashboards{
	
	public MySettings(WebDriver driver) {
		super(driver);
	}

	private By simNicknameBar = By.cssSelector("#settings_sim_nickname");
	private By callForwardForm=By.xpath("//form[@id='update_call_forwarding_form']");
	private By editCallForward = By.cssSelector("#edit_settings_call_forwarding");
	private By confCallForwardPopup = By.xpath("//a[@class='confirm_popup_confirm button-green-action small-12 columns text-center']");
	private By selectCallForward_yes = By.xpath("//form[@id='update_call_forwarding_form']/div[2]/div/label[1]");
	private By selectCallForward_No = By.xpath("//form[@id='update_call_forwarding_form']/div[2]/div/label[2]");

	private By callNewDivertNumber = By.xpath("//form[@id='update_call_forwarding_form']/div[3]/input");
	private By saveCallForward = By.xpath("//form[@id='update_call_forwarding_form']/div[4]/div/input");
	private By callForwardSuccMsg = By.xpath("//body[@id='body-content']/div[15]/p");
	private By CallForwardSuccMsgDismiss=By.xpath("//body[@id='body-content']/div[15]/a");
	private By callDivertNumber = By.xpath("//div[@id='settings_call_forwarding']/div/div[1]/div[1]/div[2]/div");
	private By callDivertStatus =By.xpath("//div[@id='settings_call_forwarding']/div/div[1]/div[2]");
	
	GetTestData dp= new GetTestData();
	
	public MySettings waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(simNicknameBar,dp.getShortWait());
		return this;
	}
	
	public MySettings clickEditCallForward(){			
		CustomMethods cm = new CustomMethods(driver);
		cm.scrollForElement(driver.findElement(editCallForward));
		cm.mouseHoverAndClick(driver.findElement(editCallForward));		
		return this;
	}
	public MySettings confirmCallForwardContinuePopup(){
		new CustomWaits(driver).waitForElementToBeVisible(confCallForwardPopup,dp.getLongWait());
		WebElement element=driver.findElement(confCallForwardPopup);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		new CustomWaits(driver).waitForElementToDisappear(confCallForwardPopup,dp.getLongWait());
		return this;
	}
	
	public MySettings callForward_Yes() {		
		new CustomMethods(driver).scrollForElement(driver.findElement(callForwardForm));
		if(!driver.findElement(selectCallForward_yes).isSelected())
			driver.findElement(selectCallForward_yes).click();
		return this;
	}

	
	public MySettings callForward_No() {		
		new CustomMethods(driver).scrollForElement(driver.findElement(callForwardForm));
		if(!driver.findElement(selectCallForward_No).isSelected())
			driver.findElement(selectCallForward_No).click();
		
		return this;
	}
	
	public MySettings enterCallForwardValidNumber() {		
		driver.findElement(callNewDivertNumber).clear();
		driver.findElement(callNewDivertNumber).sendKeys(new GetTestData().getValidCallDivertNumber());
		return this;
	}
	
	public MySettings saveCallForwardSetting() {		
		driver.findElement(saveCallForward).submit();
		return this;
		
	}
	
	public MySettings dismissCallSettingUpdatePopup(){
		new CustomWaits(driver).waitForElementToBeVisible(callForwardSuccMsg,dp.getLongWait());		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		return this;
	}
	
		
	public MySettings callForwardNumberEnable(){
		clickEditCallForward().confirmCallForwardContinuePopup().callForward_Yes()
		.enterCallForwardValidNumber().saveCallForwardSetting().dismissCallSettingUpdatePopup();
		return this;
	}
	
	public MySettings callForwardNumberDisable(){
		clickEditCallForward().confirmCallForwardContinuePopup().callForward_No().saveCallForwardSetting()
		.dismissCallSettingUpdatePopup();
		return this;
	}
	
	public MySettings verifyCallForwardNewNumber(){
		new CustomMethods(driver).scrollForElement(driver.findElement(callDivertNumber)); 
		Assert.assertTrue(driver.findElement(callDivertNumber).getText()
				.contains(new GetTestData().getValidCallDivertNumber()));
		return this;
	}
	
	public MySettings verifyCallForwardStatusYes(){
		new CustomMethods(driver).scrollForElement(driver.findElement(callDivertStatus)); 
		Assert.assertTrue(driver.findElement(callDivertStatus).getText().equalsIgnoreCase("yes"));
		return this;
	}
	public MySettings verifyCallForwardStatusNo(){
		new CustomMethods(driver).scrollForElement(driver.findElement(callDivertStatus)); 
		Assert.assertTrue(driver.findElement(callDivertStatus).getText()
				.equalsIgnoreCase("no"));
		return this;
	}
}
