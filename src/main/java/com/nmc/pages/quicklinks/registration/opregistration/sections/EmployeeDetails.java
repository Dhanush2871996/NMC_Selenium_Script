package com.nmc.pages.quicklinks.registration.opregistration.sections;

import java.util.Map;

import org.openqa.selenium.WebElement;

import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

public class EmployeeDetails {
	
	OPRegistrationWebElements opReg;
	
	public EmployeeDetails(OPRegistrationWebElements opRegWelementObj) {
		opReg = opRegWelementObj;
	}
	
	public void setEmployer(String empType) {
		CommonActions.selectDropdownByOption(empType, opReg.getGenderDd());//Please check the elements
	}
	
	public void setAllEmployerDetails(Map values,WebElement element) {
		
	}

}
