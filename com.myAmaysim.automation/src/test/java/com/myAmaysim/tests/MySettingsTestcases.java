package com.myAmaysim.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myAmaysim.base.TestBaseSetup;
import com.myAmaysim.pages.LoginPage;



public class MySettingsTestcases extends TestBaseSetup{
	
	WebDriver driver = null;	

	
	@BeforeMethod
	public void setUp() {
		driver =getDriver();
	}
	
	//Testcase to enable and change call forward number successfully
	@Test
	 public void verifyCallForwardEnable()	{		
			new LoginPage(driver).login().clickMySettings().callForwardNumberEnable().
			verifyCallForwardStatusYes().verifyCallForwardNewNumber();
	}
	
	//Testcase to disable  call forward number successfully
	@Test(dependsOnMethods = {"verifyCallForwardEnable"})
	 public void verifyCallForwardDisable()	{		
			new LoginPage(driver).login().clickMySettings().callForwardNumberDisable()
			.verifyCallForwardStatusNo();
	}
}
