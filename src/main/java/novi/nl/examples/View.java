package novi.nl.examples;

public class View {

	public static String getDefaultHTML() {
		String result = "";
		
		result += "<head>" + "<script>" + "function startNewGame() {"
			+ "	  var playerOne = document.getElementById(\"namePlayerOne\").value;"
			+ "	  var playerTwo = document.getElementById(\"namePlayerTwo\").value;"
			+ "	  var params = \"?playerOne=\"+playerOne+\"&\"+\"playerTwo=\"+playerTwo;"
			+ " if (playerOne && playerTwo) {" + " return \"/new-game/\"+params; " + "} " + "return \"#\";" + "	}"
			+ "</script>" + "<style>" + " a { " + "	display: block; " + " width: 113px; " + " margin: auto; "
			+ " } " + "p { " + " text-align: center;" + "}" + "h1 { " + " text-align: center;" + "}" + "td { "
			+ " width: 100px; " + " height: 100px; " + " }" + " table { " + " margin: 5px auto; " + " }"
			+ " .vert { " + " border-left: 2px solid black; " + " border-right: 2px solid black; " + " } "
			+ " .hori { " + " border-top: 2px solid black; " + " border-bottom: 2px solid black; " + " } "
			+ "tr: { 1px solid black }"
			+ "td: { 1px solid black }"
			+ "</style>" + "</head>" + "<body>" + "<h1>Tic Tac Toe</h1>";
			
		return result;
	}
	
	public String draw(Game game, Board board, Player[] players, Player currentPlayer) {
		String result = "";
		
		result += printCurrentPlayer(currentPlayer);
		result += printScore(players);
		result += printBoard(board);
		result += errorMessages(game);
		result += drawWinner(currentPlayer, game);
		result += drawRematch(game, board);
		
		return result;
	}
	
	private String errorMessages(Game game) {
		String result = "";
		
		if (game.isCurrentMoveIsInvalid()) {
			result += "</br></br>"
					+ "<h1 style=\"color: red;\">De zet is ongeldig jow!!</h1>";
		}
		
		return result;
	}
	
	private String printBoard(Board board) {
		String result = "";
		
		result += "</br>";
		
		result += "<table>";
		
		for (int row = 0; row < board.getBoard().length; row++) {
			result += "<tr>";
			
			for (int column = 0; column < board.getBoard()[row].length; column++) {
				result += "<td class=\"vert hori\">";
				
				if (board.getBoard()[row][column] == null)
					result += "<a href=\"?row=" + row + "&column=" + column + "\"><h1>|---|</h1></a>";
				else if (board.getBoard()[row][column] == Piece.OPIECE)
					result += "<a href=\"?row=" + row + "&column=" + column + "\"><h1>|-O-|</h1></a>";
				else if (board.getBoard()[row][column] == Piece.XPIECE)
					result += "<a href=\"?row=" + row + "&column=" + column + "\"><h1>|-X-|</h1></a>";
				
				result += "</td>";

			}
			
			result += "</tr>";
		}
		
		result += "</table>";
		
		return result;
	}
	
	private String printScore(Player[] players) {
		String result = "";
		
		result += "<h4>Score:";

		for (Player player : players) {
			result += "[" + player.getName() + " : " + player.getScore().getScore() + "]";
		}
		
		result += "</br>";
		
		return result;
	}
	
	private String printCurrentPlayer(Player currentPlayer) {
		String result = "";
		
		result += "<h2>Je bent aan de beurt <b>" + currentPlayer.getName() + "</b> Doe een zet!!</h2></br>";
		
		return result;
	}

	private String drawWinner(Player currentPlayer, Game game) {
		String result = "";
		
		if (game.checkWinner()) {
			result += "</br></br>"
					+ "<h1 style=\"color: green;\">Lekker bezig " + currentPlayer.getName() + ", je hebt gewonnen!!!</h1>";
		}
		
		return result;
	}
	
	private String drawRematch(Game game, Board board) {
		String result = "";
		
		if (game.checkWinner() || board.boardIsFull()) {
			result += "</br></br>"
					+ "<h1 style=\"color: orange;\">Rematch?</h1>"
					+ "<a href=\"/new-game/?rematch=ja\">JA</a>"
					+ "<a href=\"/new-game/?rematch=nee\">NEE</a>";
		}
		
		return result;
	}
}
