package com.nmc.pages.login.scenarios;

import org.openqa.selenium.WebDriver;

import com.nmc.pages.login.UserLogOut;
import com.nmc.pages.login.sections.LogOut;

public class LogOutOfApplication {
	UserLogOut userLogOutObj;
	LogOut logOut;
	public LogOutOfApplication(WebDriver driver) {
		userLogOutObj = new UserLogOut(driver);
		logOut = new LogOut(userLogOutObj);
	}
	
	public void logOut() {
		logOut.clickOnlogout();
	}
	
	public UserLogOut getUserLogOutObj() {
		return userLogOutObj;
	}
}
