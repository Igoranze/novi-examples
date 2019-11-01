package novi.nl.examples;

import java.util.Scanner;

public class Player {

	private String name;
	private Piece piece;
	private Score score;

	public Player(String name, Piece piece) {
		this.name = name;
		this.piece = piece;

		score = new Score();
	}

	public String getName() {
		return name;
	}

	public int[] doMove(Scanner in) throws NumberFormatException {
		System.out.println("Kies een rij");
		int row = Integer.parseInt(in.nextLine());

		System.out.println("Kies een kolom");
		int column = Integer.parseInt(in.nextLine());

		int[] result = { row, column };
		return result;
	}

	public Score getScore() {
		return score;
	}

	public Piece getPiece() {
		return piece;
	}

	public boolean exitGame(Scanner in) {
		System.out.println("Wil je het spel afsluiten?");
		return Boolean.parseBoolean(in.nextLine());
	}
}
