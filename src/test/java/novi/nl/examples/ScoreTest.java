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
	
}
