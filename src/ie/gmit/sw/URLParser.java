package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.net.URL;

public class URLParser implements Parserator {
	
	private BufferedReader br = null; //Provides efficient reading of all characters, lines etc. in the URL
	
    private String s = null; //Used for separation and storing of strings into the ArrayList
    
    private List<String> urlContents = new ArrayList<String>(); //ArrayList created to store all contents of parsed URL
    
    
    public URLParser() //Default Constructor
    {
    	
    }
    
    public void parse(String s1) //Interface method
    {
			//Read in the URL
	        try
	        {   
	        	URL url1 = new URL(s1); //New instance of URL
	        	
	    	  	br = new BufferedReader(new InputStreamReader(url1.openStream())); //Need to covert to InputStreamReader so the BufferedReader can read it
	  
	    
		        while((s = br.readLine()) != null) //Try to separate words and store in the ArrayList
		  	  	{		  
		  		  String [] str = s.split("\\s+"); //Groups all white spaces as a delimiter
		  		  
		  		  urlContents.addAll(Arrays.asList(str)); //Adding all strings to the ArrayList
		  	  	}
		        
		        br.close();
		        
		        System.out.println("\nUrl successfully read!"); //If URL read is successful
	        } 
	        
		  	  
	        catch(IOException e)
	        {
	        	System.out.println("\nInvalid Url please try again"); //If URL read is unsuccessful
	        }
	        
			
	        
	}
}
