
public class Furniture {

	private String furnitureName;
	private int price;
	private Person designer;
	
	Furniture(){

	}

	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Person getDesigner() {
		return designer;
	}
	public void setDesigner(Person designer) {
		this.designer = designer;
	}

	public String toString() {
		return "[Furniture Name: " + furnitureName + ", Price: " + price + ", Designer: " + designer + "]";
	}

}
