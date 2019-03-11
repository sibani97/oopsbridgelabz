package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockAccount {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		CompanyDemo companydemo=new CompanyDemo();
		Customer customer=new Customer();
		
		String filePath = "companydemo.json";
		String filePath1="customer.json";

		File file = new File(filePath);
		File file1 = new File(filePath1);
		String writeCustPath="/home/admin1/eclipse-workspace/JavaProject2/customer1.json";
		String writeCompanyPath ="/home/admin1/eclipse-workspace/JavaProject2/writecompany1.json";
		
		File file2=new File(writeCustPath);
		File file3=new File(writeCompanyPath);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<CompanyDemo> companyList = objectMapper.readValue(file, new TypeReference<List<CompanyDemo>>() {});
		for(int i=0;i<companyList.size();i++)
		{
			System.out.println("Name:"+"  "+companyList.get(i).getCname());
			System.out.println(" Share Price:"+"  "+companyList.get(i).getSharePrice());
			
			System.out.println("Number of Share:"+"  "+companyList.get(i).getNumberofshare());
			System.out.println("---------------------------------------------");
			
		}
		
		List<Customer> custList = objectMapper.readValue(file1, new TypeReference<List<Customer>>() {});
		for(int i=0;i<custList.size();i++)
		{
			System.out.println("Customer_id:"+"  "+custList.get(i).getCustid());
			System.out.println(" CustName:"+"  "+custList.get(i).getCustname());
			System.out.println("Mobile_No:"+"  "+custList.get(i).getMobileno());
			System.out.println("City:"+"  "+custList.get(i).getCity());
			System.out.println("date"+"  "+custList.get(i).getDate());
			System.out.println("Customer available share:"+"  "+custList.get(i).getCustomerAvailableShare());
			System.out.println("---------------------------------------------");
			
			boolean flag = false ;
			while(flag == false ) {
				companydemo=(CompanyDemo)companyList.get(0);
				customer=(Customer)custList.get(0);
				System.out.println(companydemo);
				System.out.println(customer);
				System.out.println("Enter the choice");
				System.out.println("\t 1.Buy Shares \t 2.Sell Shares \t 3.Exit");
				int choice = JsonUtility.inputInteger();
				switch(choice)
				{
				case 1:
					System.out.println("enter the number of share");
					int buynumberofshare=JsonUtility.inputInteger();
					
					if( buynumberofshare>companydemo.getNumberofshare())
					{
						System.out.println( buynumberofshare+"number of share not available");
					}
					else {
		int companyshare=companydemo.getNumberofshare()-buynumberofshare;
		System.out.println("after sell companys share"+"---"+companyshare);
		int customershare=customer.getCustomerAvailableShare()+buynumberofshare;
		System.out.println("after buy customer share:"+"---"+customershare);
		companydemo.setNumberofshare(companyshare);
		customer.setCustomerAvailableShare(customershare);
		System.out.println("enter the date");
		String date=JsonUtility.inputSingleString();
		customer.setDate(date);
        System.out.println("You have successfully buyed :"+"---"+buynumberofshare+"---"+" of "+"---"+companydemo.getCname()+"---"+" on "+customer.getDate());
		companyList.add(companydemo);
		custList.add(customer);
		objectMapper.writeValue(file2,customer);
		objectMapper.writeValue(file3,companydemo);
        	
		}
		break;			
		case 2:
			System.out.println("enter the number os share");
			int sellNumberofShare=JsonUtility.inputInteger();
			if(sellNumberofShare>customer.getCustomerAvailableShare())
			{
				System.out.println(sellNumberofShare+"---"+"number of share not available");
				
			}
			else
			{
				int customerRemainShare=customer.getCustomerAvailableShare()-sellNumberofShare;
				System.out.println("customer remaining share:"+"---"+customerRemainShare);
				int companyAddedShare=companydemo.getNumberofshare()+sellNumberofShare;
				System.out.println("companys total share"+"--"+ companyAddedShare);
				companydemo.setNumberofshare(companyAddedShare);
				customer.setCustomerAvailableShare(customerRemainShare);
				System.out.println("enter the date");
				String date=JsonUtility.inputSingleString();
				customer.setDate(date);
				System.out.println("You have successfully sell :"+"---"+sellNumberofShare+"---"+" of "+"---"+companydemo.getCname()+"---"+" on "+"---"+customer.getDate());
				custList.add(customer);
				objectMapper.writeValue(file2,customer);
				objectMapper.writeValue(file3,companydemo);
			}
			break;
		case 3:
       System.exit(0);
				
				}
		}
		
		

	}

	}
	}
