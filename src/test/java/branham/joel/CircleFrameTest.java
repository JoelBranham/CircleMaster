package branham.joel;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CircleFrameTest{

	private ByteArrayOutputStream outContent;
	
	private CircleManager circleManager;
	private CircleCanvas circleCanvas;
	private CircleFrame circleFrame;
	
	@Before
	public void setup(){
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		circleManager = new CircleManager(5, 100, 100, new Random());
		circleCanvas = new CircleCanvas(circleManager);
		circleFrame = new CircleFrame(circleCanvas);
	}

	@After
	public void cleanUpStreams(){
		System.setOut(null);
	}

	@Test
	public void testMainWithExpectedNumberArgsDoesNotThrowException(){
		String[] args = {"123", "5001", "2001"};
		boolean exceptionThrown = false;
		try {
			circleFrame.main(args);
		}
		catch(NumberFormatException nfe){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}
	@Test
	public void testMainWithExpectNumberButIncorrectArgsCausesCommandLineOutput(){

		String[] args = {"One", "5001", "2001"};
		circleFrame.main(args);
		assertEquals("Invalid command-line input(s).", outContent.toString());
	}

	@Test
	public void testMainWithIncorrectNumberArgsCausesCommandLineOutput(){
		String[] args = {"123", "50"};
		circleFrame.main(args);
		assertEquals("Invalid command-line input(s).", outContent.toString());
	}
	
}