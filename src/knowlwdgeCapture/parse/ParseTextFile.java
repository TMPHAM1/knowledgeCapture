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
		        			        	
		            String line = scanner.nextLine().trim();

		            if (line.contains(delimTag)) 
		            {
		                tokenFound = true;
		                blockValue ="";
		                
		            } else if (line.contains(breakTag)) {
		                tokenFound = false;
		                blockList.add(blockValue);
		              
		            }

		            if ((tokenFound) && (!line.contains(delimTag))) {
		            	blockValue = blockValue + line;
		            }
				
		        }
		        scanner.close();
			}catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file");                
	            }
			return blockList;
		} 
	
}
