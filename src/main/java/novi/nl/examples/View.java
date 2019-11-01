package novi.nl.examples;

public class View {

	public String draw(Board board, Player[] players, Player currentPlayer) {
		String result = "";
		
		result += printCurrentPlayer(currentPlayer);
		result += printScore(players);
		result += printBoard(board);
		
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

	public String drawWinner(Player currentPlayer, Board board) {
		String result = "";
		
		result += printBoard(board);
		
		return result;
	}
}
