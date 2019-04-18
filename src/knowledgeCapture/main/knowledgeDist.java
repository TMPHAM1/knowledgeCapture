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
 
}
