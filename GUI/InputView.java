package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputView extends JTextArea implements Observer{
	private DictionaryModel model;
	private String sig;
	
	public InputView(DictionaryModel model) {
		this.model = model;
		sig = model.getCurrSig();
		this.setText(sig);
		Font font = new Font("Century Gothic", Font.PLAIN, 40);
		this.setFont(font);
		this.setEditable(false);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		sig = model.getCurrSig();

		System.out.println("Current sig is " + sig);
		model.setPossibleWords();
		
		if(model.isPossWordEmpty())
			this.setText(model.getEnteredWords());
		else
			this.setText(model.getEnteredWords() + " " + model.getCurrWord());
	}
	
}
