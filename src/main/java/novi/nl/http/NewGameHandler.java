package novi.nl.http;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import novi.nl.examples.Game;

public class NewGameHandler implements HttpHandler {

	private Game g;

	public NewGameHandler(Game g) {
		this.g = g;
	}

	private String page(Map<String, String> params) {
		StringBuilder result = new StringBuilder();

		result.append("<html>" + "<head>" + "<script>" + "function startNewGame() {"
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
				+ "</style>" + "</head>" + "<body>" + "<h1>Tic Tac Toe</h1>" + g.getGameView()
//				+ "<p>Player one: " + params.get("playerOne") + "</p>"
//				+ "<p>Player two: " + params.get("playerTwo") + "</p>"
//				+ "<table>"
//				+ "  <tr>"
//				+ "    <td></td>"
//				+ "    <td class=\"vert\"></td>"
//				+ "    <td></td>"
//				+ "  </tr>"
//				+ "  <tr>"
//				+ "    <td class=\"hori\"></td>"
//				+ "    <td class=\"vert hori\"></td>"
//				+ "    <td class=\"hori\"></td>"
//				+ "  </tr>"
//				+ "  <tr>"
//				+ "    <td></td>"
//				+ "    <td class=\"vert\"></td>"
//				+ "    <td></td>"
//				+ "  </tr>"
//				+ "</table>"
//				+ "</body>"

				+ "</html>");

		return result.toString();
	}

	private void setupPlayers(Map<String, String> params) {
		g.setPlayers(params.get("playerOne"), params.get("playerTwo"));
		g.startGame();
	}

	private void playerDoMove(Map<String, String> params) {
		int[] move = { Integer.parseInt(params.get("row")), Integer.parseInt(params.get("column")) }; 
		g.getBoard().updateBoard(move, g.getCurrentPlayer().getPiece());
		g.swapPlayerTurn();

	}
	
	@Override
	public void handle(HttpExchange t) throws IOException {

		try {
			Map<String, String> params = null;
			try {
				params = Server.queryToMap(t.getRequestURI().getQuery());
			} catch (Exception e) {
				// do nothing
			}

			if (g.getCurrentPlayer() == null) {
				setupPlayers(params);
			} else {
				playerDoMove(params);
			}

			String response = page(params);

			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
