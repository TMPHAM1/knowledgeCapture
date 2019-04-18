package knowledgeCapture.main;

import java.util.ArrayList;

import knowledgeCapture.model.knowledge;

public class knowledgeDist {
 public static void main(String[] args) {
	ArrayList<String> parsedBlock = new ArrayList<String>();
			parsedBlock.add("Author: Trent Sanford; LastUpdated: 11/21/90; Description: This function is used for reading and looking for descrtips of other functions;");
			read(parsedBlock);
 }
 public static knowledge[] read(ArrayList<String> parsedBlock) {
	 	knowledge[] knowledgeItemList = null;
	 	for (String knowledgeBlock: parsedBlock) { // For each Block we get 
	 		//knowledge knowledgeItem = new knowledge();
	 		
	 		 String[] propertyString = knowledgeBlock.split(";"); // Split the String at ; to break each line
	 		for (String property : propertyString) {
	 			String[] propertyValue = property.split(":"); //Split the string at the colon to get the property and value;
	 			switch(propertyValue[0].trim()) { // Set current lines property and value
	 			case "Author": 
	 				knowledge.setAuthor(propertyValue[1]);
	 				break;
	 			case "LastUpdated":
	 				knowledge.setLastUpdated(propertyValue[1]);
	 				break;
	 			case "Description":	
	 				knowledge.setDescription(propertyValue[1]);
	 				break;
	 			default:
	 				break;
	 			}
	 				
	 		}
	 		
	 		
	 	}
	 	
	 	
	 	
	 	
	 	
		return knowledgeItemList;
 }
}

