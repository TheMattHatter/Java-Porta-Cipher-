package ie.gmit.sw;

public class Parse {
	
	private static Parserator p1; //Parserator upcasted to either FileParser or URLParser
	private static String scheme1 = "http://"; //Scheme 1 for URL parsing
	private static String scheme2 = "https://"; //Scheme 2 for URL parsing
	
	public static void parseString(String location) 
	{	
		
		if(location.startsWith(scheme1) || location.startsWith(scheme2)) //If input is a URL
		{
			try
			{
				p1 = new URLParser(); //Instance of URLParser created 
				p1.parse(location); //Calls parse method to parse the file
			}
			
			catch(NullPointerException e) //Catching NullPointerException if an invalid URL is entered
			{
				System.out.println("Invalid URL please try again"); //Printed if url could not be parsed
			}
		}
		
		
		else //If input is a file
		{
			p1 = new FileParser(); //Instance of FileParser created 
			p1.parse(location);
		}		
		
	}//End parseMenu*/
	
	

}
