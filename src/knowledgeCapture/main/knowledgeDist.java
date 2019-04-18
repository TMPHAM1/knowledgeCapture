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
		knowledge test1 = new knowledge();
		test1.setAuthor("Trent: trenton.sanford@infosys.com");
		test1.setLastUpdated("04-17-2019");
		test1.setDescription("This is just a test. Your description of the method would be here");
		knowledge test2 = new knowledge();
		test2.setAuthor("Trent: trenton.sanford@infosys.com");
		test2.setLastUpdated("04-17-2019");
		test2.setDescription("This is just another test. Your descricption of the method would be here");
		List<knowledge> test = new ArrayList<knowledge>();
		test.add(test1);
		test.add(test2);
		write(test);
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
 
}
