package branham.joel;

import java.awt.*;

/**
 * A model for each circle with radius, color, and relevant coordinates.
 */
public class CircleModel{

	/**
	 * The radius of the circle.
	 */
	private int radius;

	/**
	 * The fill color of the circle. Colors are given an alpha value of 127 which gives them 50% transparency. This ensures that overlapping circles are still visible.
	 */
	private Color color;

	/**
	 * The x and y coordinates of the center of the circle.
	 */
	private double centerX, centerY;

	/**
	 * The x and y coordinates of the upper-left corner of the circle.
	 */
	private double upperLeftX, upperLeftY;

	/**
	 * The coordinates for the center of the circle are calculated based off of the radius and upper-left bound coordinates.
	 * @param radius The circle's radius.
	 * @param upperLeftX The x-coordinate of the upper-left corner a square encompassing the circle.
	 * @param upperLeftY The y-coordinate of the upper-left corner of a square encompassing the circle.
	 */
	public CircleModel(int radius, double upperLeftX, double upperLeftY){
		this.radius = radius;
		this.color = new Color(0,0,0, 127);

		this.upperLeftX = upperLeftX;
		this.upperLeftY = upperLeftY;

		this.centerX = upperLeftX + radius;
		this.centerY = upperLeftY + radius;
	}

	/**
	 * Sets the filled color of the circle.
	 * @param c The fill color to be set.
	 */
	public void setColor(Color c){
		this.color = c;
	}

	/**
	 * Sets the x-coordinate of the upper-left corner of the circle.
	 * @param x The x-coordinate of the upper-left corner of the circle.
	 */
	public void setUpperLeftX(double x){
		this.upperLeftX = x;
		this.centerX = upperLeftX + radius;
	}

	/**
	 * Sets the y-coordinate of the upper-left corner of the circle.
	 * @param y The y-coordinate of the upper-left corner of the circle.
	 */
	public void setUpperLeftY(double y){
		this.upperLeftY = y;
		this.centerY = upperLeftY + radius;
	}

	/**
	 * Returns the circle's filled color.
	 * @return Color
	 */
	public Color getColor(){
		return this.color;
	}

	/**
	 * Returns the circle's radius.
	 * @return integer
	 */
	public int getRadius(){
		return this.radius;
	}

	/**
	 * Returns the x-coordinate of the circle's upper-left bound.
	 * @return integer
	 */
	public double getUpperLeftX(){
		return this.upperLeftX;
	}

	/**
	 * Returns the y-coordinate of the circle's upper-left bound.
	 * @return double
	 */
	public double getUpperLeftY(){
		return this.upperLeftY;
	}

	/**
	 * Returns the x-coordinate of the circle's center.
	 * @return double
	 */
	public double getCenterX(){ return this.centerX; }

	/**
	 * Returns the y-coordinate of the circle's center.
	 * @return double
	 */
	public double getCenterY(){ return this.centerY; }
		
}