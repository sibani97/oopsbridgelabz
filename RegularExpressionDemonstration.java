package com.bridgelabz.oops;

import java.util.regex.Pattern;

public class RegularExpressionDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utility utility = new Utility();
		JsonUtility jsonutlity=new JsonUtility();
		OopsUtility oopsutility=new OopsUtility();
		String st = "Hello <<name>>, We have your full name as <<full name>> "
				+ "\nin our system. your contact number is 91-xxxxxxxxxx. "
				+ "\nPlease,let us know in case of any clarification "
				+ "\nThank you BridgeLabz 01/01/2016.";
		int x=0;
		int y=0;
		int z=0;
		String firstName="";
		String lastName="";
		String phoneNumber="";
		if(x==0) {
		System.out.println("Enter first name");
		firstName=jsonutlity.inputString();
		Pattern p =Pattern.compile("^[A-Za-z]{3,20}$");
		boolean b =p.matcher(firstName).matches();
		if(b) {
			x=1;
		}	
		if(x==0)
			System.out.println("Enter only alphabets for name");
		}
		while(z==0) {
		System.out.println("Enter last name");
		 lastName=jsonutlity.inputString();
		 Pattern p = Pattern.compile("^[A-Za-z]{3,20}$");
		 if(p.matcher(lastName).matches())
			 z=1;
		 if(z==0)
			 System.out.println("Enter only alphabets for name");
		}
		 while(y==0) {
		System.out.println("Enter phone number");
		 phoneNumber=jsonutlity.inputString();
		 Pattern p = Pattern.compile("^[0-9]{10}$");
		 if(p.matcher(phoneNumber).matches())
			 y=1;
		 if(y==0)
			 System.out.println("Please enter numbers only of length 10");
		 }
		System.out.println(oopsutility.replaceExpressionDemonstration(st,firstName,lastName,phoneNumber));
		
	}


	}


