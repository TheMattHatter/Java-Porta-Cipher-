package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Parse {
	
	private static BufferedReader br; //Buffered reader that will be returned
	private static String scheme1 = "http://"; //Scheme 1 for URL parsing
	private static String scheme2 = "https://"; //Scheme 2 for URL parsing
	
	public static BufferedReader parseLocation(String location)
	{
		
		try
		{
			if(location.startsWith(scheme1) || location.startsWith(scheme2)) //Check if file is a url
			{
				URL url = new URL(location);
				
				br = new BufferedReader(new InputStreamReader(url.openStream())); //Need to covert to InputStreamReader so the BufferedReader can read it
				
				System.out.println("\nURL successfully read!");  //Printed if file parse is successfully
			}
			
			else
			{
				File f = new File(location);
				
				if(f.isFile()) //Check if location is a file
				{
					br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
					
					System.out.println("\nFile successfully read!");  //Printed if file parse is successfully
				}
				
			}
				
		}
		
        catch(IOException e)
        {
        	System.out.println("\nInvalid file or URL please try again"); //If URL read is unsuccessful
        }
		
		return br;
	}
	
	

}
