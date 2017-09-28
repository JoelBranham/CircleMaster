package branham.joel;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CircleModelTest{
	
	private CircleModel c;
	
	@Before
	public void setup(){
		c = new CircleModel(2, 3.0, 4.0);
	}

	@Test
	public void testDefaultColor(){
		assertEquals(new Color(0,0,0, 127), c.getColor());
	}

	@Test
	public void testSetColor(){
		c.setColor(new Color(0,255,255, 127));
		assertEquals(new Color(0,255,255, 127), c.getColor());
	}

	@Test
	public void testGetRadius(){
		assertEquals(2, c.getRadius());
	}

	@Test
	public void testGetUpperLeftX(){
		assertEquals(3.0, c.getUpperLeftX(), 0);
	}

	@Test
	public void testGetUpperLeftY(){
		assertEquals(4.0, c.getUpperLeftY(), 0);
	}

	@Test
	public void testGetCenterX(){
		assertEquals(5.0, c.getCenterX(), 0);
	}

	@Test
	public void testGetCenterY(){
		assertEquals(6.0, c.getCenterY(), 0);
	}

	@Test
	public void setUpperLeftX(){
		assertEquals(3.0, c.getUpperLeftX(), 0);
		c.setUpperLeftX(1.0);
		assertEquals(1.0, c.getUpperLeftX(), 0);
	}

	@Test
	public void setUpperLeftY(){
		assertEquals(4.0, c.getUpperLeftY(), 0);
		c.setUpperLeftY(5.0);
		assertEquals(5.0, c.getUpperLeftY(), 0);
	}

	
}