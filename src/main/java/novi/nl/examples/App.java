package novi.nl.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import novi.nl.http.*;

public class App {
		
	public static void main(String args[]) throws IOException {
		Server httpServer = new Server(8080);
		httpServer.startServer(new Game());
		
//		new App();

	}
	
	public App() {
		
		Piece p = Piece.OPIECE;
		p.getPiece();
	}
	
	public static void clearScreen() { 
	    System.out.println("\n\n\n\n\n\n\n\n\n\n");
	}  
}
