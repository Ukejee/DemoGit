package com.three.game;

import java.util.InputMismatchException;

public class Game {

	Player p1;
	Player p2;
	Board board;
	
	public void startGame() {
		
		p1 = new Player("Player 1", "X");
		p2 = new Player("Player 2", "O");
		board = new Board();
		
		System.out.println("===============================================");
		System.out.println("                   TicTacToe");
		System.out.println("===============================================");
		System.out.println("   ");
		System.out.println("Player 1 is X");
		System.out.println("Player 2 is O");
		System.out.println(" ");
		board.initializeBoard();
		board.createBoard();
		
	}
	
	public void playGame() {
		
		int turnCount = 0;
		startGame();
		System.out.println("Player 1 goes first");
		while(board.GameWon == false) {
			try {
			board.fillSlot(p1.takeTurn(), p1.signature);
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Select a slot number between 1 - 9 only.");
				board.fillSlot(p1.takeTurn(), p1.signature);
			}
			catch(InputMismatchException ex) {
				System.out.println("Enter slot number in figures not words.");
				board.fillSlot(p1.takeTurn(), p1.signature);
			}
			board.createBoard();
			board.checkWinner();
			try {
			board.fillSlot(p2.takeTurn(), p2.signature);
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Select a slot number between 1 - 9 only.");
			}
			catch(InputMismatchException ex) {
				System.out.println("Enter slot number in figures not words.");
				board.fillSlot(p2.takeTurn(), p2.signature);
			}
			board.createBoard();
			board.checkWinner();
			turnCount++;
			if(turnCount == 4) {
				System.out.println("It's a draw.");
				board.GameWon = true;
				
			}
		}
	}
	
}
