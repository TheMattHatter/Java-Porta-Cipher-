package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class Menu {

	private boolean menuExit = false; //Boolean for use of exiting Main Menu

	private Parserator p1; //Parserator manipulated later to be either of type FileParser or of type URLParser
	private String key = "";
	private String plainText = "";
	//private String key = "";
	
	private Scanner sc = new Scanner(System.in); //Scanner used by all methods
	
	
	/***************************************
	 
	 ===========================
	 Section 1 Main Menu Options
	 ===========================
	  
	 * Main Menu with 4 options:
	  
	 * 1) Enter the keyword and a file/URL
	 * 2) Encrypt the file/URL
	 * 3) Decrypt the file/URL
	 * 4) Exit the program
	 
	 
	 ***************************************/
	
	//Program Greeting//
	private static void printHomeHeader()
	{
		System.out.println("+-----------------------------------------+");
		System.out.println("|              Welcome To My              |");
		System.out.println("|            Java Porta Cipher            |");
		System.out.println("+-----------------------------------------+");
		
	}

	
	//Main Menu options//
	private void printMainMenu()
	{
		System.out.println();
		System.out.println("+---------------------+");
		System.out.println("|       Main Menu     |");
		System.out.println("+---------------------+");
		System.out.println("\nPlease enter a selection between (1) and (4):");
		System.out.println("1) Keyword and File/URL Parser");
		System.out.println("2) Encrypt");
		System.out.println("3) Decrypt");
		System.out.println("4) Exit");
		
	}
	
	//Runs the actual menu
	public void runMenu()
	{
		int choice; //Integer to store menu choice
		
		printHomeHeader();
		
		while(!menuExit) //While Loop for Main Menu
		{		
			printMainMenu(); //Prints out the Main Menu
				
			choice = getChoice(); //Value of getChoice method is stored in choice
				
			performAction(choice); //Perform an action depending on menu choice 
			
		}
		
		
	}
	
	
	//Gets menu choice
	private int getChoice()
	{	
		
		int choice = -1; //Condition that ensures menu will loop
		
		
		while(choice < 1 || choice > 4) //While loop to determine choice
		{
			
			try
			{
				System.out.print("\nPlease enter a menu choice 1-4: "); //Prompt user for menu choice
				choice = sc.nextInt();
				
				if(choice < 1 || choice > 4) //Error handling in case input is outside menu condition
				{
					System.out.println("\nPlease keep your choice between 1 and 4");
				}
				
			}
			
			
            catch (Exception e) //Error handling in case input is not an integer
			{
            	
                System.out.println("\nInvalid choice! That's not a number!"); 
                sc.next();
                
            }
			
			
		}
		
		return choice;
	}
	
	
	//Menu actions depending on choice//
	private void performAction(int choice)
	{
		
		switch (choice) //Actions for the menu choices
		{
		case 1:
			parse(); //Parse Menu to determine File/URL
			break;
		
		case 2:
			encrypt(); //Search options for File/URL
			break;
		
		case 3:
			//Decrypt(); //Stat options for File/URL
			break;
			
		case 4:
			menuExit = true; //Exits Program
			
			System.out.println("\nThank you for using my Porta Cipher!"); //Thank you message once the program is terminated
			break;
			
		default:
			System.out.println("An unknown error has occured, please try again!"); //Default in the case of an error
			
		}//End switch(choice)//
		
		
	}//End performAction//
	
	
	private void parse() 
	{
		String parseChoice; //String that holds either file destination or URL
		
		String scheme1 = "http://"; //Scheme 1 for URL parsing
		String scheme2 = "https://"; //Scheme 2 for URL parsing
		
		System.out.print("\nPlease enter the key to encypt and decrypt: "); //Asking User for a file/URL
		key = sc.next();
		
			System.out.print("\nPlease enter a file destination or a URL: "); //Asking User for a file/URL
			parseChoice = sc.next();
			
			if(parseChoice.startsWith(scheme1) || parseChoice.startsWith(scheme2)) //If input is a URL
			{
				try
				{
					p1 = new URLParser(); //Instance of URLParser created 
					p1.parse(parseChoice);
				}
				
				catch(NullPointerException e) //Catching NullPointerException if an invalid URL is entered
				{
					System.out.println("Invalid URL please try again");
				}
			}
			
			
			else //If input is a file
			{
				p1 = new FileParser(); //Instance of FileParser created 
				p1.parse(parseChoice);
			}		
		
	}//End parseMenu
	
	private void encrypt()
	{
		p1.replace();
		plainText = p1.joinStrings();
		String encryptedText = p1.encrypt(plainText, key);
		
		System.out.println(encryptedText);
		
	}
	
}

