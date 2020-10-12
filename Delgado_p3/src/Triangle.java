
public class Triangle extends Shape2D {

	private double base;
	private double height;
	public Triangle(double b, double h){
		base = b;
		height = h;
	}

	public String getName(){
		return "triangle";
	}
	public double getArea(){
		return base*height/2;
	}

}
