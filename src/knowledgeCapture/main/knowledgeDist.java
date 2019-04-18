package knowledgeCapture.main;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import knowledgeCapture.model.knowledge;

public class knowledgeDist {
	public static void main(String[] args) {
//		knowledge test1 = new knowledge();
//		test1.setAuthor("Trent: trenton.sanford@infosys.com");
//		test1.setLastUpdated("04-17-2019");
//		test1.setDescription("This is just a test. Your description of the method would be here");
//		knowledge test2 = new knowledge();
//		test2.setAuthor("Trent: trenton.sanford@infosys.com");
//		test2.setLastUpdated("04-17-2019");
//		test2.setDescription("This is just another test. Your descricption of the method would be here");
//		List<knowledge> test = new ArrayList<knowledge>();
//		test.add(test1);
//		test.add(test2);
		ArrayList<String> parsedBlock = new ArrayList<String>();
		parsedBlock.add("Author: Trent Sanford; LastUpdated: 11/21/90; Description: This function is used for reading and looking for descrtips of other functions;");
		read(parsedBlock);
		write(test);
	}
	
	public static void write(List<knowledge> knowledgeList) {
		Path file = Paths.get("knowledge.txt");
		List<String> knowledgeStringList = new ArrayList<String>();
		for(int i = 0; i<knowledgeList.size(); i++){
			String author = knowledgeList.get(i).getAuthor();
			String date = knowledgeList.get(i).getLastUpdated();
			String description = knowledgeList.get(i).getDescription();
			String completed = "Author: "+ author+"\n"+"Last Updated on:" + date + "\n" + "Description of function: " + description+"\n";
			knowledgeStringList.add(completed);
		}
		try {
			Files.write(file, knowledgeStringList, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

