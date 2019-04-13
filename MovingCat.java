import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Program Explanation: This program creates a cat that have a moving ability. But we have map that has obstacles for cat.
 * Walls,seas are obstacles and there are many foods. Cat is trying to eat foods. It's totally random process. We can get this map from file.
 * Also this file gives us a size of the world.
 * @author Efe Ertekin / ID: 041701006
 * @since 28 Mar, 2019
 */
public class MovingCat {

	/**
	 * This is the main. We are doing almost every thing in here. As you can see at the bottom
	 * you can see which codes are doing which works in comments.
	 * @param args
	 */
	public static void main(String[] args) {

		int sizeOfTheWorld = 40;  //It's helping to set scales
		int moveCounter = 10000;  //How many moves we want to see
		int eatenFood = 0;  //eaten food number

		StdDraw.setCanvasSize(800, 800);  //Canvas size
		StdDraw.enableDoubleBuffering();  //enabling double buffering
		StdDraw.setXscale(0, sizeOfTheWorld);  //setting x scale
		StdDraw.setYscale(0, sizeOfTheWorld);  //setting y scale

		
		String filename = "world.txt";  //we are getting file with this

		File myFile = new File(filename);  //File process
		Scanner myInput = null;  //new Scanner
		try {
			myInput = new Scanner(myFile);    //try-catch for getting file 
		} catch (FileNotFoundException e) {
			System.out.println(filename + ": Input file can not be found!\nExiting program...");
			System.exit(10);
		}

		myInput.hasNext();  //to see next line in file
		String line1 = myInput.nextLine();  //line1 = next line
		String[] parts = line1.split(" ");  //parts array is getting line1 with splitting version
		int sizeOfx = Integer.parseInt(parts[0].trim());  //We are getting size of x from file which is mentioned in file's first line
		int sizeOfy = Integer.parseInt(parts[1].trim());  //We are getting size of y from file which is mentioned in file's first line
		int[][] coordinates = new int[sizeOfx][sizeOfy];  //We are creating a new 2D array to keep numbers like a coordinate


		while(myInput.hasNext()) {  //It's almost the same as above part. These are getting other lines and split them to get numbers like we desired
			for (int i = sizeOfy-1; i > -1; i--) {
				String line = myInput.nextLine();
				String[] ways = line.split(";");
				for (int k = 0; k < sizeOfx; k++)
					if (ways[k].trim() != null)
						coordinates[k][i]= Integer.parseInt(ways[k].trim());
			}
		}		
		drawWorld(sizeOfTheWorld,coordinates);  //drawWorld function is drawing the world
		drawLines(sizeOfTheWorld);  //drawLines is the function that draw lines which they are making clear to observe cat and his moves

		Cat noob = new Cat(3,1,StdDraw.PRINCETON_ORANGE);  //IT'S THE CAT WHICH IS NOOB(HIS NAME)

		Random generatedNum = new Random();  //we are getting randomly generated number with this
		for (int k = 0; k < moveCounter; k++) { 

			int direction = generatedNum.nextInt(4);  // we have 4 directions to move

			
			if ((coordinates[noob.getX()][noob.getY()-1]==3)) {  //if cat can see any food, he will eat the food without extra step
				noob.move(0);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(noob.getX() + 0.5, (noob.getY()+1) + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
				eatenFood++;  //counting eaten food
			}
			if ((coordinates[noob.getX()-1][noob.getY()]==3)) {  //if cat can see any food, he will eat the food without extra step
				noob.move(1);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare((noob.getX()+1) + 0.5, noob.getY() + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
				eatenFood++;  //counting eaten food
			}
			if ((coordinates[noob.getX()][noob.getY()+1]==3)) {  //if cat can see any food, he will eat the food without extra step
				noob.move(2);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(noob.getX() + 0.5, (noob.getY()-1) + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
				eatenFood++;  //counting eaten food
			}
			if ((coordinates[noob.getX()+1][noob.getY()]==3)) {  //if cat can see any food, he will eat the food without extra step
				noob.move(3);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare((noob.getX()-1) + 0.5, noob.getY() + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
				eatenFood++;  //counting eaten food
			}

			// check the world boundaries before moving the cat
			if (((direction == 0) && (coordinates[noob.getX()][noob.getY()-1]==0))) {

				noob.move(direction);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(noob.getX() + 0.5, (noob.getY()+1) + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
			}
			if (((direction == 1) && (coordinates[noob.getX()-1][noob.getY()]==0))) {

				noob.move(direction);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare((noob.getX()+1) + 0.5, noob.getY() + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
			}
			if (((direction == 2) && (coordinates[noob.getX()][noob.getY()+1]==0))) {

				noob.move(direction);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(noob.getX() + 0.5, (noob.getY()-1) + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
			}
			if (((direction == 3) && (coordinates[noob.getX()+1][noob.getY()]==0))) {

				noob.move(direction);
				coordinates[noob.getX()][noob.getY()]=0;
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare((noob.getX()-1) + 0.5, noob.getY() + 0.5, 0.45);  //to delete cat's move
				StdDraw.show();
			}

			noob.draw();  //drawing cat
			StdDraw.pause(1);  //we are calibrating cat's movement speed
		}
		
		System.out.println("How many foods eaten by cat: "+eatenFood);  //how many food eaten by cat
	}

	
	/**
	 * This function is drawing world which is include sea, wall, spaces, food.
	 * @param n, its just for for loop
	 * @param coordinates, its getting coordinates
	 */
	public static void drawWorld(int n,int[][]coordinates) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (coordinates[i][j] == 1) {   //checking coordinates if there any number we want to see
					StdDraw.setPenColor(StdDraw.GRAY);  //wall color
					StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
				}else if (coordinates[i][j] == 2) {   //checking coordinates if there any number we want to see                
					StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);  //sea color
					StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
				}else if (coordinates[i][j] == 3) {  //checking coordinates if there any number we want to see
					StdDraw.setPenColor(StdDraw.MAGENTA);  //food color
					StdDraw.filledSquare(i + 0.5, j + 0.5, 0.45);
				}else {
					StdDraw.setPenColor(StdDraw.WHITE);  //space color
					StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
				}

			}
		}
		StdDraw.show();  //its drawing 
	}

	
	/**
	 * This function is drawing lines that makes places(sea,food,spaces,walls) obvious 
	 * @param n
	 */
	public static void drawLines(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.square(i+1, j+1, 1);
			}
		}
		StdDraw.show();


	}
}







