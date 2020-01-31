package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.infra.BaseClass;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

public class OPRegistrationSuccess extends BaseClass {

	OPRegistrationWebElements opRegObj;
	
	public OPRegistrationSuccess(OPRegistrationWebElements opRegWebElement) {
		opRegObj = opRegWebElement;
	}
	/**
	 * 
	 * @return String Mr No of the patient from registration success screen
	 */
	public String copyMrNo()
	{
		String mrNo = CommonActions.getText(opRegObj.getMrNo());
		logger.info("Mr No (ie Hospital Id) copyed is :  "+mrNo);
		return mrNo;
	}
	/**
	 * 
	 * @return Visit Id of the patient from registration success screen
	 */
	public String copyVisitId()
	{
		String visitId = CommonActions.getText(opRegObj.getVisitId());
		logger.info("Visit  Id copyed from Success Screen is : "+visitId);
		return visitId;
	}
	
}
