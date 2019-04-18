package knowlwdgeCapture.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = "/Users/Raz/Development/javaEclipse/knowledgeCapture/src/knowlwdgeCapture/parse/test.txt";
		
		try {
			ArrayList<String> blockList;
			blockList = ParseTextFile.parseText(filePath);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		

	}

}
