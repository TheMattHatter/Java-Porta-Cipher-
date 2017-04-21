 
 CONTENTS OF THIS FILE
 ---------------------
   
 * Introduction
 * Instructions
 * Coding Process
 * Tests
 * Problems
 * Conclusion




 INTRODUCTION
 ---------------------
 Matthew Shiel (G00338622) Data Structures & Algorithms Assignment 
 Rapid Encryption using a Porta Cipher.

 This substitution cipher program is capable of rapidly encrypting and decrypting 
 a file/URL using methods and ideas that I learned over the year eg. HashMaps.

 The average running time for reading the book "War and Peace", fully encrypting
 and writing to an output file was 272ms based on around 50 tests done on my
 custom built i5, 16gb ram, desktop workstation.
 
 I hope you enjoy using my program and seeing my work process from the README.
 If you would like to see my entire process the program is on my GitHub, carefully
 detailing each process step by step.



 INSTRUCTIONS
 ---------------------
   
 1. When first running the program you are prompted with a main menu.
 
 2. You have 4 choices. Parse, Encrypt, Decrypt and Exit.

 3. Press (1) to ensure you can parse the file/URL.
 4. Enter in a file directory or URL and hit enter. Then enter in a key to encrypt
    the file with.

 5. After a successful parse you may now use either (2) or (3) to Encrypt or Decrypt.
 6. Press (2) to encrypt the parsed file. In the PortaCipher folder, a new file
    "encryptedLocation.txt" will be written.
 7. Press (3) to decrypt. Enter the file/URL location. In the PortaCipher folder, a new file
    "decryptedLocation.txt" will be written.

 8. Finally when finished, press (4) to terminate the program.



 RELEVANT DESIGN FEATURES / ADDITIONAL INFORMATION
 ----------------------------------------------------------

 ======
 RUNNER
 ======

 * Runner creates an instance of the Menu class.

 * Then 'runMenu()' is called on the Menu to begin the program.


 ====
 MENU
 ====

 * runMenu() initiates a while loop to run the menu until a valid choice is made.

 * In this while loop, two methods are important, a method to get the user choice and a method to act on that choice.

 * The getChoice() method will work similarily. A while loop is invoked to prompt the user
   to enter a valid menu choice. They will run until choice is no longer "-1" and
   the user enters a valid choice between the menu's parametres eg. "1 to 4"

 * The "Perform Action" also contains a switch statement which controls all the menu options.
   Each case will invoke different classes to either parse, decrypt or encrypt a file/Url.


 ======
 PARSE
 ======

 * The parse class contains one static method, parseLocation().

 * parseLocation() - recieves a file/URL location and returns a BufferedReader.

 * At the top of the class there are two static constant Strings, SCHEME1 and SCHEME2.
   These are used to tell whether or not the location must be parsed as a file or a URL.
   If the location starts with a scheme they are parsed as a URL, else as a File.

 * The If Else statements are surrounded by a try-catch block to handle the thrown IOException.

 * To optimise speed the InputStreamReader is wrapped in a BufferedReader.

 EXTRA INFORMATION
 -----------------
 * The parsing was originally done with two classes, FileParser and URLParser,
   which implemented one method, parse(), from an Interface (Parserator)

 * I considered it bad practice to have an interface with only one method so I 
   simplified everything to one Parse class.

 * All of these changes can be seen from my aforementioned GitHub repository.


 =================
 ENCRYPT & DECRYPT
 =================

 * The Encrypt class contains two static methods, encryptFile() and encryptLine().

 * encryptFile() - Creates a new BufferedReader for the file/URL location and a PrintWriter
   to write a file. Then it loops through the BufferedReader line by line, encrypts each 
   word and writes the words to a file "encryptedLocation.txt".

 * The String "encryptedString" calls encryptLine() and stores the encrypted word which is then written to the file.

 * encryptLine() - Reads in a word and a key, converts them to uppercase, generates an extended key for when the word
   is longer than the key and the key has to repeat itself, loops for the length of the word and encrypts each character
   then appends each character to a StringBuilder and returns the encrypted word.

 * I use StringBuilders when concatenating the extendedKey and the encryptedLine as I found it to be faster than using "+=".

 * I utilise two HashMaps and two arrays in this method. The first HashMap is for the word you're encrypting. Each
   letter key (A-Z) has a unique numeric value (0-25) The second HashMap is for the key you're encrypting with.
   Each letter key (AB, BC, DE) has a unique numeric value (0-12). I used HashMaps for the reason that they have 
   O(1) access with high probability.

 * The two encryption arrays hold the characters to be encrypted to.

 * If the character is between 'A' and 'Z' the correct encryption is fetched from the arrays and appended to the end of the 
   StringBuilder. If not then the non-alphanumeric character is appended automatically. This preserves full-stops, commas etc.
   Finally the encrypted string is returned.

 **The class Decrypt is the exact same as Encrypt. The only reason I have another class is because I encountered a stream exception issue.
   The stream was already closed in the Encrypt class so I couldn't open a closed stream. For this reason I created a new class, for a new stream.
   It also allows me to write to a different file "decryptedLocation.txt".

 EXTRA INFORMATION
 -----------------
 * The encryption was originally done by parsing the entire text file, removing
   all non-alphanumeric characters using String.replaceAll() and a regex [^A-Za-z],
   concatenating each character into one string with a StringBuilder, and then encrypting
   the one string.

 * This method was slow and I was not satisfied with the speeds I was coming out with.
   War and Peace would not even encrypt.

 * I moved on from this and arrived at the method layed out above. By writing each String to a file
   as it was being read, encrypting each word character by character, and using HashMaps, I achieved
   a much more desirable speed and could encrypt all of the provided files/URLs.


 TESTS
 ------------------
 
 * I was able to read files in from file directories on my PC eg. C:\Users\Matthew\Desktop\WarAndPeace-LeoTolstoy.txt and also
  a file created in the JRE System Library. 

 * http://www.puzzlers.org/pub/wordlists/pocket.txt

 * I found that this website was useful for testing the URL Parser as it simply contains a list of 20,000+
   words.

 * I did my best to test all possibilities of innapropriate use of the program eg. wrong entries
   and to error handle accordingly. This does not mean I didn't miss something but just as an FYI
   before I conclude.

 ISSUES
 -------------------

 *Unfortunately I did encounter an issue with the program. I do believe that my logic when encrypting
  ((wordLetter(at i)-keyLetter(at i))%13) and ((wordLetter(at i)+keyLetter(at i))%13), then grabbing the 
  appropriate encrypted character, was correct. However when encrypting War and Peace, for example, with
  a word like "pop" the encryption was perfect. But when encrypting with a word like "butterfly", "part" etc.
  It would only half encrypt the file. I got very bogged down on this for a week and in the end I couldn't solve it.

 CONCLUSION
 -------------------

 This program challenged me many a time over the last few weeks, especially when having to deal with issues like
 repeating the key for the length of the word and encountering non-alphanumeric characters and handling them 
 appropriately. Additionally, working with an emphasis on speed and low RAM consumption was a new challenge in itself
 and better helped me understand the importance of making your program as efficient as possible.
 I hope that this suffices. Overall I'm happy to have completed it and thought the program itself was quite cool
 when it finally came together and worked (sometimes). I only wish I could have solved the issue I was having with some
 keys working and other keys not.
