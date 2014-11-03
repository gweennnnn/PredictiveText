package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DictionaryView extends JPanel implements Observer{

	private String[][] buttons;
	private JButton[] [] keys;
	private int keySize = 4;
	
	public void makeButtons()
	{
		buttons = new String[keySize][keySize];
		buttons[0][0] = "1";
		buttons[0][1] = "2";
		buttons[0][2] = "3";
		buttons[1][0] = "4";
		buttons[1][1] = "5";
		buttons[1][2] = "6";
		buttons[2][0] = "7";
		buttons[2][1] = "8";
		buttons[2][2] = "9";
		buttons[3][0] = "*";
		buttons[3][1] = "0";
		buttons[3][2] = "Back";
	}
	
	public void makeButtonChars(String[][] buttonChars)
	{
		buttonChars[0][0] = "";
		buttonChars[0][1] = "   a b c";
		buttonChars[0][2] = "   d e f";
		buttonChars[1][0] = "   g h i";
		buttonChars[1][1] = "   j k l";
		buttonChars[1][2] = "   m n o";
		buttonChars[2][0] = "   p q r s";
		buttonChars[2][1] = "   t u v";
		buttonChars[2][2] = "   w x y z";
		buttonChars[3][0] = "";
		buttonChars[3][1] = "";
		buttonChars[3][2] = "";
	}
	
	public DictionaryView(DictionaryModel model) {
		keys = new JButton[keySize][keySize];
		setLayout( new GridLayout(keySize, keySize) );

		makeButtons();
		String[][] buttonChars = new String[keySize][keySize];
		makeButtonChars(buttonChars);
		
		
		for(int i = 0; i < keySize; i++)
		{
			for(int j = 0; j < keySize; j++)
			{
				if(buttons[i][j] != null)
				{
					keys[i][j] = new JButton(buttons[i][j]+buttonChars[i][j]);
					keys[i][j].addActionListener(new KeyListener(model, buttons[i][j]));
					keys[i][j].setBackground(Color.ORANGE);
					Font font = new Font("Century Gothic", Font.PLAIN, 20);
					keys[i][j].setFont(font);
					add(keys[i][j]);
				}
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
;