package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.infra.BaseClass;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

public class OPRegistrationLinksAndBtns extends BaseClass
{
	OPRegistrationWebElements opRegObj;
	
	public OPRegistrationLinksAndBtns(OPRegistrationWebElements opRegWebElement) {
		opRegObj = opRegWebElement;
	}
	
	public void registerBtn()
	{
		CommonActions.clickElement(opRegObj.getRegisterBtn());
		logger.info("Succefully click on Register Button ");
	}
	
//	public void registerEditBillBtn()
//	{
//		CommonActions.clickElement(opRegObj.getRegisterEditBillBtn());
//		logger.info("Successfully cliked on Register and Edit bill button ");
//	}
}

