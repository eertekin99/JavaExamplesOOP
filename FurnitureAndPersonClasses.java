import java.util.ArrayList;
import java.util.Scanner;

public class FurnitureAndPersonClasses {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ArrayList<Furniture> furnitureList = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		while(true) {

		System.out.println("Press a to add furniture\r\n" + 
				"Press s to show all furniture\r\n" + 
				"Press q quit program");
		
		String test = input.next();


			if (test.equals("a")) {
				System.out.println("Furniture Name: ");
				String furnitures = input.next();

				System.out.println("Price: ");
				int prices = input.nextInt();

				System.out.println("Designer Name: ");
				String designers = input.next();

				Person p = new Person(designers);

				Furniture e = new Furniture();

				e.setDesigner(p);
				e.setFurnitureName(furnitures);
				e.setPrice(prices);
				furnitureList.add(e);
				

			}else if(test.equals("s")) {
				for(int i=0 ; i < furnitureList.size(); i++)
					System.out.println(furnitureList.get(i).toString());

			}else if(test.equals("q")) {
				break;
			}



		}
	}
}

