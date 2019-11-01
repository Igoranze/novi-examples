package novi.nl.examples;

public enum Piece {
	XPIECE("X", 1, true),
	OPIECE("O", 2);
	
	private String p = "";
	
	Piece(String p, int i) {
		this.p = p;
	}
	
	Piece(String p, int i, boolean b) {
		this.p = p;
	}
	
	public String getPiece() {
		return p;
	}
	
	public String toString() {
		return p;
	}
}
