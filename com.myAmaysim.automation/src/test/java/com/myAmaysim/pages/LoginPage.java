package com.myAmaysim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.myAmaysim.helpclass.CustomMethods;
import com.myAmaysim.helpclass.CustomWaits;
import com.myAmaysim.helpclass.GetTestData;



public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By 	amaysimNumber = By.cssSelector("#my_amaysim2_user_session_login");
	private By 	password = By.cssSelector("#password");
	private By 	login = By.cssSelector("#login_button");
	
	GetTestData loginData= new GetTestData();
	
	public LoginPage enterAmaysimNumber(){
		driver.findElement(amaysimNumber).sendKeys(loginData.getAmaysimNumber());
		return this;
	}
	public LoginPage enterPassword(){
		driver.findElement(password).sendKeys(loginData.getPassword());
		return this;
	}
	public Dashboards clickLogin(){		
		new CustomMethods(driver).clickAndWaitForElementToDisappear(login ,10);
		return new Dashboards(driver).waitForPageToLoad();
	}
	
	public Dashboards login(){
		return enterAmaysimNumber().enterPassword().clickLogin();
		
	}
	
}
