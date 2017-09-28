package branham.joel;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CircleManagerTest{

	@Test
	public void testConstructor(){
		CircleManager cm = new CircleManager(1, 500, 500, new MockRandom());
		CircleModel c1 = cm.getCircleArray()[0];
		assertEquals(100, c1.getUpperLeftX(), 0);
		assertEquals(200, c1.getUpperLeftY(), 0);
		assertEquals(50, c1.getRadius(), 0);
		assertEquals(150, c1.getCenterX(), 0);
		assertEquals(250, c1.getCenterY(), 0);
		assertEquals(new Color(0,0,0, 127), c1.getColor());
	}

	@Test
	public void testUpdateCircleColorWhenTwoCirclesOverlapUsingMockRandom(){
		CircleManager cm = new CircleManager(2, 100, 100, new MockRandom());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[0].getColor());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[1].getColor());
	}

	@Test
	public void testUpdateCircleColorUpdatesColorsUsingMockRandom1(){
		CircleManager cm = new CircleManager(3, 100, 100, new MockRandom());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[0].getColor());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[1].getColor());
		assertEquals(new Color(0,0,0, 127), cm.getCircleArray()[2].getColor());
	}

	@Test
	public void testUpdateCircleColorUpdatesColorsUsingMockRandom2(){
		CircleManager cm = new CircleManager(4, 100, 100, new MockRandom());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[0].getColor());
		assertEquals(new Color(0,255,255, 127), cm.getCircleArray()[1].getColor());
		assertEquals(new Color(0,0,0, 127), cm.getCircleArray()[2].getColor());
		assertEquals(new Color(0,0,0, 127), cm.getCircleArray()[3].getColor());
	}
	
}