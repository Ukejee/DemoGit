package com.three.game;

public class Board {

	String board [] = new String[9];
	boolean GameWon = false;
	
	
	public void createBoard() {
		
		System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("----------");
		System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("----------");
		System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
		
		
		
	}
	
	public void initializeBoard() {
		
		for(int i = 0; i < 9; i++) {
			
			board[i] = " ";
			
		}
		
	}
	
	public void checkWinner() {
		
		String row1 = board[0] + board[1] + board[2];
		String row2 = board[3] + board[4] + board[5];
		String row3 = board[6] + board[7] + board[8];
		String column1 = board[0] + board[3] + board[6];
		String column2 = board[1] + board[4] + board[7];
		String column3 = board[2] + board[5] + board[8];
		String diagonal1 = board[0] + board[4] + board[8];
		String diagonal2 = board[2] + board[4] + board[6];
		
		if(row1.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(row2.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(row3.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(column1.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(column2.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(column3.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(diagonal1.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(diagonal2.equals("XXX")) {
			System.out.println("Player 1 is the winner!!!!!");
			GameWon = true;
		}
		else if(row1.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(row2.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(row3.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(column1.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(column2.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(column3.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(diagonal1.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
		else if(diagonal2.equals("OOO")) {
			System.out.println("Player 2 is the winner!!!!!");
			GameWon = true;
		}
	
		
		
	}
	
	public void fillSlot(int slotNo, String symbol) throws ArrayIndexOutOfBoundsException {
		
		board[slotNo - 1] = symbol;
		
	}
	
	
}
