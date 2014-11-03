
package predictive;

/**
 * Stores the signature and the word associated with it
 * @author Gwen
 *
 */
public class WordSig implements Comparable<WordSig>{

	private String signature;
	private String word;
	public WordSig(String signature, String words)
	{
		this.signature = signature;
		this.word = words;
	}
	
	/**
	 * Get Signature
	 * @return String
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * Get Words
	 * @return String words
	 */
	public String getWords() {
		return word;
	}
	
	public String toString()
	{
		return word;
	}
	
	/**
	 * Compares only the signatures of the wordsig combo
	 */
	@Override
	public int compareTo(WordSig arg0) {
		return this.signature.compareToIgnoreCase(arg0.signature);
	}

}
