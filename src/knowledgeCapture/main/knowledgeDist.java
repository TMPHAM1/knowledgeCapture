package knowledgeCapture.main;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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

		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream("knowledge.pdf"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

  
		document.open();
	
		Font font = FontFactory.getFont(FontFactory.COURIER, 11, BaseColor.BLACK);
		for(Integer i = 0; i<knowledgeList.size(); i++){
			
			Paragraph author = new Paragraph("Author: "+knowledgeList.get(i).getAuthor(), font);
			Paragraph date = new Paragraph("Last Updated On: "+ knowledgeList.get(i).getLastUpdated(), font);
			Paragraph description = new Paragraph("Description: "+knowledgeList.get(i).getDescription(), font);
			Integer methodNum = i+1;
			Chunk number = new Chunk(methodNum.toString()+":",font);
			try {
				document.add(number);
				document.add(new Chunk());
				document.add(author);
				
				document.add(date);
				
				document.add(description);
				document.add(Chunk.NEWLINE);
			} catch (DocumentException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		document.close();
		
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

