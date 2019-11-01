package novi.nl.examples;

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

	public int[] doMove(String row, String column) throws NumberFormatException {
		
		int rowI = Integer.parseInt(row);
		int columnI = Integer.parseInt(column);

		int[] result = { rowI, columnI };
		return result;
	}

	public Score getScore() {
		return score;
	}

	public Piece getPiece() {
		return piece;
	}

	public void exitGame() {
		System.exit(1);
	}
}
