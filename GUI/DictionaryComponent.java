package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import predictive.Dictionary;

@SuppressWarnings("serial")
public class DictionaryComponent extends JPanel{

	public DictionaryComponent(Dictionary<String> dict) {
		//model
		DictionaryModel model = new DictionaryModel(dict);
		
		//views
		DictionaryView dictview = new DictionaryView(model);
		InputView inputview = new InputView(model);

		setLayout( new BorderLayout() );
		add(inputview, BorderLayout.NORTH);
		add(dictview, BorderLayout.CENTER);
		model.addObserver(dictview);
		model.addObserver(inputview);
		

		this.setVisible(true);
	}
}
