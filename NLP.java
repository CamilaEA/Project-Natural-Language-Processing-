import java.util.ArrayList;
import java.util.Scanner;

public class NLP {

  // ArrayList of words.txt and translation.txt
  private ArrayList<String> wordsList; 
  private ArrayList<String> translationList;

  // Constructor initializes word and translation list from files
  public NLP() {
    wordsList = FileReader.toStringList("words.txt");
    translationList = FileReader.toStringList("translation.txt");
  }
  
    /** 
     * Creates a list of words from the input
     *
     * Precondition: Input is in the form of a String
     * Postcondition: Wordlist will contain words from the input
     *
     * @param input Input string that splits into words
     * @return ArrayList of words
     */
  public ArrayList<String> createWordList(String input) {
    ArrayList<String> wordList = new ArrayList<String>();

    String[] newWords = input.split(" ");
    for(String word : newWords) {
         wordList.add(word);
     }
    return wordList;
  }

  /** 
     * Checks inputted words with the wordsList and translates them
     *
     * Precondition: translated ArrayList is empty
     * Postcondition: at least one element will be in the translated ArrayList
     *
     * @param input Input list of words to check and translate
     * @return ArrayList of the translated words
     */
   public ArrayList<String> checkWords(ArrayList<String> input) {
     ArrayList<String> translated = new ArrayList<String>();
    
     for (String word : input) {
      int index = wordsList.indexOf(word);
      if (index != -1) {
       if (!translated.contains(translationList.get(index))) {
         translated.add(translationList.get(index));
       } else {
         translated.add(word);
       }
        } else {
           translated.add(word);
          }
        }
       return translated;
    }


    /** 
     * asks the user for input and processes the song title
     */
public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to Song Title Translator!");
    System.out.println("Please input the name of a song in all lowercase");
    String userInput = input.nextLine();

    ArrayList<String> wordList = createWordList(userInput);
    ArrayList<String> translatedWordList = checkWords(wordList);

   
        printSummary(wordList, translatedWordList);
    
      
    input.close();
  }


  /** 
     * Prints original and translated song title in the console
     *
     * Precondition: wordList will match the input of the user
     * Postcondition: translated song title will be from the words in the wordList
     *
     * @param wordList original list of words
     * @param translatedWordList new list of translated words
     */
  public void printSummary(ArrayList<String> wordList, ArrayList<String> translatedWordList) {
    System.out.println("Original Song Title: ");
    System.out.println(wordList);
    System.out.println("Translated Song Title: ");
    System.out.println(translatedWordList);

    noTranslation(wordList, translatedWordList);
    
  }

  /** 
     * Informs user if there are any words that did not translate
     *
     * Precondition: iterates through the wordList and translatedWordList
     * Postcondition: translation will either be true or false
     *
     * @param wordList original list of words
     * @param translatedWordList new list of translated words
     */
  public void noTranslation(ArrayList<String> wordList, ArrayList<String> translatedWordList) {
    boolean anyTranslated = false;

    for (String word : wordList) {
     int index = wordList.indexOf(word);
      if (!word.equals(translatedWordList.get(index))) {
          anyTranslated = true;
         }
      }
       if (!anyTranslated) {
        System.out.println("Sorry, song title entered currently has no translation.");
      }
    }
  
}
