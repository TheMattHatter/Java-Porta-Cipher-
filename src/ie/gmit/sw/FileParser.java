package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class FileParser implements Parserator {
	
	private BufferedReader br = null; //Provides efficient reading of all characters, lines etc. in the File
	
    private String s = null; //Used for separation and storing of strings into the ArrayList
    
    private List<String> fileContents = new ArrayList<String>(); //ArrayList created to store all contents of parsed File
    
	
	//Default constructor//
	public FileParser()
	{
		
	}
	
	//Passing in a file//
	public FileParser(File file)
	{
		
	}
	
	//Parserator (interface) method//
	public void parse(String s1)
	{
		this.parse(new File (s1)); //Casting String as file and parsing it
	}
	
	//File parsing//
	public void parse(File file)
	{
		
		if(file.isFile()) //File validation
		{
			
			try
			{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			}
			
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			
	        //Try to separate words and store in the ArrayList
	        try
	        {
		        while((s = br.readLine()) != null)
		  	  {		  
		  		  String [] str = s.split("\\s+"); //Groups all white spaces as a delimiter
		  		 
		  		  fileContents.addAll(Arrays.asList(str));  //Adding all strings to the ArrayList
		  	  }
		        
	        }
	        
	        catch(IOException e)
	        {
	  		 e.printStackTrace();
	        }
	        
			System.out.println("\nFile successfully read!");  //Printed if file parse is successfully

	        
		}
		
		else
		{
			System.out.println("\nThat file does not exist please try again!");  //Printed if file does not exist
		}
		
	}
}
