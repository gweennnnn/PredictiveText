package GUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

import predictive.Dictionary;

public class DictionaryModel extends Observable{
	private Dictionary<String> dict;
	private List<String> enteredWords;
	private StringBuffer currSig;
	private ArrayList<String> currPossibleWords;
	private int currPos;
	
	public DictionaryModel(Dictionary<String> dict) {
		this.dict = dict;
		enteredWords = new ArrayList<String>();
		currSig = new StringBuffer("");
		currPossibleWords = new ArrayList<String>();
		currPos = 0;
	}
	
	public String getCurrWord()
	{
		return currPossibleWords.get(currPos);
	}
	
	public String getCurrSig()
	{
		return currSig.toString();
	}
	
	public String getEnteredWords()
	{
		String x = "";
		for(int i = 0; i < enteredWords.size(); i++)
			x = x + enteredWords.get(i) + " ";
		return x;
	}

	public ArrayList<String> getPossibleWords()
	{
		return currPossibleWords;
	}
	
	public String wordToSignature(String word)
	{
		return dict.wordToSignature(word);
	}
	
	public ArrayList<String> signatureToWords(String signature)
	{
		ArrayList<String> x;
		Collection<String> y = dict.signatureToWords(signature);
		if(y != null) 
			x = new ArrayList<>(y);
		else
			x = new ArrayList<>();	
		return x;
	}
	
	public boolean isPossWordEmpty()
	{
		if(this.getPossibleWords().isEmpty() || this.getPossibleWords() == null)
			return true;
		return false;
	}
	
	public void setPossibleWords()
	{
		if(!getCurrSig().equals(""))
			currPossibleWords = this.signatureToWords(this.getCurrSig());
		else
			currPossibleWords = new ArrayList<>();
	}
	
	public void addToCurrSig(String singleChar)
	{
		if(singleChar.equals("*"))
		{	
			System.out.println(currPossibleWords);
			if(this.isPossWordEmpty())
			{
				currPos = 0;
				System.out.println("EMPTY");
			}
			else
			{
				System.out.println("NOT EMPTY");
				currPos = (currPos+1) % currPossibleWords.size();
			}
		}
		else if(singleChar.equals("0"))
		{
			if(!this.isPossWordEmpty())
				addEnteredWords(getCurrWord());
			this.currPos = 0;
			currSig.setLength(0);
			currPossibleWords = new ArrayList<String>();
		}
		else if(singleChar.equals("1"))
		{
			
		}
		else if(singleChar.equals("Back"))
		{
			currPos = 0;
			if(currSig.length() > 0)
			{
				currSig.deleteCharAt((currSig.length()-1));
				System.out.println("Meepmeep");
			}
			else
			{
				if(!enteredWords.isEmpty())
				{
					StringBuffer x = new StringBuffer(this.enteredWords.remove(enteredWords.size()-1));
					x.deleteCharAt(x.length()-1);
					currSig = new StringBuffer(dict.wordToSignature(x.toString()));
					
				}
			}
		}
		else
		{
			currPos = 0;
			currSig.append(singleChar);
		}
		setChanged();
        notifyObservers();
	}
	
	public void addEnteredWords(String word)
	{
		enteredWords.add(word);
	}
}
