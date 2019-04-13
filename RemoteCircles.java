import java.util.Random;

/**
 * Program Explanation: This program creates random circles and find most far 2 circles. Then it draws
 * red line between them. In addition to this, make thicker these 2 circles.
 * @author Efe Ertekin / ID: 041701006
 * @since Mar 16, 2019
 */
public class RemoteCircles {

	/**
	 * Function Explanation: it makes all calculations. As you can see inside of the main.Check comments. 
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfCircles = 100;  //Number of circles

		StdDraw.setCanvasSize(500, 500);  //Canvas sizes
		StdDraw.setXscale(0, 1);  //X size to 1
		StdDraw.setYscale(0, 1);  //Y size to 1

		Random r = new Random();  //Define random


		Circle[] circles = new Circle[numberOfCircles];  //Creating Circle Array

		for(int a=0; a<circles.length; a++) {
			circles[a] = new Circle((r.nextDouble()+0.1)/(1.2),(r.nextDouble()+0.1)/(1.2), (r.nextDouble()+1)/50);  // Calculations of avoid canvas
			circles[a].draw(); //draw circles inside array

		}

		double maximumDistanceBetweenCircles = 0;  //Assign double to use in other calculations
		double control = 0;  //Assign double to use in other calculations

		int circle1 = 0;  //Assign integer to use in other calculations
		int circle2 = 0;  //Assign integer to use in other calculations

		for(int i = 0; i<circles.length; i++) {  //examine i step by step
			for(int m = 0; m<circles.length; m++) {  //examine m step by step

				control = circles[i].distance(circles[m]);  //Checking distances between circles

				if(control>=maximumDistanceBetweenCircles) {  //if statement to assign maximum distance
					maximumDistanceBetweenCircles = control;  //assign maximum distance to maximumDistanceBetweenCircles
					circle1 = m;  //which circles are most far from them (circle's number)
					circle2 = i;  //which circles are most far from them (circle's number)
				}

			}

		}
		StdDraw.setPenRadius(0.01);  //Set pen radius
		circles[circle1].draw();  //Circle which most far from other circle
		circles[circle2].draw();  //Circle which most far from other circle

		StdDraw.setPenColor(StdDraw.RED);  //Set pen color to red
		StdDraw.line(circles[circle1].getx(), circles[circle1].gety(), circles[circle2].getx(), circles[circle2].gety());
		//Drawing line between most far distances

	}

}