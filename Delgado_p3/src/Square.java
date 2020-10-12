
public class Square extends Shape2D {

  private double sides;

  public Square(double s){
      sides = s;
  }

  public String getName(){
      return "square";
  }

  public double getArea(){
      return sides*sides;
  }

}
