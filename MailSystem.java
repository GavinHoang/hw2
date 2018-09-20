package hw2;

import java.util.ArrayList;

/**
   A system of voice mail boxes.
*/
public class MailSystem
{
   /**
      Constructs a mail system with a given number of mailboxes
      @param mailboxCount the number of mailboxes
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList<>();

      // Initialize mail boxes.

      for (int i = 0; i < mailboxCount; i++)
      {
         String passcode = "" + (i + 1);
         String greeting = "You have reached mailbox " + (i + 1) 
               + ". \nTo leave a message, press (1), to access your mailbox, press (2)."; //Please leave a message now.";
         mailboxes.add(new Mailbox(passcode, greeting));
      }
   }

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox or null if not found
   */
   public Mailbox findMailbox(String ext)
   {
      int i = Integer.parseInt(ext);
      if (1 <= i && i <= mailboxes.size())
         return  mailboxes.get(i - 1);
      else return null;
   }

   private ArrayList<Mailbox> mailboxes;
}

