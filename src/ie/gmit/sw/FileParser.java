package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class FileParser implements Parserator {
	
	private BufferedReader br = null; //Provides efficient reading of all characters, lines etc. in the File
	
    private String s = null; //Used for separation and storing of strings into the ArrayList
    
    private List<String> fileContents = new ArrayList<String>(); //ArrayList created to store all contents of parsed File
    
    private HashMap<Character, Integer> charMap;
    
    private HashMap<Character, Integer> charMapKey;
    
	//Default constructor//
	public FileParser()
	{
		
	}
	
	//Passing in a file//
	public FileParser(File file)
	{
		
	}
	
	//Parserator (interface) method//
	public void parse(String location)
	{
		this.parse(new File (location)); //Casting String as file and parsing it
	}
	
	//File parsing//
	public void parse(File location)
	{
		
		if(location.isFile()) //File validation
		{
			
			try
			{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
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
		  		  String [] str = s.split("\\s+"); //Ensure proper spacing
		  		 
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
	
	public void replace()
	{
		String myRegex = "[^a-zA-Z]";

		int index = 0;
		for (String s : fileContents)
		{
			fileContents.set(index++, s.replaceAll(myRegex, ""));
		}
	}
	
	public String joinStrings()
	{
		String plainText = String.join("", fileContents);
		
		return plainText;
	}
	
	public String encrypt(String plainText, String key)
	{
		charMap =  new HashMap<Character, Integer>(); //Hashmap to hold 
		
		charMap.put('A', 0);
		charMap.put('B', 1);
		charMap.put('C', 2);
		charMap.put('D', 3);
		charMap.put('E', 4);
		charMap.put('F', 5);
		charMap.put('G', 6);
		charMap.put('H', 7);
		charMap.put('I', 8);
		charMap.put('J', 9);
		charMap.put('K', 10);
		charMap.put('L', 11);
		charMap.put('M', 12);
		charMap.put('N', 13);
		charMap.put('O', 14);
		charMap.put('P', 15);
		charMap.put('Q', 16);
		charMap.put('R', 17);
		charMap.put('S', 18);
		charMap.put('T', 19);
		charMap.put('U', 20);
		charMap.put('V', 21);
		charMap.put('W', 22);
		charMap.put('X', 23);
		charMap.put('Y', 24);
		charMap.put('Z', 25);
		
		charMapKey =  new HashMap<Character, Integer>();
		
		charMapKey.put('A', 0);
		charMapKey.put('B', 0);
		charMapKey.put('C', 1);
		charMapKey.put('D', 1);
		charMapKey.put('E', 2);
		charMapKey.put('F', 2);
		charMapKey.put('G', 3);
		charMapKey.put('H', 3);
		charMapKey.put('I', 4);
		charMapKey.put('J', 4);
		charMapKey.put('K', 5);
		charMapKey.put('L', 5);
		charMapKey.put('M', 6);
		charMapKey.put('N', 6);
		charMapKey.put('O', 7);
		charMapKey.put('P', 7);
		charMapKey.put('Q', 8);
		charMapKey.put('R', 8);
		charMapKey.put('S', 9);
		charMapKey.put('T', 9);
		charMapKey.put('U', 10);
		charMapKey.put('V', 10);
		charMapKey.put('W', 11);
		charMapKey.put('X', 11);
		charMapKey.put('Y', 12);
		charMapKey.put('Z', 12);
		
		char encryptionArray[] = {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char encryptionArray2[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
		
		//Scanner sc = new Scanner(System.in);
		
		//String key = ""; 
		
		//String plaintext = "";
		
		//System.out.print("Enter text to encrypt: ");
		//plaintext = sc.nextLine();
		
		//System.out.print("\nEnter a key: ");
		//key = sc.nextLine();
		
		plainText = plainText.toUpperCase();
		key = key.toUpperCase();
		
		//replace(fileContents);
		
		//plainText = plainText.replaceAll("\\s+","");
		//key = key.replaceAll("\\s+", "");
		
		
		
		StringBuilder builder = new StringBuilder(plainText.length() + key.length() - 1);
		while (builder.length() < plainText.length()) {
		    builder.append(key);
		}
		builder.setLength(plainText.length());
		String keyExtended = builder.toString();
		
		String encryptedText = "";
		
		for(int i = 0; i < plainText.length(); i++)
		{
			char plaintextLetter = plainText.charAt(i);
			char keyLetter = keyExtended.charAt(i);
			
			int lookup = 0;

			if(charMap.get(plaintextLetter) > 12)
			{
				lookup = ((charMap.get(plaintextLetter)-charMapKey.get(keyLetter)) % 13);
				encryptedText += encryptionArray2[lookup];
			}
			
			else
			{
				lookup = ((charMap.get(plaintextLetter)+charMapKey.get(keyLetter)) % 13);
				encryptedText += encryptionArray[lookup];
			}
					
		}
		
		return encryptedText;
		//System.out.println("\nEncrypted text: " + encryptedText);
	}
	
	
}
