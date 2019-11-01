package novi.nl.examples;

public class Board {

	private Piece[][] board;

	public Board(int column, int row) {
		board = new Piece[column][row];

	}

	public Piece[][] getBoard() {
		return board;
	}

	public boolean boardIsFull() {
		boolean result = true;
		
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				if (board[row][column] == null) {
					result = false;
				}
			}			
		}
		
		return result;
	}
	
	public boolean isValidMove(int[] move) throws InvalidMoveException {
		try {
			if (board[move[0]][move[1]] == null)
				return true;
			else
				return false;
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			throw new InvalidMoveException(aioobe.getMessage());
		}
	}

	public void updateBoard(int[] move, Piece piece) {
		board[move[0]][move[1]] = piece;
	}
}
