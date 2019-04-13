
/**
 * Program Explanation: This is Circle class. We are using this in other class. 
 * @author Efe Ertekin / ID: 041701006
 * @since Mar 16, 2019
 */
public class Circle {
	private double x;  // declare x
	private double y;  // declare y
	private double r;  // declare r

	/**
	 * Constructor
	 * @param x
	 * @param y
	 * @param r
	 */
	public Circle(double x, double y, double r) {
		this.x=x;
		this.y=y;
		this.r=r;
	}
	/**
	 * This function drawing circles
	 */
	public void draw() {
		StdDraw.circle(x,y,r);
		StdDraw.show();
	}

	/**
	 * @return double x, getting double x
	 */
	public double getx() {
		return x;
	}

	/** 
	 * @return double y, getting double y
	 */
	public double gety() {
		return y;
	}

	/**
	 * This function calculates distances between circles.
	 * @param inputCircle, which is circle from array
	 * @return
	 */
	public double distance(Circle inputCircle) {
		double distance1;  // declare distance1
		distance1 = Math.sqrt(((inputCircle.getx()-this.x)*(inputCircle.getx()-this.x))+((inputCircle.gety()-this.y)*(inputCircle.gety()-this.y)));
		//calculation of finding distance
		return distance1;  //return distance1
	}

}