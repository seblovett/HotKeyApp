package windowbuilder.seblovett;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 

public class HotKeyParser {

	private String HotKeyFile;
	private List<String> HotKeyFileContents;
	public String FOUR = "!F1";
	public String FIVE = "!F2";
	public String SIX = "!F3";
	public String SEVEN = "!F6";
	public String EIGHT = "!F9";
	public String NINE = "!F11";
	public String UP = "!X";
	public String DOWN = "!Y";
	public String FIRE = "!Z";

	public HotKeyParser(String filename)  throws IOException
	{
		this.HotKeyFile = filename;
		FileReader inFile = null;
		List<String> lines = new ArrayList<String>();
		try 
		{
			inFile = new FileReader(this.HotKeyFile);
	         
	         BufferedReader bufferedReader = new BufferedReader(inFile);
	         this.HotKeyFileContents = new ArrayList<String>();
	         String line = null;
	         while ((line = bufferedReader.readLine()) != null) {
	        	 this.HotKeyFileContents.add(line);
	             //System.out.println(line);
	         }
	         bufferedReader.close();
	         inFile.close();
	    }
		finally 
		{
	         if (inFile != null) {
	        	 inFile.close();
	         }
	    }
		

	}
	
	
	public String GetKey(String Key)
	{
		boolean ReturnStr = false;
		for (String s : this.HotKeyFileContents)
		{
			if (ReturnStr == true)
			{
				return s;
			}
			if (s.contains(Key))
			{
				//System.out.println(s);
				ReturnStr = true;
			}
		}
		return null;
	}
}
