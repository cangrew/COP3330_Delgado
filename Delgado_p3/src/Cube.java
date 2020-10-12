public class Cube extends Shape3D {

    private double sides;

    public Cube(double s){
        sides = s;
    }

    public String getName(){
        return "cube";
    }

    public double getArea(){
        return sides*sides*6;
    }

    public double getVolume(){
        return sides*sides*sides;
    }

}
