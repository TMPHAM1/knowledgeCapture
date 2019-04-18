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
import knowlwdgeCapture.parse.ParseTextFile;

public class knowledgeDist {
	public static void main(String[] args) {
		ArrayList<String> parsedBlock = new ArrayList<String>();
		try {
			parsedBlock = ParseTextFile.parseText("/Users/hanmikim/git/knowledgeCapture/src/knowledgeCapture/main/knowledgeDist.java");
			List<knowledge> knowledgeList = read(parsedBlock);
			write(knowledgeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 <kd>
	 Author: Trent Sanford;
	 LastUpdated: 4/18/2019;
	 Description: This function will take in a list of knowledge models and create a PDF with a list
	 			  of all Knowledge Distribution blocks formatted correctly.;
	 FunctionName: write();
	 Input: List<knowledge> knowledgeList;
	 Output: No outputs;
	 </kd>
	 */
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
			Paragraph functionName = new Paragraph("Function Name: "+knowledgeList.get(i).getFunctionName(), font);
			Paragraph functionInputs = new Paragraph("Input(s): "+knowledgeList.get(i).getInput(), font);
			Paragraph functionOutputs = new Paragraph("Output(s): "+knowledgeList.get(i).getOutput(), font);
			Integer methodNum = i+1;
			Chunk number = new Chunk(methodNum.toString()+":",font);
			try {
				document.add(number);
				document.add(new Chunk());
				document.add(author);
				
				document.add(date);
				
				document.add(description);
				document.add(functionName);
				document.add(functionInputs);
				document.add(functionOutputs);
				
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
		Description: This function is made to break the properties out to get the correct values for each properties;
		FunctionName: read();
		Input: ArrayList<String>;
		Output: List<knowledge>;

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
		 			case "FunctionName":	
		 				newKnowledge.setFunctionName(propertyValue[1]);
		 				break;
		 			case "Input":	
		 				newKnowledge.setInput(propertyValue[1]);
		 				break;
		 			case "Output":	
		 				newKnowledge.setOutput(propertyValue[1]);
		 				break;
		 			default:
		 				break;
		 			}
		 				
		 		}
		 		knowledgeItemList.add(newKnowledge);
		 	}
			return knowledgeItemList;
	 }
		/*	<kd>
		Author:Razibul Ahmed;
		LastUpdated: 4/18/2018;
		Description: This function filters out the knowledge block based on tags;
		FunctionName: parseText();
		Input: String filePath;
		Output: ArrayList<String>;
		</kd> */

}

