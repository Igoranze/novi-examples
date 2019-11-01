package novi.nl.examples;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.TestCase;

public class ScoreTest extends TestCase {

	@Test
	public void testScoreUpdate() {		
		Score score = new Score();
		score.countScore();
		score.countScore();
		score.countScore();
		score.countScore();
		score.countScore();
		score.countScore();

		int expected = 6;
		int actual = score.getScore();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHumanPlayerDoAMove() {
		Human human = new Human("Igor", Piece.OPIECE);
		
		String data = "2\r\n2\r\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
	
		Scanner sc = new Scanner(System.in);
		
		int[] actual = human.doMove(sc);
		int[] expected = {2, 2};
		
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
	}
	
}
