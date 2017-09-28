package branham.joel;

import java.awt.*;
import java.util.*;

/**
 * Manages array of CircleModel.
 */
public class CircleManager{

	/**
	 * Array of CircleModel
	 */
	private CircleModel[] circleArray;
	private int numCircles;
	private int windowWidth;
	private int windowHeight;
	private Random r;

	/**
	 *
	 * @param numCircles Determines size of the CircleModel array.
	 * @param windowWidth The width of the application's window
	 * @param windowHeight The height of the application's window.
	 * @param r The Random number generator.
	 */
	public CircleManager(int numCircles, int windowWidth, int windowHeight, Random r){
		this.numCircles = numCircles;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.r = r;
		createNewCircles();
	}

	/**
	 * Resets circleArray. The following happens for every circle:
	 *  First, a number between 1 and the windowWidth - 2 is generated for the upper-left x-coordinate of the circle.
	 *  Next, a number between 1 and the windowHeight - 2 is generated for the upper-left y-coordinate of the circle.
	 *  The largest posible radius is determined based on which dimension is closest to its respective border.
	 *  Next, a random number between 1 and the largest possible radius is generated to determine the circle's radius.
	 *  Finally, the circle color of each circle is updated if it overlaps with another, otherwise it is the default black.
	 */
	public void createNewCircles(){
		circleArray = new CircleModel[numCircles];
		for (int i = 0; i < circleArray.length; i++){
			int upperLeftX = r.nextInt(windowWidth - 2);
			int upperLeftY = r.nextInt(windowHeight - 2);

			int biggestRadius = (windowHeight - upperLeftY) / 2;
			if ((windowWidth - upperLeftX) / 2 < biggestRadius){
				biggestRadius = (windowWidth - upperLeftX) / 2;
			}
			int radius = r.nextInt(biggestRadius);

			circleArray[i] =  new CircleModel(radius, upperLeftX, upperLeftY);
			updateCircleColor(i);
		}
	}

	/**
	 * Updates circle color if circles overlap.
	 * @param index The index of the CircleModel in the CircleArray to be updated.
	 */
	public void updateCircleColor(int index){
		Color overlappingColor = new Color(0,255,255, 127);
		for (int i = 0; i < index; i++){
			if (circlesOverlap(circleArray[i], circleArray[index])) {
				circleArray[i].setColor(overlappingColor);
				circleArray[index].setColor(overlappingColor);
			}
		}
	}

	/**
	 * Circles overlap if the distance between their centers is less than or equal to the sum of their radii
	 * @param c1 First CircleModel
	 * @param c2 Second CircleModel
	 * @return Boolean - True if circles overlap or false if they do not.
	 */
	public boolean circlesOverlap(CircleModel c1, CircleModel c2){
		return Math.sqrt( Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + Math.pow(c1.getCenterY() - c2.getCenterY(), 2))
				<= c1.getRadius() + c2.getRadius();
	}

	/**
	 * Returns the array of CircleModel.
	 * @return CircleModel Array
	 */
	public CircleModel[] getCircleArray(){
		return circleArray;
	}

}