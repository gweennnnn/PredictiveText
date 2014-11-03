package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import predictive.Dictionary;
/**
 * Dictionary implemented by maps
 * @author Gwen
 *
 */
public class DictionaryMapImpl implements Dictionary<String>{
	private String FILE_NAME="words.bin";
	private Map<String, Set<String>> listOfWords;
	BufferedReader reader;
	
	public Map<String, Set<String>> getListOfWords() {
		return listOfWords;
	}
	
	/**
	 * creates a map and populates it
	 */
	public DictionaryMapImpl()
	{
		listOfWords = new TreeMap<String, Set<String>>();
		populateList();
	}
	
	/**
	 * populates list with information read from file
	 */
	private void populateList()
	{
		try
		{
			reader = new BufferedReader(new FileReader(FILE_NAME));
			String word;
			while ((word = reader.readLine()) != null)
			{
				String signature = wordToSignature(word);
				TreeSet y = new TreeSet();
				if(listOfWords.get(signature) != null)
					y = (TreeSet) listOfWords.get(signature);
				
				y.add(word.toLowerCase());
				listOfWords.put(signature, y);
			}
			reader.close();
			
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * gets the signature of a word
	 */
	@Override
	public String wordToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}

	/**
	 * gets a set of words from a signature
	 */
	@Override
	public Set signatureToWords(String signature) {
		return listOfWords.get(signature);
	}

}
