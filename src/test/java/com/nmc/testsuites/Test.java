package com.nmc.testsuites;

import java.io.IOException;

import com.nmc.infra.WriteIntoExcelFile;

public class Test {
	public static void main(String[] args) throws IOException {
		WriteIntoExcelFile write = new WriteIntoExcelFile();
		//write.writeUniqueFieldsIntoExcel();
		write.writeRegistrationIntoExcel("manish", 0);
	}
}
