package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.infra.BaseClass;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

public class AdditionalPatientInformation extends BaseClass
{

	OPRegistrationWebElements opRegObj;

	public AdditionalPatientInformation(OPRegistrationWebElements opRegWebElement) {
		opRegObj = opRegWebElement;
	}
	
	public void selectNationality(String nationality)
	{
		CommonActions.selectDropdownByOption(nationality,opRegObj.getNationalityDd());
		logger.info("nationality selected is "+nationality);
	}
	
	public void selectConsentCollected(String consentCollected)
	{
		CommonActions.selectDropdownByOption(consentCollected, opRegObj.getConsentCollectedDd());
		logger.info("Consent Collected selected is "+consentCollected);
	}
	
	public void selectIdType(String idType)
	{
		CommonActions.selectDropdownByOption(idType, opRegObj.getIdTypeDd());
		logger.info("ID Type selected is "+idType);
	}
	
}
