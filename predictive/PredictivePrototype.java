package predictive;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Predictive Prototype predicts the words the user will type
 * @author Gwen
 *
 */
public class PredictivePrototype
{
	//LINKS TO MARTINS ONLINE PORTAL THING! IF ITS WRONG I ATTACHED IT TO THIS PROJECT. UNCOMMENT LINE 26!
	//final static String URL = "http://www.cs.bham.ac.uk/~mhe/sw-exercises/lecture-examples/collections/words";
	final static String FILE_NAME = "words.bin";
	private static Map<Character, Integer> alphabet = new HashMap<Character, Integer>();
	private static BufferedReader reader;
	
	/**
	 * Takes a word and returns it's corresponding integer representation
	 * @param word 
	 * @return String of integers
	 */
	public static String wordToSignature(String word)
	{
		//Q1.
		//what string x = x + "hi" does under the hood is to
		//convert the string to a StringBuilder, append "hi",
		//then convert it back to string.
		//This uses too much extra resources.
		//Therefore it is more resource friendly to simply create
		//a string buffer and convert it to a string once all the
		//appropriate things have been appended.
		
		createAlphabet();
		
		StringBuffer signature = new StringBuffer();
		String lowerCase = word.toLowerCase();
		for(int i = 0; i < lowerCase.length(); i++)
		{
			
			if(alphabet.containsKey(lowerCase.charAt(i)))
				signature.append(alphabet.get(lowerCase.charAt(i)));
			else
				signature.append(" ");
		}
		return signature.toString();
	}
	
	/**
	 * Takes the integer signature and returns everything that fulfills the signature
	 * @param signature
	 * @return Set<String> of all words that fulfilled the criteria
	 */
	public static Set<String> signatureToWords(String signature)
	{
		//Q2
		//It is unadvisable as by storing huge chunks of string in code,
		//it would store all 5MB in the cache, and this is waay too much wastage.
		//instead, traversing the list and only storing the words
		//that fulfill the criteria is more reccommended, as it would cut down on
		//the amount of cache space used.
		
		//I assume it is also easier to edit a separate file instead of going through
		//code.
		
		Set<String> words = new HashSet<String>();
		try
		{
			//URL url = new URL(URL);
			//reader = new BufferedReader(new InputStreamReader(url.openStream()));
			reader = new BufferedReader(new FileReader(FILE_NAME));
			String word;
			while ((word = reader.readLine()) != null)
			{
				if(wordToSignature(word).equals(signature))
					words.add(word);
			}
			reader.close();
			
		} catch (IOException e) { e.printStackTrace(); }
		
		return words;
	}

	/**
	 * Compares the signature of a potential word and the input signature and returns a boolean 
	 * @param signature potential word
	 * @param word input word
	 * @return boolean
	 */
	public static boolean contains(String signature, String word)
	{
		String compareStr = "";
		
		if(signature.length() > word.length())
			compareStr = signature.substring(0, (word.length()));
		else
			compareStr = signature;
		if(compareStr.contains(word))
			return true;
		return false;
	}
	
	/**
	 * Goes through and checks if the word matches the list of character possibilities. Adds it to 'words' if so.
	 * @param charSets list of character arrays that contain the character possibilities
	 * @param words list of words that matches the character possibilities
	 * @param readWord word to be checked
	 */
	public static void goThruPossibilities(List<Character[]> charSets, Set<String> words, String readWord)
	{
		String lowerCaseWord = readWord.toLowerCase();
		int count = 0;
		boolean doesWordMatch = true;
		for(Character[] charArr : charSets)
		{
			
			
			for(int i = 0; i < charArr.length; i++)
			{
				if((lowerCaseWord.length() > count) && charArr[i] == lowerCaseWord.charAt(count))
				{
					doesWordMatch = true;
					break;
				}
				doesWordMatch = false;
			}
			
			if(doesWordMatch == false)
				break;
			count++;
		}
		
		if(doesWordMatch == true && !words.contains(lowerCaseWord))
			words.add(lowerCaseWord);
	}
	
	/**
	 * Converts any non-alphabetical characters to spaces
	 * @param x character to be checked
	 * @return checked char
	 */
	public static char convertNonLetters(char x)
	{
		if(!Character.isLetter(x))
			x = ' ';
		return x;
	}

	/**
	 * fills Hashmap with alphabets as keys and number is values
	 */
	public static void createAlphabet()
	{
		alphabet.put('a', 2);
		alphabet.put('b', 2);
		alphabet.put('c', 2);
		alphabet.put('d', 3);
		alphabet.put('e', 3);
		alphabet.put('f', 3);
		alphabet.put('g', 4);
		alphabet.put('h', 4);
		alphabet.put('i', 4);
		alphabet.put('j', 5);
		alphabet.put('k', 5);
		alphabet.put('l', 5);
		alphabet.put('m', 6);
		alphabet.put('n', 6);
		alphabet.put('o', 6);
		alphabet.put('p', 7);
		alphabet.put('q', 7);
		alphabet.put('r', 7);
		alphabet.put('s', 7);
		alphabet.put('t', 8);
		alphabet.put('u', 8);
		alphabet.put('v', 8);
		alphabet.put('w', 9);
		alphabet.put('x', 9);
		alphabet.put('y', 9);
		alphabet.put('z', 9);
	}
	
}
