package com.three.game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

	String name;
	String signature;
	int userSlot;
	
	public Player(String userName, String userSignature ) {
		
		name = userName;
		signature = userSignature;
		
	}
	
	public int takeTurn() throws InputMismatchException {
		
		System.out.println("Enter slot number " + name + ": ");
		Scanner in = new Scanner(System.in);
		int userSlot = in.nextInt();
		return userSlot;
		
	}
	
	
	
}
