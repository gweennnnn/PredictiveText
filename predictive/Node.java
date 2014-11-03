package predictive;

import java.util.Set;
import java.util.TreeSet;

public class Node {
	private Set<String> storedWords;
	private Node[] branches;
	private int rootVal;
	
	public Node(int rootVal) {
		storedWords = new TreeSet<String>();
		branches = new Node[8];
		this.rootVal = rootVal;
	}
	
	/**
	 * add word to node
	 * @param word
	 */
	public void addWord(String word)
	{
		storedWords.add(word.toLowerCase());
	}
	
	/**
	 * check if word exists in node
	 * @param word
	 * @return boolean
	 */
	public boolean containsWord(String word)
	{
		return storedWords.contains(word.toLowerCase());
	}
	
	/**
	 * add Branch to tree
	 * @param e new branch
	 */
	public void addBranch(Character signature)
	{
		int index = Character.getNumericValue(signature);
			branches[index-2] = new Node(index);
	}
	
	/**
	 * get all stored words
	 * @return Set<String>
	 */
	public Set<String> getStoredWords()
	{
		return this.storedWords;
	}
	
	/**
	 * get all branches
	 * @return Node[]
	 */
	public Node[] getBranches()
	{
		return this.branches;
	}
	
	/**
	 * get specific branch
	 * @param nodeVal
	 * @return Node
	 */
	public Node getSpecificBranch(Character nodeVal)
	{
		
		int index = Character.getNumericValue(nodeVal);
		if(branches[index-2] == null)
			return null;
		else
			return branches[index-2];
	}
	
	/**
	 * check if branch exists
	 * @param Node
	 * @return Node
	 */
	public boolean doesBranchExist(Character nodeVal)
	{
		int index = Character.getNumericValue(nodeVal);
		if(branches[index-2] == null)
			return false;
		return true;
	}
	
	
	public int getRootValue()
	{
		return this.rootVal;
	}
	
	public String toString()
	{
		String derp = "Root: " + this.getRootValue() + "\n";
		derp = derp + "CHILDREN \n";
		
		
		for(int i = 0; i < getBranches().length; i++)
		{
			derp = derp + getBranches()[i] + "\n";
		}
		return derp;
	}
}
