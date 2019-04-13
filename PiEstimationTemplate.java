import java.awt.Color;

public class PiEstimationTemplate {

	public static void main(String[] args) {
		// canvas parameters
		// pi , x , y , inside(how many of them inside) , outside

		int n = 5000;
		double pi=0;
		double x=0;
		double y=0;
		int inside=0;
		int outside=0;

		int canvas_width = 500;
		int canvas_height = 500;
		StdDraw.clear(StdDraw.WHITE); // set canvas background color
		StdDraw.setCanvasSize(canvas_width, canvas_height); // set canvas/window size
		StdDraw.setXscale(0, 1); // set x coordinates
		StdDraw.setYscale(0, 1); // set y coordinates

		// circle 1
		double circle_center_x = 0.5; //x
		double circle_center_y = 0.5; //y
		double circle_radius   = 0.5; //radius
		double circle_border_thickness = 0.004; //thickness
		Color circle_color = StdDraw.PRINCETON_ORANGE; //circle's color
		StdDraw.setPenColor(circle_color); //circle_color
		StdDraw.setPenRadius(circle_border_thickness); //thickness
		StdDraw.circle(circle_center_x, circle_center_y, circle_radius); //0-1

		for(int i=0; i<n; i++) {
			x = Math.random(); //random number for x
			y = Math.random(); // random number for y
			if((x-0.5)*(x-0.5)+(y-0.5)*(y-0.5) > 0.5*0.5) { 
				StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE); //outside circle color
				outside++;
			}else {
				StdDraw.setPenColor(StdDraw.GRAY); //inside circle color
				inside++;
			}
			StdDraw.filledCircle(x, y, 0.004); //drawing random circles

		}

		pi = (4*(double)(inside)/(inside+outside)); //pi calculation
		System.out.println("pi= "+pi); //printing pi 

	}

}
