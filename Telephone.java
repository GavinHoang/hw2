//package hw2;

import java.util.Scanner;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class Telephone
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
   */
   public Telephone(Scanner aScanner) // aScanner = new scanner(System.in)
   {
      scanner = aScanner;
   }

 
   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c) 
   {
      boolean more = true;
   
      while (more)
      {
    	  	 
         String input = scanner.nextLine(); // take the whole line/message
         
         if (input == null) continue;
         if (input.equalsIgnoreCase("H"))
            c.hangup();
         else if (input.equalsIgnoreCase("Q"))
            more = false;         
         else if (Character.isDigit(input.charAt(0)) || 
        		 input.contains("#") || input.length() > 1)// assume message has at least two char
         { 
        	 	try 
        	 	{
        	 	 c.dial(input);            	 	 
        	 	}
        	 	catch(NumberFormatException e){
        	 		speak("Invalid input, try againh");
        	 	}
         }        	                
        	 //c.record(input);
         
      }
   }

   private Scanner scanner;
}
