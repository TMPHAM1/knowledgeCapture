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
		ArrayList<String> parsedBlock = new ArrayList<String>();
		parsedBlock.add("Author: Trent Sanford; LastUpdated: 02/02/02; Description: This function is used for reading and looking for description of other functions;");
		parsedBlock.add("Author: Razibul Ahmed; LastUpdated: 02/02/02; Description: Made to take in a txt file to parse information on a specfic function");
		List<knowledge> knowledgeList = read(parsedBlock);
		write(knowledgeList);
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
			e.printStackTrace();
		}
		
	}
	/*	<kd>
		Author: Tien Pham;
		LastUpdated: 4/18/2018;
		Description: "This function is made to break the properties out to get the correct values for each properties";

		</kd> */
	 public static List<knowledge> read(ArrayList<String> parsedBlock) {
		 		List<knowledge> knowledgeItemList = new ArrayList<knowledge>();
		 	for (String knowledgeBlock: parsedBlock) { // For each Block we get 
		 		knowledge newKnowledge = new knowledge();
		 		 String[] propertyString = knowledgeBlock.split(";"); // Split the String at ; to break each line
		 		for (String property : propertyString) {
		 			String[] propertyValue = property.split(":"); //Split the string at the colon to get the property and value;
		 			switch(propertyValue[0].trim()) { // Set current lines property and value
		 			case "Author": 
		 				newKnowledge.setAuthor(propertyValue[1]);
		 				break;
		 			case "LastUpdated":
		 				newKnowledge.setLastUpdated(propertyValue[1]);
		 				break;
		 			case "Description":	
		 				newKnowledge.setDescription(propertyValue[1]);
		 				break;
		 			default:
		 				break;
		 			}
		 				
		 		}
		 		knowledgeItemList.add(newKnowledge);
		 	}
			return knowledgeItemList;
	 }

}

