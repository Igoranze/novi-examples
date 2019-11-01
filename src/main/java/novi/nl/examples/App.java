package novi.nl.examples;

import java.io.IOException;

import novi.nl.http.*;

public class App {
		
	public static void main(String args[]) throws IOException {
		new App();
	}
	
	public App() throws IOException {
		Server httpServer = new Server(8080);
		httpServer.startServer(new Game());
	}
}
