package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.infra.BaseClass;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

/**
 * @author manish In this class we have methods for each of the fields present
 *         in Op registration screen under "Visit Information" section
 */
public class VisitInformation extends BaseClass {

	OPRegistrationWebElements opReg;

	public VisitInformation(OPRegistrationWebElements opRegWebElement) {
		opReg = opRegWebElement;
	}
	
	public void selectDepartment(String department)
	{
		CommonActions.selectDropdownByOption(department, opReg.getDepartmentDd());
		logger.info("Department selected is "+department);
	}
	
	public void enterConsultingDoctor(String consultingDoctor)
	{
		CommonActions.selectTextFieldOption(consultingDoctor, opReg.getConsultingDoctor());
		logger.info("Consulting Doctor selected is "+consultingDoctor);
	}
	public void selectConsultationType(String consultationType)
	{
		CommonActions.selectDropdownByOption(consultationType, opReg.getConsultationTypeDd());
		logger.info("Consultation Type selected is "+consultationType);
	}
}
