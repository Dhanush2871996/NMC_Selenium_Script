package com.nmc.testcases.testcase01;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nmc.infra.BaseClass;
import com.nmc.infra.WriteIntoExcelFile;
import com.nmc.pages.login.UserLogOut;
import com.nmc.pages.login.scenarios.LogOutOfApplication;
import com.nmc.pages.login.scenarios.LoginToApplication;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.pages.quicklinks.registration.opregistration.scenarios.SimpleOPInsRegistration;

/**
 * 
 * @author manish
 *
 */

public class SampleTestCase extends BaseClass {

	SimpleOPInsRegistration simpleOpInsReg;
	OPRegistrationWebElements opRegWeb;
	LoginToApplication loginToApp;
	LogOutOfApplication logOutOfApp;
	WriteIntoExcelFile write;

	@BeforeClass
	public void before_method() throws AWTException, IOException {
		
		simpleOpInsReg = new SimpleOPInsRegistration(driver);
		loginToApp = new LoginToApplication(driver);
		logOutOfApp = new LogOutOfApplication(driver);
		write = new WriteIntoExcelFile();
	}

	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 * 
	 */
	@Test(dataProvider = "regData")
	public void test_1(String... data) throws InterruptedException, IOException{
		write.writeUniqueFieldsIntoExcel();
		loginToApp.login();
		simpleOpInsReg.getOpRegObject().navigateToOpRegScr();
		simpleOpInsReg.enterBasicInformation(data);
		simpleOpInsReg.enterAdditionalPatientInfo(data);
		simpleOpInsReg.enterVisitInformation(data);
		simpleOpInsReg.clickRegisterButton();
		simpleOpInsReg.getMrNoVisitIdFromSuccessScr();
		simpleOpInsReg.storeMRNoVisitIdIntoExcel();
		Thread.sleep(500);
		logger.info("patient Registered successfull.");
		logOutOfApp.logOut();
	}

	@AfterMethod
	public void after_method() {

	}

	@DataProvider(name = "regData")
	Object[][] getData() throws IOException {
		Object[][] excelData = simpleOpInsReg.getExcelData();
		return excelData;

	}

}
