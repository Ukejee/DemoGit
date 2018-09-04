package com.three.game;
import java.util.InputMismatchException;

import javax.swing.JButton;


public class Game implements GameInterface {

	Player p1;
	Player p2;
	Board board;
	UserInterFace ui;
	boolean isPlayer1Turn = true;
	
	public void setupGame(){
		
		//welcome message
		System.out.println("about to set up the game");
		//create board
		board = new Board();
		board.initializeBoard();
		//set up ui
		ui = new UserInterFace(this);
		
		//create players
		p1 = new Player("Player 1", "X");
		p2 = new Player("Player 2", "O");

		displayWelcomeMessage();
		
		
		
		
		
		
	}
	
	public Player getCurrentPlayer() {
		//setting player one to play first
		return (isPlayer1Turn)? p1: p2;
	}
	
	public void displayWelcomeMessage() {
		ui.println("===============================================");
		ui.println("                  TicTacToe                    ");
		ui.println("===============================================");
		ui.println("   ");
		ui.println("Player 1 is X");
		ui.println("Player 2 is O");
		ui.println(" ");
		ui.println(getCurrentPlayer().name + " will start first");
		//ui.displayText();
	}
	
	
	
	public void processPlayerTurn(int selectedSquare) {
		
		//loop until game has been won or game over
			//get the current player
		if(board.hasGameEnded()) return;
			System.out.println("this is here");
		try {
			if(board.checkSlotValidity(selectedSquare)) {
				//validate board position
				board.fillSlot(selectedSquare, getCurrentPlayer().signature);
				ui.setButtonText(selectedSquare, getCurrentPlayer().signature);
				String winningPlayer = board.checkWinnerV2(p1, p2);
				
				if(board.hasGameEnded()) {
					System.out.println("game has ended");
					//perform winner check
					
					if(winningPlayer == null) {
						ui.println("Game ended in a draw");
					}else {
						ui.println(winningPlayer + " is the winner");
					}
					
					
				}else {
					
					
					isPlayer1Turn = !isPlayer1Turn;
					ui.println(getCurrentPlayer().name + " your turn" );
				}
				
			}
			
		}catch(InvalidSlotException e) {
			ui.println(e.getMessage());
		}
		
			
	
	}
	
	
	public void playGame() {
		//set up new game
		setupGame();
		
	}
	
}
