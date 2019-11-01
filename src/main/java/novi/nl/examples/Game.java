package novi.nl.examples;

public class Game {

	private Board board;
	private Player[] players;
	private Player currentPlayer;

	private View view;

	private boolean currentMoveIsInvalid;

	public Game() {
		players = new Player[2];
		view = new View();
	}

	public void setPlayers(String playerOne, String playerTwo) {
		if (playerOne != null && playerTwo != null) {
			playerOne = playerOne.replace("<", " ").replace(">", " ").replace("javascript", " ").replace("script", " ").strip().trim();
			playerTwo = playerTwo.replace("<", " ").replace(">", " ").replace("javascript", " ").replace("script", " ").strip().trim();
			
			players[0] = new Player(playerOne, Piece.XPIECE);
			players[1] = new Player(playerTwo, Piece.OPIECE);
		}
	}

	public boolean isCurrentMoveIsInvalid() {
		return currentMoveIsInvalid;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public String getGameView() {
		return view.draw(this, board, players, currentPlayer);
	}

	public void startGame() {
		currentMoveIsInvalid = false;
		currentPlayer = players[0];
		board = new Board(3, 3);
	}

	private void swapPlayerTurn() {
		if (currentPlayer == players[0])
			currentPlayer = players[1];
		else
			currentPlayer = players[0];
	}

	private boolean isValidPlayerMove(int[] move) {
		boolean result = false;

		try {
			if (board.isValidMove(move)) {
				currentMoveIsInvalid = false;
				result = true;
			} else {
				currentMoveIsInvalid = true;
				result = false;
			}
		} catch (InvalidMoveException ime) {
			currentMoveIsInvalid = true;
			result = false;
			System.out.println("This");
		}
		
		return result;
	}

	public boolean checkWinner() {
		Piece[][] board = this.board.getBoard();
		Piece currentPlayerPiece = currentPlayer.getPiece();

		if (board[0][0] == currentPlayerPiece && board[0][1] == currentPlayerPiece && board[0][2] == currentPlayerPiece)
			return true;
		else if (board[1][0] == currentPlayerPiece && board[1][1] == currentPlayerPiece
				&& board[1][2] == currentPlayerPiece)
			return true;
		else if (board[2][0] == currentPlayerPiece && board[2][1] == currentPlayerPiece
				&& board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][0] == currentPlayerPiece && board[1][0] == currentPlayerPiece
				&& board[2][0] == currentPlayerPiece)
			return true;
		else if (board[0][1] == currentPlayerPiece && board[1][1] == currentPlayerPiece
				&& board[2][1] == currentPlayerPiece)
			return true;
		else if (board[0][2] == currentPlayerPiece && board[1][2] == currentPlayerPiece
				&& board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][0] == currentPlayerPiece && board[1][1] == currentPlayerPiece
				&& board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][2] == currentPlayerPiece && board[1][1] == currentPlayerPiece
				&& board[2][0] == currentPlayerPiece)
			return true;
		else
			return false;
	}

	public void playerDoesAMove(String row, String column) {
		int[] move = null;

		if (row != null && column != null && !board.boardIsFull()) {
			try {
				move = currentPlayer.doMove(row, column);
				currentMoveIsInvalid = false;
			} catch (NumberFormatException e) {
				currentMoveIsInvalid = true;
			}
	
			if (!currentMoveIsInvalid && !checkWinner() && isValidPlayerMove(move)) {
				board.updateBoard(move, currentPlayer.getPiece());
			}
	
			if (!currentMoveIsInvalid && !checkWinner()) {
				swapPlayerTurn();
			}
		}
	}

	public void rematch(String rematch) {
		if (rematch != null ) {
			if (rematch.toLowerCase().equals("JA".toLowerCase())) {
				if (checkWinner()) {
					currentPlayer.getScore().countScore();
				}
				swapPlayerTurn();
				currentMoveIsInvalid = false;
				board = new Board(3, 3);
			} else if (rematch.toLowerCase().equals("NEE".toLowerCase())) {
				currentPlayer.exitGame();
			}
		}
	}
}
