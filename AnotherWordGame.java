import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * AnotherWordGame is a game which gives user a scrambled word 
 * and four chances to guess it correctly. 
 * NOTE TO MR. BUESCHER: Game was created because initial attempt of WordGame
 * seemed too easy. Scrambling took many, many, many tries. Still working on
 * this for fun (hence all the commented out code).
 * 
 *
 * @author Shruthi Ravichandran (group: Yazzy Ahuja, Isy Herman)
 * @version 2020-01-24
 */
public class AnotherWordGame
{
    private static String[] words;
    private String fileName = "popular.txt";
    private int numWords = 25322;
    private boolean isSorted;
    private static String orig;
    private static String scrambled = "";
    private static String guess;
    //private static String guess2;
    //private static String guess3;    
    /**
     * Constructor for objects of class AnotherWordGame
     */
    public AnotherWordGame()
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
    }
    
    /**
     * Chooses a Random Word from Array of 25,000+ words
     *
     * @return    chosen word
     */
    public String chooseRandomWord()
    {
       orig = words[(int)(Math.random()*25322)];
       return orig;
    }
    /**
     * Scrambles the Original Word
     *
     * @return    scrambled word
     */
    public String scrambleWord()
    {
       /*String temp = "artful";
       String newString = " ";
       String plswork = " ";
       String newone = " ";
       Boolean isit = false;
       String temp = orig;*/
       
       ArrayList<Character> thing = new ArrayList<Character>(orig.length());//creates character ArrayList
            //System.out.println(orig.length());
       for (int k = 0; k <orig.length(); k++) //copies word into ArraList of characters
       {
            thing.add(orig.charAt(k));
       }
       ArrayList<Character> scram = new ArrayList<Character>(orig.length()); //creates scrambling ArrayList
       for (int j = 0; j <orig.length(); j++) //picks a random number as index to remove from thing and add to scram
       {
             int num = (int)(Math.random()*thing.size());
             scram.add(thing.get(num));
             thing.remove(num);
       }
       for (int m = 0; m <scram.size(); m++) //copies scrambled ArrayList into string
       {
             scrambled += scram.get(m);
       }
       //System.out.println(scrambled);
       return scrambled;
    }    
    /*public int guessesLeft()
    {
        int startingGuesses = 3;
        int n = startingGuesses;
        return n;
    }*/
     /**
     * Checks if the user's guess is correct
     *
     * @return    whether the guess was correct
     */
    public boolean checkGuess()
    {
        if(guess.equals(orig))
        {
            return true;
        }
        return false;
    }
    /*public boolean checkGuess2()
    {
        if(guess2.equals(orig))
        {
            return true;
        }
        return false;
    }
    public boolean checkGuess3()
    {
        if(guess3.equals(orig))
        {
            return true;
        }
        return false;
    }*/
    public static void main (String[] args)
    {
        Scanner kbd = new Scanner (System.in);
        AnotherWordGame myWords = new AnotherWordGame();
        myWords.chooseRandomWord();
        //System.out.println(myWords.chooseRandomWord());
        //System.out.println(myWords.scrambleWord());
        //System.out.println ("Welcome to WordScramble! Your word for this round is " + myWords.chooseRandomWord());
        System.out.println(myWords.scrambleWord());
        int startingGuess = 3;

        System.out.println("What do you think this word is? (You have " + (startingGuess+1) + " guesses so guess wisely!): ");
        guess = kbd.nextLine();
        for (int i = 0; i <= 3; i++)
        {
            if(myWords.checkGuess() == true)
            {
                System.out.println("Congrats! You got it right! The unscrambled word is indeed " + myWords.orig);
                break;
            }
            else
            {
                if(i == 3)
                {
                     System.out.println("Sorry. " + guess + " is incorrect. The correct answer is "+ myWords.orig);
                }
                else
                {
                    System.out.println("Sorry. " + guess + " is incorrect. Please try again."+" You have " + startingGuess + " guesses left! Be careful!");
                    guess = kbd.nextLine(); 
                    startingGuess--;
                }
            }
        }
        /*
        if(myWords.checkGuess1() == true)
        {
            System.out.println("Congrats! You got it right on the first try! The unscrambled word is indeed " + myWords.orig);
        }
        else
        {
            System.out.println("Sorry. " + guess + " is incorrect. Please try again.");
            guess2 = kbd.nextLine();
            if(myWords.checkGuess2() == true)
            {
                    System.out.println("Congrats! You got it right on the " + myWords.guessesLeft() + " th try! The unscrambled word is indeed " + myWords.orig);
            }
            else
            {
                 System.out.println("Sorry. " + guess2 + " is incorrect. Please try again.");
                 guess3 = kbd.nextLine();
                 if(myWords.checkGuess3() == true)
                 {
                     System.out.println("Congrats! You FINALLY got it right! Play again next time and maybe do better?");
                 }
                 else
                 {
                     System.out.println("Sorry. Your final guess of " + guess3 + " is incorrect. Too bad! Play again!");
                 }
            }
        }*/
        kbd.close();
    }
}
/*int num = (int) (Math.random() * temp.length());
           scram+= temp.charAt(num);*/
           /*int[] nums = new int[temp.length()];
           for (int k = 0; k <temp.length(); k++)
           {
              int add = 0;
              nums[0] = add;
              add++;
           }
           int num = (int) (Math.random() * temp.length());
           plswork+=temp.charAt(nums[num]);
           //newone = temp.substring(0,num) + temp.substring(num,temp.length());
           */
           
           /*int num = (int) (Math.random() * temp.length());
           char letrep = temp.charAt(num);
           scram += letrep;
           temp.replace(temp.charAt(num),' ');*/