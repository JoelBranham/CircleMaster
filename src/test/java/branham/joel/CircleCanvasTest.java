package branham.joel;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleCanvasTest{
	
	private CircleCanvas circleCanvas;
	private CircleManager circleManager;
	
	@Before
	public void setup(){
		circleManager = new CircleManager(5, 100, 100, new Random());
		circleCanvas = new CircleCanvas(circleManager);
	}


	@Test
	public void testResetCircles(){
		circleCanvas.drawNewCircles();
	}

}