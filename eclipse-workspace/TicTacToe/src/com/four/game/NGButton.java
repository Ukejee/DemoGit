package com.four.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NGButton extends JButton implements ActionListener {

	  private TextArea text = new TextArea(4,3);
	
	public NGButton(String label) {
		super(label);
		addActionListener(this);
	}
	
	//public NGButton() {}
	
	public void actionPerformed(ActionEvent e) {

		
	}
	public TextArea printTurn() {
		text.append("\n Player 1");
		return text;
	}
	
	public TextArea getTextArea() {
		return text;
	}
}
