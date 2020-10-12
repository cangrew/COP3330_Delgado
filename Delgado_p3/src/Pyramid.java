public class Pyramid extends Shape3D {

    private double baseL;
    private double baseW;
    private double height;

    public Pyramid(double bL, double bW, double h){
        baseL = bL;
        baseW = bW;
        height = h;
    }

    public String getName(){
        return "pyramid";
    }

    public double getArea(){
        double area = baseL*baseW;
        area = area + baseL*Math.sqrt(Math.pow(baseW/2,2)+Math.pow(height,2));
        area = area + baseW*Math.sqrt(Math.pow(baseL/2,2)+Math.pow(height,2));
        return area;
    }

    public double getVolume(){
        return baseL*baseW*height/3;
    }

}
