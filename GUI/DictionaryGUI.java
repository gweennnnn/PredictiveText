package GUI;
import javax.swing.JFrame;
import predictive.Dictionary;
import predictive.DictionaryMapImpl;


public class DictionaryGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dictionary");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dictionary<String> dict = new DictionaryMapImpl();
		DictionaryComponent comp = new DictionaryComponent(dict);
		
		frame.add(comp);
		frame.setVisible(true);
		
	}
}
