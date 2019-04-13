import java.awt.Color;

/**
 * Program Explanation: This is the Cat class which is used in main class. It creates a cat. We can calibrate cat's coordinates, color etc. with
 * this class. Also it includes draw, move and setter/getter methods. 
 * @author Efe Ertekin / ID: 041701006
 * @since 28 Mar, 2019
 */
public class Cat {

	private int x;  //cat's x coordinate
	private int y;  //cat's y coordinate
	private Color color;  //cat's color
	private int foodCount;  //food counter

	/**
	 * 
	 * @param x
	 * @param y
	 * @param color
	 */
	Cat(int x, int y, Color color){
		this.x=x;
		this.y=y;
		this.color=color;

	}

	/**
	 * Get of x
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set of x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 *  Get of y
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 *  Set of y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 *  Get of color
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 *  Set of color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Get of foodCount
	 * @return
	 */
	public int getFoodCount() {
		return foodCount;
	}

	/**
	 * Set of foodCount
	 * @param foodCount
	 */
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	/**
	 * This function is the main process. It gives us a chance to move our cat. We can change
	 * cat's coordinates with this function.
	 * @param direction
	 */
	public void move(int direction) {
		if (direction == 0)
			y--;
		else if (direction == 1)
			x--;
		else if (direction == 2)
			y++;
		else if (direction == 3)
			x++;

	}

	/**
	 * It's drawing cat.
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x+0.5, y+0.5, 0.4);
		StdDraw.show();
	}



}
