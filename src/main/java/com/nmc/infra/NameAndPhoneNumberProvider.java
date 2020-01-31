package com.nmc.infra;

import java.util.Random;

public class NameAndPhoneNumberProvider {

	public String patientName()
	{
		StringBuilder name= new StringBuilder();
		Random rand = new Random();
		for(int i=0;i<1;i++)
		{
			 char x =(char) (rand.nextInt((112 - 97) + 1) + 97);
			name.append(x);
		}
		return "Man ETL "+name.toString();
	}
	
	public String PatientPhoneNumber(int numberLength)
	{
		StringBuilder phoneNum= new StringBuilder();
		Random rand = new Random();
		for(int i=0;i<numberLength;i++)
		{
			
			 char x = (char)(rand.nextInt((57 - 48) + 1) + 48);
			 phoneNum.append(x);
		}
		return phoneNum.toString();
	}
}
