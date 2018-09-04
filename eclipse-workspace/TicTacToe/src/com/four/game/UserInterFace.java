package com.four.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInterFace extends JFrame{

	private static JPanel panel;
	private static JPanel pan = new JPanel();
	private static XOButton buttons[] = new XOButton[9];
	private static NGButton newGameBtn = new NGButton("New Game");
	private static EButton exitBtn = new EButton("Exit");
	private static JSplitPane sp = new JSplitPane();
	private static TextArea textArea = newGameBtn.getTextArea();
	public static byte value = 0;
	
	public static void main(String[]args) {
		new UserInterFace();
	}
	
	public static void initializeUI() {
		panel = new JPanel();
	}
	
	public UserInterFace() {
		super("UserInterFace");
		initializeUI();
		
		setSize(450,450);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			buttons[i] = new XOButton();
			buttons[i].addActionListener(new ButtonAction(buttons[i]));
			panel.add(buttons[i]);
		}
		sp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		sp.setDividerLocation(250);
		sp.setLeftComponent(panel);
		sp.setRightComponent(pan);
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		pan.add(newGameBtn);
		pan.add(newGameBtn.getTextArea());
		pan.add(exitBtn);
		add(sp);
		setVisible(true);
		textArea.setText(displayText());
		
		newGameBtn.addActionListener(new ButtonAction(newGameBtn));
		exitBtn.addActionListener(new ButtonAction(exitBtn));
		
	}
	
	private static class ButtonAction implements ActionListener{
		private JButton jbutton;
		public ButtonAction(JButton jbutton) {
			this.jbutton = jbutton;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(jbutton.getActionCommand().equalsIgnoreCase("New Game")) {
				displayText();
			}else if(jbutton.getActionCommand().equalsIgnoreCase("exit")) {
				System.exit(0);
			}else {
				
				JButton buttonClicked = (JButton)e.getSource();
				
					if(value%2 == 0) {
					buttonClicked.setText("X");
					printTurn();
				
					if(checkWinner() == true) {
						textArea.append("\n" + "Player 1 is the winner!!!");
						JOptionPane.showConfirmDialog(null, "Restart Game.");
						resetGame();
					}
				}
				else {
					buttonClicked.setText("O");
					printTurn2();
					if(checkWinner() == true) {
						textArea.append("\n" + "Player 2 is the winner!!!");
						JOptionPane.showConfirmDialog(null, "Restart Game.");
						resetGame();
					}
				}
				value++;
				if(value == 8 && checkWinner() == false) {
					textArea.append("\n" + "It's a draw.");
					JOptionPane.showConfirmDialog(null, "Restart Game.");
					resetGame();
				}
		
			}
		}
	}
	public static void printTurn() {
		textArea.append("\nPlayer 2's turn.");
	}
	
	public static void printTurn2() {
		textArea.append("\nPlayer 1's turn.");
	}
	
	
	public static boolean checkWinner() {
		/* 0 | 1 | 2
		   3 | 4 | 5
		   6 | 7 | 8
		 */
		//check row
		if(checkAdjacent(0,1) && checkAdjacent(1,2)) {
			return true;
		}
		else if(checkAdjacent(3,4) && checkAdjacent(4,5)) {
			return true;
		}
		else if (checkAdjacent(6,7) && checkAdjacent(7,8)) {
			return true;
		}
		//check column
		else if (checkAdjacent(0,3) && checkAdjacent(3,6)) {
			return true;
		}
		else if (checkAdjacent(1,4) && checkAdjacent(4,7)) {
			return true;
		}
		else if (checkAdjacent(2,5) && checkAdjacent(5,8)) {
			return true;
		}
		//check diagonal
		else if (checkAdjacent(0,4) && checkAdjacent(4,8)) {
			return true;
		}
		else if (checkAdjacent(2,4) && checkAdjacent(4,6)) {
			return true;
		}
		else {
			return false;
		}
	}
		
		public static boolean checkAdjacent(int a, int b) {
			
			if(buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		
		 public static void resetGame() {
		        for(int i = 0; i <= 8; i++) {
		            buttons[i].setText("");
		        }
		        textArea.setText(" ");
		    }
		 
		 public static boolean checkButtonValidity(JButton clickedButton) throws InvalidSlotExceptionV2 {
			 if(clickedButton.equals(null)) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 
		 public static String displayText() {
			 
			 String message =("========================================" + 
			 "\n       TicTacToe" + "\n======================================"
					 + " \n  " + "\nPlayer 1 is  X" + "\nPlayer 2 is  O" + "\n");
			 return message;
		 }
		 
		 public static void takeTurn(ActionEvent e) {
			   JButton buttonClicked = (JButton)e.getSource();
				if(value%2 == 0) {
				buttonClicked.setText("X");
				printTurn();
			 
		 }
	
	}
}

