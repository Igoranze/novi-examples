package novi.nl.http;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import novi.nl.examples.Game;
import novi.nl.examples.View;

public class NewGameHandler implements HttpHandler {

	private Game g;

	public NewGameHandler(Game g) {
		this.g = g;
	}

	private String page(Map<String, String> params) {
		StringBuilder result = new StringBuilder();

		result.append("<html>"
				+ View.getDefaultHTML()
				+ g.getGameView()
				+ "</html>");

		return result.toString();
	}

	private void setupPlayers(Map<String, String> params) {
		g.setPlayers(params.get("playerOne"), params.get("playerTwo"));
		g.startGame();
	}

	private void playerDoMove(Map<String, String> params) {
		g.playerDoesAMove(params.get("row"), params.get("column"));
	}
	
	private void rematch(Map<String, String> params) {
		g.rematch(params.get("rematch"));
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
				rematch(params);
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
