package com.nmc.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nmc.utilities.ConfigReader;
import com.nmc.utilities.XLUtils;

public class WriteIntoExcelFile {
	ConfigReader readConfigFile;
	NameAndPhoneNumberProvider dataProvider;
	File file;
	FileInputStream fileInputStream;
	FileOutputStream fileOutPutStream;
	XSSFWorkbook wb;

	public WriteIntoExcelFile() throws IOException {
		readConfigFile = new ConfigReader();
		dataProvider = new NameAndPhoneNumberProvider();
		
	}

	public void writeUniqueFieldsIntoExcel() throws IOException{
		
		file = new File(readConfigFile.getExcelRegistrationDataPath());
		fileInputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(fileInputStream);
		fileOutPutStream = new FileOutputStream(file);
		XSSFSheet sh = wb.getSheet(readConfigFile.getExcelRegistrationDataSheetName());

		for (int i = 0; i < 1; i++) {
			sh.getRow(1).createCell(1 + i).setCellValue(dataProvider.patientName());// patient first middle and Last //
																					// name
		}
		sh.getRow(1).createCell(2).setCellValue(dataProvider.PatientPhoneNumber(10));// patient phone Number
		wb.write(fileOutPutStream);
		wb.close();
		fileOutPutStream.close();
		System.out.println("Written sucessfully");
	}

	public void writeRegistrationIntoExcel(String registeredInfo, int columnNum) throws IOException {
		File file = new File(readConfigFile.getExcelRegInfoDataPath());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheet(readConfigFile.getExcelRegInfoDataSheetName());

		int row = XLUtils.getRowCount(readConfigFile.getExcelRegInfoDataPath(),
				readConfigFile.getExcelRegInfoDataSheetName());

		if (columnNum == 0) {
			System.out.println("Entered");
			sh.createRow(row + 1);
			row++;
		}

		sh.getRow(row).createCell(columnNum).setCellValue(registeredInfo);// enter reg info into excel

		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		fos.close();
		System.out.println("Written new patient data into excel sucessfully");
	}


}
