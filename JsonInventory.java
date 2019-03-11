package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonInventory {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		String filename = "Rice";
		String filename1="Wheat";
		String filename2="Pulses";
		
		String filePath = "Rice.json";
		String filePath1="Wheat.json";
		String filePath2="Pulses.json";
		
		File file = new File(filePath);
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		
		String writeRicePath="/home/admin1/eclipse-workspace/JavaProject2/writeRice.json";
		String writeWheatPath ="/home/admin1/eclipse-workspace/JavaProject2/writeWheat.json"; 
		String writePulsePath =	"/home/admin1/eclipse-workspace/JavaProject2/writePulses.json";		
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<Rice> riceList = objectMapper.readValue(file, new TypeReference<List<Rice>>() {});
		for(int i=0;i<riceList.size();i++)
		{
			System.out.println("Name:"+"  "+riceList.get(i).getName());
			System.out.println("Price:"+"  "+riceList.get(i).getPrice());
			
			System.out.println("Weight:"+"  "+riceList.get(i).getWeight());
			System.out.println("---------------------------------------------");
			
		}
		List<Wheat> wheatList=objectMapper.readValue(file1,new TypeReference<List<Wheat>>() {});
		for(int i=0;i<wheatList.size();i++)
		{
			System.out.println("Name:"+"  "+wheatList.get(i).getName());
			System.out.println("Price:"+"  "+wheatList.get(i).getPrice());
			
			System.out.println("Weight:"+"  "+wheatList.get(i).getWeight());
			System.out.println("---------------------------------------------");
		}
		
		List<Pulses> pulsesList=objectMapper.readValue(file2,new TypeReference<List<Pulses>>() {});
		for(int i=0;i<pulsesList.size();i++)
		{
			System.out.println("Name:"+"  "+pulsesList.get(i).getName());
			System.out.println("Price:"+"  "+pulsesList.get(i).getPrice());
			
			System.out.println("Weight:"+"  "+pulsesList.get(i).getWeight());
			System.out.println("---------------------------------------------");
		}
		boolean flag = false ;
		while(flag == false ) {
			System.out.println("Enter the choice");
			System.out.println(" 1:Add Inventory \t 2:Total Price \t 3:Exit");
			int choice = JsonUtility.inputInteger();
			switch(choice)
			{
			case 1:
				System.out.println("Select the inventory name \t1.rice \t 2.wheat \t 3.pulses");
				int inventoryName = JsonUtility.inputInteger();
				switch(inventoryName) {
				case 1:
					Rice inventoryRice = new Rice();
					System.out.println("Enter the name:");
					inventoryRice.setName(JsonUtility.inputSingleString());
					System.out.println("Enter the price");
					inventoryRice.setPrice(JsonUtility.inputDouble());
					System.out.println("Enter the weight");
					inventoryRice.setWeight(JsonUtility.inputInteger());                  
					
					riceList.add(inventoryRice);
					System.out.println("Rice inventory added successfully");
					String riceJson = objectMapper.writeValueAsString(inventoryRice);
					JsonUtility.writeToJsonFile(riceJson, writeRicePath);
					System.out.println(riceJson);
					System.out.println("File Writted Successfully");
					break;
				case 2 :
					Wheat inventoryWheat = new Wheat();
					System.out.println("Enter the name:");
					inventoryWheat.setName(JsonUtility.inputSingleString());
					System.out.println("Enter the weight");
					inventoryWheat.setWeight(JsonUtility.inputInteger());                  
					System.out.println("Enter the price");
					inventoryWheat.setPrice(JsonUtility.inputDouble());
					wheatList.add(inventoryWheat);
					System.out.println("Wheat inventory added successfully");
					String wheatsJson = objectMapper.writeValueAsString(inventoryWheat);
					JsonUtility.writeToJsonFile(wheatsJson, writeWheatPath);
					System.out.println("File Writted Successfully");
					break;
				case 3 :
					Pulses inventoryPulses = new Pulses();
					System.out.println("Enter the name:");
					inventoryPulses.setName(JsonUtility.inputSingleString());
					System.out.println("Enter the weight");
					inventoryPulses.setWeight(JsonUtility.inputInteger());                  
					System.out.println("Enter the price");
					inventoryPulses.setPrice(JsonUtility.inputDouble());
					pulsesList.add(inventoryPulses);
					System.out.println("Pulse inventory added successfully");
					String pulsesJson = objectMapper.writeValueAsString(inventoryPulses);
					JsonUtility.writeToJsonFile(pulsesJson, writePulsePath);
					System.out.println("File Writted Successfully");
					
				}
			case 2:
				for (int i = 0; i < riceList.size(); i++) {
					Rice inventoryRice = riceList.get(i);
					double ricePrice = inventoryRice.getWeight()*inventoryRice.getPrice();
					System.out.println("Rice name :" + inventoryRice.getName()+" total price is "+ricePrice);
				}
				for (int i = 0; i < wheatList.size(); i++) {
					Wheat inventoryWheat = wheatList.get(i);
					double wheatPrice = inventoryWheat.getWeight()*inventoryWheat.getPrice();
					System.out.println("Wheat name :" + inventoryWheat.getName()+" total price is "+wheatPrice);
					
				}
				for (int i = 0; i < pulsesList.size(); i++) {
					Pulses inventoryPulse = pulsesList.get(i);
					double pulsePrice = inventoryPulse.getWeight()*inventoryPulse.getPrice();
					System.out.println("Pulse name :" + inventoryPulse.getName()+" total price is "+pulsePrice);
					
				}
				break;
			case 3 :
				System.exit(0);
			}
			
		
	}

	}

}
