package ie.gmit.sw;

import java.util.*;

public class Menu {

	private boolean menuExit = false; //Boolean for use of exiting Main Menu

	private String decryptLocation = ""; //File/URL location to decrypt
	private String location = ""; //File/URL location to encrypt
	private String key = ""; //Key to encrypt/decrypt the file/URL with

	private Scanner sc = new Scanner(System.in); //Scanner for reading in input
	
	
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
	
	//Runs the actual menu//
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
	
	
	//Gets menu choice//
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
		
		return choice; //Returns menu choice
	}
	
	
	//Menu actions depending on choice//
	private void performAction(int choice)
	{
		
		switch (choice) //Actions for the menu choices
		{
		case 1:
			Parse.parseLocation(getLocation(),getKey()); //Parse Menu to determine File/URL
			break;
		
		case 2:
			//long startTime = System.currentTimeMillis();
			Encrypt.encryptFile(location, key); //Encrypt a file/URL
			//long endTime = System.currentTimeMillis();
			//System.out.println("Encryption took "+(endTime-startTime)+" ms"); //UNCOMMENT THESE TO CHECK THE ENCRYPTION TIME
			break;
		
		case 3:
			Decrypt.decryptFile(getDecryptLocation(), getKey()); //Decrypt a file/URL
			break;
			
		case 4:
			menuExit = true; //Exits Program
			
			System.out.println("\nThank you for using my Porta Cipher!"); //Thank you message once the program is terminated
			break;
			
		default:
			System.out.println("An unknown error has occured, please try again!"); //Default in the case of an error
			
		}
		
		
	}
	
	
	//Gets user input Key//
	private String getKey() 
	{
		System.out.print("\nPlease enter a key to encrypt: ");
		key = sc.next();
		
		return key;
	}

	//Gets user input location to encrypt//
	private String getLocation()
	{
		System.out.print("\nPlease enter a file directory or URL to encrypt: ");
		location = sc.next();
		
		return location;
	}
	
	//Gets user input to decrypt//
	private String getDecryptLocation()
	{
		System.out.print("\nPlease enter a file directory or URL to decrypt: ");
		decryptLocation = sc.next();
		
		return decryptLocation;
	}
	
}

