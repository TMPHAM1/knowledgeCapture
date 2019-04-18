package knowlwdgeCapture.parse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParseTextFile {
	
	public static ArrayList<String> parseText(String filePath) throws Exception {
//			Integer lineNumber = 0;
			String delimTag = "<kd>";
			String breakTag = "</kd>";
			
			
			ArrayList<String> blockList = new ArrayList<>();
			
			
			try {
				
				Scanner scanner = new Scanner(new FileInputStream(filePath));

		        boolean tokenFound = false;
		    	String blockValue= "";
		        while (scanner.hasNextLine()) {
		        	
//		        	HashMap<String,String> block = new HashMap<>();
		        	
//		        	lineNumber++;
		        	
		            String line = scanner.nextLine().trim();

		          
		            if (line.contains(delimTag)) 
		            {
		                tokenFound = true;
		                blockValue ="";
//		                block.put("lineStart", lineNumber.toString());
		                
		                
		            } else if (line.contains(breakTag)) {
		                tokenFound = false;
		                blockList.add(blockValue);
//		                block.put("block", blockValue);
//		                blockList.add(block)
		              
		            }
//		            System.out.println(tokenFound);
//		            System.out.println(!line.contains(delimTag));
		            if ((tokenFound) && (!line.contains(delimTag))) {
		            	blockValue = blockValue + line;
		            }
				
		        }
		        scanner.close();
			}catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file");                
	            }
	           System.out.println(blockList.get(1));
			return blockList;
		} 
	
}
