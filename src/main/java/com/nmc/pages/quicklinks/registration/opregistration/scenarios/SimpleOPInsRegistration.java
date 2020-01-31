package com.nmc.pages.quicklinks.registration.opregistration.scenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.nmc.infra.BaseClass;
import com.nmc.infra.WriteIntoExcelFile;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.pages.quicklinks.registration.opregistration.sections.AdditionalPatientInformation;
import com.nmc.pages.quicklinks.registration.opregistration.sections.BasicInforamtion;
import com.nmc.pages.quicklinks.registration.opregistration.sections.EmployeeDetails;
import com.nmc.pages.quicklinks.registration.opregistration.sections.OPRegistrationLinksAndBtns;
import com.nmc.pages.quicklinks.registration.opregistration.sections.OPRegistrationSuccess;
import com.nmc.pages.quicklinks.registration.opregistration.sections.PatientDetails;
import com.nmc.pages.quicklinks.registration.opregistration.sections.VisitInformation;
import com.nmc.utilities.ConfigReader;
import com.nmc.utilities.XLUtils;

/**
 *
 * 
 * @author manish
 *
 */
public class SimpleOPInsRegistration {
	OPRegistrationWebElements opReg;

	PatientDetails patientDetails;
	BasicInforamtion basicInformation;
	AdditionalPatientInformation addnlPatientInfo;
	VisitInformation visitInformation;
	EmployeeDetails employeDetails;
	OPRegistrationLinksAndBtns opRegLinkBtn;
	OPRegistrationSuccess opRegSuccesScr;
	WriteIntoExcelFile writeIntoExcel;
	
	// Excel File related
	ConfigReader configReader;
	String xlFileName;
	String sheetName;
	Robot robot;

	String copyMrNo;
	String copyVisitId;
	/**
	 * 
	 * @param driver
	 * @throws IOException 
	 * @throws AWTException 
	 */

	public SimpleOPInsRegistration(WebDriver driver) throws IOException  {
		opReg = new OPRegistrationWebElements(driver);

		patientDetails = new PatientDetails(opReg);
		basicInformation = new BasicInforamtion(opReg);
		addnlPatientInfo = new AdditionalPatientInformation(opReg);
		visitInformation = new VisitInformation(opReg);
		employeDetails = new EmployeeDetails(opReg);
		opRegLinkBtn = new OPRegistrationLinksAndBtns(opReg);
		opRegSuccesScr = new OPRegistrationSuccess(opReg);

		// Excel file Reader
		configReader = new ConfigReader();
		xlFileName = configReader.getExcelRegistrationDataPath();
		sheetName = configReader.getExcelRegistrationDataSheetName();
		
		writeIntoExcel = new WriteIntoExcelFile();

	}

	/**
	 * 
	 * @return returning PORegistrationWebelemntObject
	 */
	public OPRegistrationWebElements getOpRegObject() {
		return opReg;
	}

	/**
	 * Here parameter data will be read from XL file from resource folder
	 */
	public void enterPatientDetails() {
		patientDetails.setMrNumber();
		patientDetails.enterMrNum("121323123131");
	}

	/**
	 * Here parameter data will be read from XL file from resource folder
	 */
	public void enterBasicInformation(String... obj) {
		basicInformation.setSalutation(obj[0].toString());
		basicInformation.enterFirstName(obj[1].toString());
		basicInformation.enterMobNo(obj[2].toString());
		basicInformation.enterAge(obj[3].toString());
		basicInformation.selectGender(obj[4].toString());
	}

	/**
	 * Here we have take care from which index the values of AdditonalPatient
	 * 
	 * @param obj
	 */
	public void enterAdditionalPatientInfo(String... obj) {
		addnlPatientInfo.selectNationality(obj[5].toString());
		addnlPatientInfo.selectConsentCollected(obj[6].toString());
		addnlPatientInfo.selectIdType(obj[7].toString());
	}
	
	public void enterVisitInformation(String ...obj) 
	{
		visitInformation.selectDepartment(obj[8].toString());
		visitInformation.enterConsultingDoctor(obj[9].toString());
		visitInformation.selectConsultationType(obj[10].toString());
	}

	public void clickRegisterButton()
	{
		opRegLinkBtn.registerBtn();
	}
	
	public void getMrNoVisitIdFromSuccessScr() throws InterruptedException
	{
		copyMrNo = opRegSuccesScr.copyMrNo();
		copyVisitId = opRegSuccesScr.copyVisitId();
//		Thread.sleep(100);
	}
	
	public void storeMRNoVisitIdIntoExcel() throws IOException
	{
		
		 writeIntoExcel.writeRegistrationIntoExcel(copyMrNo, 0);
		 writeIntoExcel.writeRegistrationIntoExcel(copyVisitId, 1);

		
	}
	
	public Object[][] getExcelData() throws IOException {
		int rowNum = XLUtils.getRowCount(xlFileName, sheetName);
		int colNum = XLUtils.getCellCount(xlFileName, sheetName, 1);
		System.out.println("Number of Roows are " + rowNum);
		System.out.println("number of columns are : " + colNum);
		Object testObj[][] = new Object[rowNum][1];
		String loginData[] = new String[colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				loginData[j] = XLUtils.getCellData(xlFileName, sheetName, i, j);
			}
			testObj[i - 1][0] = loginData;
		}
		return testObj;
	}
	
}
