package ie.gmit.sw;

import java.io.*;
import java.net.URL;

public class Parse {
	
	private static BufferedReader br;
	private static final String SCHEME1 = "http://"; //Scheme 1 for URL validation
	private static final String SCHEME2 = "https://"; //Scheme 2 for URL validation
	
	// Big O: Best = O(1). Worst = 0(1)
	// The rational behind this estimation is that it is mainly comparisons in the if else
	// which are traditionally O(1)
	public static BufferedReader parseLocation(String location, String key) 
	{		
		try
		{
			if(location.startsWith(SCHEME1) || location.startsWith(SCHEME2)) //If input is a URL
			{
				URL url = new URL(location); //New instance of URL	        	
			  	br = new BufferedReader(new InputStreamReader(url.openStream())); //Wrap an InputStreamReader with br and open a URL stream
			  	
			  	System.out.println("\nURL successfully read");
			}
				
			else //If input is a file
			{
				File file = new File(location); //New instance of URL
				
				if(file.isFile()) //Check if the input is a file
				{
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); //Wrap an InputStreamReader with br and open a FileInputStream
				}
				
			  	System.out.println("\nFile successfully read");
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace(); //Prints the stack trace of the Exception to System.err.
		}
			
		return br; //Return the BufferedReader
	}
	
}
