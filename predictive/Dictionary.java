package predictive;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Interface of Dictionaries
 * @author Gwen
 *
 * @param <Item> Class used to store dictionary entries
 */
public interface Dictionary<Item> {
	public String wordToSignature(String word);
	
	public Collection<Item> signatureToWords(String signature);
}
