public class Sphere extends Shape3D {

    private double radius;

    public Sphere(double r){
        radius = r;
    }

    public String getName(){
        return "sphere";
    }

    public double getArea(){
        return 4*Math.PI*Math.pow(radius,2);
    }

    public double getVolume(){
        return 4/3.0*Math.PI*Math.pow(radius,3);
    }

    /*public static void main(String[] args){
        Shape3D shape = new Sphere(0.6);
        shape.getVolume();
    }*/

}