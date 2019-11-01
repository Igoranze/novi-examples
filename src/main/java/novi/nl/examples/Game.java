package novi.nl.examples;

import java.util.Scanner;

public class Game {

	private Scanner scan = new Scanner(System.in);
	private Board board;
	private Player[] players;
	private Player currentPlayer;

	private View view;

	public Game() {
		players = new Player[2];
	}
	
	public void setPlayers(String playerOne, String playerTwo) {
		players[0] = new Player(playerOne, Piece.XPIECE);
		players[1] = new Player(playerTwo, Piece.OPIECE);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public String getGameView() {
		return view.draw(board, players, currentPlayer);
	}
	
	public void startGame() {
		currentPlayer = players[0];
		board = new Board(3, 3);
		view = new View();
		
//		boolean gameIsActive = true;
//		while (gameIsActive) {
//			runningGame();
//
//			gameIsActive = !currentPlayer.exitGame(scan);
//		}
	}
	
	private void runningGame() {
		board = new Board(3, 3);
		boolean isGameRunning = true;
		
		while(isGameRunning) {
			view.draw(board, players, currentPlayer);
			
			System.out.println("");
			int[] move = getValidPlayerMove();
			board.updateBoard(move, currentPlayer.getPiece());
			
			if (checkWinner()) {
				currentPlayer.getScore().countScore();
				view.drawWinner(currentPlayer, board);
				isGameRunning = false;
			} else {			
				swapPlayerTurn();
			}
		}
	}
	
	public void swapPlayerTurn() {
		if (currentPlayer == players[0])
			currentPlayer = players[1];
		else
			currentPlayer = players[0];
	}
	
	private int[] getValidPlayerMove() {
		int[] result = null;
		
		boolean validMove = false;
		
		while (!validMove) {
			try {
				result = currentPlayer.doMove(scan);
				if (!board.isValidMove(result))
					System.out.println("Zet is ongeldig, probeer het nog een keer");
				else
					validMove = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Je hebt geen cijfer ingevuld. Probeer het nog een keer"); // Dit zou dus eigenlijk in je VIEW class moeten
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			} finally {
				System.out.println("");
			}
		}
		
		return result;
	}
	
	private boolean checkWinner() {
		Piece[][] board = this.board.getBoard(); // [row][column]
		Piece currentPlayerPiece = currentPlayer.getPiece();
		
		if (board[0][0] == currentPlayerPiece && board[0][1] == currentPlayerPiece && board[0][2] == currentPlayerPiece)
			return true;
		else if (board[1][0] == currentPlayerPiece && board[1][1] == currentPlayerPiece && board[1][2] == currentPlayerPiece)
			return true;
		else if (board[2][0] == currentPlayerPiece && board[2][1] == currentPlayerPiece && board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][0] == currentPlayerPiece && board[1][0] == currentPlayerPiece && board[2][0] == currentPlayerPiece)
			return true;
		else if (board[0][1] == currentPlayerPiece && board[1][1] == currentPlayerPiece && board[2][1] == currentPlayerPiece)
			return true;
		else if (board[0][2] == currentPlayerPiece && board[1][2] == currentPlayerPiece && board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][0] == currentPlayerPiece && board[1][1] == currentPlayerPiece && board[2][2] == currentPlayerPiece)
			return true;
		else if (board[0][2] == currentPlayerPiece && board[1][1] == currentPlayerPiece && board[2][0] == currentPlayerPiece)
			return true;
		else
			return false;
	}
}
