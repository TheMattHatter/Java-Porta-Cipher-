package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Encrypt {
	
	private String[] words;
	
	private static List<String> contents = new ArrayList<String>(); //ArrayList created to store all contents of parsed URL
	
    private static HashMap<Character, Integer> charMap;
    
    private static HashMap<Character, Integer> cipherKeyMap;
	
	public static void runEncryption(String location, String key, String filename) throws IOException //Throws the exception when looping through the BufferedReader
	{
		String s = null;
		
		BufferedReader br = Parse.parseLocation(location);
		
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".txt"));
		
		//Split the file/URL into lines and calls encrypt line method
		while((s = br.readLine()) != null)
		{
			//String s1 = encryptLine(s.toUpperCase(), key);
			bw.write(s);
		}
		
			bw.close();
			br.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static String encryptLine(String s, String key)
	{	
		String encryptedCharacter = "";
		char encryptionArray[] = {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char encryptionArray2[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
		
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
		
		cipherKeyMap =  new HashMap<Character, Integer>();
		
		cipherKeyMap.put('A', 0);
		cipherKeyMap.put('B', 0);
		cipherKeyMap.put('C', 1);
		cipherKeyMap.put('D', 1);
		cipherKeyMap.put('E', 2);
		cipherKeyMap.put('F', 2);
		cipherKeyMap.put('G', 3);
		cipherKeyMap.put('H', 3);
		cipherKeyMap.put('I', 4);
		cipherKeyMap.put('J', 4);
		cipherKeyMap.put('K', 5);
		cipherKeyMap.put('L', 5);
		cipherKeyMap.put('M', 6);
		cipherKeyMap.put('N', 6);
		cipherKeyMap.put('O', 7);
		cipherKeyMap.put('P', 7);
		cipherKeyMap.put('Q', 8);
		cipherKeyMap.put('R', 8);
		cipherKeyMap.put('S', 9);
		cipherKeyMap.put('T', 9);
		cipherKeyMap.put('U', 10);
		cipherKeyMap.put('V', 10);
		cipherKeyMap.put('W', 11);
		cipherKeyMap.put('X', 11);
		cipherKeyMap.put('Y', 12);
		cipherKeyMap.put('Z', 12);
		
		String[] words = s.split("\\s"); //Splits the into words wherever there are spaces
		
		int i = 0;
		
		// Loops through array of words
		for (i = 0; i < words.length; i++) 
		{	
			String word = words[i];
			
			StringBuilder builder = new StringBuilder(word.length() + key.length() - 1);
			
			while (builder.length() < word.length()) 
			{
			    builder.append(key);
			}
			
			builder.setLength(word.length());
			String keyExtended = builder.toString();
			
			String encryptedText = "";
				
			for(i = 0; i < word.length(); i++)
			{
				char wordLetter = word.charAt(i);
				char keyLetter = keyExtended.charAt(i);
				
				if((wordLetter >= 'a' && wordLetter <= 'z') || (wordLetter >= 'A' && wordLetter <= 'Z'))
				{
					int lookup = 0;
					
					if(charMap.get(wordLetter) > 12)
					{
						lookup = ((charMap.get(wordLetter)-cipherKeyMap.get(keyLetter)) % 13);
						encryptedCharacter += encryptionArray2[lookup];
					}
					
					else
					{
						lookup = ((charMap.get(wordLetter)+cipherKeyMap.get(keyLetter)) % 13);
						encryptedCharacter += encryptionArray[lookup];
					}	
				}
			}
		}
		
		return encryptedCharacter;
	
	}
	
	public static void encryptCharacter(char wordLetter, char keyLetter)
	{
		
	}
}
