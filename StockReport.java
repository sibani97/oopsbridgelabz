package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockReport {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		String filePath = "company.json";
		File file = new File(filePath);
		String writeCompanyPath="/home/admin1/eclipse-workspace/JavaProject2/writeCompany.json";
		ObjectMapper objectMapper = new ObjectMapper();
		List<CompanyDtls> companylist=objectMapper.readValue(file, new TypeReference<List<CompanyDtls>>() {});
		for(int i=0;i<companylist.size();i++)
		{

			System.out.println("Stock Names:"+"----"+companylist.get(i).getCname());
			System.out.println("Number of Share:"+"-----"+companylist.get(i).getNumberofshare());
			
			System.out.println("Share Price:"+"----"+companylist.get(i).getSharePrice());
			System.out.println("---------------------------------------------");
		}
		boolean flag = false ;
		while(flag == false ) {
			System.out.println("Enter the choice");
			System.out.println(" 1:Add Stock \t 2:Calculate Stock Price \t 3:Exit");
			int choice = JsonUtility.inputInteger();
			
			switch(choice)
			{
			case 1:
				CompanyDtls company = new CompanyDtls();
				System.out.println("Enter the  company name:");
				
				company.setCname(JsonUtility.inputSingleString());
				System.out.println("Enter the  share price");
				company.setSharePrice(JsonUtility.inputDouble());
				System.out.println("Enter the number of share");
				company.setNumberofshare(JsonUtility.inputInteger());                
				companylist.add( company);
				
				System.out.println("Everything added successfully");
				String companyJson = objectMapper.writeValueAsString(company);
				JsonUtility.writeToJsonFile(companyJson,writeCompanyPath);
				System.out.println(companyJson);
				System.out.println("File Writted Successfully");
				
				
			
			
		case 2:
			for (int i = 0; i <  companylist.size(); i++) {
				
				CompanyDtls companydtl=companylist.get(i);
				
				double totalprice =companydtl.getNumberofshare()*companydtl.getSharePrice();
				System.out.println("stock name"+companydtl.getCname()+ "total price :" + totalprice);
			}
			
			break;
			
		case 3 :
			System.exit(0);
		}
		

	}

	}}
