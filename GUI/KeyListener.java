package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyListener implements ActionListener{

	private DictionaryModel model;
	private String sig;
	
	public KeyListener(DictionaryModel model, String sig) {
		 this.model = model;
		 this.sig = sig;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.addToCurrSig(sig);
		model.setPossibleWords();
	}

}
