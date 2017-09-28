package branham.joel;

import java.awt.*;
import javax.swing.*;

/**
 * JPanel on which circles are drawn.
 */
public class CircleCanvas extends JPanel {

	private CircleManager circleManager;

	/**
	 * @param circleManager Used to access CircleModels and reset them.
	 */
	public CircleCanvas(CircleManager circleManager) {
		this.circleManager = circleManager;
	}

	/**
	 * Draws Circles on CircleCanvas. For every CircleModel in circleModelArray, the outline of a circle (technically an oval with
	 * uniform height and width) whose height/width is determined by the CircleModel's radius is drawn in gray. This same shape is then filled
	 * with its CircleModel's corresponding color.
	 * @param g Graphics
	 */
	public void drawCircles(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		CircleModel[] circleModelArray = circleManager.getCircleArray();
		for (int i = 0; i < circleModelArray.length; i++) {
			g.setColor(Color.gray);
			((Graphics2D) g).setStroke(new BasicStroke(3));
			g.drawOval((int) circleModelArray[i].getUpperLeftX(), (int) circleModelArray[i].getUpperLeftY(),
					circleModelArray[i].getRadius() * 2, circleModelArray[i].getRadius() * 2);
			g.setColor(circleModelArray[i].getColor());
			g.fillOval((int) circleModelArray[i].getUpperLeftX(), (int) circleModelArray[i].getUpperLeftY(),
					circleModelArray[i].getRadius() * 2, circleModelArray[i].getRadius() * 2);
		}
	}

	/**
	 * Prompts the CircleManager object to create new circles. Repaint() calls paintComponent().
	 */
	public void drawNewCircles(){
		circleManager.createNewCircles();
		repaint();
	}

	/**
	 * Prompts the circles to be drawn by calling drawCircles().
	 * @param g Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircles(g);
	}

}