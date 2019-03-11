package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class CompanyLinkedList {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		CompanyDemo companydemo=new CompanyDemo();
		String filePath = "company.json";
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<CompanyDemo> companyList = objectMapper.readValue(file, new TypeReference<List<CompanyDemo>>() {});
		System.out.println(companyList);
		CustomLinkedList<CompanyDemo> customlist=new CustomLinkedList<CompanyDemo>();
		for(int i=0;i<companyList.size();i++)
		{
			customlist.add(companyList.get(i));
		}
		customlist.printList();
		boolean flag =false ;
		while (flag == false) {
			System.out.println("Enter your choice");
			System.out.println("1.Add Company Share \t 2.Remove Company Share \t 3.Exit");
			int choice = JsonUtility.inputInteger();
			switch(choice) {
case 1:
	System.out.println("enter the stock details");
	System.out.println("enter the company name");
	 String companynm=JsonUtility.inputSingleString();
	 companydemo.setCname(companynm);
	 System.out.println("enter the number of share");
	 int noOfShare=JsonUtility.inputInteger();
	 companydemo.setNumberofshare( noOfShare);
	 System.out.println("enter share price");
	 double shareprice=JsonUtility.inputDouble();
	 companydemo.setSharePrice(shareprice);
	 customlist.add(companydemo);
	 JsonUtility.jsonObjectWriteLinkedList(customlist, filePath);
	 System.out.println("Stock Details added successfully");
	 customlist.printList();
	 break;
case 2:
	System.out.println("remove stock details");
	System.out.println("enter the company name");
	String cname1=JsonUtility.inputSingleString();
	for(int i=0;i<customlist.size();i++)
	{
		if(customlist.getElement(i).getCname().equals(cname1))
		{
			customlist.delete(cname1);
			System.out.println("company is deleted");
		}
		
	}
	JsonUtility.jsonObjectWriteLinkedList(customlist, filePath);
	System.out.println("Stock Details deleted successfully");
	customlist.printList();
	break;
case 3:
System.exit(0);

	}

}
}}