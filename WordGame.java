import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * WordGame is a game played between the user and a computer where 
 * they each take turns saying words which begin with the letter 
 * the previous said word ended with. 
 * NOTE TO MR. BUESCHER: This version was also going to include a 
 * set length limit (to increase complexity of playing), a tracker of points, 
 * and intolerance of repeats. Since another game was also written, 
 * there was not enough time to implement these ideas. I'm working on them
 * for fun (hence all the commented out code).
 * 
 *
 * @author Shruthi Ravichandran (group: Yazzy Ahuja, Isy Herman)
 * @version 2020-01-24
 */
public class WordGame
{
      private String[] words;
      private String fileName = "popular.txt";
      private int numWords = 25322;
      private boolean isSorted;
      private static String giveback = "";
      private static String userWord = "";
      private static char lastLetter = ' ';
      private static ArrayList<String> alreadyUsed;
        /** The constructor attempts to fill the array words with 
       *  words from the file fileName.
       */
      public WordGame()
      {
        File file = new File(fileName);
        Scanner wordFile = null;
        try
        {
            wordFile = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 
    
        // Initialize the array of words
        words = new String[numWords];
        // Fill the array from the input file
        for (int i = 0; i < numWords; i++)
        {
          words[i] = wordFile.nextLine();
        }
        //alreadyUsed.add("begin");
      }
      /**
      * Finds a word in the list which begins with a character
      *
      * @return    word beginning with specific character
      */      
      public String findWord(char C)
      {
          String returnword = " ";
          for (String word : words)
          {
              if (word.charAt(0) == C)
              {
                 returnword = word;
                 break;
              }
          }
          return returnword;
      }
      /**
      * Finds the last letter of a given word
      *
      * @return    last letter of word
      */
      public char lastLetter(String word)
      {
          lastLetter = word.charAt(word.length()-1);
          return lastLetter;
      }
      /**
      * Fills array with word
      *
      */
      public void fillWithUsed(String word)
      {
          alreadyUsed.add(word);
      }
      /*public boolean noRepeats(String word)
      {
         for (int i = 0; i < alreadyUsed.size(); i++)
         {
             if (alreadyUsed.get(i).equals(word))
             {
                 return true;
             }
         }
         return false;
      } */
      public static void main (String[] args)
        {
            Scanner kbd = new Scanner (System.in);
            WordGame myWords = new WordGame();
            System.out.println ("Loaded over 23,000 words!");
            System.out.print ("Enter a word: ");
            while (userWord != "QUIT")
            {
                userWord = kbd.nextLine();
                //System.out.println(userWord);      
                giveback = myWords.findWord(myWords.lastLetter(userWord));
                System.out.println(giveback);
            }
            
            //System.out.print("Enter a word: ");
            //userWord = kbd.nextLine();
            //System.out.println(userWord); 
            
            //System.out.println("The last letter is " + lastLetter);
              /*
            while (userWord != "QUIT")
            {
                //myWords.alreadyUsed.add(userWord);
                //if(myWords.noRepeats(userWord) == false)
                {  
                   giveback = myWords.findWord(lastLetter);
                   System.out.println(giveback);
                   System.out.print ("Enter a word: ");
                   userWord = kbd.nextLine();
                   System.out.println(userWord); 
                }*/
                kbd.close(); 
            }   
}
            //kbd.close();  

